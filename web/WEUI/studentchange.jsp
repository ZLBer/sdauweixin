<%--
  Created by IntelliJ IDEA.
  User: 平行时空
  Date: 2018/4/23
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>信息确认</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">

    <link rel="stylesheet" href="https://cdn.bootcss.com/weui/1.1.2/style/weui.min.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/jquery-weui/1.2.0/css/jquery-weui.min.css">
    <link rel="stylesheet" href="<c:url value="/css/demo.css"/>">
</head>
<body>

            <header class="demos-header">
                <h1 class="demos-title" style="font-size: 20px;" align="center">2018届毕业生就业去向信息核对</h1>
                <%--<p class="demos-sub-title" align="center">信息确认系统</p>--%>
            </header>

            <p style="color: red;">&nbsp;&nbsp;&nbsp;以下信息非常重要请一定认真核对。如果无误，请点击“确认无误”，确认无误后信息锁定无法修改；如果有误，请点击“有错误，需修改”，进入修改页面将错误信息修改为正确信息，点击“修改完毕，提交”，提交后信息锁定无法修改。</p>

            <div class="weui-cells weui-cells_form">
                <div class="weui-cell">
                    <div class="weui-cell__hd"><label class="weui-label">姓名:</label></div>
                    <div class="weui-flex">
                        <div class="weui-flex__item">${data.sName}</div>
                    </div>
                </div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__hd"><label class="weui-label">学号:</label></div>
                <div class="weui-cell__bd">
                    <div class="weui-flex">
                        <div class="weui-flex__item">${data.sId}</div>
                    </div>
                </div>
            </div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__hd"><label class="weui-label">性别:</label></div>
                <div class="weui-cell__bd">
                    <div class="weui-flex">
                        <div class="weui-flex__item">${data.sSex}</div>
                    </div>
                </div>
            </div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__hd"><label class="weui-label">专业:</label></div>
                <div class="weui-cell__bd">
                    <div class="weui-flex">
                        <div class="weui-flex__item">${data.sMajor}</div>
                    </div>
                </div>
            </div>

            <div class="weui-cell">
                <div class="weui-cell__hd"><label class="weui-label">学院:</label></div>
                <div class="weui-cell__bd">
                    <div class="weui-flex">
                        <div class="weui-flex__item">${data.sDepartment}</div>
                    </div>
                </div>
            </div>

            <div class="weui-cell">
                <div class="weui-cell__hd"><label class="weui-label">生源地:</label></div>
                <div class="weui-cell__bd">
                    <div class="weui-flex">
                        <div class="weui-flex__item">${data.sBirthplace}</div>
                    </div>
                </div>
            </div>


            <div class="weui-cell">
                <div class="weui-cell__hd"><label class="weui-label">接收单位:</label></div>
                <div class="weui-cell__bd">
                    <div class="weui-flex">
                        <div class="weui-flex__item">${data.sReceivingunit}</div>
                    </div>
                </div>
            </div>

            <div class="weui-cell">
                <div class="weui-cell__hd"><label class="weui-label">档案转寄地址:</label></div>
                <div class="weui-cell__bd">
                    <div class="weui-flex">
                        <div class="weui-flex__item">${data.sForaddress}</div>
                    </div>
                </div>
            </div>


            <div class="weui-cell">
                <div class="weui-cell__hd"><label class="weui-label">就业类型:</label></div>
                <div class="weui-cell__bd">
                    <div class="weui-flex">
                        <div class="weui-flex__item">${data.sReporttype}</div>
                    </div>
                </div>
            </div>

            </div>
            <c:if test="${data.sIschanged ==0}">
                <div class="weui-cell">
                    <div class="weui-cell_hd" style="width: 100%;">
                        <a href="<c:url value='StudentServlet?method=changedata&s_id=${data.sId}'/>" class="weui-btn weui-btn_primary">有错误，需修改</a>
                    </div>
                </div>
            </c:if>

            <c:choose>
                <c:when test="${data.sIschanged >0}">
                    <div class="weui-cell">
                        <div class="weui-cell_hd" style="width: 100%;">
                            <a href="javascript:void(0);" class="weui-btn weui-btn_primary weui-btn_disabled">您已确认</a>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="weui-cell">
                        <div class="weui-cell_hd" style="width: 100%;">
                            <a href="<c:url value='StudentServlet?method=isOk&s_id=${data.sId}&sIschanged=1'/>" class="weui-btn weui-btn_primary">确认无误</a>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>

            </div>
</body>
</html>