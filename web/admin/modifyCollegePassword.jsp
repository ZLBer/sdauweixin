
<%--
  Created by IntelliJ IDEA.
  User: Minister
  Date: 2017/5/24
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="/css/IconExtension.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<head>
    <title>修改学院密码</title>
</head>
<body>
<p style="color: red">*重置操作将会把密码重置为123456</p>
<table border="1" frame="void" class="easyui-datagrid" id="content"
       rownumbers="true"  width="100%">
    <thead>
    <tr>
        <th data-options="field:'1'">学院</th>
        <th data-options="field:'2'">老师姓名</th>
        <th data-options="field:'3'">工号</th>
        <th data-options="field:'4'">操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="row" items="${collegeInfo}">
        <tr>
            <td>${row[0]}</td>
            <td>${row[1]}</td>
            <td>${row[2]}</td>
            <td><a href="${pageContext.request.contextPath}/admin/modifyCollPwdServlet?id=${row[3]}">重置密码</a></td>
        </tr>
    </c:forEach>
    </tbody>

</table>
</body>
</html>
