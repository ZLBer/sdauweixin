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
<tr><td>民族</td>
    <td><select name="studentnation">
        <option <c:if test="${stu.studentnation=='汉族'}">selected</c:if>>汉族</option>
        <option <c:if test="${stu.studentnation=='蒙古族'}">selected</c:if>>蒙古族</option>
        <option <c:if test="${stu.studentnation=='回族'}">selected</c:if>>回族</option>
        <option <c:if test="${stu.studentnation=='藏族'}">selected</c:if>>藏族</option>
        <option <c:if test="${stu.studentnation=='维吾尔族'}">selected</c:if>>维吾尔族</option>
        <option <c:if test="${stu.studentnation=='苗族'}">selected</c:if>>苗族</option>
        <option <c:if test="${stu.studentnation=='彝族'}">selected</c:if>>彝族</option>
        <option <c:if test="${stu.studentnation=='壮族'}">selected</c:if>>壮族</option>
        <option <c:if test="${stu.studentnation=='布依族'}">selected</c:if>>布依族</option>
        <option <c:if test="${stu.studentnation=='朝鲜族'}">selected</c:if>>朝鲜族</option>
        <option <c:if test="${stu.studentnation=='满族'}">selected</c:if>>满族</option>
        <option <c:if test="${stu.studentnation=='侗族'}">selected</c:if>>侗族</option>
        <option <c:if test="${stu.studentnation=='瑶族'}">selected</c:if>>瑶族</option>
        <option <c:if test="${stu.studentnation=='白族'}">selected</c:if>>白族</option>
        <option <c:if test="${stu.studentnation=='土家族'}">selected</c:if>>土家族</option>
        <option <c:if test="${stu.studentnation=='哈尼族'}">selected</c:if>>哈尼族</option>
        <option <c:if test="${stu.studentnation=='哈萨克族'}">selected</c:if>>哈萨克族</option>
        <option <c:if test="${stu.studentnation=='傣族'}">selected</c:if>>傣族</option>
        <option <c:if test="${stu.studentnation=='黎族'}">selected</c:if>>黎族</option>
        <option <c:if test="${stu.studentnation=='傈僳族'}">selected</c:if>>傈僳族</option>
        <option <c:if test="${stu.studentnation=='佤族'}">selected</c:if>>佤族</option>
        <option <c:if test="${stu.studentnation=='畲族'}">selected</c:if>>畲族</option>
        <option <c:if test="${stu.studentnation=='高山族'}">selected</c:if>>高山族</option>
        <option <c:if test="${stu.studentnation=='拉祜族'}">selected</c:if>>拉祜族</option>
        <option <c:if test="${stu.studentnation=='水族'}">selected</c:if>>水族</option>
        <option <c:if test="${stu.studentnation=='东乡族'}">selected</c:if>>东乡族</option>
        <option <c:if test="${stu.studentnation=='纳西族'}">selected</c:if>>纳西族</option>
        <option <c:if test="${stu.studentnation=='景颇族'}">selected</c:if>>景颇族</option>
        <option <c:if test="${stu.studentnation=='柯尔克孜族'}">selected</c:if>>柯尔克孜族</option>
        <option <c:if test="${stu.studentnation=='土族'}">selected</c:if>>土族</option>
        <option <c:if test="${stu.studentnation=='达斡尔族'}">selected</c:if>>达斡尔族</option>
        <option <c:if test="${stu.studentnation=='仫佬族'}">selected</c:if>>仫佬族</option>
        <option <c:if test="${stu.studentnation=='羌族'}">selected</c:if>>羌族</option>
        <option <c:if test="${stu.studentnation=='布朗族'}">selected</c:if>>布朗族</option>
        <option <c:if test="${stu.studentnation=='撒拉族'}">selected</c:if>>撒拉族</option>
        <option <c:if test="${stu.studentnation=='毛南族'}">selected</c:if>>毛南族</option>
        <option <c:if test="${stu.studentnation=='仡佬族'}">selected</c:if>>仡佬族</option>
        <option <c:if test="${stu.studentnation=='锡伯族'}">selected</c:if>>锡伯族</option>
        <option <c:if test="${stu.studentnation=='阿昌族'}">selected</c:if>>阿昌族</option>
        <option <c:if test="${stu.studentnation=='普米族'}">selected</c:if>>普米族</option>
        <option <c:if test="${stu.studentnation=='塔吉克族'}">selected</c:if>>塔吉克族</option>
        <option <c:if test="${stu.studentnation=='怒族'}">selected</c:if>>怒族</option>
        <option <c:if test="${stu.studentnation=='乌孜别克族'}">selected</c:if>>乌孜别克族</option>
        <option <c:if test="${stu.studentnation=='俄罗斯族'}">selected</c:if>>俄罗斯族</option>
        <option <c:if test="${stu.studentnation=='鄂温克族'}">selected</c:if>>鄂温克族</option>
        <option <c:if test="${stu.studentnation=='德昂族'}">selected</c:if>>德昂族</option>
        <option <c:if test="${stu.studentnation=='保安族'}">selected</c:if>>保安族</option>
        <option <c:if test="${stu.studentnation=='裕固族'}">selected</c:if>>裕固族</option>
        <option <c:if test="${stu.studentnation=='京族'}">selected</c:if>>京族</option>
        <option <c:if test="${stu.studentnation=='塔塔尔族'}">selected</c:if>>塔塔尔族</option>
        <option <c:if test="${stu.studentnation=='独龙族'}">selected</c:if>>独龙族</option>
        <option <c:if test="${stu.studentnation=='塔塔尔族'}">selected</c:if>>塔塔尔族</option>
        <option <c:if test="${stu.studentnation=='鄂伦春族'}">selected</c:if>>鄂伦春族</option>
        <option <c:if test="${stu.studentnation=='赫哲族'}">selected</c:if>>赫哲族</option>
        <option <c:if test="${stu.studentnation=='门巴族'}">selected</c:if>>门巴族</option>
        <option <c:if test="${stu.studentnation=='珞巴族'}">selected</c:if>>珞巴族</option>
        <option <c:if test="${stu.studentnation=='基诺族'}">selected</c:if>>基诺族</option>
    </select></td></tr>
