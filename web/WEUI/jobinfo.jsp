<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 2017/5/15 0015
  Time: 下午 7:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.0/weui.css">
    <title>招聘信息</title>
    <script text="text/javascript">
        function jump2(pageno)
        {
            var queryForm =document.getElementById("query");
            queryForm.pageNo.value = pageno;
            queryForm.submit();
        }
    </script>
</head>
<body>
    <form action="${pageContext.request.contextPath}+'/navi/checkProble'" method="post" id="query">
        <input type="hidden" value="1" name="pageNo">
    </form>

    <div class="weui-cell">
        <div class="weui=cell__bd">
            <label class="weui_label">
                <c:if test="${recordCount==0}">
                    <br/><br/>无记录
                </c:if>
            </label>
        </div>
    </div>

    <c:if test="${recordCount>0}">
        <!--问题号 回复 时间-->
        <div class="page__hd">
            <div class="page__title">所有问题</div>
        </div>

        <div class="weui-cells">
            <c:forEach items="${problemList}" var="problem">
                <a class="weui-cell weui-cell_access" href="${pageContext.request.contextPath}+'/student/problemtoSee?problemid=${problem.problemid}'">
                    <div class="weui-cell__bd">
                        <p>${problem.problemtext}</p>
                    </div>
                    <div class="weui-cell__ft">
                        <c:if test="${problem.problemstate==0}">
                            未处理
                        </c:if>
                        <c:if test="${problem.problemstate==1}">
                            已处理
                        </c:if>
                    </div>
                </a>
            </c:forEach>
        </div>
        共有问题${recordCount}条， 第${pageNo}/${pageCount}页，
        <c:if test="${pageNo>1}">
            <a href="javascript:jump2('1')">首页</a>
            <a href="javascript:jump2('${pageNo-1}')">上页</a>
        </c:if>
        <c:if test="${pageNo==1}">
            首页  上页
        </c:if>

        <c:if test="${pageNo<pageCount}">
            <a href="javascript:jump2('${pageNo+1}')">下页</a>
            <a href="javascript:jump2('${pageCount}')">末页</a>
        </c:if>
        <c:if test="${pageNo==pageCount}">
            下页   末页
        </c:if>

        <br/><br/>

    </c:if>

</body>
</html>
