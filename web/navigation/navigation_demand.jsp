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
    <title>查看需求</title>
    <script type="text/javascript" src="ckeditor/ckeditor.js"></script>
</head>
<body>
<center>
    <div style="margin:20px 0"></div>
    <div class="easyui-panel" title="查看需求" style="width:100%;padding:30px 60px;">
        <table>
            <tr><th>需求专业</th><th>需求人数</th></tr>
            <tr><td>
                <table>
                    <c:forEach items="${majorList}" var="major">

                        ${major.majorname}<br>
                    </c:forEach>

                </table>
            </td>
                <td>
                    <table>
                        <c:forEach items="${demandList}" var="demand">
                            ${demand.demandnum}<br>
                        </c:forEach>
                    </table>
                </td>
            </tr>
        </table>
            <div style="float:left;">
                <%--<a href="article_queryByNavi?aid=${article.articleid}">返回上一页</a>--%>
                <a href="${pageContext.request.contextPath}/enterprise/enterprise_insecond2?modify=true&major=&college=0">修改</a>
                <a href="${pageContext.request.contextPath}/navigation/article_queryByNavi?aid=${aid}">返回上一页</a>
            </div>
            <%--<%=((List)request.getAttribute("articleList")).size()%>--%>

    </div>
    </div>
</center>
</body>
</html>