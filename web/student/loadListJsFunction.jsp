<%--
  Created by IntelliJ IDEA.
  User: Minister
  Date: 2017/9/6
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
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
            var url="${pageContext.request.contextPath}/enterprise/list";
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
