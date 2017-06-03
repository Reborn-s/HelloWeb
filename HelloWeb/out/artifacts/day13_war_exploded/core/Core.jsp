<%--
  Created by IntelliJ IDEA.
  User: Reborn。
  Date: 2017/5/9
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Core</title>
</head>
<body>
<c:set var="code" value="<script>alert('hello');</script>" scope="request" />
<c:out value="${code}" default="none" escapeXml="true"/>

<br/>

<c:remove var="code" scope="request"/>
<c:out value="${code}" default="none"/>

<br/>

<c:url value="/index.jsp"/>
<c:url var="code" value="/index.jsp" scope="request"/>
<br/>
<a href="<c:url value="Core.jsp"/> ">click me</a>
<br/>
<a href="${code} ">click me</a>
<br/>
<c:url value="Core.jsp">
    <c:param name="name" value="hebe"/>
    <c:param name="hobby" value="code"/>
    <c:param name="score" value="98"/>
</c:url>

<br/>

<c:set var="a" value="zhangsan" scope="request"/>
<c:if test="${not empty a}">
    <c:out value="${a}"/>
</c:if>

<br/>

<c:set var="score" value="${param.score}"/>

<c:choose>
    <c:when test="${score>100||score<0}">错误分数！${score}</c:when>
    <c:when test="${score>=90}">A级</c:when>
    <c:when test="${score>=80}">B级</c:when>
    <c:when test="${score>=70}">C级</c:when>
    <c:otherwise>E级</c:otherwise>
</c:choose>

<br/>

<c:forEach var="i" begin="1" end="10" step="2">
    ${i}<br/>
</c:forEach>

<br/>

<%
    String[] args = {"one","two","three"};
    request.setAttribute("strs",args);
%>

<%--   *****"${strs}"中}与"之间不能有空格   --%>
<c:forEach items="${strs}" var="str">
    ${str}<br/>
</c:forEach>

<hr/>

<c:forEach items="${strs}" var="str" varStatus="vs">
    <c:choose>
        <c:when test="${vs.last}">
            第${vs.count}个元素${vs.current}
        </c:when>
        <c:otherwise>
            第${vs.count}个元素${vs.current},
        </c:otherwise>
    </c:choose>
</c:forEach>
</body>
</html>
