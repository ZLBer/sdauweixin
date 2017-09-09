package servlet.student;

import com.google.gson.Gson;
import po.TeacherEntity;
import util.HibernateUtil;
import util.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URLDecoder;
import java.util.List;

@WebServlet(name = "GetTeacheListServlet")
public class GetTeacheListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String location = request.getParameter("location");
        location = URLDecoder.decode(location,"UTF-8");
        PrintWriter printWriter = response.getWriter();
        if (Util.isValidString(location)) {
            String condition = "WHERE teacherLocation='" + location+"'";
            List<Object[]> teacherList = HibernateUtil.selectFields(
                    "TeacherEntity",
                    new String[]{"teacherName"},condition);
            Gson gson = new Gson();
            String json = gson.toJson(teacherList);
            printWriter.write(json);
            printWriter.flush();
            printWriter.close();
        }else{
            return;
        }
    }
}
