<%@ page  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html><head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<style>
		.right{

		}
	</style>
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<meta charset="utf-8">
<div class="container" style="height:100%">
	<div class="row clearfix">
		<div class="col-md-12 col-lg-12 column">
			<nav class="navbar navbar-default" role="navigation" style="align:center">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="#">网站主页</a>
				</div>

				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">机构简介<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li>
									<a href="http://www.sdau.edu.cn" target="_blank">农大主页</a>
								</li>
								<li>
									<a href="http://jyzx.sdau.edu.cn" target="_blank">就业信息网主页</a>
								</li>

							</ul>
						</li>

						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">生源信息<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li>
									<a href="${pageContext.request.contextPath}/enterprise/major.html" target="_blank">专业介绍</a>
								</li>
								<li>
									<a href="http://jyzx.sdau.edu.cn/s/254/t/2009/p/1/c/7744/d/7762/list.htm" target="_blank">辅导员联系方式</a>
								</li>
							</ul>
						</li>


					</ul>


				</div>

			</nav>
			<div class="carousel slide" id="carousel-134526">
				<ol class="carousel-indicators">
					<li data-slide-to="0" data-target="#carousel-134526">
					</li>
					<li data-slide-to="1" data-target="#carousel-134526">
					</li>
					<li data-slide-to="2" data-target="#carousel-134526">
					</li>
				</ol>
				<div class="carousel-inner">
					<div class="item next left" style="background: url('images/2.jpg');background-repeat: repeat">
						<img style="z-index: 10;" alt="" src="images/1.jpg" />
						<div class="carousel-caption">
							<%--<h4>--%>
								<%--First Thumbnail label--%>
							<%--</h4>--%>
						</div>
					</div>
					<div class="item" style="background: url('images/3.jpg');background-repeat: repeat">
						<img alt="" src="images/2.jpg" />
						<div class="carousel-caption">
							<%--<h4>--%>
								<%--Second Thumbnail label--%>
							<%--</h4>--%>
						</div>
					</div>
					<div class="item active left" style="background: url('images/1.jpg');background-repeat: repeat">
						<img alt="" src="images/3.jpg" />
						<div class="carousel-caption">
							<%--<h4>--%>
								<%--Third Thumbnail label--%>
							<%--</h4>--%>
						</div>
					</div>
				</div> <a class="left carousel-control" href="#carousel-134526" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-134526" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
			</div>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-xs-12 col-md-4 col-lg-4 column">
			<h2>
				校内就业信息
			</h2>
			<c:forEach items="${articleList}" var="article">
				<a href='article_query?aid=${article.articleid}')>${article.enterprisename}</a>
				<br>
			</c:forEach>
			<p>
				<a class="btn" href="filter.jsp?pageNo=1">查看更多</a>
			</p>
		</div>
		<div class="col-xs-12 col-md-4 col-lg-4 column">
			<h2>
				就业专场信息
			</h2>
			<c:forEach items="${articleSpecial}" var="articlespecial">
				<a href='article_query?aid=${articlespecial.articleid}'>${articlespecial.enterprisename}</a>
				<br>
			</c:forEach>
			<p>
				<a class="btn" href="#">查看更多</a>
			</p>
		</div>
		<div class="col-xs-12 col-md-4 col-lg-4 column">
			<h2>
				用户登录
			</h2>
			<p>
				<img src="images/03.png"><a href="login.jsp"><font size="+2" color="#666666">校内用户登录</font></a><br></p><p></p><p></p>
			<img src="images/03.png"><a href="enterprise/input_first.jsp"><font size="+2" color="#666666">企业入口</font></a>
			<p></p>
		</div>
	</div>
</div>
</body>
</html>