package servlet.student;

import org.hibernate.engine.HibernateIterator;
import po.CollegeEntity;
import po.StudentEntity;
import po.XieyiEntity;
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
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by libin on 2017/5/5.
 */
public class Student_RequestSanfangxieyi extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        HttpSession session = request.getSession();
        int studentid;
        if(request.getSession().getAttribute("userid")!=null){
            studentid = Integer.parseInt(session.getAttribute("userid").toString());
        }else{
            studentid =Integer.parseInt(request.getParameter("studentid"));
        }

        //判断是否已经申请过
        String  hql="where studentid="+studentid;
        List<XieyiEntity> students=HibernateUtil.query("XieyiEntity",hql);
        if(students.size()==0){
            XieyiEntity student = new XieyiEntity();
            //查找学生所属学院
            StudentEntity student2=(StudentEntity) HibernateUtil.get(StudentEntity.class,studentid);
        String collegename=student2.getStudentcollege();
        String hql1="where collegename="+"'"+collegename+"'";
        List<CollegeEntity> colleges=HibernateUtil.query("CollegeEntity",hql1);
           String collegeid="";
            for(CollegeEntity college: colleges){
               collegeid=college.getCollegeid()+"";

            }
            String toparty= Collegeid_judge.getCollegeid(collegeid);         //将学院id转化成相应部门id方便发消息
            //判断学院id位数
            if(Integer.parseInt(collegeid)/10==0){
             collegeid="0"+collegeid;}
        String  comname= request.getParameter("comname");
        String comnumber = request.getParameter("comnumber");
        String  comadress= request.getParameter("comadress");
        //防止公司代码不填引发异常
        if(request.getParameter("comzipcode")=="") {
            student.setComzipcode(null);
        }
        else {
            int comzipcode = Integer.parseInt(request.getParameter("comzipcode"));
            student.setComzipcode(comzipcode);
        }
        String industry=request.getParameter("industry");
        String category=request.getParameter("category");
        String  comcontact= request.getParameter("comcontact");
        String comtel = request.getParameter("comtel");
        String commail = request.getParameter("commail");
        String comnature =request.getParameter("comnature");
        String danganadress =request.getParameter("danganaddress");
        student.setStudentid(studentid);
		student.setDownloadstate(0);

        student.setState(0);
        student.setComname(comname);
        student.setComnumber(comnumber);
        student.setComadress(comadress);
        student.setCollegename(collegename);
        student.setComcontact(comcontact);
        student.setComtel(comtel);
        student.setComemail(commail);
        student.setComnature(comnature);
        student.setCategory(category);
        student.setIndustry(industry);
        student.setDanganaddress(danganadress);
        HibernateUtil.add(student);
        //再次查找并拼接三方协议编号
       List<XieyiEntity> xieyis=HibernateUtil.query("XieyiEntity","where studentid="+studentid);
       for(XieyiEntity xieyi:xieyis) {
          String xieyiid = xieyi.getXieyiid() + " ";

       String xieyinumber1=xieyiid.substring(0,4);
       String xieyinumber2=xieyiid.substring(4,8);
       xieyi.setXieyinum(xieyinumber1+collegeid+xieyinumber2);
       HibernateUtil.update(xieyi); }
        request.setAttribute("message", "申请成功");

            //-------------------------------------------------------------开始发送消息

            //获取凭证
            String access_token= WeixinUtil.getAccessToken(ParamesAPI.corpId,ParamesAPI.secret).getToken();
            //创建发送消息对象
            SMessage smsg=new SMessage();
            //拼接接口url
            String RequestUrl=smsg.POST_URL.replace("ACCESS_TOKEN",access_token);
            String content="您有新的三方协议申请待处理！";
            String PostData=smsg.STextMsg(null,toparty,null,ParamesAPI.AgentId_xinxi,content);
            System.out.println(PostData);

            int result = WeixinUtil.PostMessage(access_token, "POST", RequestUrl,PostData);
            // 打印结果
            if (0 == result) {
                System.out.println("发送三方协议消息成功");
            } else {
                System.out.println("发送三方协议操作失败");
            }
            if(request.getSession().getAttribute("userid")!=null){
                request.getRequestDispatcher("/WEUI/operate_success.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("student_requestSanfangxieyi.jsp").forward(request, response);
            }


    }
        else{

            if(request.getSession().getAttribute("userid")!=null){
                request.getRequestDispatcher("/WEUI/sanfang.jsp").forward(request, response);
            }else{
                request.setAttribute("message", "已提交过申请请耐心等待");
                request.getRequestDispatcher("student_requestSanfangxieyi.jsp").forward(request, response);}
            }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }
}