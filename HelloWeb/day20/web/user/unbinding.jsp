<%--
  Created by IntelliJ IDEA.
  User: Reborn。
  Date: 2017/5/17
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Unbinding</title>
</head>
<body>
<%
    session.removeAttribute("user");
%>
</body>
</html>
