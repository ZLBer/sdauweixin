package servlet.college;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.sf.json.JSONArray;
import po.ArticleEntity;
import po.DemandEntity;
import util.HibernateUtil;
import weixin.ParamesAPI.util.ParamesAPI;
import weixin.ParamesAPI.util.WeixinUtil;
import weixin.contacts.util.MPerson;
import weixin.msg.Resp.TextCard;
import weixin.msg.Util.Articles;
import weixin.msg.Util.SMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/3.
 */

public class College_SendMessage extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          request.setCharacterEncoding("utf-8");
          response.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        //articleid
        //article ...
        int articleid = Integer.parseInt(request.getParameter("articleid"));

        ArticleEntity article=(ArticleEntity)HibernateUtil.get(ArticleEntity.class,articleid);

        String author=article.getAuthor();

        //转换获取部门id---------------------------
        String toparty="";
        String mobile=article.getAuthortel();		//企业联系方式
        String name=article.getEnterprisename();	//企业名
        String condition2="where demand.articleid="+articleid;
        List<DemandEntity> demandList=new ArrayList<DemandEntity>();
        demandList= HibernateUtil.query("DemandEntity demand", condition2);


        int[] jsonArray=new int[92];
        int[] keyvalue=new int[92];
        //现在查询完毕，需要取majorid;
        for(int i=0;i<demandList.size();i++) {
            jsonArray[i]= demandList.get(i).getMajorid();
        }
        JsonParser parser=new JsonParser();     //创建解析器
        String filePath = request.getServletContext().getRealPath("/WEB-INF");
        JsonObject object=(JsonObject)parser.parse(new FileReader(filePath + "/major.json"));//创建一个JsonObject对象，并调用解析器的parse方法进行读取文件，返回值的类型是JsonElement,
        // 但是赋值的对象是一个JsonObject所以要进行类型的强制转换。

        // 注意Json文件，如果json文件的格式有问题，可能就会导致出现json语法异常；
        //下一步就是比对，得到的键值输出
        for(int j=0;j<demandList.size();j++)
        {
            String key=Integer.toString(jsonArray[j]);
            keyvalue[j]=object.get(key).getAsInt();
            System.out.println("keyvalue="+object.get(key).getAsInt());
        }
        for(int i=0;i<demandList.size();i++) {
            if(i<demandList.size()-1)
                toparty+=keyvalue[i]+"|";
            else toparty+=keyvalue[i];

        }
        //获取部门id结束---------------------------------

        //--------------------------------------------------------------------增加企业通讯录成员
        // 调取凭证
        String access_token = WeixinUtil.getAccessToken(ParamesAPI.corpId, ParamesAPI.secret).getToken();

        // 创建成员地址
        String CREATE_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/create?access_token=ACCESS_TOKEN ";


        // 拼装数据
        MPerson mp=new MPerson();
        String userid=articleid+"";
        String PostData =mp.Create(userid, name, mobile);

        String RequestURL = mp.CREATE_URL.replace("ACCESS_TOKEN",access_token);
        System.out.println(PostData);
        // 提交数据,获取结果
        int result = WeixinUtil.PostMessage(access_token, "POST", CREATE_URL, PostData);
        // 打印结果

        if(0==result){
            System.out.println("通讯录成员增加成功");
        }
        else {
            System.out.println("通讯录成员增加操作失败");
        }

        //--------------------------------------------------------------------开始发消息
        //创建发送消息对象
        SMessage smsg=new SMessage();
        //拼接url
        String RequestUrl=smsg.POST_URL.replace("ACCESS_TOKEN",access_token);
        // 新建图文
        String title="新的招聘信息";
        String description="您有新的招聘信息，点击详情查看";
        String serverName=request.getServerName();
        String url=serverName+"/sdauweixin/article_query?aid="+articleid;   //阅读原文的链接
        System.out.println("阅读原文链接："+url);
        String btntxt="详情";//招聘信息的内容
        //String digest="";

        TextCard textCard = new TextCard();
        textCard.setTitle(title);
        textCard.setDescription("您有新的招聘信息，点击详情查看");
        textCard.setUrl(url);
        textCard.setBtntxt(btntxt);

        //Post数据
        int agentid=ParamesAPI.AgentId_jiuyezhidao;

        String PostData1=smsg.STextCardMsg(null,toparty, null,agentid, title,description,url,btntxt);
        System.out.println(PostData1);
        int result1 = WeixinUtil.PostMessage(access_token, "POST", RequestUrl,PostData1);
        // 打印结果
        if (0 == result1) {
            System.out.println("发送招聘信息成功");
          out.println("招聘信息发布成功");
         //   request.getRequestDispatcher("/college/college_message.jsp").forward(request, response);
        } else {
            System.out.println("发送招聘信息操作失败");
        }
       // request.getRequestDispatcher("/college/college_message.jsp").forward(request, response);

    }
}
