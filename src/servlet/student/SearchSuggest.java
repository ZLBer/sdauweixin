package servlet.student;

import po.CitycodeEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by john on 2017/5/12.
 */
public class SearchSuggest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/xml;charset=UTF-8");
        PrintWriter out=response.getWriter();
        HashMap map=new HashMap();
        String inputWord=new String(request.getParameter("keyword"));
        String condition="where name like '%"+fixString(inputWord)+"%'";
        java.util.List<CitycodeEntity> userList=new ArrayList<CitycodeEntity>();
        userList= HibernateUtil.query("CitycodeEntity",condition,"order by name",1,20);

        System.out.println(userList.size());
        StringBuffer s = new StringBuffer("");
        for (int i=0;i<userList.size();i++){
            s.append(userList.get(i).getName().trim()+",");
        }
        if(userList.size()!=0){
            userList.clear();
            out.print(""+s.toString()+"");
        }else{
            out.print("没有找到对应数据,");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private String fixString(String s){
            String[] temp = s.split("'");
            StringBuffer a = new StringBuffer("");
            for (int i=0;i<temp.length;i++){
                a.append(temp[i]);
            }
            return a.toString();
    }
}
