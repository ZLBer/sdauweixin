<%@ page  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <c:forEach items="${articleList}" var="article">
</head>

<body>
<div class="container" style="height:90%;" >
    <div class="body">
        <div class="row clearfix">
            <div class="col-xs-12 col-md-2 col-lg-2 ">
            </div>
            <div class="col-xs-12 col-md-6 col-lg-6 ">
                <div style="align:center">
                    <div class="page-header">
                        <h1>${article.enterprisename}
                        </h1>
                    </div>
                    <br/>
                    <p>提交时间：${article.articletime} </p><br/>
                </div>
                <p>联系人： ${article.author}        联系电话：${article.authortel} </br></p>
                <br/>
                    ${article.articletext}<br/>
            </div>
            <div class="clearfix visible-xs"></div>
            <div class="col-xs-12 col-md-4 col-lg-4 ">
            </div>
        </div>

        </c:forEach>
    </div>
</div>

</body>
</html>
