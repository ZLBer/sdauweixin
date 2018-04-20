package util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author 平行时空
 * @created 2018-04-20 11:24
 * 简化servelt开发
 **/
public class BaseServlet extends HttpServlet {

    public BaseServlet() {
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String methodName = request.getParameter("method");
        Method method=null;

        try {
            method=this.getClass().getMethod(methodName,HttpServletRequest.class, HttpServletResponse.class);
        } catch (NoSuchMethodException e) {
            throw  new RuntimeException("您要调用的方法："+methodName+"不存在",e);
        }

        try {
            String result= (String) method.invoke(this,request,response);
            if(result!=null&&!result.trim().isEmpty()){
                int index=result.indexOf(":");
                //如果不存在：默认转发 否则进行判断转发还是重定向
                if(index==-1){
                    request.getRequestDispatcher(result).forward(request, response);
                }else{
                    System.out.println(result);
                    String start = result.substring(0, index);
                    String path = result.substring(index + 1);
                    if (start.equals("forward")) {
                        request.getRequestDispatcher(path).forward(request, response);
                    } else if (start.equals("redirect")) {
                        response.sendRedirect(request.getContextPath() + path);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //super.service(req, resp);
    }
}
