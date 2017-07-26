<%--
  Created by IntelliJ IDEA.
  User: john
  Date: 2017/5/23
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<meta charset="utf-8">
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
<body>
<div style="padding-right:400px">
    <h1 align="center"><font face="楷体" color="#000066">完善印章预约个人信息</font></h1>
    <form action="${pageContext.request.contextPath}/student/makeStamp" method="post">
        <table>
            <tr>
                <td >申请人学号:</td>
                <td>${user.studentid}<input name="studentid" type="hidden" value="${user.studentid}"></td>
            </tr>
            <tr>
                <td >用途</td>
                <td>
                    <select name="function">
                        <option>三支一扶</option>
                        <option>就业协议书</option>
                        <%--<option>就业推荐表</option>--%>
                        <option>选调生/基层就业</option>
                        <option>银行推荐表</option>
                        <option>其他</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="提交"></td>
                <td><input type="reset" value="重填"></td>
            </tr>
            ${msg}
        </table>
    </form>
</div>
</body>
</html>
