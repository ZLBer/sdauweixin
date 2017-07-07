<%-- Created by IntelliJ IDEA.
  User: Minister
  Date: 2017/4/19
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<meta charset="utf-8">
<head>
    <style type="text/css">
        tr,td:nth-child(1){
            text-align: left;
			font-family:楷体;
        }
		th,td{
            border:2px solid gray;
            text-align:center;
            padding:3px 10px;
			font-family:楷体;
        }
        table{
            border-collapse:collapse;
            margin:0 auto;
			border-radius:15px;
			overflow:hidden;
			background:#E0ECFF;
        }
    </style>
    <link rel="stylesheet" href="dateChooser/BeatPicker.css"/>
    <link rel="stylesheet" href="dateChooser/search.css"/>
    <title><font face="楷体" color="#000066">完善个人信息</font></title>
    <script typet="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="dateChooser/BeatPicker.js"></script>
    <script type="text/javascript" src="dateChooser/ajax.js"></script>
    <script type="text/javascript">
        $(function(){
            var collegeArray = ["体艺学院","国交学院","化学院","信息学院","水土学院","文法学院",
                "外语学院","生科学院","食科学院","经管学院","机电学院","动科学院","园艺学院","林学院","资环学院","植保学院","农学院"];
            var collegeSelectBox = $("#college");
            for (var i = 0;i<collegeArray.length;i++){
                if(i==(${stu.studentcollege}-1)){
                    collegeSelectBox.append("<option selected>"+collegeArray[i]+"</option>");
                }else{
                    collegeSelectBox.append("<option>"+collegeArray[i]+"</option>");
                }
            }
        });
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
                var url="/admin/college_major";
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
                        $("#major").append("<option>"+majorlist[i]+"</option>");
                }
            }
        }
    </script>
