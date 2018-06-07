package servlet.navigation;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import po.SStudentrecordEntity;
import util.HibernateUtil;
import util.JavaPoiUtil;
import weixin.test.BaseServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

/**
 * @author 平行时空
 * @created 2018-06-06 19:07
 **/
@WebServlet(urlPatterns = "/poi",name = "StudentPoiServlet")
public class StudentPoiServlet extends BaseServlet {
    /**
     * 导入模板
     * @param request
     * @param response
     * @throws Exception
     */
    public void damodel(HttpServletRequest request, HttpServletResponse response)throws Exception{
        response.reset();
        response.setContentType("application/msexcel");
        response.setHeader("Content-Disposition", "attachment;filename=" + JavaPoiUtil.getExcelName("导入模板", 2007));

        String[] keys = {"sId","sName", "sSex","sMajor","sBirthplace","sDepartment","sReceivingunit","sForaddress","sReporttype"};//要写出的字段名
        String columnNames[] = {"学号","姓名","性别","专业","生源地","学院","接收单位","档案转寄地址", "就业类型"};//列名字
        List<SStudentrecordEntity> sStudentrecordEntityList=new ArrayList<>();
        OutputStream outputStream = response.getOutputStream();
        JavaPoiUtil.createWorkBooks(SStudentrecordEntity.class,sStudentrecordEntityList, keys, columnNames, 2007).write(outputStream);
    }

    /**
     * 导出信息
     * @param request
     * @param response
     * @throws Exception
     */
    public void getdatas(HttpServletRequest request, HttpServletResponse response)throws Exception{
        response.reset();
        response.setContentType("application/msexcel");
        response.setHeader("Content-Disposition", "attachment;filename=" + JavaPoiUtil.getExcelName("导出数据", 2007));

        String[] keys = {"sId","sName", "sSex","sMajor","sBirthplace","sDepartment","sReceivingunit","sForaddress","sReporttype","sIschanged","sChangedhistory"};//要写出的字段名
        String columnNames[] = {"学号","姓名","性别","专业","生源地","学院","接收单位","档案转寄地址", "就业类型","是否修改","修改历史"};//列名字
        List<SStudentrecordEntity> sStudentrecordEntityList= HibernateUtil.query("SStudentrecordEntity","");
        System.out.println(sStudentrecordEntityList.size());
        OutputStream outputStream = response.getOutputStream();
        JavaPoiUtil.createWorkBooks(SStudentrecordEntity.class,sStudentrecordEntityList, keys, columnNames, 2007).write(outputStream);
    }

