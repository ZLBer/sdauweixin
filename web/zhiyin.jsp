<%@ page  pageEncoding="UTF-8"%>
<html>
	<meta charset="utf-8" />
	<title> 招聘信息发布系统指引</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<style type="text/css">

		.div1
		{
			margin: 0 auto;
			width: 800px;
			height:auto;
			padding-top: 60px;
			
		}
		.div2
		{
			 /*z-index:10;  */
                /*width:400px;  */
                /*height:50px;  */
                /*position:fixed;  */
                /*right:50px;  */
                /*top:100px;*/
                /*background:white; */
                /*border: 1px solid white;*/
                /*border-radius: 10px;*/
                /*text-align: center;*/
                /*padding-top: 8px;*/
                
                
		}
		p{
			line-height: 30px;
		}
		a:link
		{
			text-decoration: none;
		}
	</style>
<body>
<div class="div1">
<font size="+2"><strong><center>招聘信息发布系统指引</center></strong></font><br />
<p></p>
<font size="+2">第一步:</font><br/>
<p class="bg-warning">从企业发布入口进入提交招聘信息的页面。<br/></p>
<p></p>
<font size="+2">第二步:</font>
<p class="bg-success">根据提示填入相关需求信息，要求包括公司名称、联系人、联系方式、招聘简章等；添加的招聘简章正文可在 word
 文档中设置好格式，要求正文宋体小四，首行缩进两个字符，1.5 倍行距，标题加粗。复制到编辑区时，
 不要清除原文格式，正文编辑完毕，点击编辑区下方“下一步”继续操作。</p>
 <p></p>
 <!--<center><img  src="images/2.png" width="750px" height="400px"/></center>-->
 <font size="+2">第三步:</font>
<p class="bg-info">填写需求人数，点击“添加”依次选择增加所需专业及人数，点击编辑区下方“下一步”继续操作。
 点击“查看专业介绍”可详细了解本校的专业信息以及了解2018届毕业生及就业辅导员联系方式。<font color="red">如果不选择专业，则无法将招聘信息精准发送给相关专业学生。<br /></font>
<!--如下图所示：<br />-->
点击查看本校专业介绍,
<!--<center><img src="images/3.1.png" width="750px" height="400px"/><br /></center>-->
选择相关学院及专业,
<!--<center><img src="images/3.2.png" width="750px" height="400px"/><br /></center>-->
填写需求人数,
<!--<center><img src="images/3.3.png" width="750px" height="400px"/><br /></center>-->
填写完成后点击“添加”。
如果您想继续添加需求专业，再次重复第三步即可。</p>
<p></p>
 <font size="+2">第四步:</font>
 <p class="bg-danger">点击“下一步”。上传企业营业执照电子版图片(<font color="red">图片格式请务必是.gif,jpeg,jpg,png</font>)。</p>
<!--<img src="images/4.1.png" width="750px" height="400px"/><br />-->
选择完图片后点击“提交”。<br />
<p></p>
<font size="+2">第五步:</font>
<p class="bg-info">扫描二维码关注微信号，审核结果会以微信的形式通知您。</p>
<!--<img src="images/5.png" width="750px" height="400px"/><br />-->
<p class="bg-danger" style="line-height: 50px;"><font color="red" >温馨提示：企业联系电话请填写手机号，以便接收关注微信平台的验证码；关注微信平台后，
我们会将审核结果及时发送至您的微信上。</font></p>
<div   style="text-align: center" class="div2">
    <a href="${pageContext.request.contextPath}/enterprise/input_first.jsp" ><button class="btn btn-danger"  style="height: 50px;width: 300px" >点击下一步，开始填写招聘信息</button></a>
</div>
</div>
</body>
</html>
