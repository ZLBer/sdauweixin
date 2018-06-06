<%--
  Created by IntelliJ IDEA.
  User: 平行时空
  Date: 2018/6/6
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Excel表格操作</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

    <!-- HTML5 Shiv 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
    <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>

    <![endif]-->
</head>
<style>
    .sd{
        text-align: center;
    }
    .pas{
        margin-right: auto;
        margin-left: auto;
    }
    .forms{
        margin-right: auto;
        margin-left: auto;
        margin-top: 20%;
    }

</style>
<body>
<center>
    <form method="POST"  enctype="multipart/form-data" role="form" class="forms" action="/poi?method=getExcel1" name="uploadForm" id="forsd">
        <div class="form-group">

           <input type="file" id="fis"  name="upfile">
        </div>
        <div class="form-group">
            <input type="submit" id="files" value="上传" class="btn btn-primary">
        </div>
    </form>
</center>
    <div class="sd">
        <div class="pas">
            <a href="/poi?method=damodel">
            <button type="button" class="btn btn-primary">下载导入模板</button></a>
            <a href="/poi?method=getdatas">
            <button type="button" class="btn btn-primary">下载所有数据</button>
            </a>
            <br/>
        </div>
    </div>

<script>

    $("#files").click(function () {
        if($("#fis").val()==''){
            alert("请选择文件");
            return false;
        }else{
            $("#forsd").submit();
        }
    });

</script>

</body>
</html>
