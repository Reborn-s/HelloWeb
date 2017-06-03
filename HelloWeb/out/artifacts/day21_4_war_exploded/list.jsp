<%--
  Created by IntelliJ IDEA.
  User: Reborn。
  Date: 2017/5/18
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<a href="/BookServlet?method=findAll">查询所有</a><br/>
<a href="/BookServlet?method=findByCategory&category=1">查询JavaSE</a><br/>
<a href="/BookServlet?method=findByCategory&category=2">查询JavaEE</a><br/>
<a href="/BookServlet?method=findByCategory&category=3">查询JavaFramework</a>
</body>
</html>
