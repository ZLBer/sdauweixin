package servlet.college;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Minister on 2017/4/26.
 */
public class GetCollegeNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("UTF-8");
        PrintWriter out = response.getWriter();
        String[] stuSelectId = request.getParameterValues("stuSelectId");
        String major = request.getParameter("major");
        String sex = request.getParameter("sex");
        String state = request.getParameter("state");
        System.out.println(major);
        System.out.println(sex);
        System.out.println(state);
        if(stuSelectId!=null){
            for (String stuId:stuSelectId){
                System.out.print(stuId+" ");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
