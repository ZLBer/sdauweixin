<%--
  Created by IntelliJ IDEA.
  User: C
  Date: 2017/5/12
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>添加专业和人数</title>
    <meta http-equiv="Content-type" content="text/html;charset=UTF-8"/>
    <jsp:include page="second_header.jsp"/>
</head>

<body onload="refresh()" background="${pageContext.request.contextPath}/images/beijing.png">
<h3>如果不选择专业，则无法将招聘信息精准发送给相关专业学生。</h3>

<table>
    <tr><th>专业</th><th>需求人数</th><th>删除</th></tr>
    <tr><td>
        <table>
            <c:forEach items="${majorList}" var="major">
                <tr>
                    <td>${major.majorname}</td>
                </tr>
            </c:forEach>

        </table>
    </td>
        <td>
            <table id="collegeSelected">
                <c:forEach items="${demandList}" var="demand">
                    <tr>
                        <td>${demand.demandnum}</td>
                    </tr>
                </c:forEach>
            </table>
        </td>
        <td>
            <table>
                <c:forEach items="${demandList}" var="demand">
                    <tr>
                        <td><a href='demand_delete?majorid=${demand.majorid}' onclick="return confirm('确实要删除该 记录吗？')">删除</a></td>
                    </tr>
                </c:forEach>
            </table>
        </td>
    </tr>
</table>
<br>
<br>
<br>
${msg}
<div align="center">
    <a href="major.html" target="_blank">查看专业介绍</a>
</div>
<form action="enterprise_insecond">
    <table align="center">
        <tr>
            <select name="college" id="college" onchange="refresh()">
                <option value="0">－－请选择学院－－</option>
                <option value="27">体育与艺术学院</option>
                <option value="26">国际交流学院</option>
                <option value="25">化学与材料科学学院</option>
                <option value="24">信息科学与工程学院</option>
                <option value="23">水利土木工程学院</option>
                <option value="22">文法学院</option>
                <option value="21">外国语学院</option>
                <option value="20">生命科学学院</option>
                <option value="19">食品科学与工程学院</option>
                <option value="18">经济管理学院</option>
                <option value="17">机械与电子工程学院</option>
                <option value="16">动物科技学院</option>
                <option value="15">园艺科学与工程学院</option>
                <option value="14">林学院</option>
                <option value="13">资源与环境学院</option>
                <option value="12">植物保护学院</option>
                <option value="11">农学院</option>
            </select>
        </tr>

        <tr>
            <select name="major" id="major">
                <option>--请选择专业--</option>
            </select>
        </tr>
        <br>
        <tr>
            <td>填写该专业需求人数<input type="text" name="demandnum" value="0"></td>
        </tr>
        <tr>
            <td> <input type="submit" value="添加">
                <a href="input_third.jsp" onclick="return tableIsNotEmpty('collegeSelected')">下一步</a></td>
        </tr>
    </table>
    <a href="${pageContext.request.contextPath}/images/xyzy.pdf"  target="_Blank">2018届毕业生及就业辅导员联系方式</a>
    <%--<div style="bottom:0; left:0; position:fixed; width:100%"><img src="${pageContext.request.contextPath}/images/dibu.png" style="width:100%;height:50px"></div>--%>
</form>

</body>
</html>