<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <link rel="stylesheet" href="path/to/weui/dist/style/weui.min.css"/>
    <link rel="stylesheet" href="./example.css"/>
	<link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.0/weui.css">
	<link rel="stylesheet" href="https://cdn.bootcss.com/jquery/3.2.1/core.js">
	<link rel="stylesheet" href="https://cdn.bootcss.com/jquery/3.2.1/jquery.js">
	<link rel="stylesheet" href="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
</head>
<body ontouchstart>
   <br><br>
   <form method="post" name="updateqiye">
	   <div class="weui-toptips weui-toptips_warn js_tooltips">更改企业</div>
	   <div class="weui-cells__title">当前信息</div>
	   <hr>
       <div class="weui-cell">
		   <div class="weui=cell__bd">
			   <label class="weui_label">联系人姓名：<%=request.getAttribute("name") %></label>
		   </div>
	   </div>
	   <div class="weui-cell">
			<div class="weui=cell__bd">
				<label class="weui_label">联系人电话：<%=request.getAttribute("mobile") %></label>
			</div>
	   </div>
	   <hr><br>
		<div class="weui-cells__title">修改信息</div>
		<div class="weui-cells weui-cells_form"><hr>
		
		<div class="weui-cell">
			<div class="weui-cell__bd">
				<label class="weui_label">修改电话：</label>
			</div>
			<div class="weui-cell__bd weui_cell_primary">
					<input class="weui-input" type="number"  name="newtel" pattern="[0-9]*"  placeholder="在此输入电话"/>
			</div>
		</div><hr>
		<div class="weui-cells__tips">请务必输入正确电话号</div>
	    <br>
		<a href="javascript:document.updateqiye.action='updateqiye';document.updateqiye.submit();" class="weui-btn weui-btn_primary">修改</a>
    </div>
 	 </div>

	</div>
   </form>
</body>
</html>
