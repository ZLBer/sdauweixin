<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/9
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
        <title>填写原因</title>
        <link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.0/weui.css">
        <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    </head>
</head>
<body>
    <form action="${pageContext.request.contextPath}/college/college_handleResume" ,method="post">
        <div class="weui-cell">
            <div class="weui-cell__bd">
                <textarea class="weui-textarea" placeholder="请输入您的原因" id="status" rows="15" name="reason" ></textarea>

            </div>
        </div>
        <a  href="${pageContext.request.contextPath}/college/college_handleResume" class="weui-btn weui-btn_primary">提交</a>
    </form>
</body>
</html>
