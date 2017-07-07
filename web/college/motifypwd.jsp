<%@ page pageEncoding="UTF-8"%>
<html>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="css/IconExtension.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<style type="text/css">
    th,td{
        border:2px solid gray;
        text-align:center;
        padding:3px 10px;
        font-family:楷体;
    }
    table{
        border-collapse:collapse;
        margin:0 auto;
        border-radius:15px;
        overflow:hidden;
        background:#E0ECFF;
    }
    td{
        margin:0px;
        border:0px;
        /*cellspacing=0;
        cellpadding=0;*/
        height:40px;
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
<div style="padding-right:200px">
    <form action="college_modipwd" method="post">
        <table align="center" style= "backgound-repeat:none " frame="void" >
            <tr><td> 请输入新密码：</td><td><input type="password" id="pwd1" name="pwd1" class="easyui-textbox" required="required"/></td></tr>
            <tr><td> 请确认密码：</td><td><input type="password" id="pwd2" name="pwd2" class="easyui-textbox" required="required"/></td></tr>
            <tr><td><input type="submit"  value="修改" onclick="return checkpwd()"/></td>
                <td><input type="reset" value="重置"/></td></tr>
        </table>
    </form>
    ${msg}
</div>
</body>
</html>
