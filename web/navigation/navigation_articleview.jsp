<%--
  Created by IntelliJ IDEA.
  User: C
  Date: 2017/5/15
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="/css/IconExtension.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<head>
    <script type="text/javascript" src="ckeditor/ckeditor.js"></script>
    <title>文章查看</title>
    <style type="text/css">
        /*  #right{float:right;}
          #left{float:left;}*/
        th,td{
            border:2px solid gray;
            /* text-align:center;*/
            padding:3px 10px;
            font-family:楷体;
        }
        table{
            border-collapse:collapse;
            margin:0 auto;
            border-radius:15px;
            overflow:hidden;
            background:#E0ECFF;
        }
        td{
            margin:0px;
            border:0px;
            /*cellspacing=0;
            cellpadding=0;*/
            height:40px;
        }
    </style>
</head>
<body>
<div style="padding:0 100px;">
    <c:forEach items="${articleList}" var="article">
    <center>${article.enterprisename}</center>
        ${article.articletext}
    <table >
        <tr>
            <td>当前时间:</td>
            <td>${article.articletime}</td>
            <td>作者:</td>
            <td>${article.author}</td>
            <td rowspan="2"> 企业证明:</td>
            <td><img src="${pageContext.request.contextPath}${article.mediaid}" width="200px" height="250px"></td>
        </tr>
        <tr>
            <td>作者电话:</td>
            <td>${article.authortel}</td>
            <td>状态:</td>
            <td>${article.state}</td>
        </tr>
    </table>
    <br><a href="${pageContext.request.contextPath}${article.mediaid}">下载营业执照</a>
    <div id="left">
        <a href="/navigation/navigation_view.jsp">返回上一页</a>
    </div>
</div>
</c:forEach>
</body>
</html>