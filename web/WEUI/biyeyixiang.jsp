<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>毕业意向</title>
    
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>提交毕业意向</title>
    <link rel="stylesheet" href="../style/weui.css"/>
    <link rel="stylesheet" href="./example.css"/>
	<link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.0/weui.css">
  </head>
  
  <body>
    <br><br><br>
    <div class="weui-cells__title">毕业想干啥,点击选择！</div>

	<form method="post" name="biye">
		<div class="weui-cells weui-cells_radio">
			<label class="weui-cell weui-check_label" for="1">
				<div class="weui-cell_bd">
					<p>准备就业</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" class="weui-check" name="radio1" value="1" id="1">
						<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="2">
				<div class="weui-cell_bd">
					<p>考取研究生</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" class="weui-check" name="radio1" value="2" id="2">
						<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="3">
				<div class="weui-cell_bd">
					<p>考取公务员</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" class="weui-check" name="radio1" value="3" id="3">
						<span class="weui-icon-checked"></span>
				</div>
			</label>
			<br>
			<a href="javascript:document.biye.action='alterTagServlet';document.biye.submit();" class="weui-btn weui-btn_primary">提交</a>
		</div>
	</form>

</body>
</html>
