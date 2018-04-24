<%--
  Created by IntelliJ IDEA.
  User: 平行时空
  Date: 2018/4/23
  Time: 21:04
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


            姓名：${data.sName}<br/>
            学号：<br/>
            性别：${data.sSex} &nbsp; 民族：<br/>
            专业： <br/>
            <a href="<c:url value='StudentServlet?method=changedata&s_id=${data.sId}'/>">
                <button >编辑</button>
            </a>&nbsp;
            <a href="<c:url value='StudentServlet?method=isOk&s_id=${data.sId}&sIschanged=1'/>">
                <button >确认</button>
            </a>
</body>
</html>