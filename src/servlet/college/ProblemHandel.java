package servlet.college;

import po.ProblemEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by hello world on 2017/5/2.
 */
@WebServlet(name = "ProblemHandel")
public class ProblemHandel extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html,charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        final int problemstate=1;
        //微信对接
        String studentid;
        String reply = request.getParameter("reply");
        int problemid= Integer.parseInt(request.getParameter("problemid"));
        java.util.List<ProblemEntity> problems= new ArrayList<ProblemEntity>();
        ProblemEntity problem =new ProblemEntity();
        String condition=" where problemid="+problemid;
        problems = HibernateUtil.query("ProblemEntity problemEntity",condition);
        if(problems.size()>0)
        {
            problem=problems.get(0);
        }
        problem.setProblemtext(reply);
        problem.setProblemstate(problemstate);
        request.setAttribute("reply", reply);
        request.setAttribute("problemtext", problem.getProblemtext());
        out.print("<h2>问题已回复</h2><br>");
        request.getRequestDispatcher("student/Problem_handle.jsp").forward(request, response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
