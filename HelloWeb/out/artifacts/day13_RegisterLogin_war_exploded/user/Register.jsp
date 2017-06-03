<%--
  Created by IntelliJ IDEA.
  User: Reborn。
  Date: 2017/5/10
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Register</title>
    <script type="text/javascript">
        function _change() {
            //局部变量名尽量不要和input里name的名字重合，否则浏览器无法解析
            var vcode = document.getElementById("vCode");
            vcode.src = ${pageContext.request.contextPath}"/VerifyCodeServlet?a="+new Date().getTime();
        }
    </script>
</head>
<body>
<h1>注册</h1>
<p style="color: red">${msg}</p>
<%--${pageContext.request.contextPath}/RegisterServlet--%>
<c:choose>
    <c:when test="${requestScope.user.age==0}">
        <c:set var="showage" value=""/>
    </c:when>
    <c:otherwise>
        <c:set var="showage" value="${requestScope.user.age}"/>
    </c:otherwise>
</c:choose>
<form action="<c:url value='/RegisterServlet'/>" method="post">

    用户名：<input type="text" name="username" value="${user.username}"><p style="color: red">${errors.username}</p><br/>
    密  码：<input type="password" name="password" value="${user.password}"><p style="color: red">${errors.password}</p><br/>
    年  龄：<input type="text" name="age" value="${showage}"><p style="color: red">${errors.age}</p><br/>
    性  别：<input type="text" name="gender" value="${user.gender}"><p style="color: red">${errors.gender}</p><br/>
    验证码：<input type="text" name="verifyCode" value="${user.verifyCode}" size="3"><p style="color: red">${errors.verifyCode}</p><br/>
    <img id="vCode" src="<c:url value='/VerifyCodeServlet'/>"/>
    <a href="javascript:_change()">看不清换一张</a><br/>
    <input type="submit" value="注册"/>
</form>

</body>
</html>