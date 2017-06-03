<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Reborn。
  Date: 2017/5/10
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>登录</h1>
<p style="color: red">${msg}</p>
<%--${pageContext.request.contextPath}/RegisterServlet--%>
<c:choose>
    <c:when test="${empty cookie.user}">
        <c:set var="username" value="${requestScope.user.username}"/>
    </c:when>
    <c:otherwise>
        <c:set var="username" value="${cookie.user.value}"/>
    </c:otherwise>
</c:choose>
<form action="<c:url value='/LoginServlet'/>" method="post">
    用户名：<input type="text" name="username" value="${username}"><br/>
    密  码：<input type="password" name="password" value="${user.password}"><br/>
    <input type="submit" value="登录"/>
</form>
</body>
</html>
