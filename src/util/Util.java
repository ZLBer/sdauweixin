package util;

import po.StudentEntity;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Minister on 2017/6/28.
 */
public class Util {
    public static final String STATE_SUBMIT = "提交";
    public static final String STATE_PASS = "通过";
    public static final String STATE_REFILL = "重填";

    public static void processStuInfo(StudentEntity stu, HttpServletRequest request){
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
        String loca = getCity(request.getParameter("loca"));
        String resident = getCity(residentOffic);
        String register = getCity(registerOffice);
        //填充实体类
//        stu.setExamid(examId);
//        stu.setStudentnation(stuNation);
//        stu.setStudentnumber(stuNum);
//        stu.setPolitical(political);
//        stu.setEducation(education);
//        stu.setStudentmajor(stuMajor);
//        stu.setTrainingmode(trainMod);
        stu.setLocation(loca);
//        stu.setLength(length);
        stu.setMinor(minor);
//        stu.setStudentbirthday(stuBirth);
//        stu.setDegree(degree);
        stu.setMajorforeign(mForeign);
        stu.setForeignlevel(foreignLevel);
        stu.setComlevel(comLevel);
//        stu.setEnteryear(enterYear);
//        stu.setGraduationtime(graduTime);
//        stu.setUniversityname(isWeipei);
//        stu.setWeipeiunit(weipeiUnit);
//        stu.setWeipeilocation(weipeiLoca);
//        stu.setStudentclass(stuClass);
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
        stu.setStudentemail(email);
        stu.setStudenttel(tel);
    }
    public static String combinString(String[] Strings){
        StringBuffer result = new StringBuffer("");
        for (String s:Strings){
            result.append(s+"-");
        }
        result.delete(result.length()-1,result.length());
        return result.toString();
    }
    public static String getCity(String s){
        if (s==null){
            return "";
        }
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
    public static boolean isValidString(String args){
        if (args==null||args.equals(""))
            return false;
        return true;
    }
}
