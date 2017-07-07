package servlet.college;

import po.StudentEntity;
import po.XieyiEntity;
import servlet.PoiHwpf;
import servlet.PoiXwpf;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by libin on 2017/5/10.
 */

//批量下载本学院未审核三方协议
public class College_SelectDownloadSanfangxieyi extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type","text/html;charset=UTF-8");
        String[] studentids = request.getParameterValues("studentids");
        if(studentids==null) {
            PrintWriter out = response.getWriter();
            out.println("没有选中任何学生。");

        }
        else{
        response.setContentType("application/x-msdownload");
        response.setHeader("Content-Disposition", "attachment;filename=test.zip"); //filename参数指定下载的文件名
        ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());
        for(String studentid:studentids) {
            System.out.println(studentid);

            PoiXwpf s=new  PoiXwpf();

            try {
                s.testWrite(Integer.valueOf(studentid).intValue(), request.getServletContext().getRealPath("/WEB-INF/"),"sanfangxieyi.docx");

            } catch (Exception e) {
                e.printStackTrace();
            }
            String  filename=studentid+".docx";
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
    }}
}
