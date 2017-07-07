<%--
  Created by IntelliJ IDEA.
  User: Minister
  Date: 2017/5/24
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="application/vnd.ms-excel;charset=GBK"%>
<% response.setHeader("Content-disposition","attachment; filename=problem.xls"); %>
<html>
<head>
    <title>下载学生问题</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>提问者学号</th>
            <th>问题号</th>
            <th>问题内容</th>
            <th>问题状态</th>
            <th>提问时间</th>
            <th>回复内容</th>
            <th>回复时间</th>
        </tr>
        <c:forEach var="row" items="${problems}">
            <tr>
                <td>${row.studentid}</td>
                <td>${row.problemid}</td>
                <td>${row.problemtext}</td>
                <td>${row.problemstate}</td>
                <td>${row.problemtime}</td>
                <td>${row.replytext}</td>
                <td>${row.replytime}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
