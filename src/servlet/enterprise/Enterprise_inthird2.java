package servlet.enterprise;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import po.ArticleEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by C on 2017/5/4.
 */
public class Enterprise_inthird2 extends HttpServlet {
    private static final String UPLOAD_DIRECTORY = "upload";
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String mediaid = "";
        HttpSession session = request.getSession();
        // 检测是否为多媒体上传
        if (!ServletFileUpload.isMultipartContent(request)) {
            // 如果不是则停止
            PrintWriter writer = response.getWriter();
            writer.println("Error: 表单必须包含 enctype=multipart/form-data");
            writer.flush();
            return;
        }
        // 配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // 设置临时存储目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 设置最大文件上传值
        upload.setFileSizeMax(MAX_FILE_SIZE);
        // 设置最大请求值 (包含文件和表单数据)
        upload.setSizeMax(MAX_REQUEST_SIZE);
        // 中文处理
        upload.setHeaderEncoding("UTF-8");
        // 构造临时路径来存储上传的文件
        // 这个路径相对当前应用的目录
        // 这个路径相对当前应用的目录0
        //String uploadPath="/enterprise/upload/"+File.separator + UPLOAD_DIRECTORY;
        String uploadPath = request.getServletContext().getRealPath("/enterprise/") + File.separator + UPLOAD_DIRECTORY;
        System.out.println(uploadPath);
        String absoultfilePath = null;
        String fileName;

        // 如果目录不存在则创建
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        try {
            // 解析请求的内容提取文件数据
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);
            if (formItems != null && formItems.size() > 0) {
                // 迭代表单数据
                for (FileItem item : formItems) {
                    //跳过空文件
                    if (item.getName() == "") continue;
                    // 处理不在表单中的字段
                    if (!item.isFormField()) {
                        //文件名添加时间防止重名
                        Date date = new Date();
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
                        String dateString = formatter.format(date);
                        System.out.println(dateString);
                        fileName = new File(dateString + item.getName()).getName();
                        absoultfilePath ="/enterprise/upload/" +fileName ;

                        String filePath = uploadPath + File.separator + fileName;
                        //获取图片存放位置
                        if (mediaid == "")
                            mediaid = filePath;
                        File storeFile = new File(filePath);
                        // 在控制台输出文件的上传路径
                        System.out.println(filePath);
                        // 保存文件到硬盘
                        item.write(storeFile);
                        request.setAttribute("message",
                                "企业信息上传成功!请耐心等待审核！");
                    }
                }
            }
        } catch (Exception ex) {
            request.setAttribute("message",
                    "错误信息: " + ex.getMessage());

        }
        System.out.println(absoultfilePath);
        ArticleEntity article = (ArticleEntity)session.getAttribute("article");
        try {
            ArticleEntity articleEntity = (ArticleEntity) HibernateUtil.get(Class.forName("po.ArticleEntity"), article.getArticleid());
            articleEntity.setMediaid(absoultfilePath);
            articleEntity.setState("未审核");
            HibernateUtil.update(articleEntity);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        session.invalidate();
        request.getServletContext().getRequestDispatcher("/enterprise/enterprise_message.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
