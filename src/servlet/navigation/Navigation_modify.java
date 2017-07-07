package servlet.navigation;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.sf.json.JSONArray;
import po.ArticleEntity;
import po.DemandEntity;
import util.HibernateUtil;
import weixin.ParamesAPI.util.ParamesAPI;
import weixin.ParamesAPI.util.WeixinUtil;
import weixin.contacts.util.MPerson;
import weixin.msg.Util.Articles;
import weixin.msg.Util.SMessage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/**
 * Created by C on 2017/5/2.
 */
public class Navigation_modify extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String STATE = "审核";
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int articleid=Integer.parseInt(request.getParameter("articleid"));
        String enterprisename=request.getParameter("enterprisename");
        String articletext = request.getParameter("articletext");
        String columnid = request.getParameter("columid");
//        Timestamp nousedate = new Timestamp(date.getTime());
        //Timestamp articletime=request.getParameter("articletime");

        String author=request.getParameter("author");
        String authortel=request.getParameter("authortel");

        String condition="where article.articleid="+articleid;
        List<ArticleEntity> articleList= HibernateUtil.query("ArticleEntity article", condition);

        out.println(articleList.size());
        //转换获取部门id---------------------------
        String toparty="";
        String condition2="where demand.articleid="+articleid;
        java.util.List<DemandEntity> demandList=new ArrayList<DemandEntity>();
        demandList= HibernateUtil.query("DemandEntity demand", condition2);
        ArticleEntity a = (ArticleEntity) articleList.get(0);
        a.setEnterprisename(enterprisename);
        a.setArticletext(articletext);

        a.setState(STATE);
        response.getWriter().print("您已成功将其修改");
        HibernateUtil.update(a);

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



        request.setCharacterEncoding("UTF-8");

///////////////////////////////////////////////////////////////////微信接口调用--增加企业通讯录成员

        // 创建成员地址
        String CREATE_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/create?access_token=ACCESS_TOKEN ";



        String userid=request.getParameter("articleid");
        String name=request.getParameter("enterprisename");
        String mobile=request.getParameter("authortel");

        // 调取凭证
        String access_token = WeixinUtil.getAccessToken(ParamesAPI.corpId, ParamesAPI.secret).getToken();
        // 拼装数据
        MPerson mp=new MPerson();
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

/////////////////////////////////////////////////////////////////微信接口调用--发送图文招聘信息
        //创建发送消息对象
        SMessage smsg=new SMessage();
        //拼接url
        String RequestUrl=smsg.POST_URL.replace("ACCESS_TOKEN",access_token);
        // 新建图文
        String title="新的招聘信息";//
        String article_author=author;
        String serverName=request.getServerName();
        String Content_source_url=serverName+"/sdauweixin/article_query?aid="+articleid;   //阅读原文的链接
        System.out.println("阅读原文链接："+Content_source_url);
        String Content="点击阅读原文查看详细信息";//招聘信息的内容
        String digest="";

        Articles articles=new Articles();
        articles.setTitle(title);
        articles.setThumb_media_id("2X4-jISenTghV2Y87F-YOTHfdx2o5uQ4qo-JIVbRT0i8zZcZj2SMQDRyC909VofZMURde4Bmh0rzkMoNzFznjlw");
        articles.setAuthor(article_author);
        articles.setContent_source_url(Content_source_url);     //阅读原文的链接
        articles.setContent(Content);       //图文消息内容
        articles.setDigest(digest);         //图文消息描述
        articles.setShow_cover_pic("1");    //是否显示封面
        //整合图文
        List<Articles> list = new ArrayList<Articles>();
        list.add(articles);
        // 图文转json
        String articlesList = JSONArray.fromObject(list).toString();
        //Post数据
        int agentid=ParamesAPI.AgentId_jiuyezhidao;

        String PostData1=smsg.SMpNewsMsg(toparty, agentid, articlesList);
        System.out.println(PostData1);
        int result1 = WeixinUtil.PostMessage(access_token, "POST", RequestUrl,PostData1);
        // 打印结果
        if (0 == result1) {
            System.out.println("发送招聘信息成功");
        } else {
            System.out.println("发送招聘信息操作失败");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
