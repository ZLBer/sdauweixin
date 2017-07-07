package servlet.navigation;

import po.ArticleEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by C on 2017/5/7.
 */

public class Navigation_review extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String STATE = "审核";
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        //是否批量
        boolean isBatch = request.getParameter("batch").equals("true")?true:false;
        if(!isBatch) {
            //获取articleid
            int articleid = Integer.parseInt(request.getParameter("articleid"));
            ArticleEntity art = (ArticleEntity) HibernateUtil.get(ArticleEntity.class, articleid);
            art.setState(STATE);
            HibernateUtil.update(art);
            //相应信息
            out.print("<h1>已经审核通过企业号为 " + articleid + " 的招聘信息</h1><br>");
        }else{
            String[] articleSelectId = request.getParameterValues("articleSelectId");
            StringBuffer artIds = new StringBuffer("");
            //如果有articleSelectId 存在
            if(articleSelectId!=null){
                //组合id序列 为*,*,*,*,*格式
                for (String artId:articleSelectId){
                    artIds.append(artId+",");
                }
                artIds.delete(artIds.length()-1,artIds.length());
                //组成condition
                String condition = "where articleid IN ("+artIds+")";
                System.out.println(condition);
                List<ArticleEntity> articles = HibernateUtil.query("ArticleEntity",condition);
                for (ArticleEntity art:articles){
                    art.setState(STATE);
                    HibernateUtil.update(art);
                }
                out.print("<h1>批量通过完成</h1><br>");
            }else{
                out.print("<h1>您没有选择要通过的条目</h1><br>");
            }
        }
        out.print("<a href='navigation_edit?pageNo=1'>返回上一页<a/>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
