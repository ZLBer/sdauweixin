package servlet.college;

import po.CollegeEntity;
import po.StudentEntity;
import po.XieyiEntity;
import util.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by libin on 2017/5/4.
 */
//学院查看未审核三方协议
public class College_CheckSanfangxieyi extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type","text/html;charset=UTF-8");
       int collegeid=Integer.parseInt(request.getParameter("collegeid"));
        CollegeEntity college=(CollegeEntity) HibernateUtil.get(CollegeEntity.class,collegeid);
       int  page_current=Integer.parseInt(request.getParameter("page_current"));
   int page_size=10;
      String collegename=college.getCollegename();
        String  hql="where state=0 and collegename="+"'"+collegename+"'";
      List<XieyiEntity> students=HibernateUtil.query("XieyiEntity",hql);
  //设置分页相关信息
        if(page_current>(students.size()%page_size==0?students.size()/page_size:students.size()/page_size+1))
        {
            request.setAttribute("page_current",page_current-1);
        }
        else if(page_current<1)
            request.setAttribute("page_current",1);
        else
        request.setAttribute("page_current",page_current);//页码
        request.setAttribute("page_size",10);//页码
        request.setAttribute("length",students.size());//总长度
        request.setAttribute("page_count",students.size()%page_size==0?students.size()/page_size:students.size()/page_size+1);//总页码
        request.setAttribute("students",students); //遍历集合
        request.getRequestDispatcher("college_checkSanfangxieyi.jsp").forward(request,response);
}
}
