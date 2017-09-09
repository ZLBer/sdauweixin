package servlet.navigation;

import util.HibernateUtil;
import weixin.msg.Resp.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by C on 2017/4/20.
 */
@WebServlet(name = "Student_view")
public class Student_view extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public Student_view() {
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
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();


    }

    /**
     * The doPost method of the servlet. <br>
     *
     * This method is called when a form has its tag value method equals to post.
     *
     * @param request the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException if an error occurred
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String fieldName=request.getParameter("fieldName");
            String fieldValue=request.getParameter("fieldValue");
            String condition="";
            if(fieldName!=null && !"".equals(fieldName)){
                condition=" where "+fieldName +" like '%"+fieldValue+"%'";
            }
            int pageSize=5;
            int pageNo=Integer.parseInt(request.getParameter("pageNo"));
            try {
                int recordCount=HibernateUtil.recordCount("ArticleEntity", condition);
            if(recordCount>0){
                List<Article> articlelist=HibernateUtil.query("ArticleEntity", condition, "order by articleid desc", pageNo, pageSize);
                int t1=recordCount%pageSize;
                int t2=recordCount/pageSize;
                int pageCount=(t1==0?t2:t2+1);
                request.setAttribute("pageNo", pageNo);
                request.setAttribute("pageCount", pageCount);
                request.setAttribute("articlelist", articlelist);
            }
            request.setAttribute("recordCount", recordCount);

            request.getRequestDispatcher("").forward(request,response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException if an error occurs
     */
    public void init() throws ServletException {
        // Put your code here
    }
}

