<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 2017/5/25 0025
  Time: 下午 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.0/weui.css">
    <title>审核盖章</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">

    <script>
        function jump1(pageno){
            var queryForm=document.getElementById("query");
            queryForm.pageNo.value=pageno;
            queryForm.submit();
        }
    </script>
</head>
<body>
    <form action="${pageContext.request.contextPath}/college/checkStamp" method="post" id="query">
        <input type="hidden" name="pageNo" value="1"/>
        <input type="hidden" name="collegeid" value="<%=session.getAttribute("collegeid")%>"/>

    <center>
    <div class="weui-cell">
        <div class="weui=cell__bd">
            <label class="weui_label">
                <c:if test="${recordCount==0}">
                    <br/><br/>当前没有盖章申请！
                </c:if>
            </label>
        </div>
    </div>
    </center>
    <c:if test="${recordCount>0}">
        <div class="page__hd">
            <div class="page__title">共有问题${recordCount}条， 第${pageNo}/${pageCount}页</div>
        </div>
        <div class="weui-cells">
            <c:forEach items="${stamplist}" var="stamp">
                ${stamp.studentid}&nbsp;&nbsp;${stamp.functron}
                <a class="weui-btn weui-btn_plain-default" href="${pageContext.request.contextPath}/college/college_selectStamp?stampid=${stamp.stampid}&pageNo=${pageNo}&collegeid=<%=session.getAttribute("collegeid")%>&state=1">通过</a>
                <a class="weui-btn weui-btn_plain-default" href="${pageContext.request.contextPath}/college/college_selectStamp?stampid=${stamp.stampid}&pageNo=${pageNo}&collegeid=<%=session.getAttribute("collegeid")%>&state=0">不通过</a>
            </c:forEach>
        </div>

    <br>
    </form>
    <!--分页切换-->
<center>
    <div class="page__hd">
        <div class="page__title">
            <c:if test="${pageNo>1}">
                <a href="javascript:jump1('1')">首页</a>&nbsp;&nbsp;
                <a href="javascript:jump1('${pageNo-1}')">上页</a>
            </c:if>
            <c:if test="${pageNo==1}">
                首页 &nbsp;&nbsp; 上页&nbsp;&nbsp;
            </c:if>
            <c:if test="${pageNo<pageCount}">
                <a href="javascript:jump1('${pageNo+1}')">下页</a>&nbsp;&nbsp;
                <a href="javascript:jump1('${pageCount}')">末页</a>&nbsp;&nbsp;
            </c:if>
            <c:if test="${pageNo==pageCount}">
                下页  &nbsp;&nbsp; 末页&nbsp;&nbsp;
            </c:if>
        </div>
    </div>
</center>
    <br>
    </c:if>
</body>
</html>
