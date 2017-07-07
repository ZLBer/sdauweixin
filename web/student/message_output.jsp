<%--
  Created by IntelliJ IDEA.
  User: hello world
  Date: 2017/4/24
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    textarea{
        resize:none;
    }
	

</style>
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
<head>
<meta http-equiv="Content-type" content="text/html;charset=UTF-8"/>
<head>
	<link rel="stylesheet" type="text/css" href="/css/IconExtension.css">
	<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
	<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
	<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   
    <title>企业招聘信息</title>
</head>

<body>
<div class="easyui-panel" title="企业招聘信息" style="width:100%;padding:30px 60px;">
<center>
              <div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
               发布招聘信息
            </h3>
            <form role="form">
                <div class="form-group" >
                    <label for="exampleInputEmail1">企业名称</label><input type="text" class="form-control" id="exampleInputEmail1" />
                </div><br>
                <div class="form-group">
                    <label for="exampleInputPassword1">联系人</label><input type="password" class="form-control" id="exampleInputPassword1" />
                </div><br>
                <div class="form-group">
                    <label for="exampleInputPassword1">联系电话</label><input type="password" class="form-control" id="exampleInputPassword2" />
                </div><br>
                <div class="form-group">
                    <label for="exampleInputPassword1">招聘专业</label><input type="password" class="form-control" id="exampleInputPassword3" />
                </div><br>
                <div class="form-group">
                    <label for="exampleInputPassword1">需求人数</label><input type="password" class="form-control" id="exampleInputPassword4" />
                </div><br>
                <div class="form-group">
                    <label for="exampleInputPassword1">招聘简章</label>
                    <textarea col="80" class="ckeditor" row="10" name="ckedtior"></textarea>
                </div><br>

                <div class="form-group">
                    <label for="exampleInputFile">上传营业执照</label><input type="file" id="exampleInputFile" />
                    <p class="help-block">
                        图片不得大于2M
                    </p>
                </div><br>
                <button type="submit" class="btn btn-default">提交</button>
            </form>
        </div>
    </div>
</div>
</center>
</div>
</body>
</html>
