package servlet;

import po.ArticleEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "getMoreServlet",urlPatterns = "/getMoreServlet")
public class getMoreServlet extends HttpServlet {
    public static final String STATE_PASS = "审核";
    private final int PAGE_SIZE = 10;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String pageNo = request.getParameter("pageNo");
        String clazz = "ArticleEntity";
        String condition = "WHERE state='"+STATE_PASS+"'";
        int count = HibernateUtil.recordCount(clazz,condition);
        List infoList = HibernateUtil.query(
                clazz,
                condition,
                "ORDER BY articletime DESC",
                Integer.parseInt(pageNo),PAGE_SIZE);

        request.setAttribute("infoList",infoList);
        request.setAttribute("currentPage",pageNo);
        request.setAttribute("pageSize",PAGE_SIZE);
        request.setAttribute("count",count);
        request.setAttribute("servlet","filter.jsp?pageNo=");
        request.getRequestDispatcher("moreInfo.jsp").forward(request,response);
    }
}
