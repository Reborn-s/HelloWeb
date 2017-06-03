<%--
Created by Reborn。 on 2017/5/17.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>客户关系管理系统</title>
</head>
<body>
    <h3 align="center">高级搜索</h3>
    <form action="<c:url value="CustomerServlet"/>" method="get">
        <input type="hidden" name="method" value="query"/>
        <table border="0" align="center" width="40%" style="margin-left: 100px">
            <tr>
                <td width="100px">客户名称</td>
                <td width="40%">
                    <input type="text" name="cname">
                </td>
            </tr>
            <tr>
                <td>客户性别</td>
                <td>
                    <select name="gender">
                        <option value="">==请选择性别==</option>
                        <option value="male">male</option>
                        <option value="female">female</option>
                    </select>
                </td>
            </tr>
            <tr>
            <td>手机</td>
            <td>
                <input type="text" name="cellphone"/>
            </td>
            </tr>
            <tr>
                <td>邮箱</td>
                <td>
                    <input type="text" name="email"/>
                </td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>

                    <input type="submit" value="搜索"/>
                    <input type="reset" value="重置"/>
                </td>
            </tr>

        </table>
    </form>

</body>
</html>
