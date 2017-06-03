<%--
  Created by IntelliJ IDEA.
  User: Reborn。
  Date: 2017/5/17
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>登录</h1><br/>
${msg}
<form action="/LoginServlet" method="post">
    用户名：<input type="text" name="username"/>
    <input type="submit" value="登录"/>
</form>
</body>
</html>
