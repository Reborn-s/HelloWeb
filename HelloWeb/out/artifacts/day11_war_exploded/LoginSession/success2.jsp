<%--
  Created by IntelliJ IDEA.
  User: Reborn。
  Date: 2017/5/6
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success2</title>
</head>
<body>
<%
    String username = (String)session.getAttribute("username");
    if(username==null)
    {
        request.setAttribute("msg","您还没有登录！请登录！");
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }
%>
<h2>登录成功！欢迎<%=username%>来到美丽新世界！</h2>
</body>
</html>
