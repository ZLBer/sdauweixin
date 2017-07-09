<%--
  Created by IntelliJ IDEA.
  User: Minister
  Date: 2017/5/1
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="application/vnd.ms-excel;charset=GBK"%>
<% response.setHeader("Content-disposition","attachment; filename=student.xls"); %>
<html>
<head>
    <style>
        td{mso-number-format:"\@";}????
    </style>
    <title>学生信息</title>
</head>
<body>

    <table border="1">
        <tr>
            <td>学号</td>
            <td>考生号</td>
            <td>姓名</td>
            <td>性别</td>
            <td>民族</td>
            <td>身份证号</td>
            <td>政治面貌</td>
            <td>学历</td>
            <td>专业</td>
            <td>培养方式</td>
            <td>生源所在地</td>
            <td>学制</td>
            <td>辅修专业</td>
            <td>出生日期</td>
            <td>学位</td>
            <td>主修外语语种</td>
            <td>外语水平</td>
            <td>计算机水平</td>
            <td>入学年份</td>
            <td>毕业时间</td>
            <td>是否定向培养</td>
            <td>委培定向单位</td>
            <td>委培单位所在地</td>
            <td>院系</td>
            <td>常住地市区县</td>
            <td>现户籍所在地市区县</td>
            <td>常住地址详细</td>
            <td>现户籍所在地详细</td>
            <td>班级</td>
            <td>常住地乡镇街道办事处</td>
            <td>常住地乡镇街道办事处描述</td>
            <td>现户籍所在地乡镇记街道办事处</td>
            <td>现户籍所在地乡镇记街道办事处描述</td>
            <td>户籍性质</td>
            <td>职业资格</td>
            <td>家庭常用联系电话</td>
            <td>户籍登记日期</td>
            <td>学生状态</td>
        </tr>
        <c:forEach var="stu" items="${students}">
            <tr>
                <td>${stu.studentid}</td>
                <td>${stu.examid}</td>
                <td>${stu.studentname}</td>
                <td>${stu.studentsex}</td>
                <td>${stu.studentnation}</td>
                <td>${stu.studentnumber}</td>
                <td>${stu.political}</td>
                <td>${stu.education}</td>
                <td>${stu.studentmajor}</td>
                <td>${stu.trainingmode}</td>
                <td>${stu.location}</td>
                <td>${stu.length}</td>
                <td>${stu.minor}</td>
                <td>${stu.studentbirthday}</td>
                <td>${stu.degree}</td>
                <td>${stu.majorforeign}</td>
                <td>${stu.foreignlevel}</td>
                <td>${stu.comlevel}</td>
                <td>${stu.enteryear}</td>
                <td>${stu.graduationtime}</td>
                <td>${stu.universityname}</td>
                <td>${stu.weipeiunit}</td>
                <td>${stu.weipeilocation}</td>
                <td>${stu.studentcollege}</td>
                <td>${stu.resident}</td>
                <td>${stu.register}</td>
                <td>${stu.residentdetailed}</td>
                <td>${stu.registerdetailed}</td>
                <td>${stu.studentclass}</td>
                <td>${stu.residentoffice}</td>
                <td>${stu.residentaddress}</td>
                <td>${stu.registeroffice}</td>
                <td>${stu.registeraddress}</td>
                <td>${stu.tpye}</td>
                <td>${stu.vocational}</td>
                <td>${stu.hometel}</td>
                <td>${stu.registertime}</td>
                <td>${stu.studentstate}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
