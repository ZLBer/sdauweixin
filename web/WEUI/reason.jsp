<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>填写申请三方协议原因</title>
    <link rel="stylesheet" href="../style/weui.css"/>
    <link rel="stylesheet" href="./example.css"/>
	<link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.0/weui.css">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">	
</head>
<body ontouchstart>
	<script type="text/javascript" src="https://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
    <script src="https://res.wx.qq.com/open/libs/weuijs/1.0.0/weui.min.js"></script>
	<script language="javascript"> 
	function countChar(status,counter) 
	{ 
		document.getElementById(counter).innerHTML = 100 - document.getElementById(status).value.length; 
	} 
	</script> 
    <div class="weui-cells weui-cells_form">
		<form method="post" name="nofinish">
			<div class="weui-cells__title">填写申请三方协议原因：</div>
			<div class="weui-cell">
				<div class="weui-cell__bd">
					<textarea class="weui-textarea" placeholder="请输入" id="status" rows="15" name="other" onkeydown='countChar("status","counter");' onkeyup='countChar("status","counter");'maxlength="100" onchange="this.value=this.value.substring(0, 100)" onkeydown="this.value=this.value.substring(0, 100)" onkeyup="this.value=this.value.substring(0, 20)" ></textarea>
					<div class="weui-textarea-counter">还可以输入<span id="counter">100</span>字</div>
				</div>
			</div>
		</form>
	 <a href="javascript:document.nofinish.action='${pageContext.request.contextPath}/student/student_secondSanfangxieyi';document.nofinish.submit();" class="weui-btn weui-btn_primary">提交</a>
	</div>
    
</body>
</html>