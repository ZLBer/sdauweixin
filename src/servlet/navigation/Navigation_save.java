package servlet.navigation;

import po.ArticleEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by C on 2017/5/10.
 */
public class Navigation_save extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int articleid=Integer.parseInt(request.getParameter("articleid"));
        String enterprisename=request.getParameter("enterprisename");
        String articletext = request.getParameter("articletext");
        ArticleEntity a = (ArticleEntity) HibernateUtil.get(ArticleEntity.class,articleid);
        a.setEnterprisename(enterprisename);
        a.setArticletext(articletext);
            HibernateUtil.update(a);
        request.getRequestDispatcher("/navigation/save.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
