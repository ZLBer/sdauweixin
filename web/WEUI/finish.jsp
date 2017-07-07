<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
	<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
	<link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.0/weui.css">
	
	<script src="js/zepto.min.js"></script>  
	
	
</head>
<body ontouchstart>
   <br><br>
   <form method="post" name="sanfang">
		<div class="weui-toptips weui-toptips_warn js_tooltips">提交第三方协议申请</div>
		<div class="weui-cells__title">填写欲签约企业的信息</div>
		
		<div class="weui-cells weui-cells_form">
			<div class="weui-cell">
				<div class="weui-cell__bd">
					<label class="weui_label">单位名称：</label>
				</div>
				<div class="weui-cell__bd weui_cell_primary">
					<input class="weui-input" type="text"  name="comname" placeholder="在此输入单位名称" required/>
				</div>
			</div>
			<div class="weui-cell">
				<div class="weui-cell__bd">
					<label class="weui_label">企业机构代码：</label>
				</div>
				<div class="weui-cell__bd weui_cell_primary">
					<input class="weui-input" type="text"  name="comnumber" placeholder="在此输入企业机构代码"/>
				</div>
			</div>
			<div class="weui-cell">
				<div class="weui-cell__bd">
					<label class="weui_label">通讯地址：</label>
				</div>
				<div class="weui-cell__bd weui_cell_primary">
					<input class="weui-input" type="text"  name="comadress"  placeholder="在此输入通讯地址"/>
				</div>
			</div>
			<div class="weui-cell">
				<div class="weui-cell__bd">
					<label class="weui_label">邮政编码：</label>
				</div>
				<div class="weui-cell__bd weui_cell_primary">
					<input class="weui-input" type="number"  name="comzipcode"   placeholder="在此输入邮政编码"/>
				</div>
			</div>
			<div class="weui-cell">
				<div class="weui-cell__bd">
					<label class="weui_label">联系人：</label>
				</div>
				<div class="weui-cell__bd weui_cell_primary">
					<input class="weui-input" type="text"  name="comcontact" placeholder="在此输入联系人"/>
				</div>
			</div>
			<div class="weui-cell">
				<div class="weui-cell__bd">
					<label class="weui_label">联系人电话：</label>
				</div>
				<div class="weui-cell__bd weui_cell_primary">
					<input class="weui-input" type="number"  name="comtel" pattern="[0-9]{11}$"  placeholder="在此输入电话"/>
				</div>
			</div>
			<div class="weui-cell">
				<div class="weui-cell__bd">
					<label class="weui_label">邮箱：</label>
				</div>
				<div class="weui-cell__bd weui_cell_primary">
					<input class="weui-input" type="text"  name="commail" placeholder="在此输入邮箱"/>
				</div>
			</div>
		</div>
		<!--选择企业性质-->
		<div class="weui-cells__title">请选择单位性质：</div>
		<div class="weui-cells weui-cells_radio">
			<label class="weui-cell weui-check_label" for="t1">
				<div class="weui-cell_bd">
					<p>党政机关</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" class="weui-check" name="comnature" id="t1" value="党政机关">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="t2">
				<div class="weui-cell_bd">
					<p>科研事业单位</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" name="comnature" class="weui-check" id="t2" value="科研事业单位">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="t3">
				<div class="weui-cell_bd">
					<p>学校</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" class="weui-check" name="comnature" id="t3" value="学校">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="t4">
				<div class="weui-cell_bd">
					<p>商贸公司</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" name="comnature" class="weui-check" id="t4" value="商贸公司">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="t5">
				<div class="weui-cell_bd">
					<p>厂矿企业</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" class="weui-check" name="comnature" id="t5" value="厂矿企业">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="t6">
				<div class="weui-cell_bd">
					<p>部队</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" name="comnature" class="weui-check" id="t6" value="部队">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="t7">
				<div class="weui-cell_bd">
					<p>其他</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" name="comnature" class="weui-check" id="t7" value="其他">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
		</div>
			<!--选择单位行业-->
			<div class="weui-cells__title">请选择单位行业：</div>
		<div class="weui-cells weui-cells_radio">
			<label class="weui-cell weui-check_label" for="h1">
				<div class="weui-cell_bd">
					<p>农、林、牧、副、渔业</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" class="weui-check" name="industry" id="h1" value="农、林、牧、副、渔业">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="h2">
				<div class="weui-cell_bd">
					<p>采矿业</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" name="industry" class="weui-check" id="h2" value="采矿业">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="h3">
				<div class="weui-cell_bd">
					<p>电力、热力、燃气及水生产和供应业</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" class="weui-check" name="industry" id="h3" value="电力、热力、燃气及水生产和供应业">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="h4">
				<div class="weui-cell_bd">
					<p>批发和零售业</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" name="industry" class="weui-check" id="h4" value="批发和零售业">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="h5">
				<div class="weui-cell_bd">
					<p>交通运输、仓储和邮政业</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" class="weui-check" name="industry" id="h5" value="交通运输、仓储和邮政业">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="h6">
				<div class="weui-cell_bd">
					<p>住宿和餐饮业</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" name="industry" class="weui-check" id="h6" value="住宿和餐饮业">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="h7">
				<div class="weui-cell_bd">
					<p>信息传输、软件和信息技术服务业</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" name="industry" class="weui-check" id="h7" value="信息传输、软件和信息技术服务业">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="h8">
				<div class="weui-cell_bd">
					<p>金融业</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" name="industry" class="weui-check" id="h8" value="金融业">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="h9">
				<div class="weui-cell_bd">
					<p>房地产业</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio"name="industry" class="weui-check" id="h9" value="房地产业">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="h10">
				<div class="weui-cell_bd">
					<p>租赁和商务服务业</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" name="industry" class="weui-check" id="h10" value="租赁和商务服务业">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="h11">
				<div class="weui-cell_bd">
					<p>科学研究和技术服务业</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" name="industry" class="weui-check" id="h11" value="科学研究和技术服务业">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="h12">
				<div class="weui-cell_bd">
					<p>水利、环境和公共设施管理业</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" name="industry" class="weui-check" id="h12" value="水利、环境和公共设施管理业">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="h13">
				<div class="weui-cell_bd">
					<p>居民服务、修理和其他服务业</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" name="industry" class="weui-check" id="h13" value="居民服务、修理和其他服务业">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="h14">
				<div class="weui-cell_bd">
					<p>教育</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" name="industry" class="weui-check" id="h14" value="教育">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="h15">
				<div class="weui-cell_bd">
					<p>卫生和社会工作</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" name="industry" class="weui-check" id="h15" value="卫生和社会工作">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="h16">
				<div class="weui-cell_bd">
					<p>文化、体育和服务业</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" name="industry" class="weui-check" id="h16" value="文化、体育和服务业">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="h17">
				<div class="weui-cell_bd">
					<p>公共管理、社会保障和社会组织</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" name="industry" class="weui-check" id="h17" value="公共管理、社会保障和社会组织">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="h18">
				<div class="weui-cell_bd">
					<p>国际组织</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" name="industry" class="weui-check" id="h18" value="国际组织">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="h19">
				<div class="weui-cell_bd">
					<p>军队</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" name="industry" class="weui-check" id="h19" value="军队">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			
			<!--选择工作职业类别-->
			<div class="weui-cells__title">请选择工作职业类别：</div>
		<div class="weui-cells weui-cells_radio">
			<label class="weui-cell weui-check_label" for="l1">
				<div class="weui-cell_bd">
					<p>公务员</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" class="weui-check" name="category" id="l1" value="公务员">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="l2">
				<div class="weui-cell_bd">
					<p>科学研究人员</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" name="category" class="weui-check" id="l2" value="科学研究人员">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="l3">
				<div class="weui-cell_bd">
					<p>>工程技术人员</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" class="weui-check" name="category" id="l3" value="工程技术人员">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="l4">
				<div class="weui-cell_bd">
					<p>农林牧副渔业技术人员</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio"name="category" class="weui-check" id="l4" value="农林牧副渔业技术人员">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="l5">
				<div class="weui-cell_bd">
					<p>卫生专业技术人员</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" class="weui-check" name="category" id="l5" value="卫生专业技术人员">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="l6">
				<div class="weui-cell_bd">
					<p>经济业务人员</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" name="category" class="weui-check" id="l6" value="经济业务人员">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="l7">
				<div class="weui-cell_bd">
					<p>金融业务人员</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" name="category" class="weui-check" id="l7" value="金融业务人员">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="l8">
				<div class="weui-cell_bd">
					<p>法律专业人员</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" name="category" class="weui-check" id="l8" value="法律专业人员">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="l9">
				<div class="weui-cell_bd">
					<p>教学人员</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" name="category" class="weui-check" id="l9" value="教学人员">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="l10">
				<div class="weui-cell_bd">
					<p>文学艺术工作人员</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" name="category" class="weui-check" id="l10" value="文学艺术工作人员">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="l11">
				<div class="weui-cell_bd">
					<p>体育工作人员</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" name="category" class="weui-check" id="l11" value="体育工作人员">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="l12">
				<div class="weui-cell_bd">
					<p>新闻出版和文化工作人员</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" name="category" class="weui-check" id="l12" value="新闻出版和文化工作人员">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="l13">
				<div class="weui-cell_bd">
					<p>其他专业技术人员</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" name="category" class="weui-check" id="l13" value="其他专业技术人员">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="l14">
				<div class="weui-cell_bd">
					<p>办事人员和有关人员</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" name="category" class="weui-check" id="l14" value="办事人员和有关人员">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="l15">
				<div class="weui-cell_bd">
					<p>商业和服务业人员</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" name="category" class="weui-check" id="l15" value="商业和服务业人员">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="l16">
				<div class="weui-cell_bd">
					<p>生产和运输设备操作人员</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" name="category" class="weui-check" id="l16" value="生产和运输设备操作人员">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="l17">
				<div class="weui-cell_bd">
					<p>军人</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" name="category" class="weui-check" id="l17" value="军人">
					<span class="weui-icon-checked"></span>
				</div>
			</label>
			<label class="weui-cell weui-check_label" for="l18">
				<div class="weui-cell_bd">
					<p>其他人员</p>
				</div>
				<div class="weui-cell_ft">
					<input type="radio" name="category" class="weui-check" id="l18" value="其他人员">
					<span class="weui-icon-checked"></span>
				</div>
			</label>							
			<!--填写档案转寄地址-->
			<div class="weui-cell">
				<div class="weui-cell__bd">
					<label class="weui_label">输入信息：</label>
				</div>
				<div class="weui-cell__bd weui_cell_primary">
					<input class="weui-input" type="text"  name="danganaddress" placeholder="档案转寄详细地址"/>
				</div>
			</div>		

		</div>
 	 </div>
	   <a href="javascript:document.sanfang.action='${pageContext.request.contextPath}/student/student_requestSanfangxieyi';document.sanfang.submit();" class="weui-btn weui-btn_primary">提交信息</a>
  </form>



	<script src="js/example.js"></script>
	<script type="text/javascript" src="https://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>  
	<script src="https://res.wx.qq.com/open/libs/weuijs/1.0.0/weui.min.js"></script>
</body>
</html>
