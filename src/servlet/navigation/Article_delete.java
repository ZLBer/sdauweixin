package servlet.navigation;

import po.ArticleEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by john on 2017/5/1.
 */
public class Article_delete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int eid=Integer.parseInt(request.getParameter("articleid"));
        String all=request.getParameter("all");

        HibernateUtil.delete(ArticleEntity.class, eid);
        response.sendRedirect("articleByPage?pageNo=1&flag="+all);
    }
}
