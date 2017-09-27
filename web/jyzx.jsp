<%--
  Created by IntelliJ IDEA.
  User: libin
  Date: 2017/9/20
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta charset="utf-8" />
<head>
    <title>Title</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <style>
        #div1
        {
            border:1px solid dodgerblue;
            /*border-color: #FFFFFF;*/
            border-radius: 15px;
            height:280px;
            width: 305px;
            background-color: #f9f9f9;


        }
        #div2
        {
            border:1px solid dodgerblue;
            /*border-color: #FFFFFF;*/
            border-radius: 15px;
            height:280px;
            width: 305px;
            margin-left: 10px;
            background-color: #f9f9f9;
        }
        #div3
        {
            border:1px solid dodgerblue;
            /*border-color: #FFFFFF;*/
            border-radius: 15px;
            height:280px;
            width: 305px;
            margin-left: 10px;
            background-color: #f9f9f9;

        }
       
    </style>
</head>
<body>
<div class="row clearfix" style="padding-left:20px;">

    <div class="col-xs-12 col-md-4 col-lg-4 column" id="div1">
        <img src="images/main2_2.gif"  width="130px" height="50px"/>
        <p></p>
        <ul type="disc">

            <c:forEach items="${articleList}" var="article">
                <li>	<a href='article_query?aid=${article.articleid}') target="_blank">${article.enterprisename}</a> </li>
            </c:forEach>

        </ul>
        <p>
            <a class="btn" href="filter.jsp?pageNo=1&columnId=1" style="float: right;" target="_blank">more</a>
        </p>
    </div>

    <div class="col-xs-12 col-md-4 col-lg-4 column" id="div2" >
        <img src="images/main2_1.gif"  width="130px" height="50px"/>
        <p></p>
        <ul type="disc">

            <c:forEach items="${articleSpecial}" var="articlespecial">
                <li>	<a href='article_query?aid=${articlespecial.articleid}') target="_blank">${articlespecial.enterprisename}</a></li>
            </c:forEach>
        </ul>
        <p>
            <a class="btn" href="filter.jsp?pageNo=1&columnId=2" style="float: right;" target="_blank">more</a>
        </p>
    </div>

    <div class="col-xs-12 col-md-4 col-lg-4 column" id="div3">
        <img src="images/main2_3.gif"  width="130px" height="50px"/>
        <p></p>
        <p></p>
        </br>
        <p>
            <img src="images/03.png"><a href="login.jsp" ><font size="+2" color="#666666"target="_blank">校内用户登录</font></a><br></p><p></p><p></p>
        <%--<img src="images/03.png"><a href="zhiyin.jsp"><font size="+2" color="#666666">企业入口</font></a>--%>
        <p></p>
    </div>
</div>
</body>
</html>
