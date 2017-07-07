<%@ page pageEncoding="UTF-8"%>
<html>
<meta charset="utf-8">
<style>
 tr>td:nth-child(1){
            text-align: left;
			font-family:楷体;
        }
div
		{
		text-align:center;
		border:2px solid #a1a1a1;
		padding:10px 40px;
		background:#E0ECFF;
		width:350px;
		border-radius:25px;
		-moz-border-radius:25px; /* 老的 Firefox */
		}
</style>
<head>
<script>
function checkpwd()
{
var pwd1=document.getElementById("pwd1").value;
var pwd2=document.getElementById("pwd2").value;
if(pwd1!=pwd2)
{
alert("两次输入密码不一致！");
return false;
}
}
</script>

</head>
  <body>
  <center>
<div align="center" style="border:#E0ECFF">
  <form action="admin_modipwd" method="post">

  <table align="center" style= "backgound-repeat:none " frame="void">
 <tr><td> 请输入新密码：</td><td><input type="password" id="pwd1" name="pwd1" required="required"/></td></tr>
 <tr><td> 请确认密码：</td><td><input type="password" id="pwd2" name="pwd2" required="required"/></td></tr>
  <tr><td><input type="submit"  value="修改" onclick="return checkpwd()"/></td>
  <td><input type="reset" value="重置"/></td></tr>
  </table>
   </form>
    ${msg}
    </div>
    </center>

  </body>
</html>
