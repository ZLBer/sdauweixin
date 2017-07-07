<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
 
<html>
  <head>
    <title>修改信息</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    
    <link rel="stylesheet" href="css/weui.css"/>
    <link rel="stylesheet" href="css/example.css"/>
	<link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.0/weui.css">

  </head>
  
  <body ontouchstart> 
<div style="position:relative;top:50px;">  
    <form method="post" name="student">	
	    <div class="weui-cells__title">当前信息</div><hr>
		    <div class="weui-cell">
			    <div class="weui=cell__bd">
				   <label class="weui_label">学号 :&nbsp;&nbsp;&nbsp;&nbsp;<%=request.getAttribute("xuehao") %></label>
				</div> 
			</div>
			<div class="weui-cell">
			    <div class="weui=cell__bd">
				   <label class="weui_label">姓名:&nbsp;&nbsp;&nbsp;&nbsp;<%=request.getAttribute("name") %></label>
				</div> 
			</div>
			<div class="weui-cell">
			    <div class="weui=cell__bd">
				   <label class="weui_label">手机号:&nbsp;&nbsp;&nbsp;<%=request.getAttribute("mobile") %></label>
				</div> 
			</div> <hr><br>
		
		<div class="weui-cells__title">修改信息</div>
	<div class="weui-cells weui-cells_form"><hr>
		<div class="weui-cell">
			<div class="weui-cell__bd">
				<label class="weui_label">新手机号:</label>
			</div>
			<div class="weui-cell__bd weui_cell_primary">
					<input class="weui-input" type="number" name="newtel" pattern="[0-9]*" placeholder="在此输入手机号"/>
			</div>
		</div><hr>
		<div class="weui-cells__tips">请务必输入正确手机号，且该手机号必须绑定于你的微信上！</div>
	    <br>
		<a href="javascript:document.student.action='alterInfoServlet';document.student.submit();" class="weui-btn weui-btn_primary">修改</a>
    </div>
	</form>
	
</div>
  </body>
</html>