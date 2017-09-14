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
	<meta charset="utf-8"  />
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <td width="300px" style="text-align: center;">标题</td>
            <td style="text-align: center;">时间</td>
        </tr>
        <c:forEach var="item" items="${infoList}">
            <tr>
                <td style="text-align: center;"><img src="images/list.png"><a href="article_query?aid=${item.articleid}"><font size="-1">${item.enterprisename}</font></a></td>
                <td width="300px" style="text-align: center;"> <font size="-1">${item.articletime}</font></td>
            </tr>
        </c:forEach>
    </table>
    <jsp:include page="pageSplit.jsp"/>
</body>
</html>
