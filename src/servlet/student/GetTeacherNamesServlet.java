package servlet.student;

import po.StudentloginEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Minister on 2017/5/25.
 */
public class GetTeacherNamesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int studentId;
        if(session.getAttribute("userid")!=null){
            studentId=Integer.parseInt(session.getAttribute("userid").toString());
        }else{
            studentId = ((StudentloginEntity) session.getAttribute("user")).getStudentid();
        }
        //获取学生id

        //查询学生所属学院号
        String[] classes = {"StudentEntity as student", "CollegeEntity as college"};
        String[] selectedFields = {"college.collegeid"};
        String condition = "WHERE student.studentcollege=college.collegename and studentid=" + studentId;
        List<Object[]> collegeId = HibernateUtil.multiTableSelect(classes, selectedFields, condition);
        //根据学院号查询老师名
        String collegeloginAlia = "collegelogin";
        String[] fields = {collegeloginAlia + ".teachername"};
        List<Object[]> teacherList = HibernateUtil.selectFields("CollegeloginEntity as " + collegeloginAlia, fields, "WHERE " + collegeloginAlia + ".collegeid=" + collegeId.get(0));
        System.out.println(teacherList.size());
        //session.setAttribute("teacherno",teacherList.);
        request.setAttribute("teacherNames", teacherList);
        if (session.getAttribute("userid") != null) {
            request.getRequestDispatcher("/WEUI/question.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("student_tijiao.jsp").forward(request, response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
