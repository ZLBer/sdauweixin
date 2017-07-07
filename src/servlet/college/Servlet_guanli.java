package servlet.college;

import po.ProblemEntity;
import util.HibernateUtil;
import weixin.ParamesAPI.util.ParamesAPI;
import weixin.ParamesAPI.util.WeixinUtil;
import weixin.msg.Util.SMessage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 完成了学生问题的处理，将replytext数据库提交
 * 完成跟微信端的对接，保存了一个studentid
 * Created by hello world on 2017/4/21.
 */
@WebServlet(name = "Servlet_guanli")
public class Servlet_guanli extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out =response.getWriter();
        HttpSession session =request.getSession();
        final int problemstate=1;
        Date date = new Date();// new Date()为获取当前系统时间，也可使用当前时间戳
        Timestamp nousedate = new Timestamp(date.getTime());
        String reply = request.getParameter("replytext");
        //int id= Integer.parseInt(request.getParameter("problemid"));
        int problemid =Integer.parseInt(request.getParameter("problemid"));
        List<ProblemEntity> problems= new ArrayList<ProblemEntity>();
        ProblemEntity problem =new ProblemEntity();
        String condition=" where problemid="+problemid;
        problems = HibernateUtil.query("ProblemEntity problemEntity",condition);
        if(problems.size()>0)
        {
            problem=problems.get(0);
        }
        problem.setReplytext(reply);

        problem.setProblemstate(problemstate);
        problem.setReplytime(nousedate);
        problem.setReplytext(reply);
        HibernateUtil.update(problem);
        //保存学号跟微信对接
        int studentid =problem.getStudentid();
        request.setAttribute("replytext", reply);
        request.setAttribute("problemtext", problem.getProblemtext());
        out.println("问题"+problemid+"已回复成功");


        //-----------------------向学生发送消息
        String access_token= WeixinUtil.getAccessToken(ParamesAPI.corpId,ParamesAPI.secret).getToken();
        //创建发送消息对象
        SMessage smsg=new SMessage();
        //拼接url
        String RequestUrl=smsg.POST_URL.replace("ACCESS_TOKEN",access_token);
        String userid=""+studentid;
        String Content="您提交的问题已被学院回复,请前往查看。";
        int agentid=ParamesAPI.AgentId_xuesheng;
        String PostData1=smsg.STextMsg(userid,null,null, agentid, Content);
        System.out.println(PostData1);
        int result1 = WeixinUtil.PostMessage(access_token, "POST", RequestUrl,PostData1);
        // 打印结果
        if (0 == result1) {
            System.out.println("发送招聘信息成功");
        } else {
            System.out.println("发送招聘信息操作失败");
        }
        request.getRequestDispatcher("/college/college_select").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
