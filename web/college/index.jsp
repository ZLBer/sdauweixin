<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>山东农业大学就业导航系统</title>
	<link rel="stylesheet" type="text/css" href="/sdauweixin/css/IconExtension.css">
	<link rel="stylesheet" type="text/css" href="/sdauweixin/css/easyui.css">
	<link rel="stylesheet" type="text/css" href="/sdauweixin/css/demo.css">
	<link rel="stylesheet" type="text/css" href="/sdauweixin/css/icon.css">
	<script type="text/javascript" src="/sdauweixin/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/sdauweixin/js/jquery.easyui.min.js"></script>
	<script>
        function addTab(title, url){
            if ($('#tt').tabs('exists', title)){
                $('#tt').tabs('select', title);
                var currTab = $('#tt').tabs('getSelected'); //获得当前tab
                var url = currTab.panel('options').href;
                $('#tt').tabs('update', {
                    tab: currTab,
                    options: {
                        href: url
                    }
                })
            } else {
                var content = '<iframe scrolling="auto" frameborder="0" src="'+url+'" style="width:100%;height:100%;"></iframe>';
                $('#tt').tabs('add',{
                    title:title,
                    content:content,
                    closable:true
                });
            }
        }
	</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'north'" style="height:70px; background:#9FC;padding:10px">
			<font size="+2" color="#000066" face="楷体">山东农业大学就业导航中心
			</font>
			<div align="right"> 当前用户：${user.empno},${user.teachername}。
				<a href="${pageContext.request.contextPath }/logout" target="_top" >退出登录</a>
			</div>
		</div>
		<div data-options="region:'south',split:true" style="height:50px;padding:10px"><p></p>
        <center>鲁ICP备05002369号 | 版权所有©山东农业大学 | 地址:山东省泰安市岱宗大街61号| 邮编:271018 |</center>
        </div>
		<!--<div data-options="region:'east',split:true" title="East" style="width:180px;">
			<ul class="easyui-tree" data-options="url:'tree_data1.json',method:'get',animate:true,dnd:true"></ul>
		</div>-->
		<div data-options="region:'west',split:false,iconCls:'icon-application_home',collapsed:false,collapsible:false" title="主菜单" style="width:200px">
			<div class="easyui-accordion" data-options="fit:true,border:false">
				<div title="学生信息管理" style="padding:10px;">
					<p><a  class="easyui-linkbutton" onclick="addTab('审核学生信息','${pageContext.request.contextPath}/college/gotoCheckStuInfoServlet?page=1')"  target="right">审核学生信息</a></p><br>

				</div>
				<div title="三方协议" data-options="selected:true" style="padding:10px;">
					<p><a   class="easyui-linkbutton" onclick="addTab('三方协议审核','${pageContext.request.contextPath}/college/college_checkSanfangxieyi?collegeid=${user.collegeid}&page_current=1')"  target="right"> 三方协议审核 </a>
					<p><a   class="easyui-linkbutton" onclick="addTab('已审核三方协议','${pageContext.request.contextPath}/college/college_checkTrueSanfangxieyi?collegeid=${user.collegeid}&pageNo=1')"  target="right"> 已审核三方协议 </a>
				</div>
				<div title="管理学生问题" style="padding:10px">
					<p><a class="easyui-linkbutton" onclick="addTab('处理学生问题','${pageContext.request.contextPath}/college/college_select?pageNo=1')"  target="right">处理学生问题</a></p>
					<p><a class="easyui-linkbutton" onclick="addTab('查看学生问题','${pageContext.request.contextPath}/college/college_problemAll?pageNo=1')" target="right">查看学生问题</a></p>

				</div>
				<div title="发布就业信息和企业专场" style="padding:10px">
					<p><a  class="easyui-linkbutton" onclick="addTab('发布就业信息','${pageContext.request.contextPath}/college/input_first2.jsp')"  target="right">发布就业信息</a></p>
					<p><a  class="easyui-linkbutton" onclick="addTab('发布企业专场','${pageContext.request.contextPath}/college/input_first.jsp')"  target="right">发布企业专场</a></p>
				</div>
                <div title="修改密码" style="padding:10px">
					<p><a  class="easyui-linkbutton" onclick="addTab('修改密码','${pageContext.request.contextPath}/college/motifypwd.jsp')"  target="right">修改密码</a></p>
					<p><a  class="easyui-linkbutton" onclick="addTab('重置学生密码','${pageContext.request.contextPath}/college/resetStuPwd.jsp')"  target="right">重置学生密码</a></p>
				</div>
				 <div title="导出学院学生信息" style="padding:10px">
					<p><a class="easyui-linkbutton" onclick="addTab('导出学院学生信息文字版','${pageContext.request.contextPath}/college/downloadStuInfoServlet?code=false')"  target="right">导出学院学生信息文字版(.xls)</a></p>
					<p><a class="easyui-linkbutton" onclick="addTab('导出学院学生信息代码版','${pageContext.request.contextPath}/college/downloadStuInfoServlet?code=true')" target="right">导出学院学生信息代码版(.xls)</a></p>
				</div>
				<div title="上传EXECL文件并导入数据库" style="padding:10px">
					<p><a  class="easyui-linkbutton" onclick="addTab('上传EXECL文件并导入数据库','${pageContext.request.contextPath}/college/uploadExcel.jsp')"  target="right">上传EXECL文件并导入数据库</a></p>
				</div>
				<div title="用章预约审核" style="padding:10px">
					<p><a  class="easyui-linkbutton" onclick="addTab('用章预约审核','${pageContext.request.contextPath}/college/checkStamp?collegeid=${user.collegeid}&pageNo=1')"  target="right">用章预约审核</a></p>
				</div>
				<div title="简历预约审核" style="padding:10px">
					<p><a  class="easyui-linkbutton" onclick="addTab('简历预约审核','${pageContext.request.contextPath}/college/college_selectResume')"  target="right">简历预约审核</a></p>
				</div>
             </div>
		</div>
		<div data-options="region:'center',title:'Main Title',iconCls:'icon-ok'">
			<div id="tt" class="easyui-tabs" data-options="fit:true,border:false,plain:true">
				<div id="right" title="About"  style="padding:10px">
					欢迎访问
				</div>
			</div>
		</div>
	</div>
</body>
</html>