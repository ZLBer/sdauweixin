<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Minister
  Date: 2017/9/13
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <td>标题</td>
            <td>时间</td>
        </tr>
        <c:forEach var="item" items="${infoList}">
            <tr>
                <td><a href="article_query?aid=${item.articleid}">${item.enterprisename}</a></td>
                <td>${item.articletime}</td>
            </tr>
        </c:forEach>
    </table>
    <jsp:include page="pageSplit.jsp"/>
</body>
</html>