<tr><td>身份证号</td><td><input type="text" name="studentnumber" value="${stu.studentnumber}"/></td></tr>
<tr><td>政治面貌</td><td>
    <select name="political">
    <option <c:if test="${stu.political=='群众'}">selected</c:if>>群众</option>
    <option <c:if test="${stu.political=='共青团员'}">selected</c:if>>共青团员</option>
    <option <c:if test="${stu.political=='中共预备党员'}">selected</c:if>>中共预备党员</option>
    <option <c:if test="${stu.political=='中共党员'}">selected</c:if>>中共党员</option>
    <option <c:if test="${stu.political=='无党派民主人士'}">selected</c:if>>无党派民主人士</option>
    <option <c:if test="${stu.political=='台盟盟员'}">selected</c:if>>台盟盟员</option>
    <option <c:if test="${stu.political=='民进会员'}">selected</c:if>>民进会员</option>
    <option <c:if test="${stu.political=='九三学社社员'}">selected</c:if>>九三学社社员</option>
    <option <c:if test="${stu.political=='民建会员'}">selected</c:if>>民建会员</option>
    <option <c:if test="${stu.political=='致公党党员'}">selected</c:if>>致公党党员</option>
    <option <c:if test="${stu.political=='民革会员'}">selected</c:if>>民革会员</option>
    <option <c:if test="${stu.political=='农工党党员'}">selected</c:if>>农工党党员</option>
    <option <c:if test="${stu.political=='民主党派'}">selected</c:if>>民主党派</option>
    <option <c:if test="${stu.political=='民盟盟员'}">selected</c:if>>民盟盟员</option>
    </select>
    </td></tr>
<tr><td>学历</td><td>
    <select name="education">
     <option <c:if test="${stu.education=='本科生毕业'}">selected</c:if>>本科生毕业</option>
    <option <c:if test="${stu.education=='博士生毕业'}">selected</c:if>>博士生毕业</option>
    <option <c:if test="${stu.education=='博士生结业'}">selected</c:if>>博士生结业</option>
    <option <c:if test="${stu.education=='博士生肄业'}">selected</c:if>>博士生肄业</option>
    <option <c:if test="${stu.education=='双学位毕业'}">selected</c:if>>双学位毕业</option>

    <option <c:if test="${stu.education=='本科生结业'}">selected</c:if>>本科生结业</option>
    <option <c:if test="${stu.education=='本科生肄业'}">selected</c:if>>本科生肄业</option>
    <option <c:if test="${stu.education=='硕士生毕业'}">selected</c:if>>硕士生毕业</option>
    <option <c:if test="${stu.education=='硕士生结业'}">selected</c:if>>硕士生结业</option>
    <option <c:if test="${stu.education=='硕士生肄业'}">selected</c:if>>硕士生肄业</option>
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
<tr><td>外语水平</td>
    <td>
    <select name="foreignlevel">
        <option <c:if test="${stu.foreignlevel==''}">selected</c:if>>无</option>
        <option <c:if test="${stu.foreignlevel=='四级'}">selected</c:if>>四级</option>
        <option <c:if test="${stu.foreignlevel=='六级'}">selected</c:if>>六级</option>
    </select>
    </td>
</tr>
<tr><td>计算机水平</td><td>
    <select name="comlevel">
        <option <c:if test="${stu.comlevel==' '}">selected</c:if>>无</option>
        <option <c:if test="${stu.comlevel=='二级'}">selected</c:if>>二级</option>
        <option <c:if test="${stu.comlevel=='三级'}">selected</c:if>>三级</option>
        <option <c:if test="${stu.comlevel=='四级'}">selected</c:if>>四级</option>
    </select>
</td></tr>
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
<tr><td>户籍性质</td><td>
    <select name="tpye">
        <option <c:if test="${stu.tpye=='农业户口'}">selected</c:if>>农业户口</option>
        <option <c:if test="${stu.tpye=='非农业户口'}">selected</c:if>>非农业户口</option>
    </select>
</td></tr>
<tr><td>职业资格</td><td><input type="text"name="vocational" value="${stu.vocational}"/></td></tr>
<tr><td>家庭常用联系电话</td><td><input type="text"name="hometel" value="${stu.hometel}"/></td></tr>
<tr><td>户籍登记日期</td><td><input type="text" name="registertime"value="${stu.registertime}"/></td></tr>
<tr><td>学生状态</td><td><input type="radio" value="通过" name="studentstate" <c:if  test="${stu.studentstate=='通过'}">checked</c:if>/>通过&nbsp;<input type="radio" value="未通过" name="studentstate" <c:if  test="${stu.studentstate=='未通过'}">checked</c:if>/>未通过</td></tr>
</table>
    <input type="submit" value="提交修改">
</form>
</body>
</html>
