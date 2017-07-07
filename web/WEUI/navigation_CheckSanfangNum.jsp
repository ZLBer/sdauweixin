<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 2017/6/28 0028
  Time: 下午 6:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.0/weui.css">
    <title>三方协议发放数量</title>
</head>
<body>
    <div class="weui-cell">
        <center>
            学校共发放协议${schoolcount}份,各学院详细情况如下
        </center>
    </div>
    <c:forEach var="college"  items="${all}">

        <div class="weui-cells">
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <p> ${college[0]}</p>
                </div>
                <div class="weui-cell__ft">${college[1]}</div>
                <div class="weui-cell__ft">${college[2]}份</div>
             </div>
        </div>

    </c:forEach>
</body>
</html>
