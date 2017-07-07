package servlet.student;

import po.StudentEntity;
import po.StudentloginEntity;
import util.HibernateUtil;
import util.Util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Minister on 2017/4/19.
 */
public class InputStuInfoServlet extends HttpServlet {
    private final String STATE = "提交";
    private final String PASS = "通过";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("input is starting...");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        StudentloginEntity loginedUser = (StudentloginEntity) session.getAttribute("user");
        StudentEntity stu = null;
        int stuID = (loginedUser==null?99:loginedUser.getStudentid());//学号
        stu = (StudentEntity) session.getAttribute("stu");
        System.out.println("state : "+stu.getStudentstate());
        try {
            if (stu.getStudentstate().equals(Util.STATE_PASS)) {
                out.println("<h1>个人信息修改失败</h1>");
                out.println("您的信息已经通过审核，不能再修改！<br>");
                session.setAttribute("stu", stu);
                return;
            }else{
                if (stu.getStudentstate().equals(Util.STATE_SUBMIT)) {
                    out.println("<h1>个人信息修改失败</h1>");
                    out.println("您的信息已经提交，不能再修改！<br>");
                    session.setAttribute("stu", stu);
                    return;
                }
            }
        }catch(NullPointerException e){
            System.out.println("state 为 null");
        }
        System.out.println(stu.getStudentid());
        //填充实体类字段值
        stu.setStudentstate(Util.STATE_SUBMIT);
        //保存持久类
        HibernateUtil.update(stu);
        out.println("个人信息修改成功<br>");
        session.setAttribute("stu",stu);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    private void processStuInfo(StudentEntity stu,HttpServletRequest request){
        //获取前台参数
        String examId = request.getParameter("examId");
        String stuNation = request.getParameter("stuNation");
        String stuNum = request.getParameter("stuNum");
        String political = request.getParameter("political");
        String education = request.getParameter("education");
        String stuMajor = request.getParameter("stuMajor");
        String trainMod = request.getParameter("trainMod");
        String length = request.getParameter("length");
        String minor = request.getParameter("minor");
        String stuBirth = request.getParameter("stuBirth");
        String degree = request.getParameter("degree");
        String mForeign = request.getParameter("mForeign");
        String foreignLevel = request.getParameter("foreignLevel");
        String comLevel = request.getParameter("comLevel");
        String enterYear = request.getParameter("enterYear");
        String graduTime = request.getParameter("graduTime");
        String isWeipei = request.getParameter("isWeipei");
        String weipeiUnit = request.getParameter("weipeiUnit");
        String weipeiLoca = request.getParameter("weipeiLoca");
        String residentDetail = request.getParameter("residentDetail");
        String registerDetail = request.getParameter("registerDetail");
        String stuClass = request.getParameter("stuClass");
        String residentOffic = request.getParameter("residentOffice");
        String residentAddress = request.getParameter("residentAddress");
        String registerOffice = request.getParameter("registerOffice");
        String registerAddress = request.getParameter("registerAddress");
        String type = request.getParameter("type");
        String vocational = request.getParameter("vocational");
        String homeTel = request.getParameter("homeTel");
        String registerTime = request.getParameter("registerTime");
        String tel = request.getParameter("tel");
        String email = request.getParameter("email");
        String stuState = STATE;//状态
        System.out.println(residentOffic);
        System.out.println(registerOffice);
        String resident = getCity(residentOffic);
        String register = getCity(registerOffice);
        String loca = register;
        //填充实体类
        stu.setExamid(examId);
        stu.setStudentnation(stuNation);
        stu.setStudentnumber(stuNum);
        stu.setPolitical(political);
        stu.setEducation(education);
        stu.setStudentmajor(stuMajor);
        stu.setTrainingmode(trainMod);
        stu.setLocation(loca);
        stu.setLength(length);
        stu.setMinor(minor);
        stu.setStudentbirthday(stuBirth);
        stu.setDegree(degree);
        stu.setMajorforeign(mForeign);
        stu.setForeignlevel(foreignLevel);
        stu.setComlevel(comLevel);
        stu.setEnteryear(enterYear);
        stu.setGraduationtime(graduTime);
        stu.setUniversityname(isWeipei);
        stu.setWeipeiunit(weipeiUnit);
        stu.setWeipeilocation(weipeiLoca);
        stu.setStudentclass(stuClass);
        stu.setResident(resident);
        stu.setResidentaddress(residentAddress);
        stu.setResidentdetailed(residentDetail);
        stu.setResidentoffice(residentOffic);
        stu.setRegister(register);
        stu.setRegisteraddress(registerAddress);
        stu.setRegisterdetailed(registerDetail);
        stu.setRegisteroffice(registerOffice);
        stu.setTpye(type);
        stu.setVocational(vocational);
        stu.setHometel(homeTel);
        stu.setRegistertime(registerTime);
        stu.setStudentstate(stuState);
        stu.setStudentemail(email);
        stu.setStudenttel(tel);
    }
    private String combinString(String[] Strings){
        StringBuffer result = new StringBuffer("");
        for (String s:Strings){
            result.append(s+"-");
        }
        result.delete(result.length()-1,result.length());
        return result.toString();
    }
    private String getCity(String s){
        int index = 0;
        if(s.indexOf("省")>0){
            String city = s.substring(0,s.indexOf("市")+1);
            String county = s.substring(s.indexOf("市")+1,s.length());
            if (county.indexOf("区")>0){
                index = county.indexOf("区");
                return city+county.substring(0,index+1);
            }else if (county.indexOf("县")>0){
                index = county.indexOf("县");
                return city+county.substring(0,index+1);
            }else if (county.indexOf("市")>0){
                index = county.indexOf("市");
                return city+county.substring(0,index+1);
            }
        }
        return s;
    }
}