</head>
<body>
    <center>
    <h1>完善个人信息</h1>
    <%--<form action="inputStuInfoServlet" method="post">--%>
    <form action="${pageContext.request.contextPath}/student/gotoPreviewServlet" method="post">
        <table frame="void">
            <%--<tr>--%>
                <%--<td >考生号</td>--%>
                <%--<td><input name="examid" type="text" value="${stu.examid}"></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td >民族</td>--%>
                <%--<td>--%>
                    <%--<select name="stuNation">--%>
                        <%--<option value="汉族">汉族</option> <option value="蒙古族">蒙古族</option> <option value="回族">回族</option> <option value="藏族">藏族</option> <option value="维吾尔族">维吾尔族</option> <option value="苗族">苗族</option> <option value="彝族">彝族</option> <option value="壮族">壮族</option> <option value="布依族">布依族</option> <option value="朝鲜族">朝鲜族</option> <option value="满族">满族</option> <option value="侗族">侗族</option> <option value="瑶族">瑶族</option> <option value="白族">白族</option> <option value="土家族">土家族</option> <option value="哈尼族">哈尼族</option> <option value="哈萨克族">哈萨克族</option> <option value="傣族">傣族</option> <option value="黎族">黎族</option> <option value="傈僳族">傈僳族</option> <option value="佤族">佤族</option> <option value="畲族">畲族</option> <option value="高山族">高山族</option> <option value="拉祜族">拉祜族</option> <option value="水族">水族</option> <option value="东乡族">东乡族</option> <option value="纳西族">纳西族</option> <option value="景颇族">景颇族</option> <option value="柯尔克孜族">柯尔克孜族</option> <option value="土族">土族</option> <option value="达斡尔族">达斡尔族</option> <option value="仫佬族">仫佬族</option> <option value="羌族">羌族</option> <option value="布朗族">布朗族</option> <option value="撒拉族">撒拉族</option> <option value="毛南族">毛南族</option> <option value="仡佬族">仡佬族</option> <option value="锡伯族">锡伯族</option> <option value="阿昌族">阿昌族</option> <option value="普米族">普米族</option> <option value="塔吉克族">塔吉克族</option> <option value="怒族">怒族</option> <option value="乌孜别克族">乌孜别克族</option> <option value="俄罗斯族">俄罗斯族</option> <option value="鄂温克族">鄂温克族</option> <option value="德昂族">德昂族</option> <option value="保安族">保安族</option> <option value="裕固族">裕固族</option> <option value="京族">京族</option> <option value="塔塔尔族">塔塔尔族</option> <option value="独龙族">独龙族</option> <option value="鄂伦春族">鄂伦春族</option> <option value="赫哲族">赫哲族</option> <option value="门巴族">门巴族</option> <option value="珞巴族">珞巴族</option> <option value="基诺族">基诺族</option>--%>
                    <%--</select>--%>
                <%--</td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td >身份证号</td>--%>
                <%--<td><input name="stuNum" type="text" value="${stu.studentnumber}"></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td >政治面貌</td>--%>
                <%--<td>--%>
                   <%--<select name="political">--%>
                        <%--<option <c:if test="${stu.political}=='群众'">selected</c:if>>群众</option>--%>
                        <%--<option <c:if test="${stu.political}=='共青团员'">selected</c:if>>共青团员</option>--%>
                        <%--<option <c:if test="${stu.political}=='中共预备党员'">selected</c:if>>中共预备党员</option>--%>
                        <%--<option <c:if test="${stu.political}=='中共党员'">selected</c:if>>中共党员</option>--%>
                        <%--<option <c:if test="${stu.political}=='无党派民主人士'">selected</c:if>>无党派民主人士</option>--%>
                        <%--<option <c:if test="${stu.political}=='台盟盟员'">selected</c:if>>台盟盟员</option>--%>
                        <%--<option <c:if test="${stu.political}=='民进会员'">selected</c:if>>民进会员</option>--%>
                        <%--<option <c:if test="${stu.political}=='九三学社社员'">selected</c:if>>九三学社社员</option>--%>
                        <%--<option <c:if test="${stu.political}=='民建会员'">selected</c:if>>民建会员</option>--%>
                        <%--<option <c:if test="${stu.political}=='致公党党员'">selected</c:if>>致公党党员</option>--%>
                        <%--<option <c:if test="${stu.political}=='民革会员'">selected</c:if>>民革会员</option>--%>
                        <%--<option <c:if test="${stu.political}=='农工党党员'">selected</c:if>>农工党党员</option>--%>
                        <%--<option <c:if test="${stu.political}=='民主党派'">selected</c:if>>民主党派</option>--%>
                        <%--<option <c:if test="${stu.political}=='民盟盟员'">selected</c:if>>民盟盟员</option>--%>
                    <%--</select>--%>
                <%--</td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td >学历</td>--%>
                <%--<td>--%>
                    <%--<select name="education">--%>
                        <%--<option <c:if test="${stu.education}=='博士生毕业'">selected</c:if>>博士生毕业</option>--%>
                        <%--<option <c:if test="${stu.education}=='博士生结业'">selected</c:if>>博士生结业</option>--%>
                        <%--<option <c:if test="${stu.education}=='博士生肄业'">selected</c:if>>博士生肄业</option>--%>
                        <%--<option <c:if test="${stu.education}=='双学位毕业'">selected</c:if>>双学位毕业</option>--%>
                        <%--<option <c:if test="${stu.education}=='本科生毕业'">selected</c:if>>本科生毕业</option>--%>
                        <%--<option <c:if test="${stu.education}=='本科生结业'">selected</c:if>>本科生结业</option>--%>
                        <%--<option <c:if test="${stu.education}=='本科生肄业'">selected</c:if>>本科生肄业</option>--%>
                        <%--<option <c:if test="${stu.education}=='硕士生毕业'">selected</c:if>>硕士生毕业</option>--%>
                        <%--<option <c:if test="${stu.education}=='硕士生结业'">selected</c:if>>硕士生结业</option>--%>
                        <%--<option <c:if test="${stu.education}=='硕士生肄业'">selected</c:if>>硕士生肄业</option>--%>
                    <%--</select>--%>
                <%--</td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td >班级</td>--%>
                <%--<td>--%>
                    <%--<select name="stuClass">--%>
                        <%--<c:forEach var="i" begin="1" end="20">--%>
                            <%--<option value="${i}">${i}班</option>--%>
                        <%--</c:forEach>--%>
                    <%--</select>--%>
                <%--</td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td >培养方式</td>--%>
                <%--<td>--%>
                    <%--<select name="trainMod">--%>
                        <%--<option <c:if test="${stu.universityname}=='定向'">selected</c:if>>定向</option>--%>
                        <%--<option <c:if test="${stu.universityname}=='非定向'">selected</c:if>>非定向</option>--%>
                    <%--</select>--%>
                <%--</td>--%>
            <%--</tr>--%>
            <tr>
                <td >辅修专业</td>
                <td><input name="minor"></td>
            </tr>
            <%--<tr>--%>
                <%--<td >学制</td>--%>
                <%--<td>--%>
                    <%--<select name="length">--%>
                        <%--<option value="4">4年制</option>--%>
                        <%--<option value="5">5年制</option>--%>
                    <%--</select>--%>
                <%--</td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td >出生日期</td>--%>
                <%--<td><input type="text" data-beatpicker="true" name="stuBirth"></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td >学位</td>--%>
                <%--<td>--%>
                    <%--<select name="degree">--%>
                        <%--<option>学士</option>--%>
                        <%--<option>硕士</option>--%>
                        <%--<option>博士</option>--%>
                    <%--</select>--%>
                <%--</td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td >主修外语语种</td>--%>
                <%--<td>--%>
                    <%--<select name="mForeign">--%>
                        <%--<option>英语</option>--%>
                        <%--<option>俄语</option>--%>
                        <%--<option>日语</option>--%>
                        <%--<option>法语</option>--%>
                        <%--<option>德语</option>--%>
                    <%--</select>--%>
                <%--</td>--%>
            <%--</tr>--%>
            <tr>
                <td >外语水平</td>
                <td>
                    <select name="foreignLevel">
                        <option value=" ">无</option>
                        <option>四级</option>
                        <option>六级</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td >计算机水平</td>
                <td>
                    <select name="comLevel">
                        <option value=" ">无</option>
                        <option>二级</option>
                        <option>三级</option>
                        <option>四级</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td >职业资格</td>
                <td><input name="vocational" type="text" value=""></td>
            </tr>
            <%--<tr>--%>
                <%--<td >入学年份</td>--%>
                <%--<td><input type="text" data-beatpicker="true" name="enterYear"></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td >毕业时间</td>--%>
                <%--<td><input type="text" data-beatpicker="true" name="graduTime"></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td >是否定向培养</td>--%>
                <%--<td>--%>
                    <%--<select name="isWeipei">--%>
                        <%--<option>否</option>--%>
                        <%--<option>是</option>--%>
                    <%--</select>--%>
                <%--</td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td >委培定向单位</td>--%>
                <%--<td><input name="weipeiUtil" type="text" value="${stu.weipeiunit}"></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td >委培单位所在地</td>--%>
                <%--<td><input name="weipeiLoca" type="text" value="${stu.weipeilocation}"></td>--%>
            <%--</tr>--%>
            <tr>
                <td >常住地址详细（街道门牌号）</td>
                <td><input name="residentDetail" type="text" value="${stu.residentdetailed}"></td>
            </tr>
             <tr>
                <td >常住地址乡镇街道办事处</td>
                <td>
                    <div class="gover_search">
                        <div class="gover_search_form clearfix">
                            <input type="text" class="input_search_key" id="gover_search_key" placeholder="请输入关键词直接选取" value="${stu.residentoffice}" name="residentOffice"/>
                            <div class="search_suggest" id="gov_search_suggest">
                                <ul>
                                </ul>
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <td >常住地址乡镇街道办事处描述</td>
                <td><input name="residentAddress" type="text" value="${stu.residentaddress}"></td>
            </tr>
            <tr>
                <td >现户籍所在地详细（街道门牌号）</td>
                <td><input name="registerDetail" type="text" value="${stu.registerdetailed}"></td>
            </tr>
            <tr>
                <td >现户籍地址乡镇街道办事处</td>
                <td>
                    <div class="gover_search">
                        <div class="gover_search_form clearfix">
                            <input type="text" class="input_search_key" id="gover_search_key1" placeholder="请输入关键词直接选取" name="registerOffice" value="${stu.registeroffice}"/>
                            <div class="search_suggest" id="gov_search_suggest1">
                                <ul>
                                </ul>
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <td >现户籍地址乡镇街道办事处描述</td>
                <td><input name="registerAddress" type="text" value="${stu.registeraddress}"></td>
            </tr>
            <tr>
                <td >户籍性质</td>
                <td>
                    <select name="type">
                        <option>农业户口</option>
                        <option>非农业户口</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td >户籍登记日期</td>
                <td><input type="text" data-beatpicker="true" name="stuBirth"></td>
            </tr>
            <tr>
                <td >个人联系电话</td>
                <td><input name="tel" type="text" value="${stu.studenttel}"></td>
            </tr>
            <tr>
                <td >家庭常用联系电话</td>
                <td><input name="homeTel" type="text" value="${stu.hometel}"></td>
            </tr>
            <tr>
                <td >E-mail</td>
                <td><input name="email" type="text" value="${stu.studentemail}"></td>
            </tr>
            <tr style="text-align: center">
                <td><input type="submit" value="预览"></td>
                <td><input type="reset" value="重填"></td>
            </tr>
        </table>
    </form>
    </center>
</body>
<script type="text/javascript" src="dateChooser/searchJs.js"></script>
<script type="text/javascript" src="dateChooser/searchJs1.js"></script>
</html>