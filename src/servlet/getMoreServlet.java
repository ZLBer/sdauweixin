package servlet;

import util.HibernateUtil;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 本servlet用于查询特定栏目下所有审核后的招聘信息
 * 需要参数：
 * pageNo:查询页数
 * columnId:栏目ID
 */
@WebServlet(name = "getMoreServlet",urlPatterns = "/getMoreServlet")
public class getMoreServlet extends HttpServlet {
    public static final String STATE_PASS = "审核";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String pageNo = request.getParameter("pageNo");
        String columnId = request.getParameter("columnId");
        String clazz = "ArticleEntity";
        String condition = "WHERE state='"+STATE_PASS+"' " +
                "AND columnid = "+columnId;
        int count = HibernateUtil.recordCount(clazz,condition);
        int PAGE_SIZE = 10;
        List infoList = HibernateUtil.query(
                clazz,
                condition,
                "ORDER BY articletime DESC",
                Integer.parseInt(pageNo), PAGE_SIZE);

        String href;
        if (columnId.equals("1")){
            href = "filter.jsp?columnId=1&pageNo=";
        }else {
            href = "filter.jsp?columnId=2&pageNo=";
        }
        request.setAttribute("infoList",infoList);
        request.setAttribute("currentPage",pageNo);
        request.setAttribute("pageSize", PAGE_SIZE);
        request.setAttribute("count",count);
        request.setAttribute("servlet",href);
        request.getRequestDispatcher("moreInfo.jsp").forward(request,response);
    }
}
