<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/15
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.0/weui.css">
    <title>问题反馈</title>
</head>
<body ontouchstart>
<div class="page"  >
    <div class="page__bd">
        <div class="weui-form-preview">
            <div class="weui-form-preview__hd">
                <div class="weui-form-preview__item">
                    <label class="weui-form-preview__label">问题描述 ：</label><br>
                    <p style="text-align:left" class="page__desc">&nbsp;&nbsp;${problemEntity.problemtext}</p>
                </div>
            </div>
            <div class="weui-form-preview__hd">
                <div class="weui-form-preview__item">
                    <label class="weui-form-preview__label">答复时间 ：</label><br>
                    <p style="text-align:left" class="page__desc">&nbsp;&nbsp;${problemEntity.replytime}</p>
                </div>
            </div>
            <div class="weui-form-preview__hd">
                <div class="weui-form-preview__item">
                    <label class="weui-form-preview__label">答复内容 :</label><br>
                    <p style="text-align:left" class="page__desc">&nbsp;&nbsp;${problemEntity.replytext}</p>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>