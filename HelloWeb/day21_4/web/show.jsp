<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Reborn。
  Date: 2017/5/18
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8"/>

    <title>Show</title>

</head>
<body>
<h1 align="center">图书列表</h1>
<table align="center" border="1" width="50%">
    <tr>
        <th>图书名称</th>
        <th>图书价格</th>
        <th>图书种类</th>
    </tr>
    <c:forEach items="${booklist}" var="book">
        <tr>
            <td>${book.bname}</td>
            <td>${book.price}</td>

            <c:choose>
                <c:when test="${book.category eq 1}"><td style="color: red">JavaSE</td></c:when>
                <c:when test="${book.category eq 2}"><td style="color: blue">JavaEE</td></c:when>
                <c:when test="${book.category eq 3}"><td style="color: green">JavaFramework</td></c:when>
            </c:choose>
        </tr>
    </c:forEach>
</table>
</body>
</html>
