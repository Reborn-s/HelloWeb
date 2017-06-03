<%--
  Created by IntelliJ IDEA.
  User: Reborn。
  Date: 2017/5/8
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.reborn.domain.*" %>
<html>
<head>
    <title>你曾是少年</title>
</head>
<body>
<%
    Address address = new Address();
    address.setCity("Taipei");
    address.setStreet("西门町");

    Employee emp = new Employee();
    emp.setName("加滑");
    emp.setAddress(address);
    emp.setSalary(12334);

    request.setAttribute("emp",emp);
%>
<h1>使用EL获取request域的emp</h1>
${requestScope.emp}
<hr/>
${requestScope.emp.name}
<br/>
${requestScope.emp.address.city}
<br/>


</body>
</html>
