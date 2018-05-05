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
            $('#tt').tabs('select', title);
            if ($('#tt').tabs('exists', title)){
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
        <div align="right"> 当前用户：${user.gid}
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
            <div title="修改密码" style="padding:10px">
                <p><a  class="easyui-linkbutton" onclick="addTab('修改密码','${pageContext.request.contextPath}/admin/motifypwd.jsp')"  target="right">修改密码</a></p>
            </div>
            <div title="重置学院密码" style="padding:10px">
                <p><a  class="easyui-linkbutton" onclick="addTab('重置学院密码','${pageContext.request.contextPath}/admin/gotoModifyCollPwdServlet')"  target="right">重置学院密码</a></p>
            </div>
            <div title="上传文件" style="padding:10px">
                <p><a  class="easyui-linkbutton" onclick="addTab('上传文件','${pageContext.request.contextPath}/admin/uploadExcel.jsp')"  target="right">上传文件</a></p>
            </div>
            <div title="下载文档" style="padding:10px">
                <p><a  class="easyui-linkbutton" onclick="addTab('下载用章预约表','${pageContext.request.contextPath}/admin/downloadServlet?content=stamp')"  target="right">下载用章预约表</a></p>
                <p><a  class="easyui-linkbutton" onclick="addTab('下载三方协议表','${pageContext.request.contextPath}/admin/downloadServlet?content=sanFangXieYi')"  target="right">下载三方协议表</a></p>
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