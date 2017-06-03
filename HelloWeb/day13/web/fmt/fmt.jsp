<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Reborn。
  Date: 2017/5/9
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>FMT</title>
</head>
<body>

<%
    Date date = new Date();
    request.setAttribute("d",date);
%>

<fmt:formatDate value="${d}" pattern="yyyy-mm-dd hh:mm:ss"/>

<hr/>

<%
    request.setAttribute("num",3.14159);
%>

<fmt:formatNumber value="${num}" pattern="0.000"/>
<fmt:formatNumber value="${num}" pattern="0.0000000"/>
<fmt:formatNumber value="${num}" pattern="#.#######"/>

</body>
</html>
