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
import weixin.msg.Resp.Article;
import weixin.msg.Util.SMessage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by C on 2017/5/10.
 */
public class Article_queryByPend extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        final String STATE = "审核";

        int aid= Integer.parseInt(request.getParameter("aid"));
        String condition="where article.articleid="+aid+" order by articleid desc";
        List<ArticleEntity> userList=new ArrayList<ArticleEntity>();
        userList= HibernateUtil.query("ArticleEntity article", condition);
        request.setAttribute("articleList",userList);

        ArticleEntity a = new ArticleEntity();
        if(userList.size()>0){
            a =userList.get(0);
        }
        a.setState(STATE);
        HibernateUtil.update(a);

        //获取招聘信息详细信息
        int articleid=a.getArticleid();
        int columnid=a.getColumnid();

        PrintWriter out =response.getWriter();
        out.print("审核成功");
        if (columnid==1){
            out.print("<a href='navigation_edit?pageNo=1' >返回上一页<a/>");
        }
        else if(columnid==2){
            out.print("<a href='navigation_special?pageNo=1'>返回上一页<a/>");
        }


        //转换获取部门id---------------------------
        String toparty="";
        String condition2="where demand.articleid="+articleid;
        java.util.List<DemandEntity> demandList=new ArrayList<DemandEntity>();
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




////////////////////////////////////////////////////////////////////开始调用微信接口--增加通讯录成员
        // 创建成员地址
        String CREATE_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/create?access_token=ACCESS_TOKEN ";

        String userid = String.valueOf(articleid);
        String name=a.getEnterprisename();
        String mobile=a.getAuthortel();

        // 调取凭证
        String access_token = WeixinUtil.getAccessToken(ParamesAPI.corpId, ParamesAPI.secret).getToken();
        // 拼装数据
        MPerson mp=new MPerson();
        String PostData =mp.Create(userid, name, mobile);

        String RequestURL = mp.CREATE_URL.replace("ACCESS_TOKEN",access_token);
        System.out.println(PostData);
        // 提交数据,获取结果
        int result = WeixinUtil.PostMessage(access_token, "POST", RequestURL, PostData);
        // 打印结果

        if(0==result){
            System.out.println("通讯录成员增加成功");
        }
        else {
            System.out.println("通讯录成员增加操作失败");
        }
///////////////////////////////////////////////////////////////////////////开始发送news消息
        //创建发送消息对象
        SMessage smsg=new SMessage();
        //拼接接口url
        String RequestUrl=smsg.POST_URL.replace("ACCESS_TOKEN",access_token);
        //拼接招聘信息链接
        String serverName=request.getServerName();
        String Content_source_url="http://"+serverName+"/sdauweixin/article_query?aid="+articleid;   //阅读原文的链接
        //拼接文章
        Article article1 = new Article();
        article1.setTitle("您有新的招聘信息");
        article1.setDescription(a.getEnterprisename()+"的招聘信息");
        article1.setPicUrl("http://"+serverName+"/images/zp.jpg");
        article1.setUrl(Content_source_url);

        List<Article> list = new ArrayList<Article>();
        list.add(article1);
        // 图文转json
        String articlesList = JSONArray.fromObject(list).toString();
        //Post数据
        int agentid=ParamesAPI.AgentId_jiuyezhidao;

        String PostData1=smsg.SNewsMsg(null,toparty,null, agentid, articlesList);
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
        doPost(request,response);
    }
}
