package servlet.college;

import po.CollegeloginEntity;
import po.StudentEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Minister on 2017/4/24.
 */
public class ResetStuInfoServlet extends HttpServlet {
    private final String STATE = "未通过";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //更改编码方式
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //是否批量
        boolean isBatch = request.getParameter("batch").equals("true")?true:false;
        if(!isBatch) {
            //获取学号
            int stuId = Integer.parseInt(request.getParameter("stuId"));
            StudentEntity stu = (StudentEntity) HibernateUtil.get(StudentEntity.class, stuId);
            stu.setStudentstate(STATE);
            HibernateUtil.update(stu);
            //相应信息
            out.print("<h1>已经重置学号为 " + stuId + " 的学生信息</h1><br>");
        }else{
            String[] stuSelectId = request.getParameterValues("stuSelectId");
            StringBuffer stuIds = new StringBuffer("");
            //如果有stuSelectId 存在
            if(stuSelectId!=null){
                //组合id序列 为*,*,*,*,*格式
                for (String stuId:stuSelectId){
                    stuIds.append(stuId+",");
                }
                stuIds.delete(stuIds.length()-1,stuIds.length());
                //组成condition
                String condition = "where studentid IN ("+stuIds+")";
                System.out.println(condition);
                List<StudentEntity> students = HibernateUtil.query("StudentEntity",condition);
                for (StudentEntity stu:students){
                    stu.setStudentstate(STATE);
                    HibernateUtil.update(stu);
                }
                out.print("<h1>批量重置完成</h1><br>");
            }else{
                out.print("<h1>您没有选择要重置的条目</h1><br>");
            }
        }
        out.print("<a href='gotoCheckStuInfoServlet?page=1'>返回上一页<a/>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
