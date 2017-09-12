package servlet.college;

import po.StudentloginEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "resetStuPwdServlet",urlPatterns = "/college/resetStuPwdServlet")
public class resetStuPwdServlet extends HttpServlet {
    public static final String initPwd = "e10adc3949ba59abbe56e057f20f883e";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        String stuId = request.getParameter("stuId");
        StudentloginEntity studentloginEntity = (StudentloginEntity) HibernateUtil.get(StudentloginEntity.class,Integer.parseInt(stuId));
        if (studentloginEntity==null){
            writer.print("未找到该学生");
            return;
        }
        studentloginEntity.setStudentpassword(initPwd);
        HibernateUtil.update(studentloginEntity);
        writer.print("重置成功");
    }
}
