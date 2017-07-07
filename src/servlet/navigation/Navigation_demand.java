package servlet.navigation;

import po.ArticleEntity;
import po.DemandEntity;
import po.MajorEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by C on 2017/5/15.
 */
public class Navigation_demand extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int aid= Integer.parseInt(request.getParameter("aid"));
//        int articleid=Integer.parseInt(request.getParameter("articleid"));
        String condition2="where demand.articleid="+aid;
        java.util.List<DemandEntity> userList2=new ArrayList<DemandEntity>();
        userList2= HibernateUtil.query("DemandEntity demand", condition2);
        java.util.List<MajorEntity> majorList = new ArrayList<MajorEntity>();
        java.util.List<MajorEntity> mList = new ArrayList<MajorEntity>();
        for (int i = 0; i < userList2.size(); i++) {
            int m = userList2.get(i).getMajorid();
            String condition3 = "where major.majorid=" + m;
            mList = HibernateUtil.query("MajorEntity major", condition3);
            if (mList.size() > 0)
                majorList.add(mList.get(0));
        }
        request.setAttribute("aid",aid);
        request.setAttribute("demandList",userList2);

        request.setAttribute("majorList", majorList);
        request.getRequestDispatcher("/navigation/navigation_demand.jsp").forward(request,response);


    }
}
