<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/10
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>预约</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <link rel="stylesheet" href="./example.css"/>
    <link rel="stylesheet" href="../style/weui.css"/>
    <link rel="stylesheet" href="../style/weui2.css"/>
    <link rel="stylesheet" href="../style/weui3.css"/>
    <link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.0/weui.css">
    <script typet="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
    <script>
        $(function () {
            getData();
            $("#location").bind("change",getData);
        });

        function getData() {
            $("#teacher").html("");
            var location = $("#location>option:selected").text();
            var url="${pageContext.request.contextPath}/student/getTeacherListServlet";
            var param = {location:encodeURI(location)};
            var dataType = "json";
            $.get(url,param,function (data) {
                teacherList = data;
                for(var i=0;i<teacherList.length;i++){
                    $("#teacher").append("<option>"+teacherList[i]+"</option>");
                }
            },dataType);
        }
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath}/student/reservationServlet" method="post">
    <div class="weui_cells weui_cells_form ">
        <select name="location" id="location">
            <option>南校区</option>
            <option>北校区</option>
            <option>东校区</option>
        </select>
        <select name="teacher" id="teacher">
            <option value="">请选择校区</option>
        </select>
        <input type="submit" value="预约">
    </div>
</form>
</body>
</html>
