package servlet.college;

import po.ArticleEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by C on 2017/5/11.
 */
public class College_infirst extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        String state = "审核";
        String   articletext=request.getParameter("articletext");
        String   enterprisename=request.getParameter("enterprisename");
        HttpSession session=request.getSession();
        String   author=request.getParameter("author");
        String   authortel=request.getParameter("authortel");
        String   other=request.getParameter("other");


        ArticleEntity articleEntity=new  ArticleEntity();
        articleEntity.setArticletext(articletext);
        articleEntity.setEnterprisename(enterprisename);
        articleEntity.setAuthor(author);
        articleEntity.setAuthortel(authortel);
        articleEntity.setOther(other);
        articleEntity.setState(state);

        //时间戳
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Date date = new Date();// new Date()为获取当前系统时间，也可使用当前时间戳
        Timestamp nousedate = new Timestamp(date.getTime());
        articleEntity.setArticletime(nousedate);
        articleEntity.setColumnid(2);
        HibernateUtil.add(articleEntity);
        session.setAttribute("article",articleEntity);
        request.getServletContext().getRequestDispatcher("/college/input_second.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
