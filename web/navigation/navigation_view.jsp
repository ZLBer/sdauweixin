<%--
  Created by IntelliJ IDEA.
  User: C
  Date: 2017/5/9
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="/css/IconExtension.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<head>
    <title>查看招聘信息</title>
    <style>
        body{
            text-align:center;
        }
    </style>
    <script typet="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
    <script language="javascript">
        function jump1(pageno){
            var queryForm=document.getElementById("query");
            queryForm.pageNo.value=pageno;
            queryForm.submit();
        }
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath}/navigation/navigation_view" method="post" id="query">
    <select name="fieldName">
        <option value="" <c:if test="${param.fieldName==''}">selected</c:if>>全部</option>
        <option value="enterprisename" <c:if test="${param.fieldName=='enterprisename'}">selected</c:if>>企业名称</option>
        <%--<option value="articletext" <c:if test="${param.fieldName=='articletext'}">selected</c:if>>内容</option>--%>
    </select>
    <input type="text" name="fieldValue" value="${param.fieldValue}"/>
    <input type="hidden" name="pageNo" value="1"/>
    <input type="submit" value="查询"/>
</form>

<c:if test="${recordCount==0}">
    <br/><br/>无记录
</c:if>
<c:if test="${recordCount>0}">
    <form action="${pageContext.request.contextPath}/navigation/navigation_view" method="post">
        <table  border="1" frame="void" class="easyui-datagrid" id="content"
                rownumbers="true"  width="100%">
            <thead>
            <tr>
                <th data-options="field:'1'">状态</th>
                <th data-options="field:'2'">企业号</th>
                <th data-options="field:'3'">企业名称</th>
                <th data-options="field:'4'">联系人</th>
                <th data-options="field:'5'">联系方式</th>
                <th data-options="field:'6'">发布人及信息</th>
                <th data-options="field:'7'">文章发布时间</th>
                <th data-options="field:'8'">删除栏</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${articlelist}" var="article">
                <tr>
                    <td>${article.state}</td>
                    <td>${article.articleid}<br></td>
                    <td><a href="${pageContext.request.contextPath}/navigation/article_queryByView?aid=${article.articleid}">${article.enterprisename}</a><br></td>
                    <td>${article.author}<br></td>
                    <td>${article.authortel}<br></td>
                    <td>${article.other}<br></td>
                    <td>${article.articletime}<br></td>
                    <td><a href='${pageContext.request.contextPath}/navigation/article_delete?articleid=${article.articleid}&all=1' onclick="return confirm('确实要删除该 记录吗？')">删除</a></td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>
    </div>
    共有记录${recordCount}条， 第${pageNo}/${pageCount}页，
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
</body>
</html>
