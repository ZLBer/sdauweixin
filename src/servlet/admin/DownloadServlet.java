package servlet.admin;

import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Minister on 2017/7/1.
 */
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content = request.getParameter("content");
        String forwardTo = null;
        List list = null;
        switch (content){
            case "sanFangXieYi":
                list = HibernateUtil.query("XieyiEntity","");
                forwardTo = "sanFangXieYi.jsp";
                break;
            case "stamp":
                list = HibernateUtil.query("StampEntity","");
                forwardTo = "stampExcel.jsp";
                break;
        }
        request.setAttribute("list",list);
        request.getRequestDispatcher(forwardTo).forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
