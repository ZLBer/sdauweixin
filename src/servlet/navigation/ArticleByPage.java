package servlet.navigation;

import po.ArticleEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by john on 2017/5/14.
 */
public class ArticleByPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String condition="";
        int flag=Integer.parseInt(request.getParameter("flag"));
        if(flag==0) {
            condition = "where state='未审核' and columnid=1";
        }
        else if(flag==2)
        {
            condition = "where state='未审核' and columnid=2";
        }
        else if(flag==3)
        {
            condition = "where columnid=2";
        }
        else if(flag==1)
        {
            condition = "where columnid=1";
        }
        int pageSize=5;
        int pageNo=Integer.parseInt(request.getParameter("pageNo"));
            int recordCount= HibernateUtil.recordCount("ArticleEntity", condition);
            if(recordCount>0){
                List<ArticleEntity> articlelist= HibernateUtil.query("ArticleEntity", condition, "", pageNo, pageSize);
                int t1=recordCount%pageSize;
                int t2=recordCount/pageSize;
                int pageCount=(t1==0?t2:t2+1);
                request.setAttribute("pageNo", pageNo);
                request.setAttribute("pageCount", pageCount);
                request.setAttribute("articlelist", articlelist);
            }
            request.setAttribute("recordCount", recordCount);
        if(flag==0) {
            request.getRequestDispatcher("/navigation/navigation_edit.jsp").forward(request,response);
        }
        else if(flag==2)
        {
            request.getRequestDispatcher("/navigation/navigation_special.jsp").forward(request,response);
        }
        else if(flag==3)
        {
            request.getRequestDispatcher("/navigation/navigationSpecialView.jsp").forward(request,response);
        }
        else  request.getRequestDispatcher("/navigation/navigation_view.jsp").forward(request,response);
    }
}
