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
            String s_id=request.getParameter("s_id");
           // String s_id= (String) session.getAttribute("userid");
           SStudentrecordEntity data= (SStudentrecordEntity) HibernateUtil.get(SStudentrecordEntity.class,s_id);
           request.setAttribute("data",data);
            return "forward:/WEUI/studentchange.jsp";
        }


        public String changedata(HttpServletRequest request, HttpServletResponse response)throws Exception{
            String s_id=request.getParameter("s_id");
            SStudentrecordEntity data= (SStudentrecordEntity) HibernateUtil.get(SStudentrecordEntity.class,s_id);
            request.setAttribute("data",data);
            return "forward:/WEUI/studentchangeone.jsp";
        }


    public String updatedata(HttpServletRequest request, HttpServletResponse response)throws Exception{
            HttpSession session=request.getSession();
            //String sId=request.getParameter("sId");
            String sId= (String) session.getAttribute("userid");
            String sIdentitycard=request.getParameter("sIdentitycard");
            String sName=request.getParameter("sName");
            String sMajor=request.getParameter("sMajor");
            String sSex=request.getParameter("sSex");
            SStudentrecordEntity data= (SStudentrecordEntity) HibernateUtil.get(SStudentrecordEntity.class,sId);

            if(data.getsIschanged()!=1){
                String changedhistory="";
                if(data.getsChangedhistory()!=null&&!data.getsChangedhistory().trim().equalsIgnoreCase("")){
                    changedhistory=data.getsChangedhistory();
                }



                if(!sSex.equals(data.getsSex())){
                    data.setsSex(sSex);
                    changedhistory+=addChangeRes(data.getsSex(),sSex,"性别");
                }

                if(!sName.equals(data.getsName())){
                    data.setsName(sName);
                    changedhistory+=addChangeRes(data.getsName(),sName,"姓名");
                }


                if(!sMajor.equals(data.getsMajor())){
                    data.setsMajor(sMajor);
                    changedhistory+=addChangeRes(data.getsMajor(),sMajor,"专业");
                }

                if(!sIdentitycard.equals(data.getsIdentitycard())){
                    data.setsIdentitycard(sIdentitycard);
                    changedhistory+=addChangeRes(data.getsIdentitycard(),sIdentitycard,"身份证");
                }

                if(!changedhistory.equalsIgnoreCase(data.getsChangedhistory())){
                    data.setsChangedhistory(changedhistory);
                }


                data.setsIschanged(1);

                HibernateUtil.update(data);
                request.setAttribute("msg","修改成功");

            }else {
                request.setAttribute("msg","您已确认或者修改过信息无法再次修改");
            }

            return "forward:/WEUI/operate_fail.jsp";
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
        if(data.getsIschanged()==1){
            request.setAttribute("msg","您已确认并提交过您的信息无法再次更改或提交");
            return "forward:/WEUI/operate_fail.jsp";
        }else if(data.getsIschanged()==0){
            if(sIschanged==1){
                HibernateUtil.update("s_studentrecord","s_ischanged=1");
            }
        }
        request.setAttribute("msg","确认成功");
        return "forward:/WEUI/operate_fail.jsp";
    }

    private String addChangeRes(String old,String newT,String title){
        if(title==null||title.trim().equals("")){
            title="未知";
        }else if(newT==null&&newT.trim().equalsIgnoreCase("")){
            newT="未知";
        }else if(old==null&&old.trim().equalsIgnoreCase("")){
           old="未知";
        }
        return title+": "+ old+"-->"+newT+"*";
    }
}
