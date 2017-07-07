<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 2017/6/7 0007
  Time: 下午 3:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.0/weui.css">
    <title>盖章处理</title>
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
    <form action="${pageContext.request.contextPath}/navigation/navigation_stamp" method="post" id="query">
        <input type="hidden" name="pageNo" value="1"/>

    <div class="weui-cell">
        <div class="weui=cell__bd">
            <label class="weui_label">
                <c:if test="${recordCount==0}">
                    <br/><br/>当前没有盖章申请！
                </c:if>
            </label>
        </div>
    </div>


    <c:if test="${recordCount>0}">
        <div class="page__hd">
            <div class="page__title">共有问题${recordCount}条， 第${pageNo}/${pageCount}页</div>
        </div>

        <div class="weui-cells">
            <c:forEach items="${stamps}" var="stamp">
                    <div class="weui-cell__bd">
                        <p>※学号：&nbsp;${stamp.studentid}&nbsp; <br>
                            ※申请类型：&nbsp;${stamp.functron}&nbsp;
                        </p>
                    </div>
                <a href="${pageContext.request.contextPath}/navigation/navigation_checkStamp?stampid=${stamp.stampid}&pageNo=${pageNo}&userid=<%=session.getAttribute("userid")%>&state=1" class="weui-btn weui-btn_primary">盖章</a></td>

            </c:forEach>
        </div>
    </form>
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
    </c:if>
</body>
</html>
