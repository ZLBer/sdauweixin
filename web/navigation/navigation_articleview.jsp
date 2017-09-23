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
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>

<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="ckeditor/ckeditor.js"></script>
<style>
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
        background:#D3D3D3;
    }
    td{
        margin:0px;
        border:0px;
        /*cellspacing=0;
        cellpadding=0;*/
        height:40px;
    }
    .left
    {
    	float: left;
    	width: 400px;
    	height:300px;
    }
    .right
    {
    	float: right;
    	margin-left: 100px;
    	/*padding-left:100px ;*/
    	padding-right: 500px;
    	text-align: left;
    	width: 400px;
    	height: 300px;
    	
    	
    }
    .center
    {
    	margin: 0 auto;
    	width:100%;
    	height: auto;
    }
    .input-group-addon
    {
    	width: 400px;
    	height: 50px;
    	border-radius: 5px;
    	
    }
    .bott
    {
    	
    	margin-bottom: 240px;
    	border:1px solid black;
    	padding-bottom: 100px;
    	width: 200px;
    }
    .aa
    {
    	margin: 0 auto;
    }
</style>
</head>
<body>
<div style="padding:0 100px;" class="aa">
    <c:forEach items="${articleList}" var="article">
     <font size="+2"> ${article.enterprisename}</font> 
        ${article.articletext}
    
          <div class="center"> 
            <div class="left">
	            <span class="input-group-addon" style="border-radius:5px ;">发布时间: ${article.articletime}</span>
	               <br />
	            <span class="input-group-addon" style="border-radius:5px ;">信息发布者:${article.author}</span>
	                <br />
	           
	            <span class="input-group-addon" style="border-radius:5px ;">发布者电话:${article.authortel}</span>
	                <br />
	            <span class="input-group-addon" style="border-radius:5px ;">状态:${article.state}</span>
	                <br />
	                <a href="${pageContext.request.contextPath}${article.mediaid}">下载营业执照</a>&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="navigation_demand?aid=${article.articleid}"><font size="+1">查看需求</font></a>
	                <a href="${pageContext.request.contextPath}/navigation/navigation_view?pageNo=1">返回上一页</a>

	               </div>
     		   <div class="right">
	            <span class="input-group-addon" style="width:230px; height: 50px;border-radius: 5px;">企业证明:</span>
	            <p></p>
	            <img src="${pageContext.request.contextPath}${article.mediaid}" width="200px" height="250px"><br />
 
    		
    
        
				</div>
</div>
</c:forEach>
</body>
</html>