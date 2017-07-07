<%@ page  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
        function f()
        {
            document.getElementById("ck").src="checkcode?a="+Math.random();
        }
    </script>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-xs-12 col-md-12 column">
            <img src="images/head.jpg" width="100%" border="0">
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-xs-12 col-md-6 column">
            <img src="images/a.jpg" width="700px"height="330px" border="0">
        </div>
        <div class="col-xs-12 col-md-6 column"  >
            <div class="row clearfix">
                <div class="col-xs-1 col-md-2 column">
                </div>
                <div class="col-xs-1 col-md-8 column">
                    <br>
                    <br>
                    <br>
                    <form  action="login_check.action" method="post" class="bs-example bs-example-form"  style="float:left;">
                        <div class="input-group">
                            <span class="input-group-addon">账号</span>
                            <input type="text"  name="userid" class="form-control" placeholder="在此输入账号" required>
                        </div><br>
                        <div class="input-group">
                            <span class="input-group-addon">密码</span>
                            <input type="Password"  name="userpwd" class="form-control" placeholder="在此输入密码" required>
                        </div><br>
                        <div class="input-group">
                            <span class="input-group-addon">用户类型</span>
                            <select class="selectpicker show-tick form-control" name="type">
                                <option value="student" selected="selected">学生</option>
                                <option value="college">学院 </option>
                                <option value="navigation">就业中心 </option>
                                <option value="admin">管理员</option>
                            </select>
                        </div>
                        <br>
                        <div class="row clearfix">
                            <div class="col-md-8 column">
                                <div class="input-group" >
                                    <span class="input-group-addon">验证码</span>
                                    <input name="checkcode" type="text" class="form-control" placeholder="在此输入验证码"  required>
                                </div>
                            </div>
                            <div class="col-md-4 column">
                                <img src="checkcode" id="ck" onclick="f()" >
                            </div>
                        </div>

                        <br>
                        <input class="btn btn-defalut btn-block" type="submit"  value="登　　录" />
                    </form>
                    ${msg}
                </div>
            </div>
            <div class="col-md-2 column">
            </div>
        </div>
        <div class="row clearfix">
            <div class="col-md-12 column" align="center">
                <br>
                <p>Copyright © 2011 All Rights Reserved </p><br/>
                <p>鲁ICP备05002369号 | 版权所有©山东农业大学 | 地址:山东省泰安市岱宗大街61号 | 邮编:271018</p>
            </div>
        </div>
    </div>


</body>
</html>