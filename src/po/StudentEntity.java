package po;

import util.CodeUtil;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Minister on 2017/5/11.
 */
public class StudentEntity {
    private int studentid;
    private String examid;
    private String studentname;
    private String studentsex;
    private String studentnation;
    private String studentnumber;
    private String political;
    private String education;
    private String studentmajor;
    private String trainingmode;
    private String location;
    private String length;
    private String minor;
    private String studentbirthday;
    private String degree;
    private String majorforeign;
    private String foreignlevel;
    private String comlevel;
    private String enteryear;
    private String graduationtime;
    private String weipeiunit;
    private String weipeilocation;
    private String universityname;
    private String studentcollege;
    private String resident;
    private String register;
    private String residentdetailed;
    private String registerdetailed;
    private String studentclass;
    private String residentoffice;
    private String residentaddress;
    private String registeroffice;
    private String registeraddress;
    private String tpye;
    private String vocational;
    private String hometel;
    private String registertime;
    private String studentstate;
    private String studenttel;
    private String studentemail;

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getExamid() {
        return examid;
    }

    public void setExamid(String examid) {
        this.examid = examid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getStudentsex() {
        return studentsex;
    }

    public void setStudentsex(String studentsex) {
        this.studentsex = studentsex;
    }

    public String getStudentnation() {
        return studentnation;
    }

    public void setStudentnation(String studentnation) {
        this.studentnation = studentnation;
    }

    public String getStudentnumber() {
        return studentnumber;
    }

    public void setStudentnumber(String studentnumber) {
        this.studentnumber = studentnumber;
    }

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getStudentmajor() {
        return studentmajor;
    }

    public void setStudentmajor(String studentmajor) {
        this.studentmajor = studentmajor;
    }

    public String getTrainingmode() {
        return trainingmode;
    }

    public void setTrainingmode(String trainingmode) {
        this.trainingmode = trainingmode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getMinor() {
        return minor;
    }

    public void setMinor(String minor) {
        this.minor = minor;
    }

    public String getStudentbirthday() {
        return studentbirthday;
    }

    public void setStudentbirthday(String studentbirthday) {
        this.studentbirthday = studentbirthday;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getMajorforeign() {
        return majorforeign;
    }

    public void setMajorforeign(String majorforeign) {
        this.majorforeign = majorforeign;
    }

    public String getForeignlevel() {
        return foreignlevel;
    }

    public void setForeignlevel(String foreignlevel) {
        this.foreignlevel = foreignlevel;
    }

    public String getComlevel() {
        return comlevel;
    }

    public void setComlevel(String comlevel) {
        this.comlevel = comlevel;
    }

    public String getEnteryear() {
        return enteryear;
    }

    public void setEnteryear(String enteryear) {
        this.enteryear = enteryear;
    }

    public String getGraduationtime() {
        return graduationtime;
    }

    public void setGraduationtime(String graduationtime) {
        this.graduationtime = graduationtime;
    }

    public String getWeipeiunit() {
        return weipeiunit;
    }

    public void setWeipeiunit(String weipeiunit) {
        this.weipeiunit = weipeiunit;
    }

    public String getWeipeilocation() {
        return weipeilocation;
    }

    public void setWeipeilocation(String weipeilocation) {
        this.weipeilocation = weipeilocation;
    }

    public String getUniversityname() {
        return universityname;
    }

    public void setUniversityname(String universityname) {
        this.universityname = universityname;
    }

    public String getStudentcollege() {
        return studentcollege;
    }

    public void setStudentcollege(String studentcollege) {
        this.studentcollege = studentcollege;
    }

    public String getResident() {
        return resident;
    }

    public void setResident(String resident) {
        this.resident = resident;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public String getResidentdetailed() {
        return residentdetailed;
    }

    public void setResidentdetailed(String residentdetailed) {
        this.residentdetailed = residentdetailed;
    }

    public String getRegisterdetailed() {
        return registerdetailed;
    }

    public void setRegisterdetailed(String registerdetailed) {
        this.registerdetailed = registerdetailed;
    }

    public String getStudentclass() {
        return studentclass;
    }

    public void setStudentclass(String studentclass) {
        this.studentclass = studentclass;
    }

    public String getResidentoffice() {
        return residentoffice;
    }

    public void setResidentoffice(String residentoffice) {
        this.residentoffice = residentoffice;
    }

    public String getResidentaddress() {
        return residentaddress;
    }

    public void setResidentaddress(String residentaddress) {
        this.residentaddress = residentaddress;
    }

    public String getRegisteroffice() {
        return registeroffice;
    }

    public void setRegisteroffice(String registeroffice) {
        this.registeroffice = registeroffice;
    }

    public String getRegisteraddress() {
        return registeraddress;
    }

    public void setRegisteraddress(String registeraddress) {
        this.registeraddress = registeraddress;
    }

    public String getTpye() {
        return tpye;
    }

    public void setTpye(String tpye) {
        this.tpye = tpye;
    }

    public String getVocational() {
        return vocational;
    }

    public void setVocational(String vocational) {
        this.vocational = vocational;
    }

    public String getHometel() {
        return hometel;
    }

    public void setHometel(String hometel) {
        this.hometel = hometel;
    }

    public String getRegistertime() {
        return registertime;
    }

    public void setRegistertime(String registertime) {
        this.registertime = registertime;
    }

    public String getStudentstate() {
        return studentstate;
    }

    public void setStudentstate(String studentstate) {
        this.studentstate = studentstate;
    }

    public String getStudenttel() {
        return studenttel;
    }

    public void setStudenttel(String studenttel) {
        this.studenttel = studenttel;
    }

    public String getStudentemail() {
        return studentemail;
    }

    public void setStudentemail(String studentemail) {
        this.studentemail = studentemail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentEntity that = (StudentEntity) o;

        if (studentid != that.studentid) return false;
        if (examid != null ? !examid.equals(that.examid) : that.examid != null) return false;
        if (studentname != null ? !studentname.equals(that.studentname) : that.studentname != null) return false;
        if (studentsex != null ? !studentsex.equals(that.studentsex) : that.studentsex != null) return false;
        if (studentnation != null ? !studentnation.equals(that.studentnation) : that.studentnation != null)
            return false;
        if (studentnumber != null ? !studentnumber.equals(that.studentnumber) : that.studentnumber != null)
            return false;
        if (political != null ? !political.equals(that.political) : that.political != null) return false;
        if (education != null ? !education.equals(that.education) : that.education != null) return false;
        if (studentmajor != null ? !studentmajor.equals(that.studentmajor) : that.studentmajor != null) return false;
        if (trainingmode != null ? !trainingmode.equals(that.trainingmode) : that.trainingmode != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (length != null ? !length.equals(that.length) : that.length != null) return false;
        if (minor != null ? !minor.equals(that.minor) : that.minor != null) return false;
        if (studentbirthday != null ? !studentbirthday.equals(that.studentbirthday) : that.studentbirthday != null)
            return false;
        if (degree != null ? !degree.equals(that.degree) : that.degree != null) return false;
        if (majorforeign != null ? !majorforeign.equals(that.majorforeign) : that.majorforeign != null) return false;
        if (foreignlevel != null ? !foreignlevel.equals(that.foreignlevel) : that.foreignlevel != null) return false;
        if (comlevel != null ? !comlevel.equals(that.comlevel) : that.comlevel != null) return false;
        if (enteryear != null ? !enteryear.equals(that.enteryear) : that.enteryear != null) return false;
        if (graduationtime != null ? !graduationtime.equals(that.graduationtime) : that.graduationtime != null)
            return false;
        if (weipeiunit != null ? !weipeiunit.equals(that.weipeiunit) : that.weipeiunit != null) return false;
        if (weipeilocation != null ? !weipeilocation.equals(that.weipeilocation) : that.weipeilocation != null)
            return false;
        if (universityname != null ? !universityname.equals(that.universityname) : that.universityname != null)
            return false;
        if (studentcollege != null ? !studentcollege.equals(that.studentcollege) : that.studentcollege != null)
            return false;
        if (resident != null ? !resident.equals(that.resident) : that.resident != null) return false;
        if (register != null ? !register.equals(that.register) : that.register != null) return false;
        if (residentdetailed != null ? !residentdetailed.equals(that.residentdetailed) : that.residentdetailed != null)
            return false;
        if (registerdetailed != null ? !registerdetailed.equals(that.registerdetailed) : that.registerdetailed != null)
            return false;
        if (studentclass != null ? !studentclass.equals(that.studentclass) : that.studentclass != null) return false;
        if (residentoffice != null ? !residentoffice.equals(that.residentoffice) : that.residentoffice != null)
            return false;
        if (residentaddress != null ? !residentaddress.equals(that.residentaddress) : that.residentaddress != null)
            return false;
        if (registeroffice != null ? !registeroffice.equals(that.registeroffice) : that.registeroffice != null)
            return false;
        if (registeraddress != null ? !registeraddress.equals(that.registeraddress) : that.registeraddress != null)
            return false;
        if (tpye != null ? !tpye.equals(that.tpye) : that.tpye != null) return false;
        if (vocational != null ? !vocational.equals(that.vocational) : that.vocational != null) return false;
        if (hometel != null ? !hometel.equals(that.hometel) : that.hometel != null) return false;
        if (registertime != null ? !registertime.equals(that.registertime) : that.registertime != null) return false;
        if (studentstate != null ? !studentstate.equals(that.studentstate) : that.studentstate != null) return false;
        if (studenttel != null ? !studenttel.equals(that.studenttel) : that.studenttel != null) return false;
        if (studentemail != null ? !studentemail.equals(that.studentemail) : that.studentemail != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentid;
        result = 31 * result + (examid != null ? examid.hashCode() : 0);
        result = 31 * result + (studentname != null ? studentname.hashCode() : 0);
        result = 31 * result + (studentsex != null ? studentsex.hashCode() : 0);
        result = 31 * result + (studentnation != null ? studentnation.hashCode() : 0);
        result = 31 * result + (studentnumber != null ? studentnumber.hashCode() : 0);
        result = 31 * result + (political != null ? political.hashCode() : 0);
        result = 31 * result + (education != null ? education.hashCode() : 0);
        result = 31 * result + (studentmajor != null ? studentmajor.hashCode() : 0);
        result = 31 * result + (trainingmode != null ? trainingmode.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (length != null ? length.hashCode() : 0);
        result = 31 * result + (minor != null ? minor.hashCode() : 0);
        result = 31 * result + (studentbirthday != null ? studentbirthday.hashCode() : 0);
        result = 31 * result + (degree != null ? degree.hashCode() : 0);
        result = 31 * result + (majorforeign != null ? majorforeign.hashCode() : 0);
        result = 31 * result + (foreignlevel != null ? foreignlevel.hashCode() : 0);
        result = 31 * result + (comlevel != null ? comlevel.hashCode() : 0);
        result = 31 * result + (enteryear != null ? enteryear.hashCode() : 0);
        result = 31 * result + (graduationtime != null ? graduationtime.hashCode() : 0);
        result = 31 * result + (weipeiunit != null ? weipeiunit.hashCode() : 0);
        result = 31 * result + (weipeilocation != null ? weipeilocation.hashCode() : 0);
        result = 31 * result + (universityname != null ? universityname.hashCode() : 0);
        result = 31 * result + (studentcollege != null ? studentcollege.hashCode() : 0);
        result = 31 * result + (resident != null ? resident.hashCode() : 0);
        result = 31 * result + (register != null ? register.hashCode() : 0);
        result = 31 * result + (residentdetailed != null ? residentdetailed.hashCode() : 0);
        result = 31 * result + (registerdetailed != null ? registerdetailed.hashCode() : 0);
        result = 31 * result + (studentclass != null ? studentclass.hashCode() : 0);
        result = 31 * result + (residentoffice != null ? residentoffice.hashCode() : 0);
        result = 31 * result + (residentaddress != null ? residentaddress.hashCode() : 0);
        result = 31 * result + (registeroffice != null ? registeroffice.hashCode() : 0);
        result = 31 * result + (registeraddress != null ? registeraddress.hashCode() : 0);
        result = 31 * result + (tpye != null ? tpye.hashCode() : 0);
        result = 31 * result + (vocational != null ? vocational.hashCode() : 0);
        result = 31 * result + (hometel != null ? hometel.hashCode() : 0);
        result = 31 * result + (registertime != null ? registertime.hashCode() : 0);
        result = 31 * result + (studentstate != null ? studentstate.hashCode() : 0);
        result = 31 * result + (studenttel != null ? studenttel.hashCode() : 0);
        result = 31 * result + (studentemail != null ? studentemail.hashCode() : 0);
        return result;
    }
    public StudentEntity(){}

    public StudentEntity(Object[] info){

        this.setStudentid(Integer.parseInt((String) info[0]));
        this.setExamid((String) info[1]);
        this.setStudentname((String) info[2]);
        this.setStudentsex((String) info[3]);
        this.setStudentnation((String) info[4]);
        this.setStudentnumber((String) info[5]);
        this.setPolitical((String) info[6]);
        this.setEducation((String) info[7]);
        this.setStudentmajor((String) info[8]);
        this.setTrainingmode((String) info[9]);
        this.setLocation((String) info[10]);
        this.setLength((String) info[11]);
        this.setMinor((String) info[12]);
        this.setStudentbirthday((String) info[13]);
        this.setDegree((String) info[14]);
        this.setMajorforeign((String) info[15]);
        this.setForeignlevel((String) info[16]);
        this.setComlevel((String) info[17]);
        this.setEnteryear((String) info[18]);
        this.setGraduationtime((String) info[19]);
        this.setUniversityname((String) info[20]);
        this.setWeipeiunit((String) info[21]);
        this.setWeipeilocation((String) info[22]);
        this.setStudentcollege((String) info[23]);
        this.setResident((String) info[24]);
        this.setRegister((String) info[25]);
        this.setResidentdetailed((String) info[26]);
        this.setRegisterdetailed((String) info[27]);
        this.setStudentclass((String) info[28]);
        this.setResidentoffice((String) info[29]);
        this.setResidentaddress((String) info[30]);
        this.setRegisteroffice((String) info[31]);
        this.setRegisteraddress((String) info[32]);
        this.setTpye((String) info[33]);
        this.setVocational((String) info[34]);
        this.setHometel((String) info[35]);
        this.setRegistertime((String) info[36]);
        this.setStudentstate("未通过");
    }
    public void updata(Object[] info){
        this.setExamid((String) info[1]);
        this.setStudentname((String) info[2]);
        this.setStudentsex((String) info[3]);
        this.setStudentnation((String) info[4]);
        this.setStudentnumber((String) info[5]);
        this.setPolitical((String) info[6]);
        this.setEducation((String) info[7]);
        this.setStudentmajor((String) info[8]);
        this.setTrainingmode((String) info[9]);
        this.setLocation((String) info[10]);
        this.setLength((String) info[11]);
        this.setMinor((String) info[12]);
        this.setStudentbirthday((String) info[13]);
        this.setDegree((String) info[14]);
        this.setMajorforeign((String) info[15]);
        this.setForeignlevel((String) info[16]);
        this.setComlevel((String) info[17]);
        this.setEnteryear((String) info[18]);
        this.setGraduationtime((String) info[19]);
        this.setUniversityname((String) info[20]);
        this.setWeipeiunit((String) info[21]);
        this.setWeipeilocation((String) info[22]);
        this.setStudentcollege((String) info[23]);
        this.setResident((String) info[24]);
        this.setRegister((String) info[25]);
        this.setResidentdetailed((String) info[26]);
        this.setRegisterdetailed((String) info[27]);
        this.setStudentclass((String) info[28]);
        this.setResidentoffice((String) info[29]);
        this.setResidentaddress((String) info[30]);
        this.setRegisteroffice((String) info[31]);
        this.setRegisteraddress((String) info[32]);
        this.setTpye((String) info[33]);
        this.setVocational((String) info[34]);
        this.setHometel((String) info[35]);
        this.setRegistertime((String) info[36]);
        this.setStudentstate("未通过");
    }
    public static void main(String[] args){
        try {
            Class<?> clazz = StudentEntity.class;
            Method[] methods = clazz.getMethods();
            List<Method> setMethod = new ArrayList<>();
            for(int i=0;i<methods.length;i++){
                if (!methods[i].getName().startsWith("set")){
                    continue;
                }
                setMethod.add(methods[i]);
                Class<?> returnType = methods[i].getReturnType();
                Class<?> para[] = methods[i].getParameterTypes();
                int temp = methods[i].getModifiers();
                System.out.print(Modifier.toString(temp)+" ");
                System.out.print(returnType.getSimpleName()+" ");
                System.out.print(methods[i].getName()+" ");
                System.out.print("(");
                for (int j=0;j<para.length;++j){
                    System.out.print(para[j].getSimpleName()+ " " + "arg" + j);
                    if (j < para.length - 1) {
                        System.out.print(",");
                    }
                }
                Class<?> exce[] = methods[i].getExceptionTypes();
                if (exce.length > 0) {
                    System.out.print(") throws ");
                    for (int k = 0; k < exce.length; ++k) {
                        System.out.print(exce[k].getName() + " ");
                        if (k < exce.length - 1) {
                            System.out.print(",");
                        }
                    }
                } else {
                    System.out.print(")");
                }
                System.out.println();
            }
            System.out.println(setMethod.size());

            StudentEntity stu = (StudentEntity) clazz.newInstance();
            String fieldName = "studentid";
            String methodName = "set"+ stu.firstCharUpper(fieldName);
            Method method = clazz.getMethod(methodName,int.class);
            method.invoke(stu,15);
            System.out.println(stu.getStudentid());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private String firstCharUpper(String word){
        String firstChara = word.substring(0,1).toUpperCase();
        String lastChara = word.substring(1,word.length());
        return firstChara+lastChara;
    }
}
