package servlet.student;
import org.apache.commons.lang.xwork.StringUtils;
import po.*;
import po.CollegeloginEntity;
import util.HibernateUtil;

import javax.servlet.RequestDispatcher;

import util.HibernateUtil;
import weixin.ParamesAPI.util.ParamesAPI;
import weixin.ParamesAPI.util.WeixinUtil;
import weixin.msg.Util.SMessage;
import weixin.oauth2.util.GOauth2Core;
import weixin.test.Collegeid_judge;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by hello world on 2017/4/20.
 */
@WebServlet(name = "Servlet_tijiao")
public class Servlet_tijiao extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try
        {
            //本servlet实现了对于studentid，collegeid，problemstate的数据库记录
            final int problemstate = 0;
            response.setCharacterEncoding("utf-8");
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();
            HttpSession session=request.getSession();
            StudentEntity stu = new StudentEntity();
            CollegeEntity collegeEntity =new CollegeEntity();
            //获取提交的个人问题
            String problemtext = request.getParameter("problemtext")+"      ";
            removeNonBmpUnicode(problemtext);
            //System.out.println(problemtext);
            //获得当前提交个人问题的学生信息
            String teacherName = request.getParameter("teacherName");
            //获取userid
            int studentid;
            if(request.getSession().getAttribute("userid")!=null) {         //如果微信端session值bu为空
                //从微信session中获取UserID
                String UserID = request.getSession().getAttribute("userid").toString();
                studentid = Integer.parseInt(UserID);
                //根据学号来查询学生表中的个人信息

                //查询条件
                String condition = "where studentid = " + studentid;
                String orderBy = " order by problemtime desc";
                List<StudentEntity> students = new ArrayList<StudentEntity>();
                students = HibernateUtil.query("StudentEntity student", "where studentid =" + studentid);
                if (students.size() > 0) {
                    stu = students.get(0);
                }
                //学生所属学院
                String stucollege = stu.getStudentcollege();
                String condition1 = "where collegename = '" + stucollege + "'";
                List<CollegeEntity> collegeEntityList = HibernateUtil.query("CollegeEntity", condition1);

                if (collegeEntityList.size() > 0) {
                    collegeEntity = collegeEntityList.get(0);
                }
                //得到学生所属学院id
                int collegeid = collegeEntity.getCollegeid();

                //获取当前老师工号
                String condi = "where teachername='" + teacherName+"' and collegeid="+collegeid;
                List<CollegeloginEntity> colleges = HibernateUtil.query("CollegeloginEntity", condi);
                CollegeloginEntity coll = new CollegeloginEntity();
                if (colleges.size() > 0) {
                    coll = colleges.get(0);
                }
                String empno=coll.getEmpno();//工号

                ProblemEntity problem = new ProblemEntity();
                //生成问题List
                Date date = new Date();// new Date()为获取当前系统时间，也可使用当前时间戳
                Timestamp nousedate = new Timestamp(date.getTime());
                //向问题表中插数据
                problem.setTeachername(teacherName);
                problem.setStudentid(stu.getStudentid());
                problem.setCollegeid(collegeid);
                problem.setProblemstate(problemstate);
                problem.setProblemtext(problemtext);
                problem.setProblemtime(nousedate);
                System.out.println(problem.getCollegeid());
                HibernateUtil.add(problem);
                //-----------------------------------------------开始向学院发送消息
                String collegeID=""+collegeid;
                String toparty= Collegeid_judge.getCollegeid(collegeID);         //将学院id转化成相应部门id
                //获取凭证
                String access_token= WeixinUtil.getAccessToken(ParamesAPI.corpId,ParamesAPI.secret).getToken();
                //创建发送消息对象
                SMessage smsg=new SMessage();
                //拼接接口url
                String RequestUrl=smsg.POST_URL.replace("ACCESS_TOKEN",access_token);
                String content="您有新的问题待处理！";
                String PostData=smsg.STextMsg(empno,null,null,ParamesAPI.AgentId_xinxi,content);
                System.out.println(PostData);

                int result = WeixinUtil.PostMessage(access_token, "POST", RequestUrl,PostData);
                // 打印结果
                if (0 == result) {
                    System.out.println("发送问题消息成功");
                    request.setAttribute("msg","提交成功！");
                    request.getRequestDispatcher("/WEUI/operate_success.jsp").forward(request,response);
                } else {
                    System.out.println("发送问题操作失败");
                    request.setAttribute("msg","提交失败！");
                    request.getRequestDispatcher("/WEUI/operate_fail.jsp").forward(request,response);
                }

            }
            else{                                                           //如果微信端session值为空
                //获得当前提交个人问题的学生信息
                StudentloginEntity user = (StudentloginEntity) session.getAttribute("user");
                studentid =user.getStudentid();

                //根据学号来查询学生表中的个人信息
                //查询条件
                String condition="where studentid = "+ studentid;
                String orderBy =" order by problemtime desc";
                List<StudentEntity> students =new ArrayList<StudentEntity>();
                students = HibernateUtil.query("StudentEntity student","where studentid ="+studentid);
                if(students.size()>0)
                {
                    stu =students.get(0);
                }
                //学生所属学院
                String stucollege =stu.getStudentcollege();
                String condition1 ="where collegename = '"+stucollege+"'";
                java.util.List<CollegeEntity> collegeEntityList =HibernateUtil.query("CollegeEntity",condition1);
                //List<CollegeEntity> collegeEntityList =HibernateUtil.query("CollegeEntity collegeEntity",condition1);
                if(collegeEntityList.size()>0)
                {
                    collegeEntity =collegeEntityList.get(0);
                }
                //得到学生所属学院id
                int collegeid = collegeEntity.getCollegeid();
                //获取当前老师工号
                String condi = "where teachername='" + teacherName+"' and collegeid="+collegeid;
                List<CollegeloginEntity> colleges = HibernateUtil.query("CollegeloginEntity", condi);
                CollegeloginEntity coll = new CollegeloginEntity();
                if (colleges.size() > 0) {
                    coll = colleges.get(0);
                }
                String empno=coll.getEmpno();//工号

                ProblemEntity problem=new ProblemEntity();
                //生成问题List
                Date date = new Date();// new Date()为获取当前系统时间，也可使用当前时间戳
                Timestamp nousedate = new Timestamp(date.getTime());
                //向问题表中插数据
                problem.setTeachername(teacherName);
                problem.setStudentid(stu.getStudentid());
                problem.setCollegeid(collegeid);
                problem.setProblemstate(problemstate);
                problem.setProblemtext(problemtext);
                problem.setProblemtime(nousedate);
                System.out.println(problem.getCollegeid());
                HibernateUtil.add(problem);
                //-----------------------------------------------开始向学院发送消息
               String collegeID=""+collegeid;
               String toparty= Collegeid_judge.getCollegeid(collegeID);         //将学院id转化成相应部门id
               //获取凭证
               String access_token= WeixinUtil.getAccessToken(ParamesAPI.corpId,ParamesAPI.secret).getToken();
               //创建发送消息对象
               SMessage smsg=new SMessage();
               //拼接接口url
               String RequestUrl=smsg.POST_URL.replace("ACCESS_TOKEN",access_token);
               String content="您有新的问题待处理！";
               String PostData=smsg.STextMsg(empno,null,null,ParamesAPI.AgentId_xinxi,content);
               System.out.println(PostData);

               int result = WeixinUtil.PostMessage(access_token, "POST", RequestUrl,PostData);
               // 打印结果
               if (0 == result) {
                   System.out.println("发送问题消息成功");
               } else {
                   System.out.println("发送问题操作失败");
               }

                request.getRequestDispatcher("checkProblem?pageNo=1").forward(request,response);
            }

        }catch(Exception e)
        {
            e.printStackTrace();
            System.out.print("出错了");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);

    }
    public static String removeNonBmpUnicode(String str) {
        if (str == null) {
            return null;
        }
        str = str.replaceAll("[^\\u0000-\\uFFFF]", "");
        return str;
    }
}
