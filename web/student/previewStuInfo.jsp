<%--
  Created by IntelliJ IDEA.
  User: Minister
  Date: 2017/4/20
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta charset="utf-8">
<head>
    <style type="text/css">
        tr>td:nth-child(1){
            text-align: left;
            /*font-family:楷体;*/
        }
        table{
            border-radius:5px;
            overflow:hidden;
            background:#E0ECFF;
            font-family:楷体;
        }
        div
        {
            text-align:center;
            border:2px solid #a1a1a1;
            padding:10px 40px;
            background:#E0ECFF;
            width:350px;
            border-radius:25px;
            -moz-border-radius:25px; /* 老的 Firefox */
        }

    </style>
    <title>预览个人信息</title><!--frame=rhs-->
</head>
<body>
<center>
    <div  style="border:#E0ECFF;width:900px;" >
        <h1><font face="楷体" color="#000066">确认个人信息</font></h1>
        <form action="${pageContext.request.contextPath}/student/inputStuInfoServlet" method="post">
            <table style= "backgound-repeat:none " frame="void" width="900px" height="700px">
                <tr>
                    <td >学号:</td>
                    <td>${stu.studentid}</td>

                    <td >考生号:</td>
                    <td>${stu.examid}</td>
                </tr>
                <tr>
                    <td >姓名:</td>
                    <td>${stu.studentname}</td>

                    <td >性别:</td>
                    <td>${stu.studentsex}</td>
                </tr>
                <tr>
                    <td >民族：</td>
                    <td>${stu.studentnation}</td>

                    <td >身份证号：</td>
                    <td>${stu.studentnumber}</td>
                </tr>
                <tr>
                    <td >政治面貌：</td>
                    <td>${stu.political}</td>

                    <td >学历：</td>
                    <td>${stu.education}</td>
                </tr>
                <tr>
                    <td >专业：</td>
                    <td>${stu.studentmajor}</td>

                    <td >班级：</td>
                    <td>${stu.studentclass}</td>
                </tr>
                <tr>
                    <td >培养方式:</td>
                    <td>${stu.trainingmode}</td>

                    <td >生源所在地：</td>
                    <td>${stu.location}</td>
                </tr>
                <tr>
                    <td >学制：</td>
                    <td>${stu.length}</td>

                    <td >辅修专业：</td>
                    <td>${stu.minor}</td>
                </tr>
                <tr>
                    <td >出生日期：</td>
                    <td>${stu.studentbirthday}</td>

                    <td >学位：</td>
                    <td>${stu.degree}</td>
                </tr>
                <tr>
                    <td >主修外语语种：</td>
                    <td>${stu.majorforeign}</td>

                    <td >外语水平：</td>
                    <td>${stu.foreignlevel}</td>
                </tr>
                <tr>
                    <td >计算机水平：</td>
                    <td>${stu.comlevel}</td>

                    <td >职业资格：</td>
                    <td>${stu.vocational}</td>
                </tr>
                <tr>
                    <td >入学年份：</td>
                    <td>${stu.enteryear}</td>

                    <td >毕业时间：</td>
                    <td>${stu.graduationtime}</td>
                </tr>
                <tr>
                    <td >是否定向培养：</td>
                    <td>${stu.universityname}</td>

                    <td >委培定向单位：</td>
                    <td>${stu.weipeiunit}</td>
                </tr>
                <tr>
                    <td >委培单位所在地：</td>
                    <td>${stu.weipeilocation}</td>
                </tr>
                <tr>
                    <td >院系：</td>
                    <td>${stu.studentcollege}</td>

                    <td >常住地址市区县：</td>
                    <td>${stu.resident}</td>
                </tr>
                <tr>
                    <td >常住地址详细（街道门牌号）：</td>
                    <td>${stu.residentdetailed}</td>

                    <td >常住地址乡镇街道办事处：</td>
                    <td>${stu.residentoffice}</td>
                </tr>
                <tr>
                    <td >常住地址乡镇街道办事处描述：</td>
                    <td>${stu.residentaddress}</td>

                    <td >现户籍所在地市区县：</td>
                    <td>${stu.register}</td>
                </tr>
                <tr>
                    <td >现户籍所在地详细（街道门牌号）</td>
                    <td>${stu.registerdetailed}</td>

                    <td >现户籍地址乡镇街道办事处：</td>
                    <td>${stu.registeroffice}</td>
                </tr>
                <tr>
                    <td >现户籍地址乡镇街道办事处描述：</td>
                    <td>${stu.registeraddress}</td>

                    <td >户籍性质：</td>
                    <td>${stu.tpye}</td>
                </tr>
                <tr>
                    <td >户籍登记日期：</td>
                    <td>${stu.registertime}</td>
                </tr>
                <tr>
                    <td >个人联系电话：</td>
                    <td>${stu.studenttel}</td>
                </tr>
                <tr>
                    <td >E-mail：</td>
                    <td>${stu.studentemail}</td>
                </tr>
                <tr>
                    <td >家庭常用联系电话：</td>
                    <td>${stu.hometel}</td>
                </tr>
                <tr>
                    <td >账户状态：</td>
                    <td>${stu.studentstate}</td>
                </tr>
            </table>
            <input type="submit" value="提交">
            <span style="color: red;">注意：一经提交将无法再次修改</span>
        </form>
        <br>
        <br>
        <br>
        <br>
    </div></center>
</body>
</html>