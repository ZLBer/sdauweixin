<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 2017/5/25 0025
  Time: 下午 5:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用章预约</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.0/weui.css">
</head>
<body ontouchstart>
<br><br>
<form method="post" name="yongzhang">
    <div class="weui-cell">
        <div class="weui=cell__bd">
            <label class="weui_label">你的学号: <%=session.getAttribute("userid")%></label>
        </div>
    </div>
    <br><br>
    <div class="weui-cells__title">点击选择盖章用途：</div>
    <div class="weui-cells weui-cells_radio">
        <label class="weui-cell weui-check_label" for="t1">
            <div class="weui-cell_bd">
                <p>三支一扶</p>
            </div>
            <div class="weui-cell_ft">
                <input type="radio" class="weui-check" name="function" id="t1" value="三支一扶">
                <span class="weui-icon-checked"></span>
            </div>
        </label>
        <label class="weui-cell weui-check_label" for="t2">
            <div class="weui-cell_bd">
                <p>就业协议书</p>
            </div>
            <div class="weui-cell_ft">
                <input type="radio" class="weui-check" name="function" id="t2" value="就业协议书">
                <span class="weui-icon-checked"></span>
            </div>
        </label>
        <label class="weui-cell weui-check_label" for="t3">
            <div class="weui-cell_bd">
                <p>就业推荐表</p>
            </div>
            <div class="weui-cell_ft">
                <input type="radio" class="weui-check" name="function" id="t3" value="就业推荐表">
                <span class="weui-icon-checked"></span>
            </div>
        </label>
        <label class="weui-cell weui-check_label" for="t4">
            <div class="weui-cell_bd">
                <p>选调生/基层就业</p>
            </div>
            <div class="weui-cell_ft">
                <input type="radio" class="weui-check" name="function" id="t4" value="选调生/基层就业">
                <span class="weui-icon-checked"></span>
            </div>
        </label>
        <label class="weui-cell weui-check_label" for="t5">
            <div class="weui-cell_bd">
                <p>银行推荐表</p>
            </div>
            <div class="weui-cell_ft">
                <input type="radio" class="weui-check" name="function" id="t5" value="银行推荐表">
                <span class="weui-icon-checked"></span>
            </div>
        </label>
        <label class="weui-cell weui-check_label" for="t6">
            <div class="weui-cell_bd">
                <p>其他</p>
            </div>
            <div class="weui-cell_ft">
                <input type="radio" class="weui-check" name="function" id="t6" value="其他">
                <span class="weui-icon-checked"></span>
            </div>
        </label>


    </div>
    <a href="javascript:document.yongzhang.action='${pageContext.request.contextPath}/student/makeStamp';document.yongzhang.submit();" class="weui-btn weui-btn_primary">申请</a>
</form>
</body>
</html>
