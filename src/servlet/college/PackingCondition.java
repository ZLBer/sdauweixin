package servlet.college;


import util.Util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Minister on 2017/5/1.
 */
public class PackingCondition extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        //获取筛选信息
        String sno = request.getParameter("sno");
        String major = request.getParameter("major").equals("0")?null:request.getParameter("major");//学院
        String classes = request.getParameter("class").equals("all")?null:request.getParameter("class");//班级
        String sex = request.getParameter("sex").equals("all")?null:request.getParameter("sex");//性别
        String state = request.getParameter("state").equals("all")?null:request.getParameter("state");//状态
        String pageNum = request.getParameter("page");
        request.setAttribute("page",pageNum);
        //得到包装条件
        StringBuffer condition = getCondition(sno,major,classes,sex,state);
        request.setAttribute("condition",condition);
        //存入session
        session.setAttribute("major",major);
        session.setAttribute("classes",classes);
        session.setAttribute("sex",sex);
        session.setAttribute("state",state);
        System.out.println(condition);

        request.getRequestDispatcher("gotoCheckStuInfoServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    private StringBuffer getCondition(String sno,String major,String classes,String sex,String state){
        StringBuffer condition = new StringBuffer("");
        if(Util.isValidString(sno)) condition.append(" and studentid=\'"+sno+"\'");
        if(major!=null) condition.append(" and studentmajor=\'"+major+"\'");
        if(classes!=null) condition.append(" and studentclass=\'"+classes+"\'");
        if(sex!=null) condition.append(" and studentsex=\'"+sex+"\'");
        if(state!=null) condition.append(" and studentstate=\'"+state+"\'");
        return condition;
    }
}
