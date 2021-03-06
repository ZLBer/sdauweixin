package weixin.contacts.util;

import weixin.ParamesAPI.util.ParamesAPI;
import weixin.ParamesAPI.util.WeixinUtil;

/**
 * 通讯录部门管理类
 * @author Engineer.Jsp
 * @date 2014.10.10*/
public class MGroup {

	// 创建部门地址
	public static String CREATE_URL = "https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token=ACCESS_TOKEN";
	// 更新部门地址
	public static String UPDATE_URL = "https://qyapi.weixin.qq.com/cgi-bin/department/update?access_token=ACCESS_TOKEN";
	// 删除部门地址
	public static String DELETE_URL = "https://qyapi.weixin.qq.com/cgi-bin/department/delete?access_token=ACCESS_TOKEN&id=ID";
	// 获取部门列表地址
	public static String GETLIST_URL = "https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=ACCESS_TOKEN";

	/**
	 * 创建部门
	 * @param name 部门名称。长度限制为1~64个字符
	 * @param parentid 父亲部门id。根部门id为1
	 * */
	public static String Create(String name , String parentid){
		String Postjson = "{\"name\": %s,\"parentid\": %s}";
		return String.format(Postjson, name,parentid);
	}

	/**
	 * 更新部门
	 * @param name 更新的部门名称。长度限制为0~64个字符。修改部门名称时指定该参数
	 * @param id 部门id
	 * */
	public static String Update(String name , String id){
		String Postjson = "{\"id\": %s,\"name\": %s}";
		return String.format(Postjson, name,id);
	}

	/**
	 * 删除部门
	 * @param id 部门id
	 * */
	public static String Delete(String id){
		String delete_url = DELETE_URL.replace("ID", id);
		return delete_url;
	}
	//示例
	public static void main(String[] args) {
		/**
		 * 创建部门示例
		 * */
		// 调取凭证
		String access_token = WeixinUtil.getAccessToken(ParamesAPI.corpId, ParamesAPI.secret).getToken();
		// 拼装数据
		String PostData = Create("新建部门", "2");
		// 提交数据,获取结果
		int result = WeixinUtil.PostMessage(access_token, "POST", CREATE_URL, PostData);
		// 打印结果
		if(0==result){
			System.out.println("操作成功");
		}
		else {
			System.out.println("操作失败");
		}
	}
}
