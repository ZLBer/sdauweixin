package servlet.college;

/**
 * Created by libin on 2017/5/1.
 */


import servlet.PoiHwpf;
import servlet.PoiXwpf;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import  java.lang.String;

//单个下载三方协议
public class College_DownloadSanfangxieyi extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int studentid = Integer.parseInt(request.getParameter("studentid"));
        String xieyiid= request.getParameter("xieyiid");
        //获取要下载的文件名
        String filename =studentid+".docx";
        PoiXwpf s=new  PoiXwpf();
        try {
            s.testWrite(studentid,request.getServletContext().getRealPath("/WEB-INF/"),"sanfangxieyi.docx");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //得到想客服端输出的输出流
        OutputStream outputStream = response.getOutputStream();
        //输出文件用的字节数组，每次向输出流发送600个字节
        byte b[] = new byte[600];
        //要下载的文件
        File fileload = new File(request.getServletContext().getRealPath("/WEB-INF/"),filename);
        //客服端使用保存文件的对话框
        response.setHeader("Content-disposition", "attachment;filename="+filename);
        //通知客服文件的MIME类型
        response.setContentType("application/msword");
        //通知客服文件的长度
        long fileLength = fileload.length();
        String length = String.valueOf(fileLength);
        response.setHeader("Content_length", length);
        //读取文件，并发送给客服端下载
        FileInputStream inputStream = new FileInputStream(fileload);
        int n = 0;
        while((n=inputStream.read(b))!=-1){
            outputStream.write(b,0,n);
        }


    }
}

