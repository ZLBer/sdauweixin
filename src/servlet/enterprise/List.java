package servlet.enterprise;

import po.MajorEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by john on 2017/4/22.
 */
public class List extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Map<Integer,String> pm=new HashMap<Integer, String>();
    response.setContentType("text/html;charset=UTF-8");

    request.setCharacterEncoding("UTF-8");
    int cid=Integer.parseInt(request.getParameter("coll"));
    String condition="where major.collegeid="+cid;

    java.util.List<MajorEntity> userList=new ArrayList<MajorEntity>();

    userList=HibernateUtil.query("MajorEntity major", condition);
    String str="";

    if(userList.size()>0)
    {
        for (int i = 0; i < userList.size(); i++)
            if(i==0){str=userList.get(0).getMajorname();}
            else str = userList.get(i).getMajorname() + ',' + str;
    }
    pm.put(cid,str);
    PrintWriter out=response.getWriter();
    out.print(pm.get(cid));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
