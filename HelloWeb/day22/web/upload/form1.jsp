<%--
  Created by IntelliJ IDEA.
  User: Reborn。
  Date: 2017/5/18
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传demo</title>
</head>
<body>
${msg}
<form action="/UploadServlet" method="post" enctype="multipart/form-data">
    用户名：<input type="text" name="username"/><br/>
    上传文件：<input type="file" name="uploadFile"/><br/>
    <input type="submit" value="上传文件"/>
</form>
</body>
</html>
