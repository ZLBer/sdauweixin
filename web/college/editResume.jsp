<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: libin
  Date: 2017/9/9
  Time: 10:13
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
    <title>填写不同意理由</title>

</head>
<body>
<form method="post" action="college_handleResume">
    <input type="hidden" name="state" value="2">
    <input type="hidden" name="studentid" value="${studentid}">
    <center><textarea name="reason" class="easyui-textbox" style="height:300px;width: 700px;" data-options="multiline:true"> </textarea></center><br>
    	<p></p>
    <center><input type="submit" value="提交" align="center" class="easyui-linkbutton" style="width:90px;height: 50px;"></center>
</form>
</body>
</html>
