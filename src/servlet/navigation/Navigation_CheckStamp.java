package servlet.navigation;

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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by libin on 2017/5/23.
 */
public class Navigation_CheckStamp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session=request.getSession();
        String pageNo= request.getParameter("pageNo");
        int stampid=Integer.parseInt(request.getParameter("stampid"));
        String userid=new String(request.getParameter("userid").getBytes("ISO-8859-1"),"utf-8");

       StampEntity stamp=(StampEntity)HibernateUtil.get(StampEntity.class,stampid);
        //时间戳
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Date date = new Date();// new Date()为获取当前系统时间，也可使用当前时间戳
        Timestamp nousedate = new Timestamp(date.getTime());
    System.out.println(userid);
            stamp.setNstate("已审核");
            stamp.setStamptime(nousedate);
            stamp.setStampuserid(userid);
          HibernateUtil.update(stamp);

        //发送消息----
        //开始发送响应消息消息内容
        String access_token= WeixinUtil.getAccessToken(ParamesAPI.corpId,ParamesAPI.secret).getToken();
        //创建发送消息对象
        SMessage smsg=new SMessage();
        //拼接url
        String RequestUrl=smsg.POST_URL.replace("ACCESS_TOKEN",access_token);
        //消息内容
        String Content="您的盖章申请在就业指导中心已完成！";
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
            System.out.println("发送盖章消息成功");
        } else {
            System.out.println("发送盖章消息失败");
        }

        request.setAttribute("pageNo",pageNo);
        if(session.getAttribute("userid")!=null){
            request.setAttribute("msg","盖章成功！");
            request.getRequestDispatcher("/WEUI/operate_success.jsp").forward(request, response);
        }else {
            request.getRequestDispatcher("navigation_stamp?pageNo" + pageNo).forward(request, response);
        }
    }
}
