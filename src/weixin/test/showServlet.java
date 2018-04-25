package weixin.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import po.SStudentrecordEntity;
import po.StudentEntity;
import servlet.Encrypt;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "showServlet",urlPatterns = "/showServlet")
public class showServlet extends BaseServlet {

    public String test(HttpServletRequest request,HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        String userID=(String) session.getAttribute("userid");
//        String useriID=request.getParameter("sId");
        //int userid=Integer.parseInt(userID);
        SStudentrecordEntity student=new SStudentrecordEntity();
//
//        SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
//        Session session1=sessionFactory.openSession();
//
//        student= (SStudentrecordEntity) session1.createQuery(querysql);
        student= (SStudentrecordEntity) HibernateUtil.get(SStudentrecordEntity.class,userID);
        request.setAttribute("student",student);
        return "forward:/student/informationshow.jsp";
    }
}
//showServlet?method=test