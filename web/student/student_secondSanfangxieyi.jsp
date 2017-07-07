<%--
  Created by IntelliJ IDEA.
  User: libin
  Date: 2017/5/16
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta charset="utf-8">
<style>
    textarea
    {  border-radius:3px;
        border:1px solid #000;
        border-color:#09C;
        width:500px;
        height:300px;}
</style>
<head>
    <title>填写申请理由</title>
</head>
<body>
<div style=" padding:0 200px">
    填写申请理由</br>
    <form action="student_secondSanfangxieyi?studentid=${user.studentid}" method="post">
        <textarea  name="others"  cols="40" rows="20"></textarea></br>
        <input type="submit" value="提交"></br>
        ${message}
    </form>
</div>
</body>
</html>
