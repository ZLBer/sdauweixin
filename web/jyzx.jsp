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
            border-radius: 5px;
            height:280px;
            width: 310px;
            background-color: #f9f9f9;
            border-right: 0px;
            border-top-right-radius:0px ;
            border-bottom-right-radius:0px ;


        }
        #div2
        {
            border:1px solid dodgerblue;
            /*border-color: #FFFFFF;*/
            /*border-radius: 15px;*/
            height:280px;
            width: 315px;
            margin-left: 0px;
            background-color: #f9f9f9;
            border-left:0px ;
            border-right: 0px;
            
            
        }
        #div3
        {
            border:1px solid dodgerblue;
            /*border-color: #FFFFFF;*/
            border-radius: 5px;
            height:280px;
            width: 310px;
            margin-left: 0px;
            background-color: #f9f9f9;
            border-left: 0px;
            border-top-left-radius:0px ;
            border-bottom-left-radius:0px ;

        }
       
    </style>
</head>
<body>
<div class="row clearfix" style="padding-left:20px;">

    <div class="col-xs-12 col-md-4 col-lg-4 column" id="div1">
        <img src="images/main2_2.gif"  width="100px" height="40px"/>
        <a class="btn" href="filter.jsp?pageNo=1&columnId=1" style="float: right;" target="_blank">more</a>
        <p></p>
        <ul type="disc">

            <c:forEach items="${articleList}" var="article">
                <li>	<font size="2"><a href='article_query?aid=${article.articleid}') target="_blank">${article.enterprisename}</a></font> </li>
            </c:forEach>

        </ul>
        
    </div>

    <div class="col-xs-12 col-md-4 col-lg-4 column" id="div2" >
        <a class="btn" href="filter.jsp?pageNo=1&columnId=2" style="float: right;" target="_blank">more</a>
        <div style="padding-left: 20px">
        <img src="images/main2_1.gif"  width="100px" height="40px"/>
        </div>

        <p></p>
        <ul type="disc">

            <c:forEach items="${articleSpecial}" var="articlespecial">
                <li><font size="2">	<a href='article_query?aid=${articlespecial.articleid}') target="_blank">${articlespecial.enterprisename}</a></font></li>
            </c:forEach>
        </ul>
       
    </div>

    <div class="col-xs-12 col-md-4 col-lg-4 column" id="div3">
        <div style="padding-left: 50px">
        <img src="images/main2_3.gif"  width="100px" height="40px" />
    </div>
        <p></p>
        <p></p>
        </br>
        <p style="padding-left: 50px">
            <img src="images/03.png"><a href="login.jsp" ><font size="+2" color="#666666"target="_blank">校内用户登录</font></a><br></p><p></p><p></p>
        <%--<img src="images/03.png"><a href="zhiyin.jsp"><font size="+2" color="#666666">企业入口</font></a>--%>
        <p></p>
    </div>
</div>
</body>
</html>
