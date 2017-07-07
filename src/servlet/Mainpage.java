package servlet;

import po.ArticleEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by john on 2017/5/7.
 */
public class Mainpage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String condition="";
        condition=" where state='审核' and columnid=1";
        int pageSize=5;
        int pageNo=1;
        String order="order by articleid desc";
            int recordCount= HibernateUtil.recordCount("ArticleEntity", condition);
            if(recordCount>0){
                List<ArticleEntity> articlelist=HibernateUtil.query("ArticleEntity", condition, order, pageNo, pageSize);
                request.setAttribute("articleList", articlelist);
            }
        condition=" where state='审核' and columnid=2";
        List<ArticleEntity> articlespecial=HibernateUtil.query("ArticleEntity", condition, order, pageNo, pageSize);
        request.setAttribute("articleSpecial", articlespecial);
        request.getRequestDispatcher("/main.jsp").forward(request,response);
    }
}
