
<%--
  Created by IntelliJ IDEA.
  User: Minister
  Date: 2017/5/3
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta charset="utf-8">
<head>
    <title>上传Excel</title>
    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
    <script>
        $(function () {
            $("#file_form").submit(function(){
                //首先验证文件格式
                var fileName = $('#file_input').val();
                if (fileName === '') {
                    alert('请选择文件');
                    return false;
                }
                var fileType = (fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length)).toLowerCase();
                if (fileType !== 'xls' && fileType !== 'xlsx') {
                    alert('文件格式不正确，excel文件！');
                    return false;
                }
            });
        });
    </script>
</head>
<body>
<center>
    <div>
        <h1>注意</h1>
        上传的文件只能是xlsx文件（office2007及以上），且表内容第一行不会被读取，可以存放字段名。
    </div>
    <form id="file_form" action="${pageContext.request.contextPath}/college/uploadExcelServlet" enctype="multipart/form-data" method="post">
        <input type="hidden" name="isAdmin" value="true">
        <label for="isUpdate">有记录则替换</label><input type="checkbox" name="isUpdate" value="true" id="isUpdate">
        <select name="type">
            <option value="StudentEntity-37">学生信息</option>
            <option value="CitycodeEntity-2">街道办代码</option>
            <option value="XingzhengquhuaEntity-2">省市县代码</option>
            <option value="SexEntity-2">性别代码</option>
            <option value="NationEntity-2">民族代码</option>
            <option value="BachelorEntity-2">专业代码</option>
            <option value="PoliticalEntity-2">政治面貌代码</option>
        </select>
        <input type="file" name="file" id="file_input"/>
        <input type="submit" value="上传" id="upfile_btn">
    </form>
    <p><a  href="student-info-example.xlsx">下载导入学生信息模板表格(.xlsx)</a></p>
    <p><a  href="name-code-example.xlsx">下载导入代码信息模板表格(.xlsx)</a></p>
</center>
</body>
</html>
