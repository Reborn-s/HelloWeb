<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %><%--
  Created by IntelliJ IDEA.
  User: Reborn。
  Date: 2017/5/17
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>国际化</title>
</head>
<body>
<%--
把与语言相关的所有字符串都写成变量！
--%>
<%
    //获取Locale，这是由客户端浏览器提供的Locale
    Locale locale = request.getLocale();
    out.print(locale);
    ResourceBundle rb = ResourceBundle.getBundle("res",locale);
    out.print(rb);
    out.print(rb.getString("login"));
%>
<h1>${rb.getString("login")}</h1>
<form action="" method="post">
    ${rb.getString("username")}:<input type="text" name="userame"/><br/>
        ${rb.getString("password")}:<input type="password" name="password"/><br/>
    <input type="submit" value="登录">
</form>

</body>
</html>
