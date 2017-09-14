<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Minister
  Date: 2017/9/13
  Time: 20:27
  To change this template use File | Settings | File Templates.
  本分页组件需要传入的参数有：
        count:记录总数
        pageSize:页面大小
        currentPage:当前页
        servlet:用于填充href
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <c:set var="pageCount" value="${(count+pageSize-1)/pageSize}"/>
    <%
        Integer pageCount = ((Double)pageContext.getAttribute("pageCount")).intValue();
        pageContext.setAttribute("pageCount",pageCount);
    %>
    <c:if test="${pageCount>0}">
        <c:forEach var="i" begin="1" end="${pageCount}">
            <a href="${pageContext.request.contextPath}${servlet}${i}">&nbsp;[${i}]&nbsp;</a>
        </c:forEach>
        &nbsp;&nbsp;&nbsp;当前第 ${currentPage} 页，共 ${pageCount} 页
    </c:if>
</body>
</html>
