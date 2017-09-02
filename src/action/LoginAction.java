package action;

import com.opensymphony.xwork2.ActionContext;
import net.sf.json.JSONObject;
import po.*;
import servlet.Encrypt;
import util.HibernateUtil;
import weixin.ParamesAPI.util.ParamesAPI;
import weixin.ParamesAPI.util.WeixinUtil;
import weixin.contacts.util.MPerson;

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
							StudentEntity student=(StudentEntity) HibernateUtil.get(StudentEntity.class,Integer.parseInt(this.userid));
							ActionContext.getContext().getSession().put("user", user);
							ActionContext.getContext().getSession().put("stu", student);
							if(checkStatus(this.userid)==4) {
								return "studentfail";
							}


							System.out.println(student);
							return "studentsuccess";
						}
							else {
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
	/**
	 * 检查用户关注状态
	 * status=1：已关注
	 * status=2：已被禁用
	 * status=3：未关注
	 * @param userid
	 * @return
	 */
	public static int checkStatus(String userid){

		int status=4; 			//默认未激活
		//获取凭证
		String access_token= WeixinUtil.getAccessToken(ParamesAPI.corpId, ParamesAPI.secret).getToken();
		MPerson mperson = new MPerson();
		String getPersonUrl = mperson.GPerson(userid).replace("ACCESS_TOKEN",access_token);

		JSONObject jsonobject = WeixinUtil.HttpRequest(getPersonUrl, "GET", null);

		if(null!=jsonobject){

			String s=jsonobject.getString("status");
			if(!s.equals("")){

				status=Integer.parseInt(jsonobject.getString("status"));
			}else{

				int errorCode = jsonobject.getInt("errcode");
				String errMsg = jsonobject.getString("errmsg");
				System.out.println("错误码："+errorCode+"————"+"错误信息："+errMsg);
			}
		}
		else{
			System.out.println("获取授权失败了，●﹏●，自己找原因。。。");
		}
		return status;
	}
}
