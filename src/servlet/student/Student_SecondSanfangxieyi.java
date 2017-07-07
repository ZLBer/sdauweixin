package servlet.student;

import po.CollegeEntity;
import po.StudentEntity;
import po.XieyiEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by libin on 2017/5/16.
 */
public class Student_SecondSanfangxieyi extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        int studentid;
        if (request.getSession().getAttribute("userid") != null) {
            studentid = Integer.parseInt(session.getAttribute("userid").toString());
        } else {
            studentid = Integer.parseInt(request.getParameter("studentid"));
        }
        //判断是否已经申请过
        String hql = "where studentid=" + studentid;
        List<XieyiEntity> students = HibernateUtil.query("XieyiEntity", hql);
        if (students.size() == 0) {
            XieyiEntity student = new XieyiEntity();
            //查找学生所属学院
            StudentEntity student2 = (StudentEntity) HibernateUtil.get(StudentEntity.class, studentid);
            String collegename = student2.getStudentcollege();
            String hql1 = "where collegename=" + "'" + collegename + "'";
            List<CollegeEntity> colleges = HibernateUtil.query("CollegeEntity", hql1);
            String collegeid = "";
            for (CollegeEntity college : colleges) {
                collegeid = college.getCollegeid() + "";

            }
            //判断学院id位数
            if (Integer.parseInt(collegeid) / 10 == 0) {
                collegeid = "0" + collegeid;
            }
            String others = request.getParameter("others");
            student.setStudentid(studentid);
            student.setState(0);
            student.setOthers(others);
            student.setCollegename(collegename);
            student.setComnature("党政机关、科研事业单位、学校、商贸公司、厂矿企业、部队、其它（划√）");
            HibernateUtil.add(student);
            //再次查找并拼接三方协议编号
            List<XieyiEntity> xieyis = HibernateUtil.query("XieyiEntity", "where studentid=" + studentid);
            for (XieyiEntity xieyi : xieyis) {
                String xieyiid = xieyi.getXieyiid() + " ";
                String xieyinumber1 = xieyiid.substring(0, 4);
                String xieyinumber2 = xieyiid.substring(4, 8);
                xieyi.setXieyinum(xieyinumber1 + collegeid + xieyinumber2);
                HibernateUtil.update(xieyi);
            }
            request.setAttribute("message", "申请成功");
            if (request.getSession().getAttribute("userid") != null) {
                request.getRequestDispatcher("/WEUI/operate_success.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("student_secondSanfangxieyi.jsp").forward(request, response);
            }

        } else {

            if (request.getSession().getAttribute("userid") != null) {
                request.getRequestDispatcher("/WEUI/sanfang.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "已提交过申请请耐心等待");
                request.getRequestDispatcher("student_secondSanfangxieyi.jsp").forward(request, response);
            }

        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
