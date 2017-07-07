package servlet.navigation;

import po.CollegeEntity;
import po.XieyiEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by libin on 2017/5/18.
 */
@WebServlet(name = "Navigation_CheckSanfangxieyi")
public class Navigation_CheckSanfangxieyi extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type","text/html;charset=UTF-8");
        HttpSession session=request.getSession();

        String hql="where state=1 ";
        List<XieyiEntity> students=HibernateUtil.query("XieyiEntity",hql);
        int schoolcount=students.size();            //学校三方协议发放数量
        List<String[]> all=new ArrayList<>();
        for(int collegeid=11;collegeid<28;collegeid++) {

            CollegeEntity colleges = (CollegeEntity) HibernateUtil.get(CollegeEntity.class, collegeid);
            String collegename = colleges.getCollegename();
            String []college=new String[3];
            college[0] = collegeid+"";
            college[1] = collegename;
            String hql1 = "where state=1 and collegename=" + "'" + collegename + "'";
            int counts = HibernateUtil.recordCount("XieyiEntity", hql1);
            college[2] = counts+"";
            System.out.println(college[0]);
            System.out.println(college[1]);
            System.out.println(college[2]);
            all.add(college);
            college=null;
            request.setAttribute("schoolcount",schoolcount);
        }
        if(session.getAttribute("userid")!=null){
            request.setAttribute("all", all);
            request.getRequestDispatcher("/WEUI/navigation_CheckSanfangNum.jsp").forward(request,response);
        }
        else{
            request.setAttribute("all", all);
            request.getRequestDispatcher("/navigation/navigation_showSanfangxieyi.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
