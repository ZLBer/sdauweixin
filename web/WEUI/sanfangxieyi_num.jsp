<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/23
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.0/weui.css">
    <title>三方协议数量</title>
</head>
<body>
<br><br><br>
        <div class="weui-form-preview">
            <div class="weui-form-preview__hd">
                <div class="weui-form-preview__item">
                    <label class="weui-form-preview__label">${collegename} 共发放协议${count}份</label><br>
                </div>
            </div>
        </div>
<br><br><br>
    <a href="${pageContext.request.contextPath}/WEUI/college_select.jsp" class="weui-btn weui-btn_primary">返回上一页</a>

</body>
</html>
