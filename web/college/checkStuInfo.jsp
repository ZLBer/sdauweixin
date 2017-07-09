<%--
  Created by IntelliJ IDEA.
  User: Minister
  Date: 2017/4/21
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="css/IconExtension.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<head>
    <style type="text/css">
        *{
            font-size: 1em;
        }
        #count {
            margin-top:20px;
            width: 40%;
        }
        #info_table{
            width: 50%;
            margin-top:20px;
            margin-bottom:20px;
        }
        #page_box{
            margin-bottom:20px ;
        }
        th,td{
            border:2px solid gray;
            text-align:center;
            padding:3px 10px;
            font-family:楷体;
        }
    </style>

    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/ajax.js"></script>
    <script>
        function loadCollege() {
            var url="${pageContext.request.contextPath}/college/college_list";//          5/23 liyanze
            var params="coll="+${collegeId};
            sendRequest(url,params,'POST',show);
        }
        function show() {
            var major=$("#major");
            if(httpRequest.readyState==4){
                if(httpRequest.status==200)
                {
                    var majorlist=httpRequest.responseText.split(",");
                    var majornum=majorlist.length;
                    for(i=0;i<majornum-1;i++){
                        if(majorlist[i]==='${major}') {
                            major.append("<option selected>" + majorlist[i] + "</option>");
                        } else {
                            major.append("<option>" + majorlist[i] + "</option>");
                        }
                    }
                }
            }
        }
        function areYouSure(stuId){
            if(window.confirm("确定要重置学号为"+stuId+"的学生信息吗？")){
                window.location.href="resetStuInfoServlet?batch=false&stuId="+stuId;
            }
        }
        function loadOption(){
            if(httpRequest.readyState==4&&httpRequest.status==200){
            }
        }
        function onLoad(){
            sendRequest("GetCollegeNameServlet",null,"GET",loadOption)
        }
        function selectAll(){
            var state = $("#select_all").prop("checked");
            if(state==true){
                $("#select_all").prop("checked",false)
                $(".stuSelectId").prop("checked",false);
            }else{
                $("#select_all").prop("checked",true)
                $(".stuSelectId").prop("checked",true);
            }
        }
        $(document).ready(function(){
            loadCollege();
            $("#select_all").click(function () {
                var state = $("#select_all").prop("checked");
                $(".stuSelectId").prop("checked",state);
            });
        });
    </script>
    <title>审核学生信息</title>
</head>
<body>
<center>
    <h1 style="font-size: 2em"><font size="+3" color="#000066" face="楷体">审核学生信息</font></h1>
    <div id="count" style="margin-top:20px; margin-bottom:20px;">共查到 ${count} 条记录</div>
    <form action="packingCondition" method="post" name="filter">
        <div id="select_box">
            学号
            <input type="text" name="sno"/>
            专业
            <select id="major" name="major">
                <option value="0">-------所有专业-------</option>
            </select>&nbsp;&nbsp;
            班级
            <select id="class" name="class">
                <option value="all">所有</option>
                <% for(int i=1;i<=20;i++){%>
                    <option <% if (session.getAttribute("classes")!=null&&session.getAttribute("classes").equals(i+"班")){%>selected<%}%>><%=i%>班</option>
                <%}%>
            </select>&nbsp;&nbsp;

            性别
            <select id="sex" name="sex">
                <option value="all">所有</option>
                <option <c:if test="${sex=='男'}">selected</c:if>>男</option>
                <option <c:if test="${sex=='女'}">selected</c:if>>女</option>
            </select>&nbsp;&nbsp;
            状态
            <select id="state" name="state">
                <option value="all">所有</option>
                <option <c:if test="${state=='提交'}">selected</c:if>>提交</option>
                <option <c:if test="${state=='通过'}">selected</c:if>>通过</option>
                <option <c:if test="${state=='重填'}">selected</c:if>>重填</option>
            </select>&nbsp;&nbsp;
            <input type="submit" value="查询">&nbsp;&nbsp;
            <a href="javascript:document.filter.action='resetStuInfoServlet?batch=true';document.filter.submit();">批量重置</a>
            <a href="javascript:document.filter.action='passStuInfoServlet?batch=true';document.filter.submit();">批量通过</a>
        </div>

        <table border="1" id="info_table" border="1" frame="void" class="easyui-datagrid" id="content"
               rownumbers="true"  width="100%">
            <thead>
            <tr>
                <th data-options="field:'11'"><a id="select_all_a" href="javascript:selectAll()">全选</a></th>
                <th data-options="field:'1'">学号</th>
                <th data-options="field:'2'">姓名</th>
                <th data-options="field:'3'">性别</th>
                <th data-options="field:'4'">专业</th>
                <th data-options="field:'5'">班级</th>
                <th data-options="field:'6'">外语水平</th>
                <th data-options="field:'7'">计算机水平</th>
                <th data-options="field:'8'">政治面貌</th>
                <th data-options="field:'9'">状态</th>
                <th data-options="field:'10'">民族</th>
                <th data-options="field:'11'">电话</th>
                <th data-options="field:'12'">生源所在地</th>
                <th data-options="field:'13'">常住地址市区县</th>



                <th data-options="field:'14'">操作</th>




            </tr>
            </thead>
            <tbody>
            <c:forEach var="stu" items="${students}">
                <tr>
                    <td><input class="stuSelectId" type="checkbox" name="stuSelectId" value="${stu.studentid}"></td>
                    <td>${stu.studentid}</td>
                    <td>${stu.studentname}</td>
                    <td>${stu.studentsex}</td>
                    <td>${stu.studentmajor}</td>
                    <td>${stu.studentclass}</td>
                    <td>${stu.foreignlevel}</td>
                    <td>${stu.comlevel}</td>
                    <td>${stu.political}</td>
                    <td>${stu.studentstate}</td>
                    <td>${stu.studentnation}</td>
                     <td>${stu.studenttel}</td>
                      <td>${stu.location}</td>
                      <td>${stu.resident}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/college/modifyStudentInfo.jsp?studentid=${stu.studentid}">修改</a>
                        <a href="javascript:areYouSure(${stu.studentid})">重置</a>&nbsp;
                        <a href="passStuInfoServlet?batch=false&stuId=${stu.studentid}">通过</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>
    <div id="page_box">
        <%for (int i=(Integer) request.getAttribute("startPage")-1; i<(Integer) request.getAttribute("endPage");i++){
            out.print("<a href=javascript:document.filter.action='packingCondition?page="+(i+1)+"';document.filter.submit();>["+(i+1)+"]<a>&nbsp;");
        }%>
        &nbsp;&nbsp;当前第[${currentPage}]页
        &nbsp;&nbsp;共有[${pageCount}]页
    </div>
    <p><a  href="downloadStuInfoServlet?code=false">下载学生信息表格(.xlsx)</a></p>
    <br>
    <br>
    <br>
    <br>
</center>
</body>
</html>
