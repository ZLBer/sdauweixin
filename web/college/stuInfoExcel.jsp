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
    <title>ѧ����Ϣ</title>
</head>
<body>

    <table border="1">
        <tr>
            <td>ѧ��</td>
            <td>������</td>
            <td>����</td>
            <td>�Ա�</td>
            <td>����</td>
            <td>���֤��</td>
            <td>������ò</td>
            <td>ѧ��</td>
            <td>רҵ</td>
            <td>������ʽ</td>
            <td>��Դ���ڵ�</td>
            <td>ѧ��</td>
            <td>����רҵ</td>
            <td>��������</td>
            <td>ѧλ</td>
            <td>������������</td>
            <td>����ˮƽ</td>
            <td>�����ˮƽ</td>
            <td>��ѧ���</td>
            <td>��ҵʱ��</td>
            <td>�Ƿ�������</td>
            <td>ί�ඨ��λ</td>
            <td>ί�൥λ���ڵ�</td>
            <td>Ժϵ</td>
            <td>��ס��������</td>
            <td>�ֻ������ڵ�������</td>
            <td>��ס��ַ��ϸ</td>
            <td>�ֻ������ڵ���ϸ</td>
            <td>�༶</td>
            <td>��ס������ֵ����´�</td>
            <td>��ס������ֵ����´�����</td>
            <td>�ֻ������ڵ�����ǽֵ����´�</td>
            <td>�ֻ������ڵ�����ǽֵ����´�����</td>
            <td>��������</td>
            <td>ְҵ�ʸ�</td>
            <td>��ͥ������ϵ�绰</td>
            <td>�����Ǽ�����</td>
            <td>ѧ��״̬</td>
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
