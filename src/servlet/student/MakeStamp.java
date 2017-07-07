package servlet.student;

import po.CollegeEntity;
import po.StampEntity;
import po.StudentEntity;
import util.HibernateUtil;
import weixin.ParamesAPI.util.ParamesAPI;
import weixin.ParamesAPI.util.WeixinUtil;
import weixin.msg.Util.SMessage;
import weixin.test.Collegeid_judge;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by john on 2017/5/23.
 */
public class MakeStamp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        HttpSession session=request.getSession();
        String sno;
        if(session.getAttribute("userid")!=null){           //判断微信端session值不为空

            sno=session.getAttribute("userid").toString();
        }
        else{
            sno=request.getParameter("studentid");
        }
        String function=request.getParameter("function");
        String sname="";
        String studentmajor="";
        String studentcollege="";
        String collegeid="";
        String condition=" where studentid="+sno;
        List<StudentEntity> studentlist=HibernateUtil.query("StudentEntity", condition);
        if(studentlist.size()>0) {
            studentmajor=studentlist.get(0).getStudentmajor();
            sname = studentlist.get(0).getStudentname();
            studentcollege= studentlist.get(0).getStudentcollege();
        }
        String hql="where collegename='"+studentcollege+"'";
        List<CollegeEntity> colleges=HibernateUtil.query("CollegeEntity",hql);
        for( CollegeEntity college:colleges)
        {
            collegeid =college.getCollegeid()+"";
        }
        String msg="";
        String condi=" where studentid="+sno+" and functron='"+function+"' and collegestate='未审核'";
        List<StampEntity> stamps=HibernateUtil.query("StampEntity", condi);
        if(stamps.size()>0) {
            msg="你已经有该类型用章预约，请耐心等待审核！";
        }
          else {
            StampEntity stamp = new StampEntity();
            stamp.setStudentid(sno);
            stamp.setStudentname(sname);
            stamp.setStudentmajor(studentmajor);
            stamp.setCollegeid(collegeid);
            stamp.setCollegestate("未审核");
            stamp.setNstate("未审核");
            stamp.setFunctron(function);
            HibernateUtil.add(stamp);
            msg = "已提交预约，请耐心等待审核";
        }
           request.setAttribute("msg", msg);
            if(session.getAttribute("userid")!=null){           //判断微信端session值不为空,转发到操作成功页面

            String access_token= WeixinUtil.getAccessToken(ParamesAPI.corpId,ParamesAPI.secret).getToken();
            //创建发送消息对象
            SMessage smsg=new SMessage();
            //拼接url
            String RequestUrl=smsg.POST_URL.replace("ACCESS_TOKEN",access_token);
            //获取学生所在学院
            Collegeid_judge cj=new Collegeid_judge();
            String touser=cj.getCollegeid(collegeid);
            //消息内容
            String Content="您有新的盖章预约申请。";
            int agentid=ParamesAPI.AgentId_xinxi;
            String PostData=smsg.STextMsg(null,touser,null, agentid, Content);
            System.out.println(PostData);
            int result = WeixinUtil.PostMessage(access_token, "POST", RequestUrl,PostData);
            // 打印结果
            if (0 == result) {
                System.out.println("发送盖章预约消息成功");
            } else {
                System.out.println("发送盖章预约消息失败");
            }
            //String servername=request.getServerName();

            //response.sendRedirect(servername+"/sdauweixin/WEUI/operate_success.jsp");
            request.getRequestDispatcher("/WEUI/operate_success.jsp").forward(request, response);
        }
          else request.getRequestDispatcher("/student/stamp.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
