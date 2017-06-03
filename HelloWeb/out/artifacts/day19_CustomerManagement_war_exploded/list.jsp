<%--
Created by Reborn。 on 2017/5/17.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>客户列表</title>
</head>
<body>
    <h3 align="center" >客户列表</h3>
    <table border="1" width="70%" align="center">
        <tr>
            <th>客户姓名</th>
            <th>性别</th>
            <th>手机</th>
            <th>邮箱</th>
            <th>描述</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${requestScope.customersList}" var="customer">
            <tr align="center">
                <td>${customer.cname}</td>
                <td>${customer.gender}</td>
                <td>${customer.cellphone}</td>
                <td>${customer.email}</td>
                <td>${customer.description}</td>
                <td>
                    <a href="<c:url value="CustomerServlet?method=load&cid=${customer.cid}"/>">编辑</a>
                    <a href="<c:url value="CustomerServlet?method=delete&cid=${customer.cid}"/>">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
<br/>

</body>
</html>
