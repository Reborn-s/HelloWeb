<%--
  Created by IntelliJ IDEA.
  User: Reborn。
  Date: 2017/5/6
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get Cookie</title>
</head>
<body>
<h1>获取Cookie</h1>
<%
    Cookie[] cookies = request.getCookies();
    if(cookies!=null)
    {
        for(Cookie c:cookies)
            out.print(c.getName()+":"+c.getValue()+"<br/>");
    }
%>
</body>
</html>
