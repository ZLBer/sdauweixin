<%--
  Created by IntelliJ IDEA.
  User: Minister
  Date: 2017/7/1
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="application/vnd.ms-excel;charset=GBK"%>
<% response.setHeader("Content-disposition","attachment; filename=stamp.xls"); %>
<html>
<head>
</head>
<body>
    <table border="1">
        <tr>
            <th>ԤԼ��</th>
            <th>ѧ��</th>
            <th>ѧ������</th>
            <th>ѧ��רҵ</th>
            <th>��;</th>
            <th>ѧԺ������</th>
            <th>��������������</th>
            <th>������</th>
            <th>����ʱ��</th>
            <th>ѧԺ��</th>
        </tr>
        <c:forEach items="${list}" var="stamp">
            <tr>
                <td>${stamp.stampid}</td>
                <td>${stamp.studentid}</td>
                <td>${stamp.studentname}</td>
                <td>${stamp.studentmajor}</td>
                <td>${stamp.functron}</td>
                <td>${stamp.collegestate}</td>
                <td>${stamp.nstate}</td>
                <td>${stamp.stampuserid}</td>
                <td>${stamp.stamptime}</td>
                <td>${stamp.collegeid}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
