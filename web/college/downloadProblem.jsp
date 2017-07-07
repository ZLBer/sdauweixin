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
    <title>����ѧ������</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>������ѧ��</th>
            <th>�����</th>
            <th>��������</th>
            <th>����״̬</th>
            <th>����ʱ��</th>
            <th>�ظ�����</th>
            <th>�ظ�ʱ��</th>
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
