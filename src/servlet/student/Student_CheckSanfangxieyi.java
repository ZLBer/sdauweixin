package servlet.student;

import po.StudentEntity;
import po.XieyiEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by libin on 2017/5/7.
 */
public class Student_CheckSanfangxieyi extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    //防止多次提交
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int studentid =Integer.parseInt(request.getParameter("studentid"));
        String  hql="where studentid="+studentid;
        List<XieyiEntity> students= HibernateUtil.query("XieyiEntity",hql);
        PrintWriter out=response.getWriter();
        if(students.size()==0){
            request.getRequestDispatcher("student_choseSanfangxieyi.jsp").forward(request, response);

        }
        else {
            for(XieyiEntity student :students)
            {
                if(student.getState()==1)
                    out.println("已通过审核，请尽快前往学院。");
                else
                    out.println("已提交过申请请耐心等待。");
            }
        }
        }
    }

