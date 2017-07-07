<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 2017/5/16 0016
  Time: 下午 8:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>回复问题</title>
    <link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.0/weui.css">
    <script language="javascript">
        function countChar(status,counter)
        {
            document.getElementById(counter).innerHTML = 100 - document.getElementById(status).value.length;
        }
    </script>
</head>
<body>
    <form id="ff" method="post" name="reply">
        <label class="weui_label">
            <p>学生学号 ：${studentid} </p>
        </label>
        <label class="weui_label">
            <p>提问时间 ：${problemtime} </p>
        </label>
        <div>
            <p>  问题描述：</p>
            <p>&nbsp;&nbsp;&nbsp;${problemtext}</p>
        </div>

        <div class="weui-cells weui-cells_form">
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <textarea class="weui-textarea" placeholder="请输入您的回复" id="status" rows="15" name="replytext" onkeydown='countChar("status","counter");' onkeyup='countChar("status","counter");'maxlength="100" onchange="this.value=this.value.substring(0, 100)" onkeydown="this.value=this.value.substring(0, 100)" onkeyup="this.value=this.value.substring(0, 20)" ></textarea>
                     <div class="weui-textarea-counter">还可以输入<span id="counter">100</span>字</div>
                </div>
            </div>
            <a href="javascript:document.reply.action='servlet_guanli?problemid=${problemid}';document.reply.submit();" class="weui-btn weui-btn_primary">回复</a>
        </div>
    </form>
</body>
</html>
