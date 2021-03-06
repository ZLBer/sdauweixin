package servlet.navigation;

import po.ArticleEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by john on 2017/5/6.
 */
public class Article_queryByNavi extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int aid= Integer.parseInt(request.getParameter("aid"));
        String condition="where article.articleid="+aid;
        java.util.List<ArticleEntity> userList=new ArrayList<ArticleEntity>();
        userList= HibernateUtil.query("ArticleEntity article", condition);
        request.getSession().setAttribute("article",userList.get(0));
        request.setAttribute("articleList",userList);
        request.getRequestDispatcher("/navigation/navigation_modify.jsp").forward(request,response);

    }
}
