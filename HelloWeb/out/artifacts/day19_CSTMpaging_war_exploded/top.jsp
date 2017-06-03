<%--
Created by Reborn。 on 2017/5/17.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- 他的作用是为本页面所有的表单和超链接指定显示内容的框架-->
    <base target="main">
    <title>客户关系管理系统</title>
</head>
<body style="text-align: center;">
    <h1>客户关系管理系统</h1>
    <a href="<c:url value="add.jsp"/>">添加客户</a>
    <a href="<c:url value="/CustomerServlet?method=findAll"/>">查询客户</a>
    <a href="<c:url value="query.jsp"/>">高级搜索</a>

</body>
</html>
