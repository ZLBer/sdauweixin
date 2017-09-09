<%--
  Created by IntelliJ IDEA.
  User: libin
  Date: 2017/5/11
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="css/IconExtension.css">
	<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
	<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
	<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<head>
    <title>填写信息下载就业推荐表</title>
</head>
<body>
<div style="padding:0 200px;">
<h2><font face="楷体" color="#000066" size="+3">填写相关信息下载就业推荐表</font></h2>
<form action="${pageContext.request.contextPath}/student/student_infoDownload" method="post">
    <input type="hidden" name="studentid" value="${user.studentid}">
    <table>
        <tr>
            <td>邮编：
            </td>
            <td>
                <input type="text" class="easyui-textbox" name="youbian" style="width:200px; height:25px"/>
            </td>
        </tr>
    <tr>
         <td>特长爱好:</td>
         <td><textarea name="aihao" class="easyui-textbox" style="width:400px; height:50px" data-options="multiline:true"></textarea></br></td>
    </tr>
   <tr>
       <td>在校担任职务:</td>
       <td><textarea name="zhiwu" class="easyui-textbox" style="width:400px; height:50px" data-options="multiline:true"></textarea></br></td>
   </tr>
        <tr>
            <td></td>
            <td ><p style="color: red">提示：为了不影响版面或格式美观，请将社会实践情况描述控制在8行以内。</p></td>
        </tr>
   <tr>
        <td>社会实践情况:</td>
        <td><textarea name="shijian" class="easyui-textbox" style="width:400px; height:100px" data-options="multiline:true"></textarea></br></td>
    </tr>
        <tr>
            <td></td>
            <td ><p style="color: red">提示：为了不影响版面或格式美观，请将奖惩情况描述控制在7行以内。</p></td>
        </tr>
    <tr>
        <td>奖惩情况:</td>
        <td><textarea name="jiangcheng" class="easyui-textbox" style="width:400px; height:100px" data-options="multiline:true"></textarea></br></td>
    </tr>
        <tr>
            <td></td>
            <td ><p style="color: red">提示：为了不影响版面或格式美观，请将所获专业类证书描述控制在3行以内。</p></td>
        </tr>
    <tr>
        <td>所获专业类证书:</td>
        <td><textarea name="zhengshu" class="easyui-textbox" style="width:400px; height:100px" data-options="multiline:true"></textarea></br></td>
    </tr>
    <tr>
        <td>毕业生择业志愿：</td>
        <td><textarea name="zhiyuan" class="easyui-textbox" style="width:400px; height:100px" data-options="multiline:true"></textarea></br></td>
    </tr>
    <tr>
        <td>毕业生自我评价：</td>
        <td><textarea name="pingjia" class="easyui-textbox" style="width:400px; height:100px" data-options="multiline:true"></textarea></br></td>
    </tr>
    </table>
    <input type="submit" class="easyui-linkbutton" style="width:100px;height:25px;" value="提交并下载">
    <p style="color: red">提示：若遇到格式不正确可自行修改。</p>
</form>
</div>
</body>
</html>
