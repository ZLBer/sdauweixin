<%--
  Created by IntelliJ IDEA.
  User: C
  Date: 2017/5/11
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="ckeditor/ckeditor.js"></script>
    <title>填写信息</title>
</head>
<body>
<center>
    <form method="post" action="college_infirst" >
        <input type="hidden" name="columnid" value="1">
      <!--  <table>
            <tr>
            <tr><td>企业名称</td><td><input type="text" name="enterprisename"/></td></tr>
            <tr><td>企业联系人</td><td><input type="text" name="author"/></td></tr>
            <tr><td>联系人电话</td><td><input type="text" name="authortel"/></td></tr>
            <tr><td>从何处获得该信息</td><td><input type="text" name="other"></td></tr>
            <tr> <textarea class="ckeditor"   name="articletext"  >（这里填写招聘信息）</textarea> </tr>

            <td><input type="submit" value="下一步"  /></td>
            <td>   <input type="reset" value="重置"/> </td>
            </tr>
        </table>-->
        <%--加入ckeditor版本--%>
        <%--<textarea class="ckeditor"   name="articletext" id="TextArea1" rows="20" cols="216" >（这里填写招聘信息）--%>
        <%--</textarea>--%>
        <%--由于未知bug，未加ckeditor版本--%>
        <textarea  name="articletext" id="TextArea1" rows="20" cols="216" >（这里填写招聘信息）
            </textarea><br>
        <div class="input-group" style="padding-left: 100px">
            <span class="input-group-addon">企业名称：</span>
            <input type="text"  name="enterprisename" class="form-control" placeholder="在此输入企业名称" required style="width:800px;">
        </div>
        <br>
        <div class="input-group" style="padding-left: 100px">
            <span class="input-group-addon">企业联系人：</span>
            <input type="text" name="author" class="form-control" placeholder="在此输入企业联系人" required style="width: 787px">
        </div>
        <br>
        <div class="input-group" style="padding-left: 100px">
            <span class="input-group-addon">联系人电话：</span>
            <input type="text" name="authortel" class="form-control" placeholder="在此输入联系人电话" required style="width: 787px">
        </div>
        <br>
        <div class="input-group" style="padding-left: 100px">
            <span class="input-group-addon">信息发布学院：</span>
            <input type="text" name="authortel" class="form-control" placeholder="在此输入获取信息的方式" required style="width: 745px">
        </div>
        <br>
        <center><button type="submit" class="btn btn-default">下一步</button><button type="reset" class="btn btn-default">重置</button></center>

    </form>
</center>
</body>
</html>
