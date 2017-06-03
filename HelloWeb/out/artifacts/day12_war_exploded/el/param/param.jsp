<%--
  Created by IntelliJ IDEA.
  User: Reborn。
  Date: 2017/5/8
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Param</title>
</head>
<body>

${param.username}

<br/>

${paramValues['hobby'][0]}
<br/>
${paramValues.hobby[1]}
</body>
</html>
