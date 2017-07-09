<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="po.StudentEntity" %>
<%@ page import="util.HibernateUtil" %><%--
  Created by IntelliJ IDEA.
  User: libin
  Date: 2017/7/9
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改学生信息</title>
</head>
<body>
<%
    int studentid=Integer.parseInt(request.getParameter("studentid"));
    StudentEntity stu=(StudentEntity) HibernateUtil.get(StudentEntity.class,studentid);
    pageContext.setAttribute("stu",stu);
%>
<form action="${pageContext.request.contextPath}/college/modifyStudentInfo" method="post">
<table>
    <tr><td>学号</td><td><input type="text" name="studentid" value="${stu.studentid}"/></td></tr>
<tr><td>考生号</td><td><input type="text" name="examid" value="${stu.examid}"/></td></tr>
<tr><td>姓名</td><td><input type="text"  name="studentname" value="${stu.studentname}"/></td></tr>
<tr><td>性别  </td><td> <input type="radio" value="男" name="studentsex" <c:if  test="${stu.studentsex=='男'}">checked</c:if>/>男 &nbsp;  <input type="radio" value="女" name="studentsex" <c:if  test="${stu.studentsex=='女'}">checked</c:if>/>女</td></tr>
<tr><td>民族</td><td><input type="text" name="studentnation" value="${stu.studentnation}"/></td></tr>
<tr><td>身份证号</td><td><input type="text" name="studentnumber" value="${stu.studentnumber}"/></td></tr>
<tr><td>政治面貌</td><td>
    <select name="political">
    <option <c:if test="${stu.political}=='群众'">selected</c:if>>群众</option>
    <option <c:if test="${stu.political}=='共青团员'">selected</c:if>>共青团员</option>
    <option <c:if test="${stu.political}=='中共预备党员'">selected</c:if>>中共预备党员</option>
    <option <c:if test="${stu.political}=='中共党员'">selected</c:if>>中共党员</option>
    <option <c:if test="${stu.political}=='无党派民主人士'">selected</c:if>>无党派民主人士</option>
    <option <c:if test="${stu.political}=='台盟盟员'">selected</c:if>>台盟盟员</option>
    <option <c:if test="${stu.political}=='民进会员'">selected</c:if>>民进会员</option>
    <option <c:if test="${stu.political}=='九三学社社员'">selected</c:if>>九三学社社员</option>
    <option <c:if test="${stu.political}=='民建会员'">selected</c:if>>民建会员</option>
    <option <c:if test="${stu.political}=='致公党党员'">selected</c:if>>致公党党员</option>
    <option <c:if test="${stu.political}=='民革会员'">selected</c:if>>民革会员</option>
    <option <c:if test="${stu.political}=='农工党党员'">selected</c:if>>农工党党员</option>
    <option <c:if test="${stu.political}=='民主党派'">selected</c:if>>民主党派</option>
    <option <c:if test="${stu.political}=='民盟盟员'">selected</c:if>>民盟盟员</option>
    </select>
    </td></tr>
<tr><td>学历</td><td>
    <select name="education">
    <option <c:if test="${stu.education}=='博士生毕业'">selected</c:if>>博士生毕业</option>
    <option <c:if test="${stu.education}=='博士生结业'">selected</c:if>>博士生结业</option>
    <option <c:if test="${stu.education}=='博士生肄业'">selected</c:if>>博士生肄业</option>
    <option <c:if test="${stu.education}=='双学位毕业'">selected</c:if>>双学位毕业</option>
    <option <c:if test="${stu.education}=='本科生毕业'">selected</c:if>>本科生毕业</option>
    <option <c:if test="${stu.education}=='本科生结业'">selected</c:if>>本科生结业</option>
    <option <c:if test="${stu.education}=='本科生肄业'">selected</c:if>>本科生肄业</option>
    <option <c:if test="${stu.education}=='硕士生毕业'">selected</c:if>>硕士生毕业</option>
    <option <c:if test="${stu.education}=='硕士生结业'">selected</c:if>>硕士生结业</option>
    <option <c:if test="${stu.education}=='硕士生肄业'">selected</c:if>>硕士生肄业</option>
    </select>
