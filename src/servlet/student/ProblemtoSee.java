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
import java.util.ArrayList;

/**
 * Created by hello world on 2017/5/3.
 */
@WebServlet(name = "ProblemtoSee")
public class ProblemtoSee extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int problemid =Integer.parseInt(request.getParameter("problemid"));
        java.util.List<ProblemEntity> problems= new ArrayList<ProblemEntity>();
        ProblemEntity problem =new ProblemEntity();
        String condition = "where problemid="+problemid;
        problems = HibernateUtil.query("ProblemEntity problem",condition);
        if(problems.size()>0)
        {
            problem =problems.get(0);
        }
        request.setAttribute("problemEntity",problem);
        //供后面的问题追问的servlet使用


        HttpSession session = request.getSession();
        if(request.getSession().getAttribute("userid")!=null){           //如果微信端session不为空
            String id=(String)session.getAttribute("userid");
            request.getSession().setAttribute("problemid",problem.getProblemid());
            request.getRequestDispatcher("/WEUI/problem_reply.jsp").forward(request,response);
        }
        else {                                                              //如果电脑端session不为空
            StudentloginEntity studentloginEntity = (StudentloginEntity) session.getAttribute("user");
            request.getSession().setAttribute("problemid",problem.getProblemid());
            request.getRequestDispatcher("problem_handel.jsp").forward(request,response);
        }


    }
}
