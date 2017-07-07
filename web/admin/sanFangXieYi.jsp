<%--
  Created by IntelliJ IDEA.
  User: Minister
  Date: 2017/7/1
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="application/vnd.ms-excel;charset=GBK"%>
<% response.setHeader("Content-disposition","attachment; filename=sanfangxieyi.xls"); %>
<html>
<head>
</head>
<body>
    <table border="1">
        <tr>
            <th>学号</th>
            <th>公司名</th>
            <th>公司号</th>
            <th>公司地址</th>
            <th>公司邮编</th>
            <th>公司联系人</th>
            <th>公司电话</th>
            <th>公司邮箱</th>
            <th>公司性质</th>
            <th>档案地址</th>
            <th>状态</th>
            <th>其他</th>
            <th>协议编号</th>
            <th>学院名</th>
            <th>行业</th>
            <th>类别</th>
        </tr>
        <c:forEach items="${list}" var="xieYi">
            <tr>
                <td>${xieYi.studentid}</td>
                <td>${xieYi.comname}</td>
                <td>${xieYi.comnumber}</td>
                <td>${xieYi.comadress}</td>
                <td>${xieYi.comzipcode}</td>
                <td>${xieYi.comcontact}</td>
                <td>${xieYi.comtel}</td>
                <td>${xieYi.comemail}</td>
                <td>${xieYi.comnature}</td>
                <td>${xieYi.danganaddress}</td>
                <td>${xieYi.state}</td>
                <td>${xieYi.others}</td>
                <td>${xieYi.xieyinum}</td>
                <td>${xieYi.collegename}</td>
                <td>${xieYi.industry}</td>
                <td>${xieYi.category}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
