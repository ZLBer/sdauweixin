<%--
  Created by IntelliJ IDEA.
  User: libin
  Date: 2017/5/17
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta charset="utf-8">
<style>
    textarea{border-radius:3px;
        border:1px solid #000;
        border-color:#09C}
</style>
<head>
    <title>填写信息</title>
</head>
<body>
<div style="padding:0 200px;">
    <form actio="Student_infoDownload" method="post">
        <input type="hidden" name="studentid" value="${user.studentid}">
        <table>
            <tr>
                <td>特长爱好:</td>
                <td><textarea name="aihao" style="width:400px; height:50px;" ></textarea><br></td>
            </tr>
            <tr>
                <td>在校担任职务:</td>
                <td><textarea name="zhiwu"  style="width:400px; height:50px"></textarea><br></td>
            </tr>
            <tr>
                <td>社会实践情况:</td>
                <td><textarea name="shijian" style="width:400px; height:50px"></textarea><br></td>
            </tr>
            <tr>
                <td>奖惩情况:</td>
                <td><textarea name="jiangcheng" style="width:400px; height:50px"></textarea><br></td>
            </tr>
            <tr>
                <td>所获专业类证书:</td>
                <td><textarea name="zhengshu" style="width:400px; height:50px"></textarea><br></td>
            </tr>
            <tr>
                <td>毕业生选择志愿：</td>
                <td><textarea name="zhiyuan" style="width:400px; height:50px"></textarea><br></td>
            </tr>
            <tr>
                <td>毕业生自我评价：</td>
                <td><textarea name="pingjia" style="width:400px; height:50px"></textarea><br></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
