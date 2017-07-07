<%--
  Created by IntelliJ IDEA.
  User: john
  Date: 2017/5/3
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <script type="text/javascript" src="ckeditor/ckeditor.js"></script>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>提交专场信息</title>
</head>
<body>
<div class="container" >
    <div class="row clearfix">
        <div class="col-md-12">
            <div class="page-header">
                <h1>提交专场信息
                </h1>

            </div>
            <p>&nbsp;</p>
            <div >
                <form class="bs-example bs-example-form" role="form" action="enterprise_infirst2" method="post">
                    <div class="input-group">
                        <span class="input-group-addon">企业名称：</span>
                        <input type="text"  name="enterprisename" class="form-control" placeholder="在此输入企业名称" required>
                    </div>
                    <br>
                    <div class="input-group">
                        <span class="input-group-addon">企业联系人：</span>
                        <input type="text" name="author" class="form-control" placeholder="在此输入企业联系人" required>
                    </div>
                    <br>
                    <div class="input-group">
                        <span class="input-group-addon">联系人电话：</span>
                        <input type="text" name="authortel" class="form-control" placeholder="在此输入联系人电话" required>
                    </div>
                    <p>招聘信息简章：</p>
                    <textarea class="ckeditor"   name="articletext" rows="20" cols="216" required>（这里填写招聘信息）
            </textarea>
                    <p></p>
                    <center><button type="submit" class="btn btn-default">下一步</button></center>

                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
