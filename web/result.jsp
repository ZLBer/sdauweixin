<%@ page  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<meta charset="utf-8">
<head>
   <style type="text/css">
        tr,td:nth-child(1){
            text-align: left;
			font-family:楷体;
        }
		th,td{
            border:2px solid gray;
            text-align:center;
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
    </style>
</head>
<body background="${pageContext.request.contextPath}/images/beijing.png">
${msg}
    <table frame="void">
        <tr><th>企业名称</th></tr>
        <c:forEach items="${articleList}" var="article">
            <tr>
                <td><a href='article_query?aid=${article.articleid}')>${article.enterprisename}</a></td>
            </tr>
        </c:forEach>
    </table>
    <center><a href='filter.jsp'>上一步</a></center>
	<div style="bottom:0; left:0; position:fixed; width:100%"><img src="${pageContext.request.contextPath}/images/dibu.png" style="width:100%;height:150px"></div>
</body>
</html>
