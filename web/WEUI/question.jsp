<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>提交问题</title>
	<link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.0/weui.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
</head>
<body ontouchstart>
<script language="javascript">

    function countChar(status,counter)
    {
        document.getElementById(counter).innerHTML = 100 - document.getElementById(status).value.length;
    }

    function filteremoji(){
        var ranges = [
            '\ud83c[\udf00-\udfff]',
            '\ud83d[\udc00-\ude4f]',
            '\ud83d[\ude80-\udeff]'
        ];
        var emojireg = $("#status").val();
        emojireg = emojireg .replace(new RegExp(ranges.join('|'), 'g'), '');
        $("#status").val(emojireg);
    }
</script>
    <div class="weui-cells weui-cells_form">
	    <div class="weui-cells__title">请选择您要提问的老师：</div>
        <form method="post" name="filter">
            <%int i=1;%>
            <c:forEach var="row" items="${teacherNames}">
                <div class="weui-cells weui-cells_radio">
                    <label class="weui-cell weui-check_label" for="<%=i%>">
                        <div class="weui-cell_bd">
                            <p>${row}</p>
                        </div>
                        <div class="weui-cell_ft">
                            <input type="radio" class="weui-check" name="teacherName" value="${row}" id="<%=i%>">
                            <span class="weui-icon-checked"></span>
                        </div>
                        <%++i;%>
                    </label>
                </div>
            </c:forEach>
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <textarea class="weui-textarea" placeholder="请输入您的问题" id="status" rows="15" name="problemtext" onkeydown='countChar("status","counter");' onkeyup='countChar("status","counter");'maxlength="100" onchange="this.value=this.value.substring(0, 100)" onkeydown="this.value=this.value.substring(0, 100)" onkeyup="this.value=this.value.substring(0, 20)" ></textarea>
                    <div class="weui-textarea-counter">还可以输入<span id="counter">100</span>字</div>
                </div>
            </div>
            <a href="javascript:document.filter.action='${pageContext.request.contextPath}/student/servlet_tijiao';filteremoji();document.filter.submit();" class="weui-btn weui-btn_primary">提交</a>
        </form>
    </div>
    <script type="text/javascript" src="https://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
    <script src="https://res.wx.qq.com/open/libs/weuijs/1.0.0/weui.min.js"></script>
</body>
</html>
