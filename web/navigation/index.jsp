<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>山东农业大学就业导航系统</title>
    <link rel="stylesheet" type="text/css" href="../css/IconExtension.css">
	<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
	<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
	<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
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
			<div align="right"> 当前用户：${user.navigationname}
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
				<div title="招聘信息管理" style="padding:10px;">
					<p><a class="easyui-linkbutton" onclick="addTab('查看招聘信息','${pageContext.request.contextPath}/navigation/navigation_view?pageNo=1')" target="right">查看招聘信息</a></p>
					<p><a class="easyui-linkbutton" onclick="addTab('审核招聘信息','${pageContext.request.contextPath}/navigation/navigation_edit?pageNo=1')" target="right">审核招聘信息</a></p>
				</div>
				<div title="专场信息管理" style="padding:10px;">
					<p><a class="easyui-linkbutton" onclick="addTab('查看专场信息','${pageContext.request.contextPath}/navigation/navigationSpecialView?pageNo=1')" target="right">查看专场信息</a></p>
					<p><a class="easyui-linkbutton" onclick="addTab('审核专场信息','${pageContext.request.contextPath}/navigation/navigation_special?pageNo=1')" target="right">审核专场信息</a></p>
				</div>
				<div title="发布就业信息和企业专场" style="padding:10px">
					<p><a  class="easyui-linkbutton" onclick="addTab('发布就业信息','${pageContext.request.contextPath}/college/input_first2.jsp')"  target="right">发布就业信息</a></p>
					<p><a  class="easyui-linkbutton" onclick="addTab('发布企业专场','${pageContext.request.contextPath}/college/input_first.jsp')"  target="right">发布企业专场</a></p>
				</div>
                <div title="修改密码" style="padding:10px">
					<p><a class="easyui-linkbutton" onclick="addTab('修改密码',' ${pageContext.request.contextPath}/navigation/motifypwd.jsp')" target="right">修改密码</a></p>
				</div>
				<div title="三方协议" style="padding:10px">
					<p><a class="easyui-linkbutton" onclick="addTab('查看三方协议发放数量',' ${pageContext.request.contextPath}/navigation/navigation_checkSanfangxieyi')" target="right">查看三方协议发放数量</a></p>
				</div>
				<div title="用章功能" style="padding:10px">
					<p><a class="easyui-linkbutton" onclick="addTab('已盖章查询',' ${pageContext.request.contextPath}/navigation/queryStamp?pageNo=1')" target="right">已盖章查询</a></p>
					<p><a class="easyui-linkbutton" onclick="addTab('用章审核',' ${pageContext.request.contextPath}/navigation/navigation_stamp?pageNo=1')" target="right">用章审核</a></p>
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