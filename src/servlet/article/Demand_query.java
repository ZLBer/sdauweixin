package servlet.article;

import po.ArticleEntity;
import po.CollegeEntity;
import po.DemandEntity;
import po.MajorEntity;
import util.HibernateUtil;
import weixin.msg.Resp.Article;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by john on 2017/4/22.
 */
public class Demand_query extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        ArticleEntity article=new ArticleEntity();
        MajorEntity user=new MajorEntity();
        String majorname = new String(request.getParameter("major").getBytes("iso-8859-1"),"UTF-8");
        //String majorname=request.getParameter("major");
        int collegeid=Integer.parseInt(request.getParameter("college"));

        java.util.List<MajorEntity> userList=new ArrayList<MajorEntity>();
        String condition="where major.majorname='"+majorname+"' and major.collegeid="+collegeid;
        userList=HibernateUtil.query("MajorEntity major", condition);
        if(userList.size()>0)
            user=userList.get(0);
        int majorid=user.getMajorid();
        String condition2="where demand.majorid="+majorid;
        java.util.List<DemandEntity> demandList=new ArrayList<DemandEntity>();
        java.util.List<ArticleEntity> articleList=new ArrayList<ArticleEntity>();
        java.util.List<ArticleEntity> articleList2=new ArrayList<ArticleEntity>();
        demandList= HibernateUtil.query("DemandEntity demand", condition2);

        for(int i=0;i<demandList.size();i++) {
            String condition3="where article.articleid="+demandList.get(i).getArticleid();
            articleList2=HibernateUtil.query("ArticleEntity article",condition3);
            if(articleList2.size()>0)
                articleList.add(articleList2.get(0));
        }
        if(articleList.size()>0){
            request.setAttribute("articleList", articleList);
        }
        else{
            String msg="未查询到该专业的招聘信息！";
            request.setAttribute("msg",msg);
        }
        request.getRequestDispatcher("/result.jsp").forward(request,response);
    }
}
