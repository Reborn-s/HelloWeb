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
        <c:forEach items="${requestScope.pageBean.beanList}" var="customer">
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
    <%--给出分页相关的链接--%>
<center>
    第${pageBean.pageCode}页/共${pageBean.totalPages}页
    <a href="${pageBean.url}&pageCode=1"/>首页</a>
    <c:if test="${pageBean.pageCode > 1}">
        <a href="${pageBean.url}&pageCode=${pageBean.pageCode-1}"/>上一页</a>
    </c:if>

    <c:choose>
        <c:when test="${pageBean.totalPages <= 10}">
            <c:set var="begin" value="1"/>
            <c:set var="end" value="${pageBean.totalPages}"/>
        </c:when>
        <c:otherwise>
            <c:set var="begin" value="${pageBean.pageCode-5}"/>
            <c:set var="end" value="${pageBean.pageCode+4}"/>
            <c:if test="${begin<1}">
                <c:set var="begin" value="1"/>
                <c:set var="end" value="10"/>
            </c:if>
            <c:if test="${end>pageBean.totalPages}">
                <c:set var="begin" value="${pageBean.totalPages-9}"/>
                <c:set var="end" value="${pageBean.totalPages}"/>
            </c:if>
        </c:otherwise>
    </c:choose>

    <%--循环显示页码列表--%>
    <c:forEach var="i" begin="${begin}" end="${end}">
        <c:choose>
            <c:when test="${i eq pageBean.pageCode}">
                [${i}]
            </c:when>
            <c:otherwise>
                <a href="${pageBean.url}&pageCode=${i}"/>${i}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>

    <c:if test="${pageBean.pageCode < pageBean.totalPages}">
        <a href="${pageBean.url}&pageCode=${pageBean.pageCode+1}"/>下一页</a>
    </c:if>

    <a href="${pageBean.url}&pageCode=${pageBean.totalPages}"/>尾页</a>
</center>

</body>
</html>
