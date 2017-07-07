package servlet.college;

import po.CollegeEntity;
import po.CollegeloginEntity;
import po.StudentEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Minister on 2017/5/1.
 */
public class DownloadStuInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String code = request.getParameter("code");
            System.out.println(code);
            HttpSession session = request.getSession();
            //获取学院号
            CollegeloginEntity user= (CollegeloginEntity) session.getAttribute("user");
            int collegeId = user.getCollegeid();
            //获取学院名
            CollegeEntity college = (CollegeEntity) HibernateUtil.get(CollegeEntity.class,collegeId);
            String collegeName = college.getCollegename();
            //查询条件condition
            String condition = "where studentcollege = '" + collegeName + "'";//查询学生信息的条件
            System.out.println("condition: "+condition);
            //要排序的属性
            String orderBy = "order by studentid";
            //查询该学院所有学生信息 并按学号排序
            List<StudentEntity> students = HibernateUtil.query(
                    "StudentEntity",
                    condition,
                    orderBy);
            //测试
            System.out.println("记录数："+students.size());
            //是否要输出代码
            if(code.equals("true")){
    //            //生成name-code映射
    //            Map<String,String> sexMap = new HashMap<>();sexMap.put("男","1");sexMap.put("女","2");//性别
    //            Map<String,String> citycodeMap = CodeUtil.getNameToCodeMap("CitycodeEntity");//社区及村级
    //            Map<String,String> politicalMap = CodeUtil.getNameToCodeMap("PoliticalEntity");//政治面貌
    //            Map<String,String> majorMap = CodeUtil.getNameToCodeMap("BachelorEntity");//专业
    //            Map<String,String> trainModMap = CodeUtil.getNameToCodeMap("TrainingmodeEntity");//培养方案
    //            Map<String,String> nationMap = CodeUtil.getNameToCodeMap("NationEntity");//民族
    //            Map<String,String> xingzhengMap = CodeUtil.getNameToCodeMap("XingzhengquhuaEntity");//行政区划
    //            Map<String,String> educationMap = CodeUtil.getNameToCodeMap("DegreeEntity");//学历
                //修改List中对应的值
                StudentEntity stu = null;
                for (int i=0;i<students.size();i++){
                    stu = students.get(i);
                    stu.setStudentmajor((conversDataWithMap(stu.getStudentsex(),"BachelorEntity")));//专业
                    stu.setStudentsex((conversDataWithMap(stu.getStudentsex(),"SexEntity")));//性别
                    stu.setStudentnation(conversDataWithMap(stu.getStudentnation(),"NationEntity"));//民族
                    stu.setPolitical(conversDataWithMap(stu.getPolitical(),"PoliticalEntity"));//政治面貌
                    stu.setEducation(conversDataWithMap(stu.getEducation(),"DegreeEntity"));//学历
                    stu.setTrainingmode(conversDataWithMap(stu.getTrainingmode(),"TrainingmodeEntity"));//培养方式
                    stu.setLocation(conversDataWithMap(stu.getLocation(),"XingzhengquhuaEntity"));//生源地
                    stu.setMinor(conversDataWithMap(stu.getMinor(),"BachelorEntity"));//辅修
                    stu.setResident(conversDataWithMap(stu.getResident(),"XingzhengquhuaEntity"));//常住市区县
                    stu.setRegister(conversDataWithMap(stu.getRegister(),"XingzhengquhuaEntity"));//现户籍市区县
                    stu.setResidentoffice(conversDataWithMap(stu.getResidentoffice(),"CitycodeEntity"));//常街道办
                    stu.setRegisteroffice(conversDataWithMap(stu.getRegisteroffice(),"CitycodeEntity"));//现街道办
                }
            }
            request.setAttribute("students",students);
            request.getRequestDispatcher("stuInfoExcel.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    public String conversDataWithMap(String data,Map map){
        if(data == null) return null;
        String info = (String) map.get(data);
        return info;
    }
    public String conversDataWithMap(String data,String clazz){
        if(data!=null&&!data.equals("")) {
            try {
                if (clazz.equals("SexEntity")) {
                    return data.equals("男") ? "1" : "2";
                }
                String[] fields = {"code"};
                List<Object[]> code = HibernateUtil.selectFields(clazz, fields, "WHERE name='" + data + "'");
                String name = String.valueOf(code.get(0));
                return name;
            }catch (IndexOutOfBoundsException e){
                return "未知数据";
            }
        }
        return"";
    }
}
