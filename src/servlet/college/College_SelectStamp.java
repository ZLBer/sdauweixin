package servlet.college;

import po.StampEntity;
import util.HibernateUtil;
import weixin.ParamesAPI.util.ParamesAPI;
import weixin.ParamesAPI.util.WeixinUtil;
import weixin.msg.Util.SMessage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by libin on 2017/5/24.
 */
public class College_SelectStamp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session=request.getSession();
        String pageNo= request.getParameter("pageNo");
        String collegeid=request.getParameter("collegeid");
        int state=Integer.parseInt(request.getParameter("state"));
        int stampid=Integer.parseInt(request.getParameter("stampid"));
        StampEntity stamp=(StampEntity) HibernateUtil.get(StampEntity.class,stampid);
        if(state==1) {
            stamp.setCollegestate("已审核");
        }
        else {
            stamp.setCollegestate("未通过");
        }
        HibernateUtil.update(stamp);
        //开始发送响应消息消息内容
        String access_token= WeixinUtil.getAccessToken(ParamesAPI.corpId,ParamesAPI.secret).getToken();
        //创建发送消息对象
        SMessage smsg=new SMessage();
        //拼接url
        String RequestUrl=smsg.POST_URL.replace("ACCESS_TOKEN",access_token);
        //消息内容
        String Content="您的盖章申请已在学院审核通过，请前往就业指导中心盖章！";
        //发送的应用ID
        int agentid= ParamesAPI.AgentId_xuesheng;
        //发送的对象-touser
        String touser=stamp.getStudentid();
        //发送
        String PostData=smsg.STextMsg(touser,null,null, agentid, Content);
        //发送结果返回
        int result = WeixinUtil.PostMessage(access_token, "POST", RequestUrl,PostData);
        // 打印结果
        if (0 == result) {
            System.out.println("发送盖章处理消息成功");
        } else {
            System.out.println("发送盖章处理消息失败");
        }
        request.setAttribute("pageNo",pageNo);
        request.setAttribute("collegeid",collegeid);
        if(session.getAttribute("userid")!=null){
            request.setAttribute("msg","审核成功！");
            request.getRequestDispatcher("/WEUI/operate_success.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("checkStamp?pageNo"+pageNo+"&collegeid="+collegeid).forward(request,response);
        }
    }
}
