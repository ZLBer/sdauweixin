
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <style>
        body{
            text-align:center;
        }
    </style>
    <script>
        function jump1(pageno){
            var queryForm=document.getElementById("query");
            queryForm.pageNo.value=pageno;
            queryForm.submit();
        }
    </script>
    <link rel="stylesheet" type="text/css" href="/css/IconExtension.css">
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
    <script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
</head>

<body>
<form action="${pageContext.request.contextPath}/navigation/navigation_stamp" method="post" id="query">
    <select name="fieldName">
        <option value="" <c:if test="${param.fieldName==''}">selected</c:if>>全部</option>
        <option value="studentid" <c:if test="${param.fieldName=='studentid'}">selected</c:if>>学号</option>
        <option value="studentname" <c:if test="${param.fieldName=='studentname'}">selected</c:if>>姓名</option>
        <option value="studentmajor" <c:if test="${param.fieldName=='studentmajor'}">selected</c:if>>专业</option>
        <option value="functron" <c:if test="${param.fieldName=='functron'}">selected</c:if>>用途</option>
    </select>
    <input type="text" name="fieldValue" value="${param.fieldValue}"/>
    <input type="hidden" name="pageNo" value="1"/>
    <input type="submit" value="查询"/>
</form>
<c:if test="${recordCount==0}">
    <br/><br/>无记录
</c:if>
<c:if test="${recordCount>0}">
    <table border="1" id="info_table" frame="void" class="easyui-datagrid" id="content"
           rownumbers="true"  width="100%">
        <thead>
        <tr>
            <th data-options="field:'1'">学号</th>
            <th data-options="field:'2'">姓名</th>
            <th data-options="field:'3'">专业</th>
            <th data-options="field:'4'">原因</th>
            <th data-options="field:'5'">审核</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${stamps}" var="stamp">
                <tr>
                    <td>${stamp.studentid}</td>
                    <td>${stamp.studentname}</td>
                    <td>${stamp.studentmajor}</td>
                    <td>${stamp.functron}</td>
                    <td><a href="${pageContext.request.contextPath}/navigation/navigation_checkStamp?stampid=${stamp.stampid}&pageNo=${pageNo}&userid=${user.navigationid}">已盖章</a></td>
                </tr>
            </c:forEach>
        </td>
        </tr>
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