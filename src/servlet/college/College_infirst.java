package servlet.college;

import oracle.jrockit.jfr.parser.ChunkParser;
import po.ArticleEntity;
import po.CollegeloginEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by C on 2017/5/11.
 */
public class College_infirst extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        String state = "审核";
        String   articletext=request.getParameter("articletext");
        String   enterprisename=request.getParameter("enterprisename");
        HttpSession session=request.getSession();
        String   author=request.getParameter("author");
        String   authortel=request.getParameter("authortel");
        String   other=request.getParameter("other");
        if(other==null) other=" ";

        String  columnid=request.getParameter("columnid");


        ArticleEntity articleEntity=new  ArticleEntity();
        articleEntity.setArticletext(articletext);
        articleEntity.setEnterprisename(enterprisename);
        articleEntity.setAuthor(author);
        articleEntity.setAuthortel(authortel);
        //other字段加学院老师标识
        articleEntity.setOther( (String)session.getAttribute("teachername")+":"+other);
        articleEntity.setState(state);

        //时间戳
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Date date = new Date();// new Date()为获取当前系统时间，也可使用当前时间戳
        Timestamp nousedate = new Timestamp(date.getTime());
        articleEntity.setArticletime(nousedate);
        if(columnid.equals("2")) {
            articleEntity.setColumnid(2);
            HibernateUtil.add(articleEntity);
            String condition="where article.enterprisename='"+enterprisename+"' order by articleid desc";
            java.util.List<ArticleEntity> userList=new ArrayList<ArticleEntity>();
            userList= HibernateUtil.query("ArticleEntity article", condition);
            session.setAttribute("article",userList.get(0));
            request.getServletContext().getRequestDispatcher("/college/input_second.jsp").forward(request, response);
        }
        else {
            articleEntity.setColumnid(1);
            HibernateUtil.add(articleEntity);
            String condition="where article.enterprisename='"+enterprisename+"' order by articleid desc";
            java.util.List<ArticleEntity> userList=new ArrayList<ArticleEntity>();
            userList= HibernateUtil.query("ArticleEntity article", condition);
            session.setAttribute("article",userList.get(0));
            request.getServletContext().getRequestDispatcher("/college/input_second2.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
