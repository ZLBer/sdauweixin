package servlet.article;

import po.ArticleEntity;
import po.DemandEntity;
import po.MajorEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by john on 2017/4/22.
 */
public class Article_query extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        request.setCharacterEncoding("UTF-8");
        int aid= Integer.parseInt(request.getParameter("aid"));
        String condition="where article.articleid="+aid;
        java.util.List<ArticleEntity> userList=new ArrayList<ArticleEntity>();
        userList= HibernateUtil.query("ArticleEntity article", condition);
        ArticleEntity article=userList.get(0);
        String other=article.getOther();
        Timestamp articletime=article.getArticletime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String articleDay=df.format(articletime);
        request.setAttribute("other",other);
        request.setAttribute("article",article);
        request.setAttribute("articleDay",articleDay);

  //获取需求专业
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
        request.setAttribute("demandList",userList2);
        request.setAttribute("majorList", majorList);


        request.getRequestDispatcher("/show.jsp").forward(request,response);
    }
}
