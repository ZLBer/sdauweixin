package servlet.student;

import po.StudentEntity;
import servlet.PoiHwpf;
import util.HibernateUtil;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.List;
import java.util.Map;

/**
 * Created by libin on 2017/4/18.
 */
//就业推荐表下载
public class Student_infoDownload extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String [] xinxi=new String[8];
        xinxi[0]=new String(request.getParameter("aihao").getBytes("ISO-8859-1"),"utf-8");
        xinxi[1]=new String(request.getParameter("zhiwu").getBytes("ISO-8859-1"),"utf-8");
        xinxi[2]=new String(request.getParameter("shijian").getBytes("ISO-8859-1"),"utf-8");
        xinxi[3]=new String(request.getParameter("jiangcheng").getBytes("ISO-8859-1"),"utf-8");
        xinxi[4]=new String(request.getParameter("zhengshu").getBytes("ISO-8859-1"),"utf-8");
        xinxi[5]=new String(request.getParameter("zhiyuan").getBytes("ISO-8859-1"),"utf-8");
        xinxi[6]=new String(request.getParameter("pingjia").getBytes("ISO-8859-1"),"utf-8");
        xinxi[7]=new String(request.getParameter("youbian").getBytes("ISO-8859-1"),"utf-8");

        int studentid = Integer.parseInt(request.getParameter("studentid"));
        //获取要下载的文件名
        String filename =studentid+".doc";
        PoiHwpf s=new PoiHwpf();
        try {
            s.testWrite(studentid,request.getServletContext().getRealPath("/WEB-INF/"),"jiuyetuijian.doc",xinxi);
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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
