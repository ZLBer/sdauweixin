package servlet.college;

import po.CollegeloginEntity;
import po.ProblemEntity;
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
 * Created by hello world on 2017/5/5.
 */
@WebServlet(name = "ProblemtoSeeAll")
public class ProblemtoSeeAll extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        int problemstate = 0;
        //获取当前学院用户的ID
        CollegeloginEntity loginuser = (CollegeloginEntity) session.getAttribute("user");
        int collegeid = loginuser.getCollegeid();
        String teachername = loginuser.getTeachername();
        //默认查询未回答状态，顺序按照问题发布时间从晚到早排序
        String condition="where collegeid="+collegeid +
                " AND teachername='"+teachername+"'";
        String orderBy="order by problemtime desc";
        int pageSize=10;
        int pageNo=Integer.parseInt(request.getParameter("pageNo"));
        //总记录条数
        int recordCount= HibernateUtil.recordCount("ProblemEntity", condition);
        //得到按照默认排序的问题集合
        List<ProblemEntity> problems=HibernateUtil.query("ProblemEntity problem", condition,orderBy, pageNo, pageSize);
        //得到最终结果
        List<String> text = new ArrayList<String>();
        //List<Integer> proid = new ArrayList<Integer>();
        //Map<Integer,String> map = new HashMap<Integer,String>();
        try {
            if(recordCount>0){
                int t1=recordCount%pageSize;
                int t2=recordCount/pageSize;
                int pageCount=(t1==0?t2:t2+1);

                request.setAttribute("pageNo", pageNo);//页号
                request.setAttribute("pageCount", pageCount);//总页数
                request.setAttribute("problemList", problems);//返回查询到的问题结果
            }
            //得到规定内容的集合text跟问题号
           /* for (int i = 0; i <problemtextList.size() ; i++) {
                //problemttextList存着确切内容
                problemtextList.add(i,problemlist.get(i).getProblemtext());
                text.add(i,problemtextList.get(i).substring(0,5)+"......");
                problemlist.get(i).setProblemtext(text.get(i));
                /*proid.add(i,problemlist.get(i).getProblemid());
                map.put(proid.get(i),text.get(i));
            }*/
            request.setAttribute("recordCount", recordCount);

            //根据问题号跟对应问题text两个list集合形成映射
            //request.setAttribute("resultMap",map);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            request.getRequestDispatcher("/college/ProblemQuery.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}
