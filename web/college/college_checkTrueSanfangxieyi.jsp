
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<meta charset="utf-8">
<head>
    <title>审核三方协议下载</title>
    <link rel="stylesheet" type="text/css" href="css/IconExtension.css">
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
    <script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
    <style type="text/css">
        *{
            font-size: 1em;
        }
        #count {
            margin-top:20px;
            width: 40%;
        }
        #info_table{
            width: 50%;
            margin-top:20px;
            margin-bottom:20px;
        }
        #page_box{
            margin-bottom:20px ;
        }
    </style>
    <script language="javascript">
        function jump1(pageno){
            var queryForm=document.getElementById("query");
            queryForm.pageNo.value=pageno;
            queryForm.submit();
        }
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath }/college/college_checkTrueSanfangxieyi" method="post" id="query">
    <select name="fieldName">
        <option value="" <c:if test="${param.fieldName==''}">selected</c:if>>全部</option>
        <option value="studentid" <c:if test="${param.fieldName=='studentid'}">selected</c:if>>学号</option>
        <option value="studentname" <c:if test="${param.fieldName=='studentname'}">selected</c:if>>姓名</option>
    </select>
    <input type="text" name="fieldValue" value="${param.fieldValue}"/>
    <input type="hidden" name="pageNo" value="1"/>
    <input type="hidden" name="collegeid" value="${user.collegeid}"/>
    <input type="submit" value="查询"/>
</form>
<c:if test="${recordCount==0}">
    <br/><br/>无记录
</c:if>
<c:if test="${recordCount>0}">
<div> * 请学院关闭申请三方协议学生的省内就业通道</div>
<div>已发放三方协议数量：${recordCount}</div>
<a href="college_zipDownloadSanfangxieyi?collegeid=${user.collegeid}&state=1">下载全部</a>&nbsp;&nbsp;&nbsp;&nbsp;
<table border="1" id="info_table" frame="void" class="easyui-datagrid"
       rownumbers="true"  width="100%">
    <thead>
    <tr>
        <th data-options="field:'1'">学号</th>
        <th data-options="field:'2'">三方协议编号</th>
        <th data-options="field:'3'">姓名</th>
        <th data-options="field:'4'">已下载次数</th>
        <th data-options="field:'5'">操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${studentList}" var="stu">
        <tr>
            <c:forEach items="${stu}" var="student">
                <td>${student}</td>
            </c:forEach>
            <td>   <a href="college_downloadSanfangxieyi?studentid=${stu[0]}&sanfangid=${stu[1]}">下载</a></td>

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
</c:if>
</body>
</html>