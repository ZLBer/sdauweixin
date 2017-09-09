package servlet.navigation;

import po.ArticleEntity;
import util.HibernateUtil;
import weixin.msg.Resp.Article;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by C on 2017/5/9.
 */
public class Navigation_view extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String fieldName = request.getParameter("fieldName");
        String fieldValue = request.getParameter("fieldValue");
        String condition = "";
        if (fieldName != null && !"".equals(fieldName)) {
            condition = " where " + fieldName + " like '%" + fieldValue + "%' ";
        }
        int pageSize = 20;
        int pageNo=Integer.parseInt(request.getParameter("pageNo")==null?"1":request.getParameter("pageNo"));
        try {
            int recordCount = HibernateUtil.recordCount("ArticleEntity", condition);
            if (recordCount > 0) {
                List<Article> articlelist = HibernateUtil.query("ArticleEntity", condition, "order by articleid desc", pageNo, pageSize);
                int t1 = recordCount % pageSize;
                int t2 = recordCount / pageSize;
                int pageCount = (t1 == 0 ? t2 : t2 + 1);
                request.setAttribute("pageNo", pageNo);
                request.setAttribute("pageCount", pageCount);
                request.setAttribute("articlelist", articlelist);
            }
            request.setAttribute("recordCount", recordCount);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //将招聘信息发送到WEUI界面

        if(request.getSession().getAttribute("userid")!=null){
            request.getRequestDispatcher("/WEUI/jobinfo.jsp").forward(request, response);
        }
        else{
            request.getRequestDispatcher("/navigation/navigation_view.jsp").forward(request, response);
        }
    }

    public void init() throws ServletException {
        // Put your code here
    }
}
