<%--
  Created by IntelliJ IDEA.
  User: Reborn。
  Date: 2017/5/6
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GetSession</title>
</head>
<body>
<h1>获取Session中数据</h1>
<%
    String s = (String)session.getAttribute("username");
%>
<%=s%>
</body>
</html>
