<%--
  Created by IntelliJ IDEA.
  User: libin
  Date: 2017/5/18
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="/css/IconExtension.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>

<head>
</head>
<body>
<div> 学校共发放协议${schoolcount}份</div>
<table border="1" id="info_table" frame="void" class="easyui-datagrid" id="content"
       rownumbers="true"  width="100%">
    <thead>
    <tr>
        <th  data-options="field:'1'">学院代码</th>
        <th  data-options="field:'2'">学院名称</th>
        <th  data-options="field:'3'">发放数量</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="college"  items="${all}">
        <tr>
            <td>${college[0]}</td>
            <td>${college[1]}</td>
            <td>${college[2]}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
