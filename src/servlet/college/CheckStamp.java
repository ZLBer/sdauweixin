package servlet.college;

import po.CollegeEntity;
import po.CollegeloginEntity;
import po.StampEntity;
import po.StudentEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 2017/5/23.
 */
public class CheckStamp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        HttpSession session=request.getSession();
        CollegeloginEntity teacher = new CollegeloginEntity();
        CollegeEntity collegeEntity =new CollegeEntity();
        int collegeid;
        int pageNo=Integer.parseInt(request.getParameter("pageNo"));
        System.out.println("进入学院查看盖章servlet！");
        if(session.getAttribute("userid")!=null){               //如果微信端session不为空
            //从微信session中获取UserID
            String UserID = request.getSession().getAttribute("userid").toString();
            int empno = Integer.parseInt(UserID);
            List<CollegeloginEntity> teachers = new ArrayList<CollegeloginEntity>();
            teachers = HibernateUtil.query("CollegeloginEntity", "where empno =" + empno);
            if (teachers.size() > 0) {
                teacher = teachers.get(0);
            }
            //得到老师所属学院id
            collegeid = teacher.getCollegeid();
            System.out.println("老师所属学院为:"+collegeid);
        }else {                                                 //如果微信端seesion值为空
            collegeid=Integer.parseInt(request.getParameter("collegeid"));
        }
        session.setAttribute("collegeid",collegeid);
        String condition="where collegestate='未审核' and collegeid="+collegeid+" order by stampid desc";
        int pageSize=20;
        List<StampEntity> stamplist=HibernateUtil.query("StampEntity", condition, "", pageNo, pageSize);
        int recordCount= HibernateUtil.recordCount("StampEntity", condition);
        int t1=recordCount%pageSize;
        int t2=recordCount/pageSize;
        int pageCount=(t1==0?t2:t2+1);
        request.setAttribute("pageNo", pageNo);
        request.setAttribute("pageCount", pageCount);
        request.setAttribute("stamplist", stamplist);
        request.setAttribute("recordCount", recordCount);
        System.out.println("开始跳转到学院盖章jsp");
        if(session.getAttribute("userid")!=null){

            request.getRequestDispatcher("/WEUI/checkstamp.jsp").forward(request,response);

        }else{
            request.getRequestDispatcher("checkstamp.jsp").forward(request,response);
        }

    }
}
