package servlet;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import po.StudentEntity;
import po.XieyiEntity;
import sun.security.ssl.HandshakeInStream;
import util.HibernateUtil;

import java.io.*;
import java.util.List;

public class PoiHwpf {


    public  void testWrite(int studentid,String path,String filename,String []xinxi) throws Exception {
        String hql="where studentid="+studentid;
        //获取学生信息
       String aihao=xinxi[0];
       String zhiwu =xinxi[1];
       String shijian=xinxi[2];
      String jiangcheng=xinxi[3];
      String zhengshu=xinxi[4];
        String zhiyuan=xinxi[5];
        String pingjia=xinxi[6];
      String youbian=xinxi[7];
        List <StudentEntity> students= HibernateUtil.query("StudentEntity",hql);
         String studentname = "";
         String studentsex = "";
         String studentmajor = "";
         String studentcollege = "";
         String studentclass = "";
         String studenttel = "";
         String studentemail = "";
         String studentnation = "";
         String studentbirthday = "";
         String political = "";
         String education = "";
         String trainingmode = "";
         String length = "";
         String minor = "";
         String location="";
         String degree  = "";
         String comlevel="";
         String majorforeign = "";
         String foreignlevel = "";
         String graduationtime = "";
         String resident = "";
        for(StudentEntity student : students) {
            studentname = student.getStudentname();
            studentsex = student.getStudentsex();
            studentcollege = student.getStudentcollege();
            studentmajor = student.getStudentmajor();
            studentnation = student.getStudentnation();
            studenttel=student.getStudenttel();
            studentemail=student.getStudentemail();
            studentbirthday = student.getStudentbirthday();
            studentclass=student.getStudentclass();
            political=student.getPolitical();
            education=student.getEducation();
            trainingmode=student.getTrainingmode();
            length=student.getLength();
            minor=student.getMinor();
            comlevel=student.getComlevel();
            degree=student.getDegree();
            location=student.getLocation();
            majorforeign=student.getMajorforeign();
            foreignlevel=student.getForeignlevel();
            graduationtime=student.getGraduationtime();
            resident=student.getResident();
            if(studentname==null) studentname=" ";
            if(studentsex==null) studentsex=" ";
            if(studentcollege==null) studentcollege=" ";
            if(studentmajor==null) studentmajor=" ";
            if(studentnation==null) studentnation=" ";
            if(studenttel==null) studenttel=" ";
            if(studentemail==null) studentemail=" ";
            if(studentbirthday==null) studentbirthday=" ";
            if(studentclass==null) studentclass=" ";
            if(political==null) political=" ";
            if(education==null) education=" ";
            if(trainingmode==null)trainingmode=" ";
            if(length==null) length=" ";
            if(minor==null) minor=" ";
            if(comlevel==null) comlevel=" ";
            if(degree==null) degree=" ";
            if(majorforeign==null) majorforeign=" ";
            if(foreignlevel==null) foreignlevel=" ";
            if(graduationtime==null) graduationtime=" ";
            if(resident==null) resident=" ";
            if(location==null) location=" ";
            if(youbian==null) location=" ";
        }


        String templatePath = path+"/"+filename;
        InputStream is = new FileInputStream(templatePath);
        HWPFDocument doc = new HWPFDocument(is);
        Range range = doc.getRange();
        range.replaceText("${youbian}",  youbian+"");
        range.replaceText("${aihao}",  aihao+"");
        range.replaceText("${zhiwu}",  zhiwu+"");
        range.replaceText("${shijian}",  shijian+"");
        range.replaceText("${jiangcheng}",  jiangcheng+"");
        range.replaceText("${zhengshu}",  zhengshu+"");
        range.replaceText("${zhiyuan}",  zhiyuan+"");
        range.replaceText("${pingjia}",  pingjia+"");
        range.replaceText("${id}",  studentid+"");
        range.replaceText("${name}",  studentname+"");
        range.replaceText("${sex}", studentsex+"");
        range.replaceText("${birthday}",  studentbirthday+"");
        range.replaceText("${college}", studentcollege+"");
        range.replaceText("${major}", studentmajor+"");
        range.replaceText("${nation}",studentnation+"");
        range.replaceText("${studentclass}",studentclass+"");
        range.replaceText("${political}",political +"");
        range.replaceText("${educati}",education +"");
        range.replaceText("${studenttel}",studenttel +"");
        range.replaceText("${studentemail}",studentemail +"");
        range.replaceText("${mode}",trainingmode +"");
        range.replaceText("${length}",length +"");
        range.replaceText("${minor}",minor +"");
        range.replaceText("${comlevel}",comlevel +"");
        range.replaceText("${degree}",degree  +"");
        range.replaceText("${location}",location  +"");
        range.replaceText("${majorforeign}",majorforeign +"");
        range.replaceText("${foreignlevel}",foreignlevel+"");
        range.replaceText("${graduationtime}",graduationtime+"");
        range.replaceText("${resident}",resident+"");


        OutputStream os = new FileOutputStream(path +"/"+ studentid+".doc");
        //把doc输出到输出流中
        doc.write(os);

        this.closeStream(os);
        this.closeStream(is);

    }


    //关闭输入流

      void closeStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


     //关闭输出流

      void closeStream(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }




}
