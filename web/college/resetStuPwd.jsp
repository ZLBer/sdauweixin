<%--
  Created by IntelliJ IDEA.
  User: Minister
  Date: 2017/9/12
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>重置学生密码</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/college/resetStuPwdServlet">
        学号：<input type="text" name="stuId" required><input type="submit" value="重置">
    </form>
</body>
</html>
