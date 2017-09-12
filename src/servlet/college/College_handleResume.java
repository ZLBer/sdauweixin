package servlet.college;

import po.ResumeEntity;
import util.HibernateUtil;
import weixin.ParamesAPI.util.ParamesAPI;
import weixin.ParamesAPI.util.WeixinUtil;
import weixin.msg.Util.SMessage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by libin on 2017/9/9.
 */
public class College_handleResume extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      response.setCharacterEncoding("utf-8");

      String state=request.getParameter("state");
      String studenid=request.getParameter("studentid");
      if("0".equals(state)) {
          request.setAttribute("studentid",studenid);
          if(request.getSession().getAttribute("userid")!=null){        //如果微信端不为空
              request.getRequestDispatcher("/WEUI/editResume.jsp").forward(request,response);
          }
          else{
              request.getRequestDispatcher("editResume.jsp").forward(request, response);

          }
          return;
      }
      else if("1".equals(state)){
          ResumeEntity resume=(ResumeEntity) HibernateUtil.query("ResumeEntity","where student_id="+studenid+" and state=0").get(0);
          resume.setState(1);
          HibernateUtil.update(resume);
          //微信在这发同意申请的消息
          //获取凭证
          String access_token= WeixinUtil.getAccessToken(ParamesAPI.corpId,ParamesAPI.secret).getToken();
          //创建发送消息对象
          SMessage smsg=new SMessage();
          //拼接url
          String RequestURL=smsg.POST_URL.replace("ACCESS_TOKEN",access_token);
          //Post数据
          int agentid=ParamesAPI.AgentId_xuesheng;
          String stext="您预约的老师已同意，回复“预约”查看老师空闲时间。";
          String touser=studenid;
          String partyID=null;
          String totag=null;

          String PostData=SMessage.STextMsg(touser,partyID,totag,agentid,stext);

          int result1 = WeixinUtil.PostMessage(access_token, "POST", RequestURL,PostData);
          // 打印结果
          if (0 == result1) {
              System.out.println("发送消息成功");
              if(request.getSession().getAttribute("userid")!=null) {        //如果微信端不为空
                  request.setAttribute("msg","预约成功！");
                  request.getRequestDispatcher("/WEUI/operate_success.jsp").forward(request,response);

              }
              else{
                  request.getRequestDispatcher("college_selectResume").forward(request, response);
              }
          } else {
              System.out.println("发送消息失败");
              request.setAttribute("msg","预约失败！");
              request.getRequestDispatcher("/WEUI/operate_fail.jsp").forward(request,response);
          }

          return;
      }
      else {
          String reason=request.getParameter("reason");
          ResumeEntity resume=(ResumeEntity) HibernateUtil.query("ResumeEntity","where student_id="+studenid+" and state=0").get(0);
          resume.setState(2);
          resume.setReason(reason);
          HibernateUtil.update(resume);
          //微信在这里发不同意申请的消息
          //获取凭证
          String access_token= WeixinUtil.getAccessToken(ParamesAPI.corpId,ParamesAPI.secret).getToken();
          //创建发送消息对象
          SMessage smsg=new SMessage();
          //拼接url
          String RequestURL=smsg.POST_URL.replace("ACCESS_TOKEN",access_token);
          //Post数据
          int agentid=ParamesAPI.AgentId_xuesheng;
          String stext="您预约的老师因"+reason+"不方便接受您的预约，建议您更换老师/时间重新预约";
          String touser=studenid;
          String partyID=null;
          String totag=null;

          String PostData=SMessage.STextMsg(touser,partyID,totag,agentid,stext);

          int result1 = WeixinUtil.PostMessage(access_token, "POST", RequestURL,PostData);
          // 打印结果
          if (0 == result1) {
              System.out.println("发送消息成功");
              if(request.getSession().getAttribute("userid")!=null) {        //如果微信端不为空
                  request.setAttribute("msg","预约成功！");
                  request.getRequestDispatcher("/WEUI/operate_success.jsp").forward(request,response);

              }
              else{
                  request.getRequestDispatcher("college_selectResume").forward(request, response);
              }
          } else {
              System.out.println("发送消息失败");
              request.setAttribute("msg","预约失败！");
              request.getRequestDispatcher("/WEUI/operate_fail.jsp").forward(request,response);
          }

          return;
      }
    }
}
