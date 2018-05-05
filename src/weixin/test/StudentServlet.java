package weixin.test;

import po.SStudentrecordEntity;
import util.HibernateUtil;
import weixin.test.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 平行时空
 * @created 2018-04-20 12:30
 **/



@WebServlet(urlPatterns = "/StudentServlet",name="StudentServlet",asyncSupported = true)
public class StudentServlet extends BaseServlet {
        //StudentServlet?method=test 调用方式

        public String findByid(HttpServletRequest request, HttpServletResponse response)throws Exception{

            //String s_id=request.getParameter("s_id");
            HttpSession session=request.getSession();
            String s_id= (String) session.getAttribute("userid");
            if(!checked(s_id)){
                request.setAttribute("msg","您未登录");
                return "forward:/WEUI/operate_fail.jsp";
            }
           // String s_id= (String) session.getAttribute("userid");
           SStudentrecordEntity data= (SStudentrecordEntity) HibernateUtil.get(SStudentrecordEntity.class,s_id);
            if(data==null){
                request.setAttribute("msg","未知错误：您的信息不存在");
                return "forward:/WEUI/operate_fail.jsp";
            }

           request.setAttribute("data",data);
            return "forward:/WEUI/studentchange.jsp";
        }


        public String changedata(HttpServletRequest request, HttpServletResponse response)throws Exception{

            //String s_id=request.getParameter("s_id");
            HttpSession session=request.getSession();
           String s_id= (String) session.getAttribute("userid");
            if(!checked(s_id)){
                request.setAttribute("msg","您未登录");
                return "forward:/WEUI/operate_fail.jsp";
            }
            SStudentrecordEntity data= (SStudentrecordEntity) HibernateUtil.get(SStudentrecordEntity.class,s_id);
            if(data.getsIschanged()==1){
                request.setAttribute("msg","您已确认或者修改过信息无法再次修改");
                return "forward:/WEUI/operate_fail.jsp";
            }
            request.setAttribute("data",data);
            return "forward:/WEUI/studentchangeone.jsp";
        }


