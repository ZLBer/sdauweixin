package servlet.admin;

import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Minister on 2017/5/24.
 */
public class GotoModifyCollPwdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] classes = {"CollegeEntity as college","CollegeloginEntity as collegelogin"};
        String[] fields = {"college.collegename","collegelogin.teachername","collegelogin.empno","collegelogin.collegeuserid"};
        String condition = "WHERE college.collegeid=collegelogin.collegeid "
                + "ORDER BY college.collegename";
        List<Object[]> collegeLoginList = HibernateUtil.multiTableSelect(classes,fields,condition);
        System.out.println(collegeLoginList.size());
        request.setAttribute("collegeInfo",collegeLoginList);
        request.getRequestDispatcher("modifyCollegePassword.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
