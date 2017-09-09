<%--
  Created by IntelliJ IDEA.
  User: libin
  Date: 2017/5/5
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="/css/IconExtension.css">
	<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
	<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
	<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<style>
 tr,td:nth-child(1){
            text-align: left;
			/*font-family:楷体;*/
        }
		 tr,th:nth-child(1){
            text-align: left;
			/*font-family:楷体;*/
        }
		td{
			 margin:0px;
			 border:0px;
			 /*cellspacing=0;
			 cellpadding=0;*/
			 height:40px;
			 }
table{
			border-radius:15px;
			overflow:hidden;
			background:#E0ECFF;
			}；
</style>
<script>
    function submitForm(){
        $('#ff').form('submit');
    }

</script>
<head>
    <title>Title</title>
</head>
<body>
<div style="padding-right:200px">
<form action="student_requestSanfangxieyi?studentid=${user.studentid}" method="post" id="ff">
	<table align="center" frame="void">
        <tr>
            <td style="padding-left: 40px"><font color="red"> *</font>单位名称</td>   <td style="padding-right: 40px"><input type="text" name="comname" class="easyui-textbox" style="width: 200px;height: 25px;" data-options="required:true"></td>
        </tr>
        <tr>
            <td style="padding-left: 40px"><font color="red"> *</font>组织机构代码</td> <td><input type="text" name="comnumber" class="easyui-textbox" style="width: 200px;height: 25px;" data-options="required:true"></td>
        </tr>
        <tr>
            <td style="padding-left: 40px"><font color="red"> *</font>通讯地址</td> <td><input type="text" name="comadress" class="easyui-textbox" style="width: 200px;height: 25px;" data-options="required:true"></td>
        </tr>
        <tr>
            <td style="padding-left: 40px"><font color="red"> *</font>邮政编码</td> <td><input type="text" name="comzipcode" class="easyui-textbox" style="width: 200px;height: 25px;" data-options="required:true"></td>
        </tr>
        <tr>
            <td style="padding-left: 40px"><font color="red"> *</font>联系人</td> <td><input type="text" name="comcontact" class="easyui-textbox" style="width: 200px;height: 25px;" data-options="required:true"></td>
        </tr>
        <tr>
            <td style="padding-left: 40px"><font color="red"> *</font>联系电话</td> <td><input type="text" name="comtel" class="easyui-textbox" style="width: 200px;height: 25px;" data-options="required:true"></td>
        </tr>
        <tr>
            <td style="padding-left: 40px"><font color="red"> *</font>邮箱</td> <td><input type="text" name="commail" class="easyui-textbox" style="width: 200px;height: 25px;" data-options="required:true"></td>
        </tr>
       <!-- <tr>
            <td style="padding-left: 40px"><font color="red"> *</font>单位性质</td>
            <td style="padding-right: 40px"><input type="radio" name="comnature"  value="党政机关">党政机关
						  <input type="radio" name="comnature" value="科研事业单位">科研事业单位
						  <input type="radio" name="comnature" value="学校">学校<br>
                        <input type="radio" name="comnature" value="商贸公司">商贸公司
                        <input type="radio" name="comnature" value="厂矿企业">厂矿企业
                        <input type="radio" name="comnature" value="部队">部队
                        <input type="radio" name="" value="其他">其他
        </td>
        </tr>-->
        <tr>
            <td style="padding-left: 40px"><font color="red"> *</font>单位性质</td>
            <td>
                <select name="comnature" class="easyui-combobox" style="width: 200px;height: 25px;" data-options="required:true">
                    <option value="党政机关">党政机关</option>
                    <option value="科研事业单位">科研事业单位</option>
                    <option value="学校">学校</option>
                    <option value="商贸公司">商贸公司</option>
                    <option value="厂矿企业">厂矿企业</option>
                    <option value="部队">部队</option>
                    <option value="其他">其他</option>
            </td>

            </td>
        </tr>

        <tr>
         <td style="padding-left: 40px"><font color="red"> *</font>单位行业</td>

        <td><select name="industry" class="easyui-combobox" style="width: 200px;height: 25px;" data-options="required:true">
            <option value="农、林、牧、副、渔业">农、林、牧、副、渔业</option>
            <option value="采矿业">采矿业</option>
            <option value="采矿业">采矿业</option>
            <option value="电力、热力、燃气及水生产和供应业">电力、热力、燃气及水生产和供应业</option>
            <option value="建筑业">建筑业</option>
            <option value="批发和零售业">批发和零售业</option>
            <option value="交通运输、仓储和邮政业">交通运输、仓储和邮政业</option>
            <option value="住宿和餐饮业">住宿和餐饮业</option>
            <option value="信息传输、软件和信息技术服务业">信息传输、软件和信息技术服务业</option>
            <option value="金融业">金融业</option>
            <option value="房地产业">房地产业</option>
            <option value="租赁和商务服务业">租赁和商务服务业</option>
            <option value="科学研究和技术服务业">科学研究和技术服务业</option>
            <option value="水利、环境和公共设施管理业">水利、环境和公共设施管理业</option>
            <option value="居民服务、修理和其他服务业">居民服务、修理和其他服务业</option>
            <option value="教育">教育</option>
            <option value="卫生和社会工作">卫生和社会工作</option>
            <option value="文化、体育和服务业">文化、体育和服务业</option>
            <option value="公共管理、社会保障和社会组织">公共管理、社会保障和社会组织</option>
            <option value="国际组织">国际组织</option>
            <option value="军队">军队</option>
        </select></td>
    </tr>
        <tr>
            <td style="padding-left: 40px"><font color="red"> *</font>工作职业类别</td>
        <td>
            <select name="category" class="easyui-combobox" style="width: 200px;height: 25px;" data-options="required:true">
                <option value="公务员">公务员</option>
                <option value="科学研究人员">科学研究人员</option>
                <option value="工程技术人员">工程技术人员</option>
                <option value="农林牧副渔业技术人员">农林牧副渔业技术人员</option>
                <option value="卫生专业技术人员">卫生专业技术人员</option>
                <option value="经济业务人员">经济业务人员</option>
                <option value="金融业务人员">金融业务人员</option>
                <option value="法律专业人员">法律专业人员</option>
                <option value="教学人员">教学人员</option>
                <option value="文学艺术工作人员">文学艺术工作人员</option>
                <option value="体育工作人员">体育工作人员</option>
                <option value="新闻出版和文化工作人员">新闻出版和文化工作人员</option>
                <option value="其他专业技术人员">其他专业技术人员</option>
                <option value="办事人员和有关人员">办事人员和有关人员</option>
                <option value="商业和服务业人员">商业和服务业人员</option>
                <option value="生产和运输设备操作人员">生产和运输设备操作人员</option>
                <option value="军人">军人</option>
                <option value="其他人员">其他人员</option>
            </select>
        </td>
    </tr>
        <tr>
            <td style="padding-left: 40px"><font color="red"> *</font>档案转寄详细地址<br><font color="red" size="2" >（包括收件单位、部门和邮编）</font></td>
            <td><input type="text" name="danganaddress" class="easyui-textbox" style="width: 200px;height: 25px;" data-options="required:true"></td>
        </tr>
       <!-- <tr>
        <td style="text-align: right" ><input class="easyui-linkbutton"  onclick="submitForm()">提交</td>
            <td><font color="red" size="2"> </font></td>
        </tr>-->

    </table>
    ${message}

    <center> <a  class="easyui-linkbutton"  onclick="submitForm()" style="width: 80px;">提交</a><font color="red" size="2">* 所有选项均为必填项</font></center>
</form>
<div style="padding-right:200px">
</body>
</html>
