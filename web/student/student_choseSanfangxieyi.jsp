<%--
  Created by IntelliJ IDEA.
  User: libin
  Date: 2017/5/16
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>选择申请类型</title>
</head>
<body>
是否已有预先选择企业？
<a href="student_requestSanfangxieyi.jsp?studentid=${user.studentid}"> <input type="button" value="是，填写企业信息"></a> &nbsp;
<a href="student_secondSanfangxieyi.jsp?studentid=${user.studentid}"> <input type="button" value="否，填写申请理由"></a>
</body>
</html>
