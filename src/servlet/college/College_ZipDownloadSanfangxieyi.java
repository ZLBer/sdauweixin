package servlet.college;


import po.CollegeEntity;
import po.XieyiEntity;
import servlet.PoiXwpf;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by libin on 2017/5/5.
 */
//下载本学院全部未审核三方协议
public class College_ZipDownloadSanfangxieyi extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/x-msdownload");
        response.setHeader("Content-Disposition", "attachment;filename=test.zip"); //filename参数指定下载的文件名
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type","text/html;charset=UTF-8");
        int collegeid=Integer.parseInt(request.getParameter("collegeid"));
        int state=Integer.parseInt(request.getParameter("state"));
        CollegeEntity college=(CollegeEntity) HibernateUtil.get(CollegeEntity.class,collegeid);
        String collegename=college.getCollegename();
        
		String  hql;
        if(state==0)
         hql="where state="+state+" and collegename="+"'"+collegename+"'";
        else hql="where state="+state+" and collegename="+"'"+collegename+"'";
        List<XieyiEntity> students=HibernateUtil.query("XieyiEntity",hql);
        ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());
        for(XieyiEntity student : students){
            student.setDownloadstate(student.getDownloadstate()+1);
            HibernateUtil.update(student);
       		       
            PoiXwpf s=new  PoiXwpf();
            try {
                s.testWrite(student.getStudentid(),request.getServletContext().getRealPath("/WEB-INF/"),"sanfangxieyi.docx");
            } catch (Exception e) {
                e.printStackTrace();
            }
            String  filename=+student.getStudentid()+".docx";
            File file = new File(request.getServletContext().getRealPath("/WEB-INF") +"/" +filename);
            zos.putNextEntry(new ZipEntry(filename));

               FileInputStream fis = new FileInputStream(file);

            try
            {
                byte b[] = new byte[1024];
                int n = 0;
                while((n = fis.read(b)) != -1){
                    zos.write(b, 0, n);
                }
            }finally
            {
                zos.flush();
                fis.close();
            }
        }
        zos.flush();
        zos.close();
     }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
