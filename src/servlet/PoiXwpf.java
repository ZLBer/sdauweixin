package servlet;

import org.apache.poi.xwpf.usermodel.*;
import po.StudentEntity;
import po.XieyiEntity;
import util.HibernateUtil;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PoiXwpf {


    public  void testWrite(int studentid,String path,String filename) throws Exception {
        String hql="where studentid="+studentid;
        //获取学生信息

        List <StudentEntity> students= HibernateUtil.query("StudentEntity",hql);
        String studentname = "";
        String studentsex = "";
        String studentmajor = "";
        String studentcollege = "";
        String studenttel = "";
        String studentemail = "";
        String studentnation = "";
        String studentbirthday = "";
        String political = "";
        String education = "";
        String trainingmode="";
        String location = "";
        String length = "";
        String degree  = "";
        String resident = "";
        String graduationtime="";
        for(StudentEntity student : students) {
            studentname = student.getStudentname();
            studentsex = student.getStudentsex();
            studentcollege = student.getStudentcollege();
            studentmajor = student.getStudentmajor();
            studentnation = student.getStudentnation();
            trainingmode=student.getTrainingmode();
            studenttel=student.getStudenttel();
            studentemail=student.getStudentemail();
            studentbirthday = student.getStudentbirthday();
            political=student.getPolitical();
            education=student.getEducation();
            location=student.getLocation();
            length=student.getLength();
            degree=student.getDegree();
            resident=student.getResident();
            graduationtime=student.getGraduationtime();
            if(studentname==null) studentname=" ";
            if(studentsex==null) studentsex=" ";
            if(studentcollege==null) studentcollege=" ";
            if(studentmajor==null)studentmajor =" ";
            if(studentnation==null)studentnation =" ";
            if(trainingmode==null)trainingmode=" ";
            if(studenttel==null)studenttel=" ";
            if(studentemail==null) studentemail=" ";
            if(studentbirthday==null) studentbirthday=" ";
            if(political==null) political=" ";
            if(education==null)education=" ";
            if(location==null) location=" ";
            if(length==null) length=" ";
            if(degree==null) degree=" ";
            if(resident==null) resident=" ";
            if(graduationtime==null) graduationtime=" ";
        }
        //获取三方协议信息
        List <XieyiEntity> xieyis= HibernateUtil.query("XieyiEntity",hql);

        String comname="";
        String comnumber="";
        String comadress="";
        Integer comzipcode=null;
        String comcontact="";
        String comtel="";
        String commail="";
        String comnature="";
        String danganadress="";
        String xieyinum="";
        String s="";
        for(XieyiEntity xieyi: xieyis){
            comname=xieyi.getComname();
            comadress=xieyi.getComadress();
            comcontact=xieyi.getComcontact();
            comnumber=xieyi.getComnumber();
            commail=xieyi.getComemail();
            comtel=xieyi.getComtel();
            comnature=xieyi.getComnature();
            comzipcode=xieyi.getComzipcode();
            s= comzipcode+"";
            danganadress=xieyi.getDanganaddress();
            xieyinum=xieyi.getXieyinum();
            if(comname==null) comname=" ";
            if(comadress==null) comadress=" ";
            if(comtel==null) comtel=" ";
            if(comnumber==null) comnumber=" ";
            if(comcontact==null) comcontact=" ";
            if(commail==null) commail=" ";
            if(comnature==null) comnature=" ";
            if(comzipcode==null)  s=" ";
            if(danganadress==null) danganadress=" ";
            if(xieyinum==null) xieyinum=" " ;
        }
        String templatePath = path+"/"+filename;
        InputStream is = new FileInputStream(templatePath);
        XWPFDocument docx = new XWPFDocument(is);
        Map<String, Object> params = new HashMap<String, Object>();
   
        params.put("id",  studentid+"");
        params.put("name",  studentname+"");
        params.put("sex", studentsex+"");
        params.put("birthday",  studentbirthday+"");
        params.put("college", studentcollege+"");
        params.put("mode", trainingmode+"");
        params.put("major", studentmajor+"");
        params.put("nation",studentnation+"");
        params.put("politics",political +"");
        params.put("education",education +"");
        params.put("studenttel",studenttel +"");
        params.put("studentemail",studentemail +"");
        params.put("location",location +"");
        params.put("length",length +"");
        params.put("degree",degree  +"");
        params.put("resident",resident+"");
        params.put("graduationtime",graduationtime+"");
        params.put("xieyiid",xieyinum+"");
        params.put("comname",comname+"");
        params.put("comadress",comadress+"");
        params.put("ctt",comcontact+"");
        params.put("comnumber",comnumber+"");
        params.put("comtel",comtel+"");
        params.put("commail",commail+"");
        params.put("comnature",comnature+"");
        params.put("comzipcode",s);
        params.put("danganadress",danganadress+"");

        this.replaceInTable(docx, params);
        this.replaceInPara(docx, params);

        OutputStream os = new FileOutputStream(path +"/"+ studentid+".docx");
        //把doc输出到输出流中
        docx.write(os);
        this.closeStream(os);
        this.closeStream(is);

        List <XieyiEntity> xs= HibernateUtil.query("XieyiEntity",hql);

      for(XieyiEntity x: xs){

        x.setDownloadstate(x.getDownloadstate()+1);
        HibernateUtil.update(x);
      }
    }
    private void replaceInPara(XWPFDocument doc, Map<String, Object> params) {
        Iterator<XWPFParagraph> iterator = doc.getParagraphsIterator();
        XWPFParagraph para;
        while (iterator.hasNext()) {
            para = iterator.next();
            this.replaceInPara(para, params);
        }
    }
    private void replaceInTable(XWPFDocument doc, Map<String, Object> params) {
        Iterator<XWPFTable> iterator = doc.getTablesIterator();
        XWPFTable table;
        List<XWPFTableRow> rows;
        List<XWPFTableCell> cells;
        List<XWPFParagraph> paras;
        while (iterator.hasNext()) {
            table = iterator.next();
            rows = table.getRows();
            for (XWPFTableRow row : rows) {
                cells = row.getTableCells();
                for (XWPFTableCell cell : cells) {
                    paras = cell.getParagraphs();
                    for (XWPFParagraph para : paras) {
                        this.replaceInPara(para, params);
                    }
                }
            }
        }
    }
    private void replaceInPara(XWPFParagraph para, Map<String, Object> params) {
        List<XWPFRun> runs;
        Matcher matcher;
        if (this.matcher(para.getParagraphText()).find()) {
            runs = para.getRuns();
            for (int i=0; i<runs.size(); i++) {
                XWPFRun run = runs.get(i);
                String runText = run.toString();
                matcher = this.matcher(runText);
                if (matcher.find()) {
                    while ((matcher = this.matcher(runText)).find()) {
                        runText = matcher.replaceFirst(String.valueOf(params.get(matcher.group(1))));
                    }
                    //直接调用XWPFRun的setText()方法设置文本时，在底层会重新创建一个XWPFRun，把文本附加在当前文本后面，
                    //所以我们不能直接设值，需要先删除当前run,然后再自己手动插入一个新的run。
                    para.removeRun(i);
                    para.insertNewRun(i).setText(runText);
                }
            }
        }
    }
    private Matcher matcher(String str) {
        Pattern pattern = Pattern.compile("\\$\\{(.+?)\\}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        return matcher;
    }
    /**
     * 关闭输入流
     * @param is
     */
    private  void closeStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭输出流
     * @param os
     */
    private  void closeStream(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
