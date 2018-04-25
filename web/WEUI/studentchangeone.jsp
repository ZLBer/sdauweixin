<%--
  Created by IntelliJ IDEA.
  User: 平行时空
  Date: 2018/4/23
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" href="https://cdn.bootcss.com/weui/1.1.2/style/weui.min.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/jquery-weui/1.2.0/css/jquery-weui.min.css">
    <link rel="stylesheet" href="<c:url value="/css/demo.css"/> ">

</head>
<body>
<header class="demos-header">
    <h1 class="demos-title" style="font-size: 20px;" align="center">山东农业大学就业导航中心</h1>
    <p class="demos-sub-title" align="center">新生注册系统</p>
</header>
<form action="<c:url value='StudentServlet?method=updatedata'/> " method="post" id="sform">


    <div class="weui-cells weui-cells_form">
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">姓名:</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="text" placeholder="请输入您的名字" name="sName" value="${data.sName}">
            </div>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">学号:</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" type="text" pattern="[0-9]*" placeholder="请输入您的学号" value="${data.sId}" name="sId">
        </div>
    </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">性别:</label></div>
        <div class="weui-cell__bd">
            <c:choose>
                <c:when test="${data.sSex eq 男}">
                    <span class="weui-sex">
						<a href="javascript:;" class="weui-icon-circle selected " data-type="1"></a>
						<span class="stu_sex">男</span>
                        <input type="hidden" name="sSex" value="男">
					</span>
                    <span class="weui-sex">
						<a href="javascript:;" class="weui-icon-circle" data-type="2"></a>
						<span class="stu_sex">女</span>
                    <input type="hidden" name="sSex" value="女">
					</span>
                </c:when>
                <c:otherwise>
                <span class="weui-sex">
						<a href="javascript:;" class="weui-icon-circle  " data-type="1"></a>
						<span class="stu_sex">男</span>
                        <input type="hidden" name="sSex" value="男">
					</span>
                    <span class="weui-sex">
						<a href="javascript:;" class="weui-icon-circle selected" data-type="2"></a>
						<span class="stu_sex">女</span>
                    <input type="hidden" name="sSex" value="女">
					</span>
                </c:otherwise>

            </c:choose>

        </div>
    </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">民族:</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" name="sNation" type="text" placeholder="请输入您的民族" value="${data.sNation}">
        </div>
    </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">专业:</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" type="text" placeholder="请输入您的专业" name="sMajor" value="${data.sMajor}">
        </div>
    </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell_hd" style="width: 100%;">
            <a href="javascript:void(0);"  onclick="submitform();" class="weui-btn weui-btn_primary">提交</a>
        </div>
    </div>

<script type="text/javascript">
    function submitform() {
        document.getElementById("sform").submit();
    }
</script>

</form>
</body>
</html>
