<%--
  Created by IntelliJ IDEA.
  User: hello world
  Date: 2017/5/3
  Time: 0:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="css/IconExtension.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<head>
    <style>
        /*  body{
              text-align:center;
          }
          th,td{
              border:2px solid gray;
              text-align:center;
              padding:3px 10px;
          }
          table{
              border-collapse:collapse;
              margin:0 auto;
          }*/
    </style>
    <script text="text/javascript">
        function jump1(pageno)
        {
            var queryForm =document.getElementById("query");
            queryForm.pageNo.value = pageno;
            queryForm.submit();
        }
    </script>
</head>
<body>

<form action="checkProblem" method="post" id="query">
    <input type="hidden" value="1" name="pageNo">
</form>
<c:if test="${recordCount==0}">
    <br/><br/>无记录
</c:if>
<c:if test="${recordCount>0}">
    <table border="1" frame="void" class="easyui-datagrid" id="content"
           rownumbers="true"  width="100%">
        <thead>
        <tr>
            <th data-options="field:'1'">问题号</th>
            <th data-options="field:'2'">回复</th>
            <th data-options="field:'3'">时间</th>
        </tr>
        <c:forEach items="${problemList}" var="problem">
        <tbody>
        <tr>
            <td>${problem.problemid}</td>
            <td><a href="problemtoSee?problemid=${problem.problemid}">${problem.replytext}</a></td>
            <td>${problem.problemtime}</td>
        </tr>
        </tbody>
        </c:forEach>
        </thead>
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

</table>
</body>
</html>
