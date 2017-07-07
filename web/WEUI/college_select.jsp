<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/23
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>查看三方协议发放数量</title>

    <link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.0/weui.css">
</head>
<body>
<div class="weui-cells__title">选择你想查看的学院</div>

<form method="post" name="number">
    <div class="weui-cells weui-cells_radio">
        <label class="weui-cell weui-check_label" for="0">
            <div class="weui-cell_bd">
                <p>查看全部</p>
            </div>
            <div class="weui-cell_ft">
                <input type="radio" class="weui-check" name="collegeid" value="0" id="0">
                <span class="weui-icon-checked"></span>
            </div>
        </label>
        <label class="weui-cell weui-check_label" for="1">
            <div class="weui-cell_bd">
                <p>体艺学院</p>
            </div>
            <div class="weui-cell_ft">
                <input type="radio" class="weui-check" name="collegeid" value="1" id="1">
                <span class="weui-icon-checked"></span>
            </div>
        </label>
        <label class="weui-cell weui-check_label" for="2">
            <div class="weui-cell_bd">
                <p>国交学院</p>
            </div>
            <div class="weui-cell_ft">
                <input type="radio" class="weui-check" name="collegeid" value="2" id="2">
                <span class="weui-icon-checked"></span>
            </div>
        </label>
        <label class="weui-cell weui-check_label" for="3">
            <div class="weui-cell_bd">
                <p>化学院</p>
            </div>
            <div class="weui-cell_ft">
                <input type="radio" class="weui-check" name="collegeid" value="3" id="3">
                <span class="weui-icon-checked"></span>
            </div>
        </label>
        <label class="weui-cell weui-check_label" for="4">
            <div class="weui-cell_bd">
                <p>信息学院</p>
            </div>
            <div class="weui-cell_ft">
                <input type="radio" class="weui-check" name="collegeid" value="4" id="4">
                <span class="weui-icon-checked"></span>
            </div>
        </label>
        <label class="weui-cell weui-check_label" for="5">
            <div class="weui-cell_bd">
                <p>水土学院</p>
            </div>
            <div class="weui-cell_ft">
                <input type="radio" class="weui-check" name="collegeid" value="5" id="5">
                <span class="weui-icon-checked"></span>
            </div>
        </label>
        <label class="weui-cell weui-check_label" for="6">
            <div class="weui-cell_bd">
                <p>文法学院</p>
            </div>
            <div class="weui-cell_ft">
                <input type="radio" class="weui-check" name="collegeid" value="6" id="6">
                <span class="weui-icon-checked"></span>
            </div>
        </label>
        <label class="weui-cell weui-check_label" for="7">
            <div class="weui-cell_bd">
                <p>外语学院</p>
            </div>
            <div class="weui-cell_ft">
                <input type="radio" class="weui-check" name="collegeid" value="7" id="7">
                <span class="weui-icon-checked"></span>
            </div>
        </label>
        <label class="weui-cell weui-check_label" for="8">
            <div class="weui-cell_bd">
                <p>生科学院</p>
            </div>
            <div class="weui-cell_ft">
                <input type="radio" class="weui-check" name="collegeid" value="8" id="8">
                <span class="weui-icon-checked"></span>
            </div>
        </label>
        <label class="weui-cell weui-check_label" for="9">
            <div class="weui-cell_bd">
                <p>食科学院</p>
            </div>
            <div class="weui-cell_ft">
                <input type="radio" class="weui-check" name="collegeid" value="9" id="9">
                <span class="weui-icon-checked"></span>
            </div>
        </label>
        <label class="weui-cell weui-check_label" for="10">
            <div class="weui-cell_bd">
                <p>经管学院</p>
            </div>
            <div class="weui-cell_ft">
                <input type="radio" class="weui-check" name="collegeid" value="10" id="10">
                <span class="weui-icon-checked"></span>
            </div>
        </label>
        <label class="weui-cell weui-check_label" for="11">
            <div class="weui-cell_bd">
                <p>机电学院</p>
            </div>
            <div class="weui-cell_ft">
                <input type="radio" class="weui-check" name="collegeid" value="11" id="11">
                <span class="weui-icon-checked"></span>
            </div>
        </label>
        <label class="weui-cell weui-check_label" for="12">
            <div class="weui-cell_bd">
                <p>动科学院</p>
            </div>
            <div class="weui-cell_ft">
                <input type="radio" class="weui-check" name="collegeid" value="12" id="12">
                <span class="weui-icon-checked"></span>
            </div>
        </label>
        <label class="weui-cell weui-check_label" for="13">
            <div class="weui-cell_bd">
                <p>园艺学院</p>
            </div>
            <div class="weui-cell_ft">
                <input type="radio" class="weui-check" name="collegeid" value="13" id="13">
                <span class="weui-icon-checked"></span>
            </div>
        </label>
        <label class="weui-cell weui-check_label" for="14">
            <div class="weui-cell_bd">
                <p>林学院</p>
            </div>
            <div class="weui-cell_ft">
                <input type="radio" class="weui-check" name="collegeid" value="14" id="14">
                <span class="weui-icon-checked"></span>
            </div>
        </label>
        <label class="weui-cell weui-check_label" for="15">
            <div class="weui-cell_bd">
                <p>资环学院</p>
            </div>
            <div class="weui-cell_ft">
                <input type="radio" class="weui-check" name="collegeid" value="15" id="15">
                <span class="weui-icon-checked"></span>
            </div>
        </label>
        <label class="weui-cell weui-check_label" for="16">
            <div class="weui-cell_bd">
                <p>植保学院</p>
            </div>
            <div class="weui-cell_ft">
                <input type="radio" class="weui-check" name="collegeid" value="16" id="16">
                <span class="weui-icon-checked"></span>
            </div>
        </label>
        <label class="weui-cell weui-check_label" for="17">
            <div class="weui-cell_bd">
                <p>农学院</p>
            </div>
            <div class="weui-cell_ft">
                <input type="radio" class="weui-check" name="collegeid" value="17" id="17">
                <span class="weui-icon-checked"></span>
            </div>
        </label>
        <br>
        <a href="javascript:document.number.action='${pageContext.request.contextPath}/navigation/navigation_checkSanfangxieyi';document.number.submit();" class="weui-btn weui-btn_primary">提交</a>
    </div>
</form>
</body>
</html>
