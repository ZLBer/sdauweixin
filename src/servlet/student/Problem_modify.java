package servlet.student;

import po.ProblemEntity;
import po.StudentloginEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by hello world on 2017/5/7.
 */
@WebServlet(name = "Problem_modify")
public class Problem_modify extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html,charset=utf-8");
        //获取追问内容
        String problemtext = request.getParameter("problemtext");

        //String problemtext = request.getParameter("problemtext");
        PrintWriter out =response.getWriter();
        HttpSession session =request.getSession();
        int problemid =(int)session.getAttribute("problemid");//可能会有bug
        StudentloginEntity studentloginEntity =(StudentloginEntity) session.getAttribute("user");
        int studentid =studentloginEntity.getStudentid();
        String condition="where problemid ="+problemid+"and studentid ="+studentid;
        int problemstate =0;
        java.util.List<ProblemEntity> problems = HibernateUtil.query("ProblemEntity problem",condition);
        ProblemEntity problem =new ProblemEntity();
        if(problems.size()>0)
        {
            problem = problems.get(0);
        }
        Date date = new Date();// new Date()为获取当前系统时间，也可使用当前时间戳
        Timestamp nousedate = new Timestamp(date.getTime());
        problem.setProblemstate(problemstate);
        problem.setProblemtext(problem.getProblemtext()+problemtext);
        out.println(problemtext);
        problem.setProblemtime(nousedate);
        HibernateUtil.update(problem);
        out.println("问题已成功提交");
        out.print("<a href='right.jsp'>点击返回</a>");





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
