<%--
  Created by IntelliJ IDEA.
  User: 平行时空
  Date: 2018/4/23
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
</head>
<body>
<form action="<c:url value='StudentServlet?method=updatedata'/> " method="post">
    <input type="hidden" value="${data.sId}" name="sId">
    姓名：<input type="text" value="${data.sName}" name="sName"><br/>
    学号：<input type="text" value="${data.sIdentitycard}" name="sIdentitycard"><br/>
    性别：<input type="text" value="${data.sName}"> &nbsp;
    民族：<input type="text" value="${data.sSex}" name="sSex"><br/>
    专业：<input type="text" value="${data.sMajor}" name="sMajor"><br/>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
