package servlet.college;

import po.StudentEntity;
import util.HibernateUtil;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by libin on 2017/7/9.
 */
public class ModifyStudentInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      response.setCharacterEncoding("UTF-8");
      StudentEntity student=new StudentEntity();
             student.setStudentid(Integer.parseInt(request.getParameter("studentid")));
               student.setExamid(request.getParameter("examid"));
               student.setStudentname(request.getParameter("studentname"));
               student.setStudentsex(request.getParameter("studentsex"));
               student.setStudentnation(request.getParameter("studentnation"));
               student.setStudentnumber(request.getParameter("studentnumber"));
               student.setPolitical(request.getParameter("political"));
               student.setEducation(request.getParameter("education"));
               student.setStudentmajor(request.getParameter("studentmajor"));
               student.setTrainingmode(request.getParameter("trainingmode"));
               student.setLocation(request.getParameter("location"));
               student.setLength(request.getParameter("length"));
               student.setMinor(request.getParameter("minor"));
               student.setStudentbirthday(request.getParameter("studentbirthday"));
               student.setDegree(request.getParameter("degree"));
               student.setMajorforeign(request.getParameter("majorforeign"));
               student.setForeignlevel(request.getParameter("foreignlevel"));
               student.setComlevel(request.getParameter("comlevel"));
               student.setEnteryear(request.getParameter("enteryear"));
               student.setGraduationtime(request.getParameter("graduationtime"));
               student.setUniversityname(request.getParameter("universityname"));
               student.setWeipeiunit(request.getParameter("weipeiunit"));
               student.setWeipeilocation(request.getParameter("weipeilocation"));
               student.setStudentcollege(request.getParameter("studentcollege"));
               student.setResident(request.getParameter("resident"));
               student.setRegister(request.getParameter("register"));
               student.setResidentdetailed(request.getParameter("residentdetailed"));
               student.setRegisterdetailed(request.getParameter("registerdetailed"));
               student.setStudentclass(request.getParameter("studentclass"));
               student.setResidentoffice(request.getParameter("residentoffice"));
               student.setResidentaddress(request.getParameter("residentaddress"));
               student.setRegisteroffice(request.getParameter("registeroffice"));
               student.setRegisteraddress(request.getParameter("registeraddress"));
               student.setTpye(request.getParameter("tpye"));
               student.setVocational(request.getParameter("vocational"));
               student.setHometel(request.getParameter("hometel"));
               student.setRegistertime(request.getParameter("registertime"));
               student.setStudentstate(request.getParameter("studentstate"));
               HibernateUtil.update(student);
               PrintWriter out=response.getWriter();
               out.print("修改学生信息成功。");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
