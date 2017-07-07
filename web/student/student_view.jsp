<%--
  Created by IntelliJ IDEA.
  User: C
  Date: 2017/4/24
  Time: 20:06
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
    <title>查看招聘信息</title>
    <!--<style>
        body{
            text-align:center;
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
    </style>-->
    <script language="javascript">
        function update(articleid,enterprisename,articletext,articletime,columnid,mediaid1,mediaid2,author,authortel,mediaid){

            var updatearticle= document.getElementById("updatearticleForm");


            updatearticle.articleid.value=articleid;
            updatearticle.enterprisename.value=enterprisename;
            updatearticle.articletext.value=articletext;
            updatearticle.articletime.value=articletime;
            updatearticle.columnid.value=columnid;
            updatearticle.mediaid1.value=mediaid1;
            updatearticle.mediaid2.value=mediaid2;
            updatearticle.author.value=author;
            updatearticle.authortel.value=authortel;
            updatearticle.mediaid.value=mediaid;


        }
        function jump1(pageno){
            var queryForm=document.getElementById("query");
            queryForm.pageNo.value=pageno;
            queryForm.submit();
        }
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath}/Student_view"  method="post" id="student_crg">   
<center> 
	<div style="margin-bottom:20px">
	<center>
	<select name="fieldName" class="easyui-combobox">
        <option value="" <c:if test="${param.fieldName==''}">selected</c:if>>全部</option>
        <option value="enterprisename" <c:if test="${param.fieldName=='enterprisename'}">selected</c:if>>企业名称</option>
        <option value="articletext" <c:if test="${param.fieldName=='articletext'}">selected</c:if>>内容</option>
    </select>
	</div>
	<div style="margin-bottom:20px">
    <input type="text" class="easyui-textbox" name="fieldValue" value="${param.fieldValue}"/></div>
	<div style="margin-bottom:20px">
    <input type="hidden"  class="easyui-textbox" name="pageNo" value="1"/></div>
	<div style="margin-bottom:20px">
    <input type="submit"  class="easyui-linkbutton" value="查询" style="width:80px"/></div>
	</center>
</form>
</div>
<c:if test="${recordCount==0}">
    <br/><br/>无记录
</c:if>
<c:if test="${recordCount>0}">
    <table align="center" style= "backgound-repeat:none " frame="void" class="easyui-datagrid" id="content"
    		rownumbers="true"  width="100%">
         <thead>
            <tr>
                <th data-options="field:'1'">企业号</th>
                <th data-options="field:'2'">企业名称</th>
                <th data-options="field:'3'">内容</th>
                <th data-options="field:'4'">文章栏目数</th>
                <th data-options="field:'5'">时间</th>
                <th data-options="field:'6'">作者</th>
                <th data-options="field:'7'">联系方式</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${articlelist}" var="article">
            
                <tr>
                    <td>${article.articleid}<br></td>
                    <td>${article.enterprisename}<br></td>
                    <td>${article.articletext}<br></td>
                    <td>${article.columnid}<br></td>
                    <td>${article.articletime}<br></td>
                    <td>${article.author}<br></td>
                    <td>${article.authortel}<br></td>
    
    
                        <%--<td><a href="javascript:update('${article.enterprisename}','${article.articletext}','${article.columnid}','${article.articletime}');">修改</a></td>--%>
                        <%--<td><a href='student_delete.action?sid=${student.sid}' onclick="return confirm('确实要删除该 记录吗？')">删除</a></td>--%>
                </tr>
            </c:forEach>
       </tbody>
    </table>

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

