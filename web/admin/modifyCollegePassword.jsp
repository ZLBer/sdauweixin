
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
<head>
    <title>修改学院密码</title>
</head>
<body>
<p style="color: red">*重置操作将会把密码重置为123456</p>
<table border="1">
    <tr>
        <th>学院</th>
        <th>老师姓名</th>
        <th>工号</th>
        <th>操作</th>
    </tr>
    <c:forEach var="row" items="${collegeInfo}">
        <tr>
            <td>${row[0]}</td>
            <td>${row[1]}</td>
            <td>${row[2]}</td>
            <td><a href="${pageContext.request.contextPath}/admin/modifyCollPwdServlet?id=${row[3]}">重置密码</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
