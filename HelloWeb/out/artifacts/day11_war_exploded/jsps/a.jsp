<%--
  Created by IntelliJ IDEA.
  User: Reborn。
  Date: 2017/5/6
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Super Star</title>
</head>
<body>
<table border="1" align="center" width="20%">
    <tr>
        <td>姓名</td>
        <td>年龄</td>
    </tr>

    <%
        for(int i=0;i<10;i++)
        {
    %>
    <tr>
        <td>张三</td>
        <td>29</td>
    </tr>
    <%
        }
    %>

</table>
</body>
</html>
