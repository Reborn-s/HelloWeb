<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Reborn。
  Date: 2017/5/22
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajax2 POST</title>
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
                        alert("无法识别您的浏览器")
                        throw  e;
                    }
                }
            }
        }
        window.onload = function () {
            var btn = document.getElementById("buttonh");
            btn.onclick = function () {
                var xmlHttpRequest = new createXmlHttpRequest();
                xmlHttpRequest.open("POST","<c:url value="/Aservlet"/>",true);
                xmlHttpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
                xmlHttpRequest.send("username=张三&password=1233");
                xmlHttpRequest.onreadystatechange = function () {
                    if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200)
                    {
                        var text = xmlHttpRequest.responseText;
                        var h = document.getElementById("h1");
                        h.innerHTML = text;
                    }
                }
            };
        };
    </script>
</head>
<body>
<button id = "buttonh">依然点击这里！</button>
<h1 id = "h1"></h1>
</body>
</html>
