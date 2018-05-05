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
	<div style="margin:0px 0;"></div>
	<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'north'" style="height:50px; background:#9FC">
			<font size="+2" color="#000066" face="楷体">山东农业大学就业导航中心
			</font>
			<div align="right"> 当前用户：${user.studentid},${stu.studentname}。
				<a href="${pageContext.request.contextPath }/logout" target="_top" >退出登录</a>
			</div>
		</div>
		<div data-options="region:'south',split:true" style="height:50px;"><p></p>
        <center>鲁ICP备05002369号 | 版权所有©山东农业大学 | 地址:山东省泰安市岱宗大街61号| 邮编:271018 |</center>
        </div>
		<!--<div data-options="region:'east',split:true" title="East" style="width:180px;">
			<ul class="easyui-tree" data-options="url:'tree_data1.json',method:'get',animate:true,dnd:true"></ul>
		</div>-->
		<div data-options="region:'west',split:false,iconCls:'icon-application_home',collapsed:false,collapsible:false" title="主菜单" style="width:200px;">
			<div class="easyui-accordion" data-options="fit:true,border:false">
				<div title="个人信息管理" style="padding:10px;">
					<p><a class="easyui-linkbutton" onclick="addTab('完善个人信息','${pageContext.request.contextPath}/student/gotoInfoServlet')" target="right">完善个人信息</a></p><br>
					<p><a class="easyui-linkbutton" onclick="addTab('查看个人信息','${pageContext.request.contextPath}/student/queryStuInfoServlet')"  target="right">查看个人信息</a></p><br>

				</div>
				<div title="下载就业推荐表" style="padding:10px">
					<p><a  class="easyui-linkbutton" onclick="addTab('下载就业推荐表','${pageContext.request.contextPath}/student/student_infoDownload.jsp')"  target="right">下载就业推荐表</a></p>
				</div>
				<div title="三方协议" data-options="selected:true" style="padding:10px;">
					<p><a class="easyui-linkbutton" onclick="addTab('申请三方协议编号','${pageContext.request.contextPath}/student/student_checkSanfangxieyi?studentid=${user.studentid}')"   target="right" > 申请三方协议编号</a></p>
				</div>
				<div title="个人问题管理" style="padding:10px">
					<p><a class="easyui-linkbutton" onclick="addTab('提交个人问题','${pageContext.request.contextPath}/student/getTeacherNamesServlet')" target="right">我要提问</a></p><br>
					<p><a class="easyui-linkbutton" onclick="addTab('查看问题处理','${pageContext.request.contextPath}/student/checkProblem?pageNo=1')" target="right">问题反馈</a></p><br>

				</div>
				<div title="修改密码" style="padding:10px">
					<p><a  class="easyui-linkbutton" onclick="addTab('修改密码','${pageContext.request.contextPath}/student/motifypwd.jsp')"  target="right">修改密码</a></p>
				</div>
				<div title="预约" style="padding:10px">
					<p><a  class="easyui-linkbutton" onclick="addTab('用章预约','${pageContext.request.contextPath}/student/stamp.jsp')"  target="right">用章预约</a></p>
					<%--<p><a  class="easyui-linkbutton" onclick="addTab('简历预约','${pageContext.request.contextPath}/student/reservationResume.jsp')"  target="right">简历预约</a></p>--%>
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