package servlet.college;

import po.CollegeEntity;
import po.CollegeloginEntity;
import po.StudentEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Minister on 2017/4/21.
 */
public class GotoCheckStuInfoServlet extends HttpServlet {
    private  final int PAGE_SIZE = 30;//每页显示的记录数
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //获取学院号
        CollegeloginEntity user= (CollegeloginEntity) session.getAttribute("user");
        int collegeId = user.getCollegeid();
        //获取学院名
        CollegeEntity college = (CollegeEntity) HibernateUtil.get(CollegeEntity.class,collegeId);
        String collegeName = college.getCollegename();
        System.out.println(collegeName);
        //得到包装过的condition
        StringBuffer wrappedCondition = (StringBuffer) request.getAttribute("condition");
        String condition = null;
        //如果没有则新建,并清空Session中的属性
        if(wrappedCondition==null) {
            condition = "where studentcollege = '" + collegeName+"'";//查询学生信息的条件
            session.setAttribute("major",null);
            session.setAttribute("classes",null);
            session.setAttribute("sex",null);
            session.setAttribute("state",null);
        }else{
            condition = wrappedCondition.insert(0,"where studentcollege = '" + collegeName + "'").toString();
        }
        System.out.println("condition: "+condition);
        //要排序的属性
        String orderBy = "order by studentid";
        //获取总记录数count，和请求的页面数page 并计算总页数pageCount
        int count = HibernateUtil.recordCount(
                "StudentEntity",
                condition);//总记录数
        System.out.println("count: "+count);
        int page = Integer.parseInt((String) request.getAttribute("page")==null?"1": (String) request.getAttribute("page"));//查询页数 若无参数则为1
        System.out.println("page: "+page);
        int pageCount = count/PAGE_SIZE+(count%PAGE_SIZE>0?1:0);//总页数
        System.out.println("pageCount: "+pageCount);
        //查询学生信息 并按学号排序
        List<StudentEntity> students = HibernateUtil.query(
                "StudentEntity",
                condition,
                orderBy,
                page,
                PAGE_SIZE);
        //测试
        System.out.println(students.size());
        request.setAttribute("collegeId",collegeId);
        request.setAttribute("count",count);//总记录是
        request.setAttribute("pageCount",pageCount);//共有几页
        request.setAttribute("currentPage",page);//当前页数
        request.setAttribute("students",students);//结果集

        // 5/16 新加3行
        int[] pageIndex = getStartAndEnd(page,pageCount);
        request.setAttribute("startPage",pageIndex[0]);//结果集
        request.setAttribute("endPage",pageIndex[1]);//结果集

        request.getRequestDispatcher("/college/checkStuInfo.jsp").forward(request,response);
    }
    private String getParameter(){
        return "";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    // 5/16 新加函数
    private int[] getStartAndEnd(int currentPage,int pageCount){
        int[] temp = {0,0};
        if(pageCount<10){
            temp[0] = 1;
            temp[1] = pageCount;
        }else{
            if (currentPage<6){
                temp[0] = 1;
                temp[1] = 10;
            }else if (currentPage>pageCount-5){
                temp[0] = pageCount-9;
                temp[1] = pageCount;
            }else{
                temp[0] = currentPage-5;
                temp[1] = currentPage+4;
            }
        }
        return temp;
    }
}
