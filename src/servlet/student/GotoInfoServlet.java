package servlet.student;

import po.StudentEntity;
import po.StudentloginEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Minister on 2017/4/20.
 */
public class GotoInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        StudentloginEntity loginedUser = (StudentloginEntity) session.getAttribute("user");
        StudentEntity stu = null;
        int stuID = (loginedUser == null ? 99 : loginedUser.getStudentid());//学号
        stu = (StudentEntity) HibernateUtil.get(StudentEntity.class, stuID);
        session.setAttribute("stu",stu);
        request.getRequestDispatcher("/student/inputStuInfo.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
