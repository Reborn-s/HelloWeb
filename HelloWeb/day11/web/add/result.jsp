<%--
  Created by IntelliJ IDEA.
  User: Reborn。
  Date: 2017/5/6
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.ServletRequest" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<%
    Integer result = (Integer)request.getAttribute("result");
%>
<%=result%>
</body>
</html>
