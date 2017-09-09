package servlet.college;

import po.*;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hello world on 2017/5/10.
 */
@WebServlet(name = "College_problemAll")
public class College_problemAll extends HttpServlet {
    private final int pageSize =20;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html,charset =utf-8");
        PrintWriter out = response.getWriter();
        int problemstate = 0;
        int collegeid;
        String teacherName = "";
        //获取当前学院用户的姓名
        if(session.getAttribute("userid")!=null){     //如果微信端session不为空

            String loginuser = session.getAttribute("userid").toString();
            String condition="where college.collegename='"+loginuser+"' AND ";
            java.util.List<CollegeloginEntity> userList=new ArrayList<CollegeloginEntity>();
            userList= HibernateUtil.query("CollegeloginEntity college", condition);
            System.out.print(userList.size());
            collegeid=userList.get(0).getCollegeid();
        }
        else {                                                        //如果电脑端session不为空
            CollegeloginEntity loginuser = (CollegeloginEntity) session.getAttribute("user");
            collegeid = loginuser.getCollegeid();
            teacherName = loginuser.getTeachername();
        }

        //默认查询未回答状态，顺序按照问题发布时间从晚到早排序
        String condition = "where collegeid=" + collegeid+" AND teachername='"+teacherName+"'";
        String orderBy = "order by problemid desc";
        //得到页数如果为零页数为1
        int pageNo = Integer.parseInt(request.getParameter("pageNo") == null ? "1" : request.getParameter("pageNo"));
        //总记录条数
        int recordCount = HibernateUtil.recordCount("ProblemEntity", condition);
        //得到按照默认排序的问题集合
        List<ProblemEntity> problemList = HibernateUtil.query("ProblemEntity problem", condition, orderBy, pageNo, pageSize);
        System.out.println(problemList.size());
        //得到最终结果
        Map<Integer, String> map = new HashMap<Integer, String>();
        try {
            if (recordCount > 0) {
                int t1 = recordCount % pageSize;
                int t2 = recordCount / pageSize;
                int pageCount = (t1 == 0 ? t2 : t2 + 1);
                request.setAttribute("pageNo", pageNo);//页号
                request.setAttribute("pageCount", pageCount);//总页数
            }
            List<String> text = new ArrayList<String>();

            for (int i = 0; i < problemList.size(); i++) {
                text.add(i, problemList.get(i).getProblemtext().substring(0, 3) + "......");
                problemList.get(i).setProblemtext(text.get(i));

            }

            request.setAttribute("recordCount", recordCount);
            request.setAttribute("problemList", problemList);//返回查询到的问题结果
            //根据问题号跟对应问题text两个list集合形成映射
            //request.setAttribute("resultMap",map);
            if(request.getSession().getAttribute("userid")!=null){
                System.out.println("跳转到WEUI界面");
                request.getRequestDispatcher("/WEUI/problemquery.jsp").forward(request, response);
            }
            else {
                System.out.println("跳转到电脑端前台界面");
                request.getRequestDispatcher("problemall_list.jsp").forward(request, response);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.print("error");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }

}
