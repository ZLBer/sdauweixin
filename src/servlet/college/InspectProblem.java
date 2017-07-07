package servlet.college;

import po.ProblemEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by hello world on 2017/5/2.
 */
@WebServlet(name = "InspectProblem")
public class InspectProblem extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session =request.getSession();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html,utf-8");
        PrintWriter out =response.getWriter();

        //获取处理方式 check为查看 reply为回复
        String type = request.getParameter("type");

        int problemid= Integer.parseInt(request.getParameter("problemid"));
        ProblemEntity problemEntity = new ProblemEntity();
        java.util.List<ProblemEntity> problems= new ArrayList<ProblemEntity>();
        String condition = "where problemid="+problemid;
        problems = HibernateUtil.query("ProblemEntity problem",condition);
        if(problems.size()>0){
            problemEntity =problems.get(0);
        }
        request.setAttribute("problemid",problemEntity.getProblemid());
        request.setAttribute("problemtext", problemEntity.getProblemtext());
        request.setAttribute("studentid",problemEntity.getStudentid());
        request.setAttribute("problemtime",problemEntity.getProblemtime());
        request.setAttribute("replytext",problemEntity.getReplytext());
        request.setAttribute("problemEntity",problemEntity);


        if(request.getSession().getAttribute("userid")!=null){
            System.out.println("开始转发到学院回复问题页面");
            request.getRequestDispatcher("/WEUI/collegereply.jsp").forward(request,response);
        }
        else{
            if(type.equals("reply")) //跳转回复页
                request.getRequestDispatcher("handleProblem.jsp").forward(request,response);
            else//跳转查看页
                request.getRequestDispatcher("Servlet_guanli.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}
