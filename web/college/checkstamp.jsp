<%--
  Created by IntelliJ IDEA.
  User: john
  Date: 2017/5/23
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <style>
        body{
            text-align:center;
        }
    </style>
    <link rel="stylesheet" type="text/css" href="/sdauweixin/css/IconExtension.css">
    <link rel="stylesheet" type="text/css" href="/sdauweixin/css/easyui.css">
    <link rel="stylesheet" type="text/css" href="/sdauweixin/css/demo.css">
    <link rel="stylesheet" type="text/css" href="/sdauweixin/css/icon.css">
    <script type="text/javascript" src="/sdauweixin/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="/sdauweixin/js/jquery.easyui.min.js"></script>
    <script>
        function jump1(pageno){
            var queryForm=document.getElementById("query");
            queryForm.pageNo.value=pageno;
            queryForm.submit();
        }
    </script>
</head>

<body>
<form action="checkStamp" method="post" id="query">
    <input type="hidden" name="pageNo" value="1"/>
    <input type="hidden" name="collegeid" value="${user.collegeid}"/>
</form>
<c:if test="${recordCount==0}">
    <br/><br/>无记录
</c:if>
<c:if test="${recordCount>0}">
    <table border="1" id="info_table" frame="void" class="easyui-datagrid" id="content"
           rownumbers="true"  width="100%">
        <thead>
        <tr>
            <th  data-options="field:'1'">学号</th>
            <th  data-options="field:'2'">姓名</th>
            <th  data-options="field:'3'">专业</th>
            <th  data-options="field:'4'">原因</th>
            <th  data-options="field:'5'">审核</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${stamplist}" var="stamp">
            <tr>
                <td>${stamp.studentid}</td>
                <td>${stamp.studentname}</td>
                <td>${stamp.studentmajor}</td>
                <td>${stamp.functron}</td>
                <td><a href="college_selectStamp?stampid=${stamp.stampid}&pageNo=${pageNo}&collegeid=${user.collegeid}&state=1">通过</a>
                <a href="college_selectStamp?stampid=${stamp.stampid}&pageNo=${pageNo}&collegeid=${user.collegeid}&state=0">不通过</a></td>
            </tr>
        </c:forEach>
        </td>
        </tr>
        </tbody>
    </table>

    共有记录${recordCount}条， 第${pageNo}/${pageCount}页，
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
</body>
</html>