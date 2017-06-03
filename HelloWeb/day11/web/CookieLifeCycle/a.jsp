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
<h1>设置Cookie生命周期</h1>
<%
    Cookie c1 = new Cookie("a","A");
    c1.setMaxAge(60);
    response.addCookie(c1);

%>
</body>
</html>