</td></tr>
<tr><td>专业</td><td><input type="text"name="studentmajor" value="${stu.studentmajor}"/></td></tr>
<tr><td>培养方式</td><td><input type="text"name="trainingmode" value="${stu.trainingmode}"/></td></tr>
<tr><td>生源所在地</td><td><input type="text"name="location" value="${stu.location}"/></td></tr>
<tr><td>学制</td><td><input type="text"name="length" value="${stu.length}"/></td></tr>
<tr><td>辅修专业</td><td><input type="text"name="minor" value="${stu.minor}"/></td></tr>
<tr><td>出生日期</td><td><input type="text"name="studentbirthday" value="${stu.studentbirthday}"/></td></tr>
<tr><td>学位</td><td><input type="text" name="degree"value="${stu.degree}"/></td></tr>
<tr><td>主修外语语种</td><td><input type="text"name="majorforeign" value="${stu.majorforeign}"/></td></tr>
<tr><td>外语水平</td><td><input type="text"name="foreignlevel" value="${stu.foreignlevel}"/></td></tr>
<tr><td>计算机水平</td><td><input type="text" name="comlevel"value="${stu.comlevel}"/></td></tr>
<tr><td>入学年份</td><td><input type="text"name="enteryear" value="${stu.enteryear}"/></td></tr>
<tr><td>毕业时间</td><td><input type="text"name="" value="${stu.graduationtime}"/></td></tr>
<tr><td>是否定向培养</td><td><input type="text"name="universityname" value="${stu.universityname}"/></td></tr>-
<tr><td>委培定向单位</td><td><input type="text"name="weipeiunit" value="${stu.weipeiunit}"/></td></tr>
<tr><td>委培单位所在地</td><td><input type="text"name="weipeilocation" value="${stu.weipeilocation}"/></td></tr>
<tr><td>院系</td><td><input type="text"name="studentcollege" value="${stu.studentcollege}"/></td></tr>
<tr><td>常住地市区县</td><td><input type="text" name="resident"value="${stu.resident}"/></td></tr>
<tr><td>现户籍所在地市区县</td><td><input type="text" name="register"value="${stu.register}"/></td></tr>
<tr><td>常住地址详细</td><td><input type="text"name="residentdetailed" value="${stu.residentdetailed}"/></td></tr>
<tr><td>现户籍所在地详细</td><td><input type="text"name="registerdetailed" value="${stu.registerdetailed}"/></td></tr>
<tr><td>班级</td><td><input type="text" name=""value="${stu.studentclass}"/></td></tr>
<tr><td>常住地乡镇街道办事处</td><td><input type="text"name="residentoffice" value="${stu.residentoffice}"/></td></tr>
<tr><td>常住地乡镇街道办事处描述</td><td><input type="text"name="residentaddress" value="${stu.residentaddress}"/></td></tr>
<tr><td>现户籍所在地乡镇记街道办事处</td><td><input type="text" name="registeroffice"value="${stu.registeroffice}"/></td></tr>
<tr><td>现户籍所在地乡镇记街道办事处描述</td><td><input type="text"name="registeraddress" value="${stu.registeraddress}"/></td></tr>
<tr><td>户籍性质</td><td><input type="text"name="tpye" value="${stu.tpye}"/></td></tr>
<tr><td>职业资格</td><td><input type="text"name="vocational" value="${stu.vocational}"/></td></tr>
<tr><td>家庭常用联系电话</td><td><input type="text"name="hometel" value="${stu.hometel}"/></td></tr>
<tr><td>户籍登记日期</td><td><input type="text" name="registertime"value="${stu.registertime}"/></td></tr>
<tr><td>学生状态</td><td><input type="radio" value="通过" name="studentstate" <c:if  test="${stu.studentstate=='通过'}">checked</c:if>/>通过&nbsp;<input type="radio" value="未通过" name="studentstate" <c:if  test="${stu.studentstate=='未通过'}">checked</c:if>/>未通过</td></tr>
</table>
    <input type="submit" value="提交修改">
</form>
</body>
</html>
