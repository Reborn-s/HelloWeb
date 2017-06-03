<%--
  Created by IntelliJ IDEA.
  User: Reborn。
  Date: 2017/5/6
  Time: 15:37
  To change this template use File | Settings | File Templates.
  Cookie不能跨浏览器，因为Cookie是保存在浏览器中的
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Request Cookie</title>
</head>
<body>
<h1>保存Cookie</h1>
<%
    Cookie c1 = new Cookie("a","A");
    response.addCookie(c1);

    Cookie c2 = new Cookie("b","B");
    response.addCookie(c2);
%>
</body>
</html>
