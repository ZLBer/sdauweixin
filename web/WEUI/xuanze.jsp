<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
 
<html>
<head>
    <title>三方协议</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">  
    <link rel="stylesheet" href="css/weui.css"/>
    <link rel="stylesheet" href="css/example.css"/>
	<link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.0/weui.css">
</head>
  
<body ontouchstart> 
<div style="position:relative;top:50px;">  
    <form method="post" name="student">	
		<div><h3>三方协议选择,只能申请一次！</h3></div><hr>
		<div class="weui-cells">
			<div class="weui-cell">
				<div class="weui-cell__bd">
					<p>您是否有欲签约企业（请谨慎点击选择）</p>
				</div>
				
				<div class="weui-cell__ft"></div>
				</div>
			</div>
			<br><br><br>
			<div class="weui-cells">
				<a class="weui-cell weui-cell_access" href="${pageContext.request.contextPath}/WEUI/finish.jsp">
					<div class="weui-cell__bd">
						<p>是（选择该选项将不能在省内就业）</p>
					</div>
					<div class="weui-cell__ft"></div>
				</a>
				<a class="weui-cell weui-cell_access" href="${pageContext.request.contextPath}/WEUI/reason.jsp">
					<div class="weui-cell__bd">
						<p>否（选择该选项需要填写申请原因）</p>
					</div>
					<div class="weui-cell__ft"></div>
				</a>
			</div>
		</div>
	</form>
	
</div>
</body>
</html>