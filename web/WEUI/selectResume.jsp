<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/9
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <head>
        <title>查看预约简历的学生</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
        <link rel="stylesheet" href="../style/weui.css"/>
        <link rel="stylesheet" href="./example.css"/>
        <link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.0/weui.css">
    </head>
</head>
<body>
<form action="${pageContext.request.contextPath}/college/college_selectResume" method="post" id="query">

    <%--<input type="hidden" name="pageNo" value="1"/>--%>
    <%--<input type="hidden" name="collegeid" value="<%=session.getAttribute("collegeid")%>"/>--%>

    <center>
        <div class="weui-cell">
            <div class="weui=cell__bd">
                <label class="weui_label">
                    <c:if test="${recordCount==0}">
                        <br/><br/>当前没有简历预约申请！
                    </c:if>
                </label>
            </div>
        </div>
    </center>
    <c:if test="${recordCount>0}">
    <div class="page__hd">
        <div class="page__title">共有预约${recordCount}条， 第${pageNo}/${pageCount}页</div>
    </div>

    <c:forEach items="${resumes}" var="r">
        <div class="weui-cells">
                ${r.studentName}&nbsp;&nbsp;${r.studentCollege}
            <a class="weui-btn weui-btn_plain-default" href="${pageContext.request.contextPath}/college/college_handleResume?studentid=${r.studentId}&state=1">通过</a>
            <a class="weui-btn weui-btn_plain-default" href="${pageContext.request.contextPath}/college/college_handleResume?stampid=${r.studentId}&state=0">不通过</a>
        </div>
    </c:forEach>
    <br>
</form>
<!--分页切换-->
<center>
    <div class="page__hd">
        <div class="page__title">
            <c:if test="${pageNo>1}">
                <a href="javascript:jump1('1')">首页</a>&nbsp;&nbsp;
                <a href="javascript:jump1('${pageNo-1}')">上页</a>
            </c:if>
            <c:if test="${pageNo==1}">
                首页 &nbsp;&nbsp; 上页&nbsp;&nbsp;
            </c:if>
            <c:if test="${pageNo<pageCount}">
                <a href="javascript:jump1('${pageNo+1}')">下页</a>&nbsp;&nbsp;
                <a href="javascript:jump1('${pageCount}')">末页</a>&nbsp;&nbsp;
            </c:if>
            <c:if test="${pageNo==pageCount}">
                下页  &nbsp;&nbsp; 末页&nbsp;&nbsp;
            </c:if>
        </div>
    </div>
</center>
<br>
</c:if>
</body>
</html>
