<%--
  Created by IntelliJ IDEA.
  User: C
  Date: 2017/5/11
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>添加专业和人数</title>
    <meta http-equiv="Content-type" content="text/html;charset=UTF-8"/>
    <script type="text/javascript" src="../js/ajax.js"></script>
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
                var url="college_list";
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
        body{
            text-align:center;
        }
        th,td{
            border:2px solid gray;
            text-align:center;
            padding:3px 10px;
        }
        table{
            border-collapse:collapse;
            margin:0 auto;
        }
    </style>
</head>

<body onload="refresh()">
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
            <table>
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
                        <td><a href='college_delete?majorid=${demand.majorid}' onclick="return confirm('确实要删除该 记录吗？')">删除</a></td>
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
<form action="college_insecond">
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
                <option>--请选择专业－－</option>
            </select>
        </tr>
        <br>
        <tr>
            <td>填写该专业需求人数<input type="text" name="demandnum" value="0"></td>
        </tr>
        <tr>
            <td> <input type="submit" value="添加">
                <a href="college_SendMessage?articleid=${article.articleid}">下一步</a></td>
        </tr>
    </table>
</form>

</body>
</html>
