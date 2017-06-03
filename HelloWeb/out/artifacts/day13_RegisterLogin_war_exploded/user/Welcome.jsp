<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Reborn。
  Date: 2017/5/10
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<c:choose>
    <c:when test="${empty sessionScope.session_user}">
        <h2>您还没有登录！请先登录！</h2><br/>
        五秒后为您跳转到登录页面...
        <%
            response.setHeader("Refresh","5;URL=/user/Login.jsp");
        %>
    </c:when>
    <c:otherwise>
        <h1>欢迎${sessionScope.session_user.username}来到美丽新世界！</h1>
    </c:otherwise>
</c:choose>
</body>
</html>