    public void getExcel(HttpServletRequest request, HttpServletResponse response)throws Exception {
        response.setCharacterEncoding("utf-8");
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        String pa=uuid();
        String path="c:\\"+pa+".xlsx";
        if (isMultipart) {
            DiskFileItemFactory factory = new DiskFileItemFactory();

            ServletContext servletContext = this.getServletConfig().getServletContext();
            File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");

            factory.setRepository(repository);

            ServletFileUpload upload = new ServletFileUpload(factory);

            //解析请求
            try {

                List<FileItem> items = upload.parseRequest(request);
                Iterator<FileItem> iter = items.iterator();
                while (iter.hasNext()) {
                    FileItem item = iter.next();
                    System.out.println(item.getName());
                    //创建文件输出流
                    File file=new File(path);
                    if(!file.exists())
                    {
                        try {
                            file.createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    FileOutputStream fos=new FileOutputStream(file);
                    //创建输入流
                    InputStream fis=(InputStream) item.getInputStream();
                    //从输入流获取字节数组
                    byte b[]=new byte[1];
                    //读取一个输入流的字节到b[0]中
                    int read=fis.read(b);
                    while(read!=-1)
                    {
                        fos.write(b,0,1);
                        read=fis.read(b);
                    }
                    fis.close();
                    fos.flush();
                    fos.close();
                    //打印List中的内容（每一个FileItem的实例代表一个文件，执行这行代码会打印该文件的一些基本属性，文件名，大小等）
                    System.out.println(item);
                }
                System.out.println("循环输出完成");
            } catch (FileUploadException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


            List<List<Object>> lists=JavaPoiUtil.getExcelList(new File(path));
            String[] keys = {"sId","sName", "sSex","sMajor","sBirthplace","sDepartment","sReceivingunit","sForaddress","sReporttype"};//要写出的字段名
            for (int i=0;i<lists.size();i++){
                List<Object> list=lists.get(i);
                SStudentrecordEntity sStudentrecordEntity=new SStudentrecordEntity();
                sStudentrecordEntity.setsId(String.valueOf(list.get(0)));
                sStudentrecordEntity.setsName(String.valueOf(list.get(1)));
                sStudentrecordEntity.setsSex(String.valueOf(list.get(2)));
                sStudentrecordEntity.setsMajor(String.valueOf(list.get(3)));
                sStudentrecordEntity.setsBirthplace(String.valueOf(list.get(4)));
                sStudentrecordEntity.setsDepartment(String.valueOf(list.get(5)));
                sStudentrecordEntity.setsReceivingunit(String.valueOf(list.get(6)));
                sStudentrecordEntity.setsForaddress(String.valueOf(list.get(7)));
                sStudentrecordEntity.setsReporttype(String.valueOf(list.get(8)));
                if(HibernateUtil.get(SStudentrecordEntity.class,sStudentrecordEntity.getsId())==null){
                    HibernateUtil.add(sStudentrecordEntity);
                }

            }

        }
        else {
            System.out.println("False");
        }
        PrintWriter printWriter=response.getWriter();
        printWriter.println("success");
        File file=new File(path);
        file.delete();
    }


    public void getExcel1(HttpServletRequest request, HttpServletResponse response)throws Exception {
        response.setCharacterEncoding("utf-8");
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        String pa=uuid();
        String path=pa+".xlsx";


        byte[] junk = new byte[1024];
        int bytesRead = 0;

        ServletInputStream is = request.getInputStream();

        // shou首先除去Http Head
        bytesRead   =   is.readLine(junk,0,junk.length);
        bytesRead   =   is.readLine(junk,0,junk.length);
        bytesRead   =   is.readLine(junk,0,junk.length);
        bytesRead   =   is.readLine(junk,0,junk.length);
        Integer num=0;
        List<List<Object>> lists= JavaPoiUtil.getExcelList(is,path);
            for (int i=0;i<lists.size();i++){
                List<Object> list=lists.get(i);
                SStudentrecordEntity sStudentrecordEntity=new SStudentrecordEntity();
                sStudentrecordEntity.setsId(String.valueOf(list.get(0)));
                sStudentrecordEntity.setsName(String.valueOf(list.get(1)));
                sStudentrecordEntity.setsSex(String.valueOf(list.get(2)));
                sStudentrecordEntity.setsMajor(String.valueOf(list.get(3)));
                sStudentrecordEntity.setsBirthplace(String.valueOf(list.get(4)));
                sStudentrecordEntity.setsDepartment(String.valueOf(list.get(5)));
                sStudentrecordEntity.setsReceivingunit(String.valueOf(list.get(6)));
                sStudentrecordEntity.setsForaddress(String.valueOf(list.get(7)));
                sStudentrecordEntity.setsReporttype(String.valueOf(list.get(8)));
                if(HibernateUtil.get(SStudentrecordEntity.class,sStudentrecordEntity.getsId())==null){
                    HibernateUtil.add(sStudentrecordEntity);
                    num++;
                }

            }

        PrintWriter printWriter=response.getWriter();
        printWriter.println("导入成功："+num+"条"+" 失败："+(lists.size()-num)+"条");
        File file=new File(path);
        file.delete();
    }


    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }



    public String url(HttpServletRequest request, HttpServletResponse response)throws Exception{
        return "forward:/navigation/studentupload.jsp";
    }
}
