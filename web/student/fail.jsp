<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2017/5/14
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>欢迎关注企业号</title>
</head>
<body>
<div class="container" style="height:90%;">
    <div class="row clearfix">
        <div class="col-xs-12 col-md-12 col-lg-12 column">
            <div class="page-header">
                <h1>您的招聘信息已交由学校审核，请耐心等待。
                </h1>
            </div>
            <div style="align:center">
                <div align="center"><img  src="${pageContext.request.contextPath }/enterprise/erweima.jpg" height="300px" width="300px">   </div>
                <br>
                <h1>欢迎关注山农大就业指导中心企业号，您的招聘信息通过审核后可拥有企业号使用权限。</h1>
                <br>
                <div align="center"><h3> <a  href="${pageContext.request.contextPath }/index.jsp">返回主页</a></h3> </div>

            </div>
        </div>
    </div>
</div>
<div class="row clearfix" style="top:0px;width:100%">
    <div class="col-xs-12 col-md-12 col-lg-12 ">
        <div style="bottom:0px;background:#1f20ff;text-align:center;color:#ffffff;" >
            <p>Copyright  2011 All Rights Reserved </p>
            <p>鲁ICP备05002369号 | 版权所有山东农业大学 | 地址:山东省泰安市岱宗大街61号 | 邮编:271018</p>
        </div>
    </div>
</div>
</body>
</html>
