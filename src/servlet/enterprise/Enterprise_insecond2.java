package servlet.enterprise;

import po.ArticleEntity;
import po.DemandEntity;
import po.MajorEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by C on 2017/5/12.
 */
public class Enterprise_insecond2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        ArticleEntity article=new ArticleEntity();
        MajorEntity user=new MajorEntity();

        String majorname = new String(request.getParameter("major").getBytes("iso-8859-1"),"UTF-8");
        int collegeid=Integer.parseInt(request.getParameter("college"));
        if(collegeid>0) {
            java.util.List<MajorEntity> userList = new ArrayList<MajorEntity>();
            String condition = "where major.majorname='" + majorname + "' and major.collegeid=" + collegeid;
            userList = HibernateUtil.query("MajorEntity major", condition);
            if (userList.size() > 0)
                user = userList.get(0);
            //获取专业id
            int majorid = user.getMajorid();
            String msg = "";
            boolean flag = true;
            //初始化
            int demandnum = Integer.parseInt(request.getParameter("demandnum"));
            //接下来，添加上demand对象的所有字段
            DemandEntity demand = new DemandEntity();
            ArticleEntity arti = (ArticleEntity) request.getSession().getAttribute("article");
            int art = arti.getArticleid();

            String check = "where demand.articleid=" + art;
            java.util.List<DemandEntity> checkList = new ArrayList<DemandEntity>();
            checkList = HibernateUtil.query("DemandEntity demand", check);
            for (int i = 0; i < checkList.size(); i++) {
                if (majorid == checkList.get(i).getMajorid()) {
                    msg = "请勿重复添加该专业！";
                    flag = false;
                }
            }
            if (flag) {
                demand.setArticleid(art);
                demand.setDemandnum(demandnum);
                demand.setMajorid(majorid);
                HibernateUtil.add(demand);
                //添加成功之后，转向页面

                String condition2 = "where demand.articleid=" + art;
                java.util.List<DemandEntity> demandList = new ArrayList<DemandEntity>();
                demandList = HibernateUtil.query("DemandEntity demand", condition2);

                java.util.List<MajorEntity> majorList = new ArrayList<MajorEntity>();
                java.util.List<MajorEntity> mList = new ArrayList<MajorEntity>();
                for (int i = 0; i < demandList.size(); i++) {
                    int m = demandList.get(i).getMajorid();
                    String condition3 = "where major.majorid=" + m;
                    mList = HibernateUtil.query("MajorEntity major", condition3);
                    if (mList.size() > 0)
                        majorList.add(mList.get(0));
                }
                request.setAttribute("msg", msg);
                request.setAttribute("demandList", demandList);
                request.setAttribute("majorList", majorList);
                request.getRequestDispatcher("/enterprise/input_second2.jsp").forward(request, response);
            }
        }
        else {
            ArticleEntity arti = (ArticleEntity) request.getSession().getAttribute("article");
            int art = arti.getArticleid();
            String condition2 = "where demand.articleid=" + art;
            java.util.List<DemandEntity> demandList = new ArrayList<DemandEntity>();
            demandList = HibernateUtil.query("DemandEntity demand", condition2);

            java.util.List<MajorEntity> majorList = new ArrayList<MajorEntity>();
            java.util.List<MajorEntity> mList = new ArrayList<MajorEntity>();
            for (int i = 0; i < demandList.size(); i++) {
                int m = demandList.get(i).getMajorid();
                String condition3 = "where major.majorid=" + m;
                mList = HibernateUtil.query("MajorEntity major", condition3);
                if (mList.size() > 0)
                    majorList.add(mList.get(0));
            }
            request.setAttribute("demandList", demandList);
            request.setAttribute("majorList", majorList);

            String msg="专业不能为空！";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("/enterprise/input_second2.jsp").forward(request, response);
        }
    }
}
