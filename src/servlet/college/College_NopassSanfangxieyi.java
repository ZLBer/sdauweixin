package servlet.college;

import po.XieyiEntity;
import util.HibernateUtil;
import weixin.ParamesAPI.util.ParamesAPI;
import weixin.ParamesAPI.util.WeixinUtil;
import weixin.msg.Util.SMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by libin on 2017/5/17.
 */
@WebServlet(name = "College_NopassSanfangxieyi")
public class College_NopassSanfangxieyi extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type","text/html;charset=UTF-8");
        String studentcollege =request.getParameter("collegeid");
        int xieyiid = Integer.parseInt(request.getParameter("xieyiid"));

        XieyiEntity student = (XieyiEntity) HibernateUtil.get(XieyiEntity.class,xieyiid);

        HibernateUtil.delete(student);
        String  studentid=student.getStudentid()+"";   //获取学生Id
        //调用接口
        String access_token= WeixinUtil.getAccessToken(ParamesAPI.corpId,ParamesAPI.secret).getToken();
        //创建发送消息对象
        SMessage smsg=new SMessage();
        //拼接接口url
        String RequestUrl=smsg.POST_URL.replace("ACCESS_TOKEN",access_token);
        String content="您申请的三方协议未通过，请重新申请";
        String PostData=smsg.STextMsg(studentid,null,null,ParamesAPI.AgentId_xuesheng,content);
        System.out.println(PostData);

        int result = WeixinUtil.PostMessage(access_token, "POST", RequestUrl,PostData);
        // 打印结果
        if (0 == result) {
            System.out.println("发送三方协议消息成功");
        } else {
            System.out.println("发送三方协议操作失败");
        }
        request.setAttribute("collegename",studentcollege);
        request.getRequestDispatcher("college_checkSanfangxieyi?page_current=1").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   doPost(request,response);
    }
}
