<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: C
  Date: 2017/5/2
  Time: 21:09
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
    	
    	padding-left:100px ;
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
    	
    	padding-bottom: 100px;
    	width: 200px;
    }
</style>
<head>
    <title>审核招聘信息</title>
    <script type="text/javascript" src="ckeditor/ckeditor.js"></script>
</head>
<body>
<div style="padding:0 200px">
    <form action="navigation_modify" method="post" name="filter">

        <c:forEach items="${articleList}" var="article">
          <font size="+2"> ${article.enterprisename}</font> 
            
            <textarea class="ckeditor" cols="80"  name="articletext"  rows="5">${article.articletext}</textarea><br>
            
           
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
	                
	          <input type="submit"  class="easyui-linkbutton" style="width: 70px;height: 30px;" onclick="javascript:document.filter.action='${pageContext.request.contextPath}/navigation/navigation_modify';document.filter.submit();" value="发布"/>
            <input type="button"  class="easyui-linkbutton"  style="width: 70px;height: 30px;" onclick="javascript:document.filter.action='${pageContext.request.contextPath}/navigation/navigation_save?batch=true';document.filter.submit();" value="保存">
                <a href="${pageContext.request.contextPath}${article.mediaid}"><font size="+1">下载营业执照</font></a>&nbsp;&nbsp;&nbsp;
                <input type="hidden" name="articleid" value="${article.articleid}">
                <input type="hidden"  name="enterprisename" value="${article.enterprisename}">
                <a href="navigation_demand?aid=${article.articleid}"><font size="+1">查看需求</font></a>
            </div>
            
            <div class="right">
	            <span class="input-group-addon" style="width: 200px; height: 50px;border-radius: 5px;">企业证明:</span>
	            <p></p>
	            <img src="${pageContext.request.contextPath}${article.mediaid}" width="200px" height="250px"><br />
	            
            </div>

            </div>
            
           <!-- <div class="bott">
            <input type="submit" onclick="javascript:document.filter.action='${pageContext.request.contextPath}/navigation/navigation_modify';document.filter.submit();" value="发布"/>
            <input type="button" onclick="javascript:document.filter.action='${pageContext.request.contextPath}/navigation/navigation_save?batch=true';document.filter.submit();" value="保存">
        		</div>-->
            
           
           <!-- <a href="${pageContext.request.contextPath}${article.mediaid}"><font size="+1">下载营业执照</font></a>
            <br>
            <input type="hidden" name="articleid" value="${article.articleid}">
            <input type="hidden" name="enterprisename" value="${article.enterprisename}">-->


           <!-- <%--<c:forEach items="${demandList}" var="demand">--%>
            <%--需求专业:${demand.majorid}<br>--%>
            <%--需求人数:${demand.demandnum}<br>`--%>
            <%--</c:forEach>--%>-->
       </c:forEach>
        <!--<%--<%=((List)request.getAttribute("articleList")).size()%>--%>-->



    </form>
     		
          
</div>

</body>
</html>