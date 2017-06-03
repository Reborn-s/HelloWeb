<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Reborn。
  Date: 2017/5/18
  Time: 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>处理全站编码问题</title>
  </head>
  <body>
<a href="<c:url value='/Aservlet?username=张三'/>">点击这里</a><br/>
<form action="<c:url value='/Aservlet'/>" method="post">
  <input type="text" name="username" value="李四"/>
  <input type="submit" value="提交"/>
  </form>
  </body>
</html>
