package servlet.navigation;

import org.hibernate.sql.Select;
import util.HibernateUtil;
import weixin.msg.Resp.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by C on 2017/4/21.
 */

public class Navigation_edit extends HttpServlet {
    /**
     * Constructor of the object.
     */
    public Navigation_edit() {
        super();
    }

    /**
     * Destruction of the servlet. <br>
     */
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }
    /**
     * The doGet method of the servlet. <br>
     *
     * This method is called when a form has its tag value method equals to get.
     *
     * @param request the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException if an error occurred
     */


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String fieldName=request.getParameter("fieldName");
        String fieldValue=request.getParameter("fieldValue");
        String condition="";

        condition="where state='未审核' order by articleid";


        int pageSize=20;
        int pageNo=Integer.parseInt(request.getParameter("pageNo")==null?"1":request.getParameter("pageNo"));
        try {
            int recordCount=HibernateUtil.recordCount("ArticleEntity", condition);
            if(recordCount>0){
                List<Article> articlelist=HibernateUtil.query("ArticleEntity", condition, "", pageNo, pageSize);
                int t1=recordCount%pageSize;
                int t2=recordCount/pageSize;
                int pageCount=(t1==0?t2:t2+1);
                request.setAttribute("pageNo", pageNo);
                request.setAttribute("pageCount", pageCount);
                request.setAttribute("articlelist", articlelist);
            }
            request.setAttribute("recordCount", recordCount);

            request.getRequestDispatcher("/navigation/navigation_edit.jsp").forward(request,response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public void init() throws ServletException {
        // Put your code here
    }
}
