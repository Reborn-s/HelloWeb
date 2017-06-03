<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Reborn。
  Date: 2017/5/22
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户名校验</title>
    
    <script type="text/javascript">
        function createXmlHttpRequest() {
            try {
                return new XMLHttpRequest();
            } catch (e) {
                try {
                    return new ActiveXObject("Msxml2.XMLHTTP");
                } catch (e) {
                    try {
                        return new ActiveXObject("Microsoft.XMLHTTP");
                    } catch (e) {
                        alert("无法识别您的浏览器！");
                        throw e;
                    }
                }
            }
            
        }
        
        window.onload = function () {
            var userEle = document.getElementById("usernameEle");
            userEle.onblur = function () {
                var xmlHttp = createXmlHttpRequest();
                xmlHttp.open("POST","<c:url value="/ValidateServlet"/>",true);
                xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
                xmlHttp.send("username="+userEle.value);
                xmlHttp.onreadystatechange = function () {
                    if(xmlHttp.readyState==4 && xmlHttp.status==200)
                    {
                        if(xmlHttp.responseText=="1")
                            document.getElementById("errorEle").innerHTML="";
                        else
                            document.getElementById("errorEle").innerHTML="用户名已被注册！";
                    }
                };
            };
        };
    </script>
</head>
<body>
<h1>演示校验用户名是否注册</h1>
<form action="" method="post">
    用户名：<input type="text" name="username" id="usernameEle"/><span id="errorEle"></span><br/>
    密 码：<input type="password" name="password" id="passwordEle"/><br/>
    <input type="submit" value="注册"/>
</form>
</body>
</html>
