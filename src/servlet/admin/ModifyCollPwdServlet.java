package servlet.admin;

import po.CollegeloginEntity;
import servlet.Encrypt;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Minister on 2017/5/24.
 */
public class ModifyCollPwdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));
        CollegeloginEntity collegeUser = (CollegeloginEntity) HibernateUtil.get(CollegeloginEntity.class,id);
        collegeUser.setCollegepwd(Encrypt.MD5("123456"));
        HibernateUtil.update(collegeUser);

        try{
            out.print("<h1>成功重置密码为123456</h1>");
        }catch(Exception e){
            out.print("<h1>重置密码失败</h1>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
