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
    <title>信息修改</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">

    <link rel="stylesheet" href="https://cdn.bootcss.com/weui/1.1.2/style/weui.min.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/jquery-weui/1.2.0/css/jquery-weui.min.css">
    <link rel="stylesheet" href="<c:url value="/css/demo.css"/> ">

</head>
<body>
<header class="demos-header">
    <h1 class="demos-title" style="font-size: 20px;" align="center">2018届毕业生就业去向信息核对</h1>
    <%--<p class="demos-sub-title" align="center">新生注册系统</p>--%>
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
            <div class="weui-flex">
                <div class="weui-flex__item">${data.sId}</div>
                <input type="hidden" value="${data.sId}" name="s_id">
            </div>
        </div>
    </div>

    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">性别:</label></div>

        <c:choose>
              <c:when test="${data.sSex eq '男'}">

            <div class=" weui-cells_checkbox" style="display:flex;justify-content:center; align-items:center;">
                <label class="weui-cell weui-check__label" for="s111" style=" float:left;">
                    <div class="weui-cell__hd">
                        <input type="radio" class="weui-check" name="sSex" id="s111" checked="checked" value="男">
                        <i class="weui-icon-checked"></i>
                    </div>
                    <div class="weui-cell__bd">
                        <p>男</p>
                    </div>
                </label>

                <label class="weui-cell weui-check__label" for="s13"style=" float:left;">
                    <div class="weui-cell__hd">
                        <input type="radio" name="sSex" class="weui-check" id="s13" value="女">
                        <i class="weui-icon-checked"></i>
                    </div>
                    <div class="weui-cell__bd">
                        <p>女</p>
                    </div>
                </label>
            </div>

                </c:when>
                <c:otherwise>

                    <div class="weui-cells_checkbox" style="display:flex;justify-content:center; align-items:center;">
                        <label class="weui-cell weui-check__label" for="s1111" style=" float:left;">
                            <div class="weui-cell__hd">
                                <input type="radio" class="weui-check" name="sSex" id="s1111"  value="男">
                                <i class="weui-icon-checked"></i>
                            </div>
                            <div class="weui-cell__bd">
                                <p>男</p>
                            </div>
                        </label>

                        <label class="weui-cell weui-check__label" for="s122"style=" float:left;">
                            <div class="weui-cell__hd">
                                <input type="radio" name="sSex" class="weui-check" id="s122" value="女" checked="checked">
                                <i class="weui-icon-checked"></i>
                            </div>
                            <div class="weui-cell__bd">
                                <p>女</p>
                            </div>
                        </label>
                    </div>
                </c:otherwise>

            </c:choose>

   </div>


    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">学院:</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" name="sDepartment" type="text" placeholder="请输入您的学院" value="${data.sDepartment}">
        </div>
    </div>
    

    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">专业:</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" type="text" placeholder="请输入您的专业" name="sMajor" value="${data.sMajor}">
        </div>
    </div>


    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">就业类型:</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" type="text" placeholder="请输入您的就业类型" name="sReporttype" value="${data.sReporttype}">
        </div>
    </div>


    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">接收单位:</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" type="text" placeholder="请输入您的接收单位" name="sReceivingunit" value="${data.sReceivingunit}">
        </div>
    </div>

    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">生源地:</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" type="text" placeholder="请输入您的生源地" name="sBirthplace" value="${data.sBirthplace}">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">档案转寄地址:</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" type="text" placeholder="请输入您的档案转寄地址" name="sForaddress" value="${data.sForaddress}">
        </div>
    </div>

    <div class="weui-cell">
        <div class="weui-cell_hd" style="width: 100%;">
            <a href="javascript:void(0);"  onclick="submitform();" class="weui-btn weui-btn_primary">修改完毕，提交</a>
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
