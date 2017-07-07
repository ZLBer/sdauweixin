<%--
  Created by IntelliJ IDEA.
  User: hello world
  Date: 2017/4/22
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
<head>
    <style>
        textarea
        {
            resize: none;
            width: 40%;
            height: 30%;
            bored-color:blue;
        }
    </style>
    <script type="text/javascript">
        // 最小高度
        var minHeight = 100;
        // 最大高度，超过则出现滚动条
        var maxHeight = 300;
        function ResizeTextarea(){
            var t = document.getElementById('txtContent');
            h = t.scrollHeight;
            h = h > minHeight ? h : minHeight;
            h = h > maxHeight ? maxHeight : h;
            t.style.height = h + "px";
        }
        function ResizeTextareatext(){
            var t = document.getElementById('txtContent1');
            h = t.scrollHeight;
            h = h > minHeight ? h : minHeight;
            h = h > maxHeight ? maxHeight : h;
            t.style.height = h + "px";
        }
        function showdiv()
        {
            document.getElementById('show').style.display= document.getElementById('show').style.display=="none"?"block":"none";

        }
    </script>
</head>
<body>
<div style="margin:20px 0;"></div>

<div>
    <div class="weui-cell">
        <div class="weui=cell__bd">
            <label class="weui_label">回复时间 ：<span>${problemEntity.replytime}</span></label>
        </div>
    </div>


</div>

<div>
    <span></span>
</div>

<div>
    <div class="weui-cell">
        <div class="weui=cell__bd">
            <label class="weui_label">回复内容 :${problemEntity.replytext}</label>
        </div>
    </div>


</div>

</div>

</body>
</html>