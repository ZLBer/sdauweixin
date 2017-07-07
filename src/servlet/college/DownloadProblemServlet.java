package servlet.college;

import po.CollegeloginEntity;
import po.ProblemEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Minister on 2017/5/24.
 */
public class DownloadProblemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //获取学院号
        CollegeloginEntity user= (CollegeloginEntity) session.getAttribute("user");
        int collegeId = user.getCollegeid();
        //查询数据库获得实体类列表
        List<ProblemEntity> problemEntityList = HibernateUtil.query("ProblemEntity","WHERE collegeid="+collegeId, "ORDER BY studentid");

        request.setAttribute("problems",problemEntityList);
        request.getRequestDispatcher("downloadProblem.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
