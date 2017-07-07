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
import java.util.*;

/**
 * Created by hello world on 2017/5/1.
 */
@WebServlet(name = "College_select")
public class College_select extends HttpServlet {
    private final int pageSize=10;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session=request.getSession();
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html,charset =utf-8");
        PrintWriter out = response.getWriter();
        int problemstate = 0;
        String Empno = "";
        String teacherName = "";
        //获取当前学院用户的ID

        int collegeid=0;
        if(session.getAttribute("userid")!=null){     //如果微信端session不为空
            System.out.println("测试测试/微信端UserID不为空/执行微信端代码");
            Empno = session.getAttribute("userid").toString();
            System.out.println("loginuser");
            String condition="where college.empno='"+Empno+"'";
            java.util.List<CollegeloginEntity> userList=new ArrayList<CollegeloginEntity>();
            userList= HibernateUtil.query("CollegeloginEntity college", condition);
            System.out.print(userList.size());
            if(userList.size()>0) {
                collegeid = userList.get(0).getCollegeid();
                teacherName = userList.get(0).getTeachername();
            }
        }
        else {
            System.out.println("测试测试/微信端UserID为空/执行电脑端代码");//如果电脑端session为空
            CollegeloginEntity loginuser = (CollegeloginEntity) session.getAttribute("user");
            System.out.println(loginuser.getEmpno());
            Empno=loginuser.getEmpno();
            String condition="where college.empno='"+Empno+"'";
            java.util.List<CollegeloginEntity> userList=new ArrayList<CollegeloginEntity>();
            userList= HibernateUtil.query("CollegeloginEntity college", condition);
            System.out.print(userList.size());
            if(userList.size()>0) {
                collegeid = userList.get(0).getCollegeid();
                teacherName = userList.get(0).getTeachername();
            }
        }

        String condition="WHERE teachername='"+teacherName+"'" +
                " AND collegeid="+collegeid+
                " AND problemstate ="+problemstate;
        String orderBy="order by problemid desc";
        //得到页数如果为零页数为1
        int pageNo=Integer.parseInt(request.getParameter("pageNo")==null?"1":request.getParameter("pageNo"));
        System.out.println(pageNo);
        //总记录条数
        int recordCount= HibernateUtil.recordCount("ProblemEntity", condition);
        //得到按照默认排序的问题集合
        List<ProblemEntity> problemList=HibernateUtil.query("ProblemEntity problem", condition,orderBy, pageNo, pageSize);
        //得到最终结果
        Map<Integer,String> map = new HashMap<Integer,String>();
        try {
            if(recordCount>0){
                int t1=recordCount%pageSize;
                int t2=recordCount/pageSize;
                int pageCount=(t1==0?t2:t2+1);
                request.setAttribute("pageNo", pageNo);//页号
                request.setAttribute("pageCount", pageCount);//总页数
            }
            List<String> text = new ArrayList<String>();

            for(int i=0;i<problemList.size();i++)
            {
                text.add(i,problemList.get(i).getProblemtext().substring(0,3)+"......");
                problemList.get(i).setProblemtext(text.get(i));

            }
            request.setAttribute("recordCount", recordCount);
            request.setAttribute("problemList", problemList);//返回查询到的问题结果
            //根据问题号跟对应问题text两个list集合形成映射
            //request.setAttribute("resultMap",map);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.print("出错啦！");
        }

        if(session.getAttribute("userid")!=null){
            System.out.print("转发到WEUI");
            request.getRequestDispatcher("/WEUI/problemquery.jsp").forward(request, response);
        }
        else{
            System.out.print("转发到电脑端jsp");
            request.getRequestDispatcher("/college/ProblemQuery.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }
}
