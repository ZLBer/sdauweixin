
<%--
  Created by IntelliJ IDEA.
  User: libin
  Date: 2017/4/23
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>third</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
        function submit_upload_picture() {
            var file = $('#inputfile').val();
            if (!/.(gif|jpg|jpeg|png|gif|jpg|png)$/.test(file)) {
                alert("图片类型必须是.gif,jpeg,jpg,png中的一种");
                return false;
            } else {
                return true;
            }
        }
    </script>
</head>
<body>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

<center>
    <form id="form" method="post" action="enterprise_inthird" enctype="multipart/form-data" onsubmit="return submit_upload_picture()">

        <div class="form-group">
            <label for="inputfile">上传企业营业执照</label>
            <br>
            <label style="color: red">*请上传图片格式(.gif,jpeg,jpg,png)</label>
            <br>
            <input type="file" id="inputfile" name="file1">
        </div>
        <br>
        <button type="submit" class="btn btn-default">提交</button>
    </form>
</center>
</body>
</html>
