<%--
  Created by IntelliJ IDEA.
  User: Reborn。
  Date: 2017/5/8
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PageContext</title>
</head>
<body>
${pageContext.request.contextPath}
<br/>
${pageContext.request.serverName}
<br/>
${pageContext.session.id}
<br/>
<a href="${pageContext.request.contextPath}/el/cookie/cookie.jsp">点我点我</a>
<form action="${pageContext.request.contextPath}/el/initParam/initParam.jsp" method="post">
    <input type="submit" value="提交">
</form>
</body>
</html>
