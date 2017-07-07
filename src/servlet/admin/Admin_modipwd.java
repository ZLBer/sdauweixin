package servlet.admin;

import po.AdminEntity;
import servlet.Encrypt;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by john on 2017/5/1.
 */
public class Admin_modipwd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       AdminEntity admin=(po.AdminEntity)request.getSession().getAttribute("user");
       String pwd1=request.getParameter("pwd1");
        admin.setGpassword(Encrypt.MD5(pwd1));
        HibernateUtil.update(admin);
        String msg="修改成功";
        request.setAttribute("msg",msg);
        request.getRequestDispatcher("/admin/motifypwd.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
