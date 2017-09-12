<%--
  Created by IntelliJ IDEA.
  User: hello world
  Date: 2017/4/20
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="css/IconExtension.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<style>
div{
 padding-left:200px;
}
</style>

<head>
    <title>Title</title>
</head>
<body>
<div style="padding-right:200px">
<form action="servlet_tijiao" method="post" id="submitProblem">

    <table frame="void">
        <tr>
            <td colspan="2"><textarea cols="80"  name="problemtext"  rows="10" class="easyui-textbox" style="height:300px" data-options="multiline:true"></textarea></td>
        </tr>
        <tr>
            <td>
                选择老师提问老师
                <select name="teacherName" form="submitProblem" required >
                    <c:forEach var="row" items="${teacherNames}">
                        <option>${row}</option>
                    </c:forEach>
                </select>
            </td>
            <td><input type="submit" name="submit" data-options="multiline:true" value="提交" align="center" class="easyui-linkbutton"  style="width:70px"></td>
        </tr>
    </table>
</form>
<div style="padding-right:200px">
</body>
</html>