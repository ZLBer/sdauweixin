package servlet.wechat;

import util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 平行时空
 * @created 2018-04-20 12:30
 **/

@WebServlet(urlPatterns = "/StudentServlet",name="StudentServlet",asyncSupported = true)
public class StudentServlet extends BaseServlet {
        //StudentServlet?method=test 调用方式
        public String test(HttpServletRequest request, HttpServletResponse response)throws Exception{
            response.getWriter().print("test");
            return null;
        }
}
