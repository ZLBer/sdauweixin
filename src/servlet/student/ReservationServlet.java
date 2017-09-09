package servlet.student;

import po.CollegeloginEntity;
import po.ResumeEntity;
import po.StudentEntity;
import util.HibernateUtil;
import util.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ReservationServlet",urlPatterns = "/student/reservationServlet")
public class ReservationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        String teacherName = request.getParameter("teacher");
        if (!Util.isValidString(teacherName)){
            writer.print("请选择老师！");
            return;
        }
        StudentEntity stu = (StudentEntity) request.getSession().getAttribute("stu");
        if (hasReservation(stu.getStudentid())){
            writer.print("您已经提交过申请了，请等待回复。");
            return;
        }
        CollegeloginEntity collegeloginEntity = (CollegeloginEntity) HibernateUtil.query(
                "CollegeloginEntity",
                "WHERE teachername='"+teacherName+"'").get(0);

        ResumeEntity resumeEntity = new ResumeEntity();
        resumeEntity.setStudentId(stu.getStudentid());
        resumeEntity.setStudentCollege(stu.getStudentcollege());
        resumeEntity.setStudentName(stu.getStudentname());
        resumeEntity.setState(0);
        resumeEntity.setTeacherId(Integer.parseInt(collegeloginEntity.getEmpno()));
        HibernateUtil.add(resumeEntity);
        writer.print("预约成功，请等待老师回复");
    }
    private boolean hasReservation(int id){
        String condition = "WHERE studentId="+id+" AND state=0";
        int c = HibernateUtil.recordCount("ResumeEntity",condition);
        if (c!=0){
            return true;
        }
        return false;
    }
}
