<%@ page import="java.net.CookieHandler" %><%--
  Created by IntelliJ IDEA.
  User: Reborn。
  Date: 2017/5/6
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>

    <script type="text/javascript">
        function _change()
        {
            var imgEle = document.getElementById("img");
            imgEle.src = "/VerifyCodeServlet?a="+new Date().getTime();
        }
    </script>

</head>
<body>
<h1>登录</h1>
<%
    String message = (String)request.getAttribute("msg");
    if(message!=null)
    {
%>
<font color="red"><b><%=message%></b></font><br/>
<%
    }
%>
<%
    Cookie[] cookies = request.getCookies();
    String username = "";
    if(cookies!=null)
    {

        for(Cookie c:cookies)
        {
            if("username".equals(c.getName()))
                 username = c.getValue();
        }
    }

%>
<form action="/LoginServlet" method="post">
    用户名：<input type="text" name="username" value="<%=username%>"/><br/>
    密  码：<input type="password" name="password"/><br/>
    验证码：<input type = "text" name = "verifyCode" size="3"/>
    <img id = "img" src="/VerifyCodeServlet">
    <a href="javascript:_change()">换一张</a><br/>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
