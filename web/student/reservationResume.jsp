<%--
  Created by IntelliJ IDEA.
  User: Minister
  Date: 2017/9/9
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<meta charset="utf-8">
<head>
    <title></title>
    <script typet="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
    <script>
        $(function () {
            getData()
            $("#location").bind("change",getData);
        });
        function getData() {
            $("#teacher").html("");
            var location = $("#location>option:selected").text();
            var url="${pageContext.request.contextPath}/student/getTeacherListServlet";
            var param = {location:encodeURI(location)};
            var dataType = "json";
            $.get(url,param,function (data) {
                teacherList = data;
                for(var i=0;i<teacherList.length;i++){
                    $("#teacher").append("<option>"+teacherList[i]+"</option>");
                }
            },dataType);
        }
        
   </script>
    <style>
    	.div
    	{
    		background-color: #E0ECFF;
    		text-align:center;
    		margin: 0 auto;
    		width: 170px;
    		height: 80px;
    		border-radius: 10px;
    	}
    	.form
    	{
    		padding-top: 10px;
    	}
     </style>
</head>
<body>
	<center><font size="+2" face="楷体">简历预约</font></center>
	<p></p>
	<div class="div">
<form action="${pageContext.request.contextPath}/student/reservationServlet" method="post" class="form">
    <select name="location" id="location">
        <option>南校区</option>
        <option>北校区</option>
        <option>东校区</option>
    </select>
    <select name="teacher" id="teacher">
        <option value="">请选择校区</option>
    </select><br />
    <p></p>
    <input type="submit" value="预约">
</form>
</div>
</body>
</html>