    public String updatedata(HttpServletRequest request, HttpServletResponse response)throws Exception{
           HttpSession session=request.getSession();
           //String sId=request.getParameter("s_id");
           String sId= (String) session.getAttribute("userid");
           String sName=request.getParameter("sName");
           String sSex=request.getParameter("sSex");
           String sMajor=request.getParameter("sMajor");
           //生源地
           String sBirthplace=request.getParameter("sBirthplace");
           //学院
           String sDepartment=request.getParameter("sDepartment");
           //接收单位
           String sReceivingunit=request.getParameter("sReceivingunit");
           //档案转寄地址
           String sForaddress=request.getParameter("sForaddress");
           //就业类型
           String sReporttype=request.getParameter("sReporttype");

        if(!checked(sId)){
            request.setAttribute("msg","您未登录");
            return "forward:/WEUI/operate_fail.jsp";
        } else if(!checked(sName)) {
            request.setAttribute("msg","您的姓名不能为空");
            return "forward:/WEUI/operate_fail.jsp";
        }else if(!checked(sMajor)){
            request.setAttribute("msg","您的专业不能为空");
            return "forward:/WEUI/operate_fail.jsp";
        }else if (!checked(sSex)){
            request.setAttribute("msg","您的性别不能为空");
            return "forward:/WEUI/operate_fail.jsp";
        }else if (!checked(sBirthplace)){
            request.setAttribute("msg","您的生源地信息不能为空");
            return "forward:/WEUI/operate_fail.jsp";
        }else if(!checked(sDepartment)){
            request.setAttribute("msg","您的学院信息不能为空");
            return "forward:/WEUI/operate_fail.jsp";
        }else if(!checked(sReceivingunit)){
            request.setAttribute("msg","您的接收单位不能为空");
            return "forward:/WEUI/operate_fail.jsp";
        }else if(!checked(sForaddress)){
            request.setAttribute("msg","您的档案转寄地址不能为空");
            return "forward:/WEUI/operate_fail.jsp";
        }else if(!checked(sReporttype)){
            request.setAttribute("msg","您的就业类型不能为空");
            return "forward:/WEUI/operate_fail.jsp";
        }

        SStudentrecordEntity data= (SStudentrecordEntity) HibernateUtil.get(SStudentrecordEntity.class,sId);

        if(data==null){
            request.setAttribute("msg","未知错误：您的信息不存在");
                 return "forward:/WEUI/operate_fail.jsp";
        }

        //信息校验

            if(data.getsIschanged()!=1){
                String changedhistory="";
                if(data.getsChangedhistory()!=null&&!data.getsChangedhistory().trim().equalsIgnoreCase("")){
                    changedhistory=data.getsChangedhistory();
                }

                if(sSex!=null&&!sSex.equals(data.getsSex())){
                    changedhistory+=addChangeRes(data.getsSex(),sSex,"性别");
                    data.setsSex(sSex);
                }

                if(sName!=null&&!sName.equals(data.getsName())){
                    changedhistory+=addChangeRes(data.getsName(),sName,"姓名");
                    data.setsName(sName);
                }


                if(sMajor!=null&&!sMajor.equals(data.getsMajor())){
                    changedhistory+=addChangeRes(data.getsMajor(),sMajor,"专业");
                    data.setsMajor(sMajor);
                }

                if(sDepartment!=null&&!sDepartment.equals(data.getsDepartment())){
                    changedhistory+=addChangeRes(data.getsDepartment(),sDepartment,"学院");
                    data.setsDepartment(sDepartment);
                }

                if(sBirthplace!=null&&!sBirthplace.equals(data.getsBirthplace())){
                    changedhistory+=addChangeRes(data.getsBirthplace(),sBirthplace,"生源地");
                    data.setsBirthplace(sBirthplace);
                }

                if(sReceivingunit!=null&&!sReceivingunit.equals(data.getsReceivingunit())){
                    changedhistory+=addChangeRes(data.getsReceivingunit(),sReceivingunit,"接收单位");
                    data.setsReceivingunit(sReceivingunit);
                }

                if(sForaddress!=null&&!sForaddress.equals(data.getsForaddress())){
                    changedhistory+=addChangeRes(data.getsForaddress(),sForaddress,"档案转存地址");
                    data.setsForaddress(sForaddress);
                }

                if(sReporttype!=null&&!sReporttype.equals(data.getsReporttype())){
                    changedhistory+=addChangeRes(data.getsReporttype(),sReporttype,"就业类型");
                    data.setsReporttype(sReporttype);
                }

                if(!changedhistory.equalsIgnoreCase(data.getsChangedhistory())){
                    data.setsChangedhistory(changedhistory);
                }
                data.setsIschanged(1);

                HibernateUtil.update(data);
                request.setAttribute("msg","修改成功");


            }else {
                request.setAttribute("msg","您已确认或者修改过信息无法再次修改");
                return "forward:/WEUI/operate_fail.jsp";
            }
          return "forward:WEUI/operate_success.jsp";
    }
    /**
     * 确认信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String isOk(HttpServletRequest request, HttpServletResponse response)throws Exception{
        HttpSession session=request.getSession();
       //String s_id=request.getParameter("s_id");
        String s_id= (String) session.getAttribute("userid");


        Integer sIschanged= Integer.valueOf(request.getParameter("sIschanged"));

        if(s_id==null||s_id.trim().equalsIgnoreCase("")||sIschanged==null){
            request.setAttribute("msg","参数传输错误");
            return "forward:/WEUI/operate_fail.jsp";
        }

        //查询数据库
        SStudentrecordEntity data= (SStudentrecordEntity) HibernateUtil.get(SStudentrecordEntity.class,s_id);

        if(data==null){
            request.setAttribute("msg","未知错误：您的信息不存在");
            return "forward:/WEUI/operate_fail.jsp";
        }
        if(data.getsIschanged()==1){
            request.setAttribute("msg","您已确认并提交过您的信息无法再次更改或提交");
            return "forward:/WEUI/operate_fail.jsp";
        }else if(data.getsIschanged()==0){
            if(sIschanged==1){
                data.setsIschanged(1);
                HibernateUtil.update(data);
            }
        }
        request.setAttribute("msg","确认成功");
        return "forward:/WEUI/operate_success.jsp";
    }

    private String addChangeRes(String old,String newT,String title){
        System.out.println(old + ":::"+newT);
        if(title==null||title.trim().equals("")){
            title="未知";
        }else if(newT==null||newT.trim().equalsIgnoreCase("")){
            newT="未知";
        }else if(old==null||old.trim().equalsIgnoreCase("")){
           old="未知";
        }
        return title+": "+ old+"-->"+newT+"*";
    }

    public boolean checked(String s_id){
        if(s_id==null||s_id.trim().equals("")){
            return false;
        }
        return true;
    }
}
