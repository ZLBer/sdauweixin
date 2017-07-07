package servlet.enterprise;

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
 * Created by C on 2017/5/12.
 */
public class Demand_delete2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArticleEntity arti=(ArticleEntity)request.getSession().getAttribute("article");
        int art=arti.getArticleid();
        int majorid=Integer.parseInt(request.getParameter("majorid"));

        String condition = "where demand.articleid=" + art + " and demand.majorid=" + majorid;
        java.util.List<DemandEntity> demandList = new ArrayList<DemandEntity>();
        demandList = HibernateUtil.query("DemandEntity demand", condition);
        DemandEntity demand = new DemandEntity();
        if (demandList.size() > 0)
            demand = demandList.get(0);
        HibernateUtil.delete(demand);

        String condition2 = "where demand.articleid=" + art;
        demandList = HibernateUtil.query("DemandEntity demand", condition2);

        java.util.List<MajorEntity> majorList = new ArrayList<MajorEntity>();
        java.util.List<MajorEntity> mList = new ArrayList<MajorEntity>();
        for (int i = 0; i < demandList.size(); i++) {
            int m = demandList.get(i).getMajorid();
            String condition3 = "where major.majorid=" + m;
            mList = HibernateUtil.query("MajorEntity major", condition3);
            if (mList.size() > 0)
                majorList.add(mList.get(0));
        }
        request.setAttribute("demandList", demandList);
        request.setAttribute("majorList", majorList);
        request.getRequestDispatcher("/enterprise/input_second2.jsp").forward(request, response);
    }
}
