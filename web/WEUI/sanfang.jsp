<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 2017/5/22 0022
  Time: 上午 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title></title>

    <link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.0/weui.css">
</head>
<body>
<div class="weui-msg">
    <div class="weui-msg__icon-area"><i class="weui-icon-warn weui-icon_msg-primary"></i></div>
    <div class="weui-msg__text-area">
        <h2 class="weui-msg__title">您的三方协议已申请，请勿重复申请！</h2>
        <p class="weui-msg__desc"></p>
    </div>
    <div class="weui-msg__opr-area">
        <p class="weui-btn-area">
            <a href="javascript:;" class="weui-btn weui-btn_primary" onclick="WeixinJSBridge.call('closeWindow');">点击返回</a>
        </p>
    </div>
</div>
</body>
</html>
