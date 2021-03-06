package servlet.navigation;

import po.StampEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by libin on 2017/5/23.
 */
public class Navigation_Stamp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session=request.getSession();
        String hql="where collegestate='已审核' and  nstate='未审核'";
        String fieldName=request.getParameter("fieldName");
        String fieldValue=request.getParameter("fieldValue");
        String condition="";
        if(fieldName!=null && !"".equals(fieldName)){
            condition= hql+" and "+fieldName +" like '%"+fieldValue+"%' order by stampid desc";
        }
        else {
            condition= hql+" order by stampid";
        }
        int pageSize= 20;
        int pageNo=Integer.parseInt(request.getParameter("pageNo"));

        List<StampEntity> stamps = HibernateUtil.query("StampEntity",condition,"",pageNo,pageSize);
        int recordCount= HibernateUtil.recordCount("StampEntity", condition);
        if(recordCount>0) {
            int t1 = recordCount % pageSize;
            int t2 = recordCount / pageSize;
            int pageCount = (t1 == 0 ? t2 : t2 + 1);
            request.setAttribute("stamps", stamps);
            request.setAttribute("pageCount", pageCount);
            request.setAttribute("pageNo", pageNo);
            request.setAttribute("recordCount", recordCount);
        }
        if (session.getAttribute("userid") != null) {
            request.getRequestDispatcher("/WEUI/navigation_stamp.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("navigation_stamp.jsp").forward(request, response);
            }
    }
}
