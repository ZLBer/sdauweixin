package weixin.test;

import weixin.ParamesAPI.util.ParamesAPI;
import weixin.ParamesAPI.util.WeixinUtil;
import weixin.contacts.util.MTag;
import weixin.msg.Util.SMessage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class alterTagServlet extends HttpServlet {

    public alterTagServlet() {
        super();
    }

    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        System.out.println("开始删除标签成员-------------------------");
        //获取凭证
        String access_token=WeixinUtil.getAccessToken(ParamesAPI.corpId,ParamesAPI.secret).getToken();
        //获取userid
        HttpSession session = request.getSession();
        String UserID=(String) session.getAttribute("userid");
        System.out.println("UserID为："+UserID);
        MTag mtag = new MTag();
        // 删除tagid的成员
        for(int i=1;i<=3;i++){
            String tagid=""+i;
            System.out.println(UserID);
            String TagPost = mtag.Delete_Tag_Person(tagid,UserID);
            //拼接URL
            String RequestURL = mtag.DELETE_TAG_PERSON.replace("ACCESS_TOKEN",access_token);
            // 提交数据，获取结果
            int result = WeixinUtil.PostMessage(access_token, "POST",RequestURL, TagPost);
            // 打印结果
            if (0 == result) {
                System.out.println("删除成功");

            } else {
                System.out.println("删除失败");
                System.out.println(result);
            }
        }

        //添加标签成员
        //获取用户意向标签id
        request.setCharacterEncoding("UTF-8");
        String TagID=request.getParameter("radio1");
        String yx="";
        if(TagID.equals("1")){
            yx="准备就业";
        }
        else if(TagID.equals("2")){
            yx="考取研究生";
        }
        else{
            yx="考取公务员";
        }
        System.out.println("标签id-------------"+TagID);
        String TagPost = mtag.Add_Tag_Person(TagID,UserID);
        //拼接URL
        String RequestURL = mtag.ADD_TAG_PERSON.replace("ACCESS_TOKEN",access_token);
        // 提交数据，获取结果
        int result = WeixinUtil.PostMessage(access_token, "POST",RequestURL, TagPost);
        String servername=request.getServerName();           //获取域名
        // 打印结果
        if (0 == result) {
            System.out.println("添加成功");
            //创建发送消息对象
            SMessage smsg=new SMessage();
            //拼接url
            RequestURL=smsg.POST_URL.replace("ACCESS_TOKEN",access_token);
            //Post数据
            String stext="修改意向成功！\n您当前的意向为:"+yx;
            int agentid=ParamesAPI.AgentId_xuesheng;

            String touser=UserID;
            String partyID=null;
            String totag=null;

            String PostData=SMessage.STextMsg(touser,partyID,totag,agentid,stext);

            int result1 = WeixinUtil.PostMessage(access_token, "POST", RequestURL,PostData);
            // 打印结果
            if (0 == result1) {
                System.out.println("发送消息成功");
            } else {
                System.out.println("发送消息失败");
            }
            System.out.println(servername);
            request.setAttribute("msg","修改意向成功！");
            request.getRequestDispatcher("/WEUI/operate_success.jsp").forward(request,response);
        } else {
            System.out.println("添加失败");
            request.setAttribute("msg","修改意向失败！");
            request.getRequestDispatcher("/WEUI/operate_fail.jsp").forward(request,response);
        }
    }

    public void init() throws ServletException {
        // Put your code here
    }

}
