<%--
  Created by IntelliJ IDEA.
  User: mayonggang
  Date: 2018/4/25
  Time: 下午8:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>档案转移地址信息</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">

    <link rel="stylesheet" href="https://cdn.bootcss.com/weui/1.1.2/style/weui.min.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/jquery-weui/1.2.0/css/jquery-weui.min.css">
    <link rel="stylesheet" href="<c:url value="/css/demo.css"/>">
</head>
<body>
<table border="1">
    <p style="color: red;">&nbsp;&nbsp;&nbsp;以下为你的档案寄往地址以及邮政EMS反馈的接收信息，请尽快与档案接收单位联系，确认档案已被妥善保管。 </p>

    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">姓名:</label></div>
        <div class="weui-cell__bd">
            <div class="weui-flex">
                <div class="weui-flex__item">${student.sName}</div>
            </div>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">学号:</label></div>
        <div class="weui-cell__bd">
            <div class="weui-flex">
                <div class="weui-flex__item">${student.sId}</div>
            </div>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">档案转寄地址:</label></div>
        <div class="weui-cell__bd">
            <div class="weui-flex">
                <div class="weui-flex__item">${student.sForaddress}</div>
            </div>
        </div>
    </div>

    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">EMS信息:</label></div>
        <div class="weui-cell__bd">
            <div class="weui-flex">
                <div class="weui-flex__item">待上线</div>
            </div>
        </div>
    </div>
    <%--档案专辑地址--%>
    <%--ems--%>

    <%--<tr>--%>
        <%--<td>毕业年度</td>--%>
        <%--<td>${student.sGraduationyear}</td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
        <%--<td>身份证号</td>--%>
        <%--<td>${student.sIdentitycard}</td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
        <%--<td>性别</td>--%>
        <%--<td>${student.sSex}</td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
        <%--<td>民族</td>--%>
        <%--<td>${student.sNation}</td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
        <%--<td>政治面貌</td>--%>
        <%--<td>${student.sPoliticaloutlook}</td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
        <%--<td>学历</td>--%>
        <%--<td>${student.sEducation}</td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
        <%--<td>专业</td>--%>
        <%--<td>${student.sMajor}</td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
        <%--<td>培养方式</td>--%>
        <%--<td>${student.sCulturemode}</td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
        <%--<td>生源地</td>--%>
        <%--<td>${student.sBirthplace}</td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
        <%--<td>所在院系</td>--%>
        <%--<td>${student.sDepartment}</td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
        <%--<td>所在班级</td>--%>
        <%--<td>${student.sClass}</td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
        <%--<td>家庭联系电话</td>--%>
        <%--<td>${student.sStudylength}</td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
        <%--<td>联系手机</td>--%>
        <%--<td>${student.sMyphone}</td>--%>
    <%--</tr>--%>

    <%--<tr>--%>
        <%--<td>灵活就业单位名称</td>--%>
        <%--<td>${student.sUnitcomName}</td>--%>
    <%--</tr>--%>

    <%--<tr>--%>
        <%--<td>灵活就业单位性质</td>--%>
        <%--<td>${student.sUnittype}</td>--%>
    <%--</tr>--%>

    <%--<tr>--%>
        <%--<td>灵活单位就业联系方式</td>--%>
        <%--<td>${student.sUnitinformation}</td>--%>
    <%--</tr>--%>

</table>
</body>
</html>
