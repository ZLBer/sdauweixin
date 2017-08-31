package servlet.college;


import po.CollegeEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static util.HibernateUtil.multiTableSelect;

/**
 * Created by libin on 2017/5/5.
 */
//学院检查已审核三方协议
public class College_CheckTrueSanfangxieyi extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type","text/html;charset=UTF-8");
        int collegeid=Integer.parseInt(request.getParameter("collegeid"));
        CollegeEntity college=(CollegeEntity) HibernateUtil.get(CollegeEntity.class,collegeid);
        String collegename=college.getCollegename();
		String fieldName="";
		String fieldValue="";
		fieldName=request.getParameter("fieldName");
        fieldValue=request.getParameter("fieldValue");
        String  hql="";
        String condition="";
        int recordCount=0;
        if(fieldName!=null && !"".equals(fieldName)){
            hql="where state=1 and collegename="+"'"+collegename+"' and "+fieldName +" like '%"+fieldValue+"%'";
            condition= " and state=1 and collegename="+"'"+collegename+"' and student."+fieldName +" like '%"+fieldValue+"%'";
        }
        else {
            hql="where state=1 and collegename="+"'"+collegename+"'";
            condition= " and state=1 and collegename="+"'"+collegename+"'";
        }
        int pageSize=15;
        int pageNo=Integer.parseInt(request.getParameter("pageNo"));
        if(fieldName!=null &&fieldName.equals("studentname"))
        {
            hql="where studentcollege="+"'"+collegename+"' and "+fieldName +" like '%"+fieldValue+"%'";
            recordCount= HibernateUtil.recordCount("StudentEntity", hql);
        }
        else recordCount= HibernateUtil.recordCount("XieyiEntity", hql);
        if(recordCount>0) {
            final String STUDENT = "student";
            final String PRIMARYKEY = "studentid";
            final String XIEYI = "xieyi";
            String[] a = {"xieyi.studentid", "xieyi.xieyiid"
                    , "student.studentname","xieyi.downloadstate"};
            String[] tableAlias = {"StudentEntity as " + STUDENT, "XieyiEntity as " + XIEYI};
            final String CONDITION = "WHERE " + STUDENT + "." + PRIMARYKEY + "=" + XIEYI + "." + PRIMARYKEY + condition+" order by xieyiid desc";

            List<Object[]> studentlist = multiTableSelect(tableAlias, a, CONDITION, pageNo, pageSize);
            int t1=recordCount%pageSize;;
            int t2=recordCount/pageSize;
            int pageCount=(t1==0?t2:t2+1);
            request.setAttribute("pageNo", pageNo);
            request.setAttribute("pageCount", pageCount);
            request.setAttribute("studentList", studentlist);
        }
        request.setAttribute("recordCount", recordCount);
        request.getRequestDispatcher("college_checkTrueSanfangxieyi.jsp").forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doPost(request,response);
    }
}
