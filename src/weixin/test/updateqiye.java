package weixin.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.net.httpserver.HttpContext;

import net.sf.json.JSONObject;

import weixin.ParamesAPI.util.ParamesAPI;
import weixin.ParamesAPI.util.WeixinUtil;
import weixin.contacts.util.MPerson;

public class updateqiye extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public updateqiye() {
        super();
    }

    /**
     * Destruction of the servlet. <br>
     */
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        //获取code
        String code=request.getParameter("code");
        //从session中取出UserID
        HttpSession session = request.getSession();
        String userid = request.getSession().getAttribute("userid").toString();
        //定义操作通讯录成员类对象
        MPerson mper=new MPerson();

        String access_token = WeixinUtil.getAccessToken(ParamesAPI.corpId, ParamesAPI.secret).getToken();

        String name=(String)session.getAttribute("qiyename");
        String mobile=request.getParameter("newtel");

        String PostData=mper.Updata(userid,name,mobile);

        System.out.println(PostData);
        int result = WeixinUtil.PostMessage(access_token, "POST", mper.UPDATA_URL, PostData);
        String servername=request.getServerName();   //获取域名
        // 打印结果
        if(0==result){
            System.out.println("企业信息修改操作成功");
            response.sendRedirect("/sdauweixin/WEUI/operate_success.jsp");
        }
        else {
            System.out.println("修改失败");
            response.sendRedirect("/sdauweixin/WEUI/operate_fail.jsp");
        }
        out.close();
    }

    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException if an error occurs
     */
    public void init() throws ServletException {
        // Put your code here
    }

}
