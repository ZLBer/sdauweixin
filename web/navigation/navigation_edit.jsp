<%--
  Created by IntelliJ IDEA.
  User: C
  Date: 2017/4/24
  Time: 21:43
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
    <title>管理招聘信息</title>
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
        function selectAll(){
            var state = $("#select_all").prop("checked");
            if(state==true){
                $("#select_all").prop("checked",false)
                $(".articleSelectId").prop("checked",false);
            }else{
                $("#select_all").prop("checked",true)
                $(".articleSelectId").prop("checked",true);
            }
        }
        $(document).ready(function(){
            $("#select_all").click(function () {
                var state = $("#select_all").prop("checked");
                $(".articleSelectId").prop("checked",state);
            });
        });
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath}/navigation/navigation_edit" method="post" id="query">
    <input type="hidden" name="pageNo" value="1"/>
</form>
<c:if test="${recordCount==0}">
    <br/><br/>无记录<br>
</c:if>
<c:if test="${recordCount>0}">
    <form action="${pageContext.request.contextPath}/navigation/navigation_modify" method="post" name="filter">
        <table frame="void" border="1" class="easyui-datagrid" id="content"
               rownumbers="true"  width="100%">
            <thead>
            <tr>
                <th data-options="field:'0'"><a id="select_all_a" href="javascript:selectAll()">全选</a>
                    <input type="checkbox" id="select_all"></th>
                <th data-options="field:'1'">状态</th>
                <th data-options="field:'2'">审核栏</th>
                <th data-options="field:'3'">企业号</th>
                <th data-options="field:'4'">企业名称</th>
                <th data-options="field:'5'">联系人</th>
                <th data-options="field:'6'">联系方式</th>
                <th data-options="field:'7'">发布人及信息</th>
                <th data-options="field:'8'">编辑栏</th>
                <th data-options="field:'9'">删除栏</th>
                <th data-options="field:'10'">时间</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${articlelist}" var="article">
                <tr>
                    <td><input class="articleSelectId" type="checkbox" name="articleSelectId" value="${article.articleid}"></td>
                    <td>${article.state}</td>
                    <td><a href="${pageContext.request.contextPath}/navigation/article_queryByPend?aid=${article.articleid}" onclick="return confirm('是否要审核该记录吗？')">审核</a></td>
                    <td>${article.articleid}<br></td>
                    <td>${article.enterprisename}<br></td>
                    <td>${article.author}<br></td>
                    <td>${article.authortel}<br></td>
                    <td>${article.other}<br></td>
                    <td><a href="${pageContext.request.contextPath}/navigation/article_queryByNavi?aid=${article.articleid}">修改</a></td>
                    <td><a href='${pageContext.request.contextPath}/navigation/article_delete?articleid=${article.articleid}&all=0' onclick="return confirm('确实要删除该 记录吗？')">删除</a></td>
                    <td>${article.articletime}<br></td>
                </tr>
            </c:forEach>
            </tbody>
           <button><a href="javascript:document.filter.action='navigation_review?batch=true';document.filter.submit();">批量审核</a></button><br>
        </table>
    </form>
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