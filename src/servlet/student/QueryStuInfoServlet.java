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
 * 查询学生信息并跳转到学生信息页面
 * Created by 李滟泽 on 2017/4/20.
 */
public class QueryStuInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取Session，从Session中获取当前用户的个人信息
        StudentEntity stu= null;
        HttpSession session = request.getSession();
        //如果session中没有个人信息类，就从数据库中查询并放入Session中
        if((stu= (StudentEntity) session.getAttribute("stu"))==null) {
            //取出当前用户的id，并通过id获取持久化对象
            StudentloginEntity loginedUser = (StudentloginEntity) session.getAttribute("user");
            int userId = loginedUser.getStudentid();
            stu = (StudentEntity) HibernateUtil.get(StudentEntity.class, userId);
        }
        //无论Session中有或者没有都将个人信息放入Session
        session.setAttribute("stu", stu);
        request.getRequestDispatcher("/student/queryStuInfo.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
