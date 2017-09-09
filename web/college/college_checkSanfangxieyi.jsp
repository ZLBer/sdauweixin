<%@ page import="po.XieyiEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>审核三方协议申请</title>
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
</head>
<body>
<%
    int page_size=20;
    int page_current=1;
    String page_cu = request.getParameter("page_current");
    if(page_cu==null){
        page_cu="1";
    }
    page_current = Integer.parseInt(page_cu);
    if(page_current<=0){
        page_current = 1;
    }

%>
<center>
<form method="post" action="college_selectDownloadSanfangxieyi" name="box" >
    <div>* 请学院关闭申请三方协议学生的省内就业通道</br>
<c:if test="${length==0}">
    <br/><br/>无记录
</c:if>
<c:if test="${length>0}">
         <%--<a href="college_zipDownloadSanfangxieyi?collegeid=${user.collegeid}&state=0">下载全部</a>&nbsp;&nbsp;&nbsp;&nbsp;--%>
        <%--<a href="javascript:document.box.action='college_selectDownloadSanfangxieyi';document.box.submit();">批量下载</a>--%></div>
    <table border="1" id="info_table" frame="void" class="easyui-datagrid"
           rownumbers="true"  width="100%">
        <thead>
        <tr>
            <th data-options="field:'1'"></th>
            <th data-options="field:'2'">学号</th>
            <th data-options="field:'3'">三方协议编号</th>
            <th data-options="field:'4'">企业名称</th>
            <th data-options="field:'5'">申请理由</th>
            <th data-options="field:'6'">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach  var="student" begin="${(page_current-1)*page_size}" end="${page_current*page_size-1}" items="${students}">
            <tr>
                <td><input type="checkbox" name="studentids" value="${student.studentid}"></td>
                <td>${student.studentid}</td>
                <td>${student.xieyinum}</td>
                <td>${student.comname}</td>
                <td>${student.others}</td>
                <td>
                    <a href="college_passSanfangxieyi?xieyiid=${student.xieyiid}&collegeid=${user.collegeid}">通过</a> &nbsp;
                    <a href="college_nopassSanfangxieyi?xieyiid=${student.xieyiid}&collegeid=${user.collegeid}">未通过</a> &nbsp;
                    <%--<a href="college_downloadSanfangxieyi?studentid=${student.studentid}&xieyiid=${student.xieyiid}">下载</a>--%>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <table>
    <tr>
        共有记录${length}条， 第${page_current}页/共${page_count}页
    <c:if test="${page_current>1}">
        <a href = "college_checkSanfangxieyi?page_current=1&collegeid=${user.collegeid}" >首页</a>&nbsp;
        <a href = "college_checkSanfangxieyi?page_current=${page_current-1}&collegeid=${user.collegeid}" >上一页</a>&nbsp;
    </c:if>
    <c:if test="${page_current==1}">
        首页  上页
    </c:if>

    <c:if test="${page_current<page_count}">
        <a href = "college_checkSanfangxieyi?page_current=${page_current+1}&collegeid=${user.collegeid}" >下一页</a>&nbsp;
        <a href = "college_checkSanfangxieyi?page_current=${page_count}&collegeid=${user.collegeid}" >尾页</a>&nbsp;
    </c:if>
        <c:if test="${page_current==page_count}">
            下页   末页
        </c:if>
        <br/><br/>
        </c:if>
    </tr>
    </table>
</form>
</center>
</body>
</html>
