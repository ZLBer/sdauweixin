package servlet.student;

import net.sf.json.JSONObject;
import po.CollegeloginEntity;
import po.ResumeEntity;
import po.StudentEntity;
import util.HibernateUtil;
import util.Util;
import weixin.ParamesAPI.util.ParamesAPI;
import weixin.ParamesAPI.util.WeixinUtil;
import weixin.contacts.util.MPerson;
import weixin.msg.Util.SMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ReservationServlet",urlPatterns = "/student/reservationServlet")
public class ReservationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        String teacherName = request.getParameter("teacher");
        if (!Util.isValidString(teacherName)){
            writer.print("请选择老师！");
            return;
        }
        StudentEntity stu = (StudentEntity) request.getSession().getAttribute("stu");
        if (hasReservation(stu.getStudentid())){
            writer.print("您已经提交过申请了，请等待回复。");
            return;
        }
        CollegeloginEntity collegeloginEntity = (CollegeloginEntity) HibernateUtil.query(
                "CollegeloginEntity",
                "WHERE teachername='"+teacherName+"'").get(0);

        int teacherId=Integer.parseInt(collegeloginEntity.getEmpno());

        ResumeEntity resumeEntity = new ResumeEntity();
        resumeEntity.setStudentId(stu.getStudentid());
        resumeEntity.setStudentCollege(stu.getStudentcollege());
        resumeEntity.setStudentName(stu.getStudentname());
        resumeEntity.setState(0);
        resumeEntity.setTeacherId(teacherId);
        HibernateUtil.add(resumeEntity);
        if(request.getSession().getAttribute("userid")!=null){              //如果微信端userid不为空
            //获取凭证
            String access_token= WeixinUtil.getAccessToken(ParamesAPI.corpId,ParamesAPI.secret).getToken();
            int UserID =stu.getStudentid();
            //开始获取学生手机号
            MPerson mper=new MPerson();
            String getpersonURL=mper.GET_PERSON_URL.replace("ACCESS_TOKEN", access_token).replace("ID", UserID+"");

            JSONObject jsonobject = WeixinUtil.HttpRequest(getpersonURL, "GET", null);
            System.out.println("jsonobject:"+jsonobject);   //输出jsonobject

            String mobile=jsonobject.getString("mobile");

            //创建发送消息对象
            SMessage smsg=new SMessage();
            //拼接url
            String RequestURL=smsg.POST_URL.replace("ACCESS_TOKEN",access_token);
            //Post数据
            int agentid=ParamesAPI.AgentId_xuesheng;
            String stuText="预约成功，回复“预约”查看老师空闲时间";
            String teaText="您有新的简历预约，您有新的简历辅导预约，请点击下方简历预约查看。" +
                    "\n该同学来自于"+stu.getStudentcollege()+"学院\n姓名为"+stu.getStudentname()+"\n联系方式为："+mobile;
            String toTea=teacherId+"";
            String toStu=stu.getStudentid()+"";
            //给老师发消息
            String PostData1=SMessage.STextMsg(toTea,null,null,agentid,teaText);
            //给学生发消息
            String PostData2=SMessage.STextMsg(toStu,null,null,agentid,stuText);
            //获取结果
            int result1 = WeixinUtil.PostMessage(access_token, "POST", RequestURL,PostData1);
            int result2 = WeixinUtil.PostMessage(access_token, "POST", RequestURL,PostData2);
            // 打印结果
            //跳转到``页面
            if (0 == result1+result2) {
                System.out.println("发送消息成功");
                request.setAttribute("msg","预约成功！");
                request.getRequestDispatcher("WEUI/operate_success.jsp").forward(request,response);
            } else {
                System.out.println("发送消息失败");
                request.setAttribute("msg","预约失败！");
                request.getRequestDispatcher("WEUI/operate_fail.jsp").forward(request,response);
            }


        }
        else{
            writer.print("预约成功，请等待老师回复");
        }



    }
    private boolean hasReservation(int id){

        String condition = "WHERE studentId="+id+" AND state=0";
        int c = HibernateUtil.recordCount("ResumeEntity",condition);
        if (c!=0){
            return true;
        }
        return false;
    }
}
