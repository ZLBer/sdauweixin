<%--
  Created by IntelliJ IDEA.
  User: libin
  Date: 2017/9/9
  Time: 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	 <meta charset="utf-8" />
    <link rel="stylesheet" type="text/css" href="css/IconExtension.css">
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
    <script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<head>
    <title>查看学生简历申请</title>
    <script language="javascript">
        function jump1(pageno){
            var queryForm=document.getElementById("query");
            queryForm.pageNo.value=pageno;
            queryForm.submit();
        }
    </script>
</head>
<body>
<form action="college_selectResume" id="query" method="post" >
    <input type="hidden" name="pageNo" value="1">
</form>
<c:if test="${recordCount==0}">
    <br/><br/>无记录
</c:if>
<c:if test="${recordCount>0}">
<table border="1" id="info_table" frame="void" class="easyui-datagrid"
           rownumbers="true"  width="100%">
	<thead>
    <tr>
        <th data-options="field:'1'">申请人学号</th>
        <th data-options="field:'2'">姓名</th>
        <th data-options="field:'3'">学院</th>
        <th data-options="field:'4'">操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${resumes}" var="resume">
        <tr>
            <td>${resume.studentId}</td>
            <td>${resume.studentName}</td>
            <td>${resume.studentCollege}</td>
            <td><a href="${pageContext.request.contextPath}/college/college_handleResume?state=1&studentid=${resume.studentId}">
            	同意</a><a href="${pageContext.request.contextPath}/college/college_handleResume?state=0&studentid=${resume.studentId}">
            	 不同意</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

共有申请${recordCount}条， 第${pageNo}/${pageCount}页，
<c:if test="${pageNo>1}">
    <a href="javascript:jump1('1')">首页</a>
    <a href="javascript:jump1('${pageNo-1}')">上页</a>
</c:if>
<c:if test="${pageNo==1}">
    首页  上页
</c:if>

<c:if test="${pageNo<pageCount}">
    <a href="javascript:jump1('${pageNo+1}')">下页</a>
    <a href="javascript:jump1('${pageCount}')">末页</a>
</c:if>
<c:if test="${pageNo==pageCount}">
    下页   末页
</c:if>
</c:if>
</body>
</html>
