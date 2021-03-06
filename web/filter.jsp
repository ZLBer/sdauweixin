<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: john
  Date: 2017/5/6
  Time: 20:37
  To change this template use File | Settings | File Templates.
  Description: 本页面用于展示更多招聘信息。
  需要如下参数：
  pageNo: 需要显示第几页数据
  columnId: 栏目Id
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>select.html</title>
    <meta http-equiv="Content-type" content="text/html;charset=UTF-8"/>
    <script type="text/javascript" src="js/ajax.js"></script>
    <script type="text/javascript">
        function refresh()
        {

            var c=document.getElementById("college").value;
            var major=document.getElementById("major");
            if(c=="")
            {
                major.length=0;
                major.options.add(new Option("--请选择专业--"));
            }
            else{
                var url="college_major";
                var params="coll="+c;
                sendRequest(url,params,'POST',show);
            }
        }
        function show()
        {
            var major=document.getElementById("major");
            if(httpRequest.readyState==4){
                if(httpRequest.status==200)
                {
                    var majorlist=httpRequest.responseText.split(",");
                    var majornum=majorlist.length;
                    major.length=0;
                    for(i=0;i<majornum;i++)
                        major.options.add(new Option(majorlist[i]));
                }
            }
        }
    </script>
    <style>
        a:link
        {
            color: black;
            text-decoration: none;
        }
	/*div{
	width: 100%;
	height: 50px;
	position: fixed;
	bottom: 0;
	left:0;
	}*/
        .div1
        {
            padding-top: 0px;
            height: 40px;
            text-align: center;
            background: none;
        }
	</style>
</head>

<body background="images/beijing.jpg">

<center>
    <div class="div1">
<form action="demand_query" >
    <select name="college" id="college" onchange="refresh()"  style="width:150px">
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
    <select name="major" id="major"  style="width:150px">
        <option>--请选择专业－－</option>
    </select>
    <input type="submit" value="查询"   style="width:50px;height:30px">
</form>
    <%
        String pageNo = request.getParameter("pageNo");
        if(pageNo==null||pageNo.equals("")) pageNo = "1";
        pageContext.setAttribute("pageNo",pageNo);
        String columnId = request.getParameter("columnId");
        if(columnId==null||pageNo.equals("")) columnId = "1";
        pageContext.setAttribute("columnId",columnId);
    %>
    <c:import url="getMoreServlet?pageNo=${pageNo}&columnId=${columnId}"/>
    <a href="main.jsp">返回上一页</a>
</div>
<div style="bottom:0; left:0; position:absolute; width:100%"><img src="images/dibu.jpg" style="width:100%;height:150px"></div>

</center>
</body>
</html>
