package servlet.student;

import po.ProblemEntity;
import po.StudentEntity;
import po.StudentloginEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 完成了通过学生学号来查找该学生对应的问题
 * Created by hello world on 2017/5/2.
 */
@WebServlet(name = "CheckProblem")
public class CheckProblem extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html,charset=utf-8");

        HttpSession session = request.getSession();
        ProblemEntity problem = new ProblemEntity();
        int studentid;

        if(request.getSession().getAttribute("userid")!=null){           //如果微信端session不为空
            String id=(String)session.getAttribute("userid");
            studentid=Integer.parseInt(id);
        }
        else {                                                              //如果电脑端session不为空
            StudentloginEntity studentloginEntity = (StudentloginEntity) session.getAttribute("user");
            studentid = studentloginEntity.getStudentid();
        }

        //查询关于本学生的所有问题
        String condition = "where studentid=" + studentid;
        //按时间从最新到最晚排序
        String orderBy = "order by problemid desc";
        int recordCount =HibernateUtil.recordCount("ProblemEntity problem",condition);
        System.out.print(recordCount);
        int pageNo =Integer.parseInt(request.getParameter("pageNo")==null?"1":request.getParameter("pageNo"));
        int pageSize =10;
        //查询到当前学生的问题记录条数
        //int count = HibernateUtil.recordCount("ProblemEntity problemEntity", condition);
        List<ProblemEntity> problemList = HibernateUtil.query("ProblemEntity problem",condition,orderBy,pageNo,pageSize);
        //测试
        if (problemList.size() > 0) {
            problem = problemList.get(0);
        }

        if(recordCount>0)
        {
            int t1 =recordCount%pageSize;
            int t2 =recordCount/pageSize;
            int pageCount =(t1==0?t2:t2+1);
            request.setAttribute("pageNo", pageNo);//页号
            request.setAttribute("pageCount", pageCount);//总页数
        }
        List<String> text = new ArrayList<String>();
        for(int i=0;i<problemList.size();i++)
        {
                text.add(i,problemList.get(i).getProblemtext().substring(0,5)+"...");
                problemList.get(i).setProblemtext(text.get(i));

        }
        request.setAttribute("problemList", problemList);//返回查询到的问题结果
        request.setAttribute("recordCount", recordCount);

        if(request.getSession().getAttribute("userid")!=null){
            request.getRequestDispatcher("/WEUI/student_problem.jsp").forward(request, response);
        }
        else{
            request.getRequestDispatcher("ProblemList.jsp").forward(request, response);
        }


    }
}
