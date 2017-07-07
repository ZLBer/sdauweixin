<%--
  Created by IntelliJ IDEA.
  User: C
  Date: 2017/5/11
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <script type="text/javascript" src="ckeditor/ckeditor.js"></script>
    <title>填写信息</title>
</head>
<body>
<center>
    <form method="post" action="college_infirst" >
        <table>
            <tr>
            <tr><td>企业名称</td><td><input type="text" name="enterprisename"/></td></tr>
            <tr><td>企业联系人</td><td><input type="text" name="author"/></td></tr>
            <tr><td>联系人电话</td><td><input type="text" name="authortel"/></td></tr>
            <tr><td>从何处获得该信息</td><td><input type="text" name="other"></td></tr>
            <tr> <textarea class="ckeditor"   name="articletext"  >（这里填写招聘信息）</textarea> </tr>

            <td><input type="submit" value="下一步"  /></td>
            <td>   <input type="reset" value="重置"/> </td>
            </tr>
        </table>

    </form>
</center>
</body>
</html>
