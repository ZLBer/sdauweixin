package action;

import com.opensymphony.xwork2.ActionContext;
import po.AdminEntity;
import po.CollegeloginEntity;
import po.NavigationloginEntity;
import po.StudentloginEntity;
import servlet.Encrypt;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class LoginAction {
	String userid;
	String userpwd;
	String checkcode;
	String type;
	String msg;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public String getCheckcode() {
		return checkcode;
	}
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String check(){
		String ck=(String)ActionContext.getContext().getSession().get("checkCode");
		if(checkcode.equalsIgnoreCase(ck))
		{
			if(type.equals("admin"))
			{
				AdminEntity user=null;
				String condition="where admin.gname='"+this.userid+"'";
				List<AdminEntity> userList=new ArrayList<AdminEntity>();
				userList=HibernateUtil.query("AdminEntity admin", condition);
				if(userList.size()>0) {
					user = userList.get(0);
					if (user == null) {
						msg = "id不存在";
					} else {
						if (Encrypt.MD5(userpwd).equals(user.getGpassword())) {
							ActionContext.getContext().getSession().put("user", user);
							return "adminsuccess";
						} else {
							msg = "密码不正确";
						}
					}
				}
				else msg = "id不存在";
			}
			if(type.equals("student"))
			{
				StudentloginEntity user=null;
				String condition="where studentlogin.studentid='"+this.userid+"'";
				List<StudentloginEntity> userList=new ArrayList<StudentloginEntity>();
				userList=HibernateUtil.query("StudentloginEntity studentlogin", condition);
				if(userList.size()>0) {
					user = userList.get(0);
					if (user == null) {
						msg = "id不存在";
					} else {
						if (Encrypt.MD5(userpwd).equals(user.getStudentpassword())) {
							ActionContext.getContext().getSession().put("user", user);
							return "studentsuccess";
						} else {
							msg = "密码不正确";
						}
					}
				}
				else msg = "id不存在";
			}
			if(type.equals("college"))
			{
				CollegeloginEntity user=null;
				String condition="where collegelogin.empno='"+this.userid+"'";
				List<CollegeloginEntity> userList=new ArrayList<CollegeloginEntity>();
				userList=HibernateUtil.query("CollegeloginEntity collegelogin", condition);
				if(userList.size()>0) {
					user = userList.get(0);
					if (user == null) {
						msg = "id不存在";
					} else {
						if (Encrypt.MD5(userpwd).equals(user.getCollegepwd())) {
							ActionContext.getContext().getSession().put("user", user);
							return "collegesuccess";
						} else {
							msg = "密码不正确";
						}
					}
				}
				else msg = "id不存在";
			}
			if(type.equals("navigation"))
			{
				NavigationloginEntity user=null;
				String condition="where navigationlogin.navigationname='"+this.userid+"'";
				List<NavigationloginEntity> userList=new ArrayList<NavigationloginEntity>();
				userList=HibernateUtil.query("NavigationloginEntity navigationlogin", condition);
				if(userList.size()>0) {
					user = userList.get(0);
					if (user == null) {
						msg = "id不存在";
					} else {
						if (Encrypt.MD5(userpwd).equals(user.getNavigationpwd())) {
							ActionContext.getContext().getSession().put("user", user);
							return "navigationsuccess";
						} else {
							msg = "密码不正确";
						}
					}
				}
				else msg = "id不存在";
			}
		}
		else {msg="验证码不正确";}
		return "null";
	}
}
