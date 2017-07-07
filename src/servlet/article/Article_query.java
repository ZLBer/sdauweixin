package servlet.article;

import po.ArticleEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by john on 2017/4/22.
 */
public class Article_query extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        request.setCharacterEncoding("UTF-8");
        int aid= Integer.parseInt(request.getParameter("aid"));
        String condition="where article.articleid="+aid;
        java.util.List<ArticleEntity> userList=new ArrayList<ArticleEntity>();
        userList= HibernateUtil.query("ArticleEntity article", condition);
        request.setAttribute("articleList",userList);
        request.getRequestDispatcher("/show.jsp").forward(request,response);
    }
}
