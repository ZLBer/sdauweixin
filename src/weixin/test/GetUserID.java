package weixin.test;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import weixin.ParamesAPI.util.ParamesAPI;
import weixin.ParamesAPI.util.WeixinUtil;
import weixin.contacts.util.MPerson;
import weixin.msg.Resp.Article;
import weixin.msg.Util.SMessage;
import weixin.oauth2.util.GOauth2Core;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 * Created by Administrator on 2017/5/13.
 */
public class GetUserID extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        String code = request.getParameter("code");
        String state=request.getParameter("state");
        System.out.println("跳转的地址是："+state);
        String access_token = WeixinUtil.getAccessToken(ParamesAPI.corpId, ParamesAPI.secret).getToken();
        String UserID;
        //-----------------------------------------//
        if(request.getSession().getAttribute("userid")==null){        //如果session值为空

            System.out.println("Session值为空");

            UserID = GOauth2Core.GetUserID(access_token, code, ParamesAPI.AgentId_qiye);

            System.out.println("当前用户UserID为:"+UserID);
            if(UserID!=null){
                System.out.println("UserID不为空，，开始转发");
                session.setAttribute("userid",UserID);
                session.setAttribute("user",UserID);
            }else{
                System.out.println("调用接口UserId获取失败！！！");
                request.getRequestDispatcher("WEUI/operate_fail.jsp").forward(request, response);
            }
        }

        else{                       //session值不为空
            System.out.println("Session值为不为空");
            //从session中获取UserID

            UserID=request.getSession().getAttribute("userid").toString();

            if(UserID!=null){
                System.out.println("UserID不为空，，开始转发");


            }else{
                System.out.println("从session中获取UserId获取失败！！！");
                request.getRequestDispatcher("WEUI/operate_fail.jsp").forward(request, response);
            }

        }


        ///////////////////////////////////////////////////////////////判断state值，跳转到不同的地址
        if(state=="数字"){
          /* if(state/userid)
            {

                //操作数据库
            }else{
                //弹出提示框
           }*/

        }

        if(state.equals("tw")){             //跳转到提交问题jsp
            System.out.println("开始转发到问题提交页面");
            request.getRequestDispatcher("student/getTeacherNamesServlet").forward(request, response);

        }

        else if(state.equals("cw")) {       //跳转到显示学生问题的servlet
            RequestDispatcher dispatcher =  request.getRequestDispatcher("student/checkProblem");
            dispatcher.forward(request, response);
        }

        else if(state.equals("yx")){        //跳转到修改意向页面
            request.getRequestDispatcher("WEUI/biyeyixiang.jsp").forward(request, response);
        }

        else if(state.equals("xx")){        //跳转到学生修改信息页面
            MPerson mper=new MPerson();
            String getpersonURL=mper.GET_PERSON_URL.replace("ACCESS_TOKEN", access_token).replace("ID", UserID);

            JSONObject jsonobject = WeixinUtil.HttpRequest(getpersonURL, "GET", null);
            System.out.println("jsonobject:"+jsonobject);   //输出jsonobject

            String xuehao=request.getSession().getAttribute("userid").toString();
            String name=jsonobject.getString("name");
            session.setAttribute("name", name);
            String mobile=jsonobject.getString("mobile");

            request.setAttribute("name", name);
            request.setAttribute("mobile", mobile);
            request.setAttribute("xuehao", xuehao);

            request.getRequestDispatcher("WEUI/studentinfo.jsp").forward(request, response);
        }

        else if(state.equals("qx")){        //跳转到企业修改信息页面
            MPerson mper=new MPerson();
            String getpersonURL=mper.GET_PERSON_URL.replace("ACCESS_TOKEN", access_token).replace("ID", UserID);

            JSONObject jsonobject = WeixinUtil.HttpRequest(getpersonURL, "GET", null);
            System.out.println("jsonobject:"+jsonobject);   //输出jsonobject

            String name=jsonobject.getString("name");
            session.setAttribute("qiyename", name);
            String mobile=jsonobject.getString("mobile");

            if(null!=jsonobject){

                //把企业信息传到前台jsp
                request.setAttribute("name", name);
                request.setAttribute("mobile", mobile);

                System.out.println(name);
                System.out.println(mobile);
                //带值跳转
            }else{
                System.out.println("企业信息获取失败");
            }
            request.getRequestDispatcher("WEUI/updateqiye.jsp").forward(request, response);
        }
        else if(state.equals("qz")){        //跳转到企业招聘信息页面

            //创建发送消息对象
            SMessage smsg=new SMessage();
            //拼接接口url
            String RequestUrl=smsg.POST_URL.replace("ACCESS_TOKEN",access_token);
            //拼接招聘信息链接
            String serverName=request.getServerName();
            String Content_source_url="http://"+serverName+"/sdauweixin/article_query?aid="+UserID;   //阅读原文的链接
            //拼接文章
            Article article1 = new Article();
            article1.setTitle("您发布的招聘信息");
            article1.setDescription("点击查看");
            article1.setPicUrl("http://"+serverName+"/images/zp.jpg");
            article1.setUrl(Content_source_url);

            List<Article> list = new ArrayList<Article>();
            list.add(article1);
            // 图文转json
            String articlesList = JSONArray.fromObject(list).toString();
            //Post数据
            int agentid=ParamesAPI.AgentId_qiye;

            String PostData1=smsg.SNewsMsg(UserID,null,null, agentid, articlesList);
            System.out.println(PostData1);

            int result1 = WeixinUtil.PostMessage(access_token, "POST", RequestUrl,PostData1);
            // 打印结果
            if (0 == result1) {

                request.setAttribute("msg","请返回上一级，点击图文消息查看招聘信息！");
                request.getRequestDispatcher("WEUI/operate_success.jsp").forward(request, response);
            } else {

                request.setAttribute("msg","查看招聘信息失败！");
                request.getRequestDispatcher("WEUI/operate_fail.jsp").forward(request, response);
            }

        }
        else if(state.equals("lcw")){               //跳转到学院查看学生问题jsp
            RequestDispatcher dispatcher =  request.getRequestDispatcher("college/college_select");
            dispatcher.forward(request, response);
        }
        else if(state.equals("sf")){
            System.out.println("申请三方协议");
            request.getRequestDispatcher("WEUI/xuanze.jsp").forward(request, response);
        }
        else if(state.equals("office")){             //跳转到选择学院页面（查看三方协议数量）
            System.out.println("开始转发到就业指导中心查看三方协议");
            request.getRequestDispatcher("navigation/navigation_checkSanfangxieyi").forward(request, response);
        }
        else if(state.equals("gz")){                 //盖章预约
            request.getRequestDispatcher("WEUI/westamp.jsp").forward(request, response);
        }
        else if(state.equals("ckgz")){              //学院处理盖章申请      -----------未完成

            System.out.println("学院处理盖章申请跳转");
            request.getRequestDispatcher("college/checkStamp?pageNo=1").forward(request, response);
        }
        else if(state.equals("jyzdgz")){            //就业指导中心盖章
            request.getRequestDispatcher("navigation/navigation_stamp?pageNo=1").forward(request, response);
        }
        else if(state.equals("stuResume")){
            System.out.println("老师查看学生的预约");
            request.getRequestDispatcher("college/college_selectResume").forward(request,response);
        }
        else if(state.equals("stuReplyResume")){
            System.out.println("学生预约老师");
            request.getRequestDispatcher("WEUI/reservationResume.jsp").forward(request,response);
        }

        else{
            System.out.println("微信端通过GetUserID转发出错啦");
        }

        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
