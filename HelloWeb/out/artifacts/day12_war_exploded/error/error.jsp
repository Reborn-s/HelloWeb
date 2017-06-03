<%--
  Created by IntelliJ IDEA.
  User: Reborn。
  Date: 2017/5/7
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage ="true" %>
<html>
<head>
    <title>ErrorPage</title>
</head>
<body>
    <h1>出错啦！！！</h1>
    <%
        exception.printStackTrace();
    %>
</body>
</html>
