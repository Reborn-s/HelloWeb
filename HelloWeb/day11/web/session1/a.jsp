<%--
  Created by IntelliJ IDEA.
  User: Reborn。
  Date: 2017/5/6
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SaveSession</title>
</head>
<body>
<h1>向Session域保存数据</h1>
<%
    session.setAttribute("username","123");
%>
</body>
</html>
