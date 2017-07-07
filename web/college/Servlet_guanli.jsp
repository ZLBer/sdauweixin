<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: hello world
  Date: 2017/4/20
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>学院问题管理</title>
	<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
	<link rel="stylesheet" type="text/css" href="/css/IconExtension.css">
	<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
	<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
	<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
	<style>
		body{
			/*text-align: center;*/
			font-family:Arial,Helvetica,sans-serif;font-size:100%;
			line-height:1em;color:#4e4e4e;
			min-width:80%;
		}
		textarea
		{
			width: 80%;
			height: 300px;
			resize: none;
			border-radius: 40px;
			border: 2px;
			border-color: #211118;

		}
		th
		{
			resize: none;
		}
		td{
			margin:0px;
			border:0px;
			/*cellspacing=0;
            cellpadding=0;*/
			height:40px;
		}
		table{
			border-collapse:collapse;
			margin:0 auto;
			border-radius:15px;
			overflow:hidden;
			background:#E0ECFF;
		}
		#submit
		{
			float:right;
		}
		div{
			padding-right:200px;
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
	</script>
	<script type="text/javascript" src="ckeditor/ckeditor.js"></script>

</head>
<body>
<div style="margin:20px 0; padding-right:200px"></div>
<form id="ff" method="post" action="servlet_guanli?problemid=${problemid}">
	<div style="margin-bottom:20px">
		<p>学号 ：${studentid} </p>
	</div>
	<div style="margin-bottom:20px">
		<p>提问时间 ：${problemtime} </p>
	</div>
	<div >
		<p>  问题描述：</p>   <br>
		<p>${problemtext}</p>
	</div>
	<div style="margin-bottom:20px">
		<p> 回复:</p>
		<input class="easyui-textbox" name="replytext"  data-options="multiline:true" style="height:200px;width:800px"onpropertychange="ResizeTextarea()" oninput="ResizeTextarea()" onkeyup="ResizeTextarea()">
		</input>
</form>
</div>

</body>
</html>

