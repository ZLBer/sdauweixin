package servlet.college;

import po.CollegeloginEntity;
import po.ResumeEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by libin on 2017/9/9.
 */

public class College_selectResume extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");

        if(request.getSession().getAttribute("userid")!=null) {         //如果微信端userid不为空
            int pageSize = 20;
            HttpSession session = request.getSession();
            CollegeloginEntity college = (CollegeloginEntity) session.getAttribute("user");
            List<ResumeEntity> resumes = HibernateUtil.query("ResumeEntity", "where teacher_id='" + college.getEmpno() + "' and state=0", "order by id desc");
            request.setAttribute("resumes", resumes);
            //分页
            int pageNo = Integer.parseInt(request.getParameter("pageNo") == null ? "1" : request.getParameter("pageNo"));
            int recordCount = resumes.size();

            if (recordCount > 0) {
                int t1 = recordCount % pageSize;
                int t2 = recordCount / pageSize;
                int pageCount = (t1 == 0 ? t2 : t2 + 1);
                request.setAttribute("pageNo", pageNo);//页号
                request.setAttribute("pageCount", pageCount);//总页数
            }
            request.setAttribute("recordCount", recordCount);
            request.getRequestDispatcher("/WEUI/selectResume.jsp").forward(request,response);
        }
        else {
            int pageSize = 20;
            HttpSession session = request.getSession();
            CollegeloginEntity college = (CollegeloginEntity) session.getAttribute("user");
            List<ResumeEntity> resumes = HibernateUtil.query("ResumeEntity", "where teacher_id='" + college.getEmpno() + "' and state=0", "order by id desc");
            request.setAttribute("resumes", resumes);
            //分页
            int pageNo = Integer.parseInt(request.getParameter("pageNo") == null ? "1" : request.getParameter("pageNo"));
            int recordCount = resumes.size();

            if (recordCount > 0) {
                int t1 = recordCount % pageSize;
                int t2 = recordCount / pageSize;
                int pageCount = (t1 == 0 ? t2 : t2 + 1);
                request.setAttribute("pageNo", pageNo);//页号
                request.setAttribute("pageCount", pageCount);//总页数
            }
            request.setAttribute("recordCount", recordCount);
            request.getRequestDispatcher("selectResume.jsp").forward(request, response);
        }
    }
}
