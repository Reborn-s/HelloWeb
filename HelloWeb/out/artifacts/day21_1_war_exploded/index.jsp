<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Reborn。
  Date: 2017/5/17
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>分IP统计访问次数</title>
  </head>
  <body>
  <h1 align="center">访问次数</h1>
  <table align="center" width="60%" border="1">
      <tr>
          <th>IP</th>
          <th>访问次数</th>
      </tr>
      <c:forEach items="${applicationScope.map}" var="entry">
          <tr>
              <td>${entry.key}</td>
              <td>${entry.value}</td>
          </tr>
      </c:forEach>
  </table>

  </body>
</html>
