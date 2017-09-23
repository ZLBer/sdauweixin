<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Minister
  Date: 2017/9/13
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<style>
		div
		{
            padding-bottom: 10px;
			background-image: url(images/bj2.png);
            margin: 0 auto;
			width: 600px;
			height: auto;
			/*background-repeat: no-repeat;*/
            /*background-repeat:repeat-y ;*/
          /*  background-repeat:repeat-y ;*/
			text-align: center;
			/*border-radius: 10px;*/
			/*background-repeat: repeat-y;*/
		}
		table
        {
            font-size:12px;
        }
	</style>
	<meta charset="utf-8"  />
<head>
    <title>Title</title>
</head>
<body>
	<div>
    <table>
        <tr>
            <td width="300px" >标题</td>
            <td style="text-align: center;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;发布时间</td>
        </tr>
        <c:forEach var="item" items="${infoList}">
            <tr>
                <td ><img src="images/list.png" align="bottom"><a href="article_query?aid=${item.articleid}"><font >${item.enterprisename}</font></a></td>
                <td width="300px" style="text-align: right;"> <font >${item.articletime}</font></td>
            </tr>
        </c:forEach>
    </table>
    </div>
    <p></p>
    <jsp:include page="pageSplit.jsp"/>
</body>
</html>
