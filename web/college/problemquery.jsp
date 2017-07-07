<%--
  Created by IntelliJ IDEA.
  User: hello world
  Date: 2017/5/1
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<meta charset="utf-8">
<head>
    <link rel="stylesheet" type="text/css" href="/css/IconExtension.css">
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
    <script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
    <style>
        body{
            text-align:center;
        }
    </style>

    <script language="javascript">
        function jump1(pageno){
            var queryForm=document.getElementById("query");
            queryForm.pageNo.value=pageno;
            queryForm.submit();
        }
    </script>
</head>
<%--/college/problemtoSeeAll--%>
<body>
<center>
<c:if test="${recordCount==0}">
    <br/><br/>无记录
</c:if>
<c:if test="${recordCount>0}">
    <table border="1" id="info_table" frame="void" class="easyui-datagrid" id="content"
           rownumbers="true"  width="100%">
        <thead>
        <tr >
            <th data-options="field:'1'">问题号</th>
            <th data-options="field:'2'">问题内容</th>
            <th data-options="field:'3'">时间</th></tr>
        </thead>
        <tbody>
        <c:forEach items="${problemList}" var="problem">
            <tr>
                <td >${problem.problemid}</td>
                <td ><a href="inspectProblem?type=reply&problemid=${problem.problemid}">${problem.problemtext}</a></td>
                <td >${problem.problemtime}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    共有问题${recordCount}条， 第${pageNo}/${pageCount}页，
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

    <br/><br/>

</c:if>
</center>
</body>

</html>

