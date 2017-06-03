<%--
  Created by IntelliJ IDEA.
  User: Reborn。
  Date: 2017/5/9
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="reborn" uri="/WEB-INF/tlds/reborn-tag.tld" %>
<html>
<head>
    <title>MyTag</title>
</head>
<body>
<h1><reborn:myTag1/></h1>
<h1><reborn:myTag2/></h1>

<reborn:proTag test="${param.name}">
    <h1><reborn:skipTag/></h1>
</reborn:proTag>

<%
    request.setAttribute("name","hebe");
%>
<h1><reborn:myTag3>${name}</reborn:myTag3></h1>




</body>
</html>
