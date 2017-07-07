<%--
  Created by IntelliJ IDEA.
  User: hello world
  Date: 2017/5/1
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>未处理的问题</title>
    <link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.0/weui.css">
    <style>
        body{
            text-align:center;
        }
        th,td{
            border:2px solid gray;
            text-align:center;
            padding:3px 10px;
        }
        table{
            border-collapse:collapse;
            margin:0 auto;
        }
    </style>
    <script language="javascript">
        function jump1(pageno){
            var queryForm=document.getElementById("query");
            queryForm.pageNo.value=pageno;
            queryForm.submit();
        }
    </script>
    <script language="javascript">
        function countChar(status,counter)
        {
            document.getElementById(counter).innerHTML = 100 - document.getElementById(status).value.length;
        }
    </script>
</head>

<body>
<form action="${pageContext.request.contextPath}/college/college_select" method="post" id="query">

    <input type="hidden" name="pageNo" value="1"/>

</form>
<div class="weui-cell">
    <div class="weui=cell__bd">
        <label class="weui_label">
            <c:if test="${recordCount==0}">
                <br/><br/>您当前没有提交问题！
            </c:if>
        </label>
    </div>
</div>
<c:if test="${recordCount>0}">

    <div class="page__hd">
        <div class="page__title">共有问题${recordCount}条， 第${pageNo}/${pageCount}页</div>
    </div>

    <div class="weui-cells">
            <c:forEach items="${problemList}" var="problem">
                
                <a class="weui-cell weui-cell_access" href="${pageContext.request.contextPath}/college/inspectProblem?problemid=${problem.problemid}">
                    <div class="weui-cell__hd">&nbsp;※</div>
					<div class="weui-cell__bd">
                        <p>${problem.problemtext}</p>
                    </div>
                    <div class="weui-cell__ft">
                        <c:if test="${problem.problemstate==0}">
                            未回复
                        </c:if>
                        <c:if test="${problem.problemstate==1}">
                            已回复
                        </c:if>
                    </div>
                </a>
            </c:forEach>
    </div>
    <br>
    <!--分页切换-->

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
    <br>

</c:if>
</body>

</html>
