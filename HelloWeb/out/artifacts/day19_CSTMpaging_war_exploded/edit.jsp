<%--
Created by Reborn。 on 2017/5/17.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>客户关系管理系统</title>
</head>
<body>
<h3 align="center">编辑客户</h3>
<form action="<c:url value="CustomerServlet"/> " method="post" >
    <input type="hidden" name="method" value="edit"/>
    <input type="hidden" name="cid" value="${requestScope.customer.cid}"/>
    <table border="0" align="center" width="40%" style="margin-left: 100px">
        <tr>
            <td width="100px">客户名称</td>
            <td width="40%">
                <input type="text" name="cname" value="${requestScope.customer.cname}"/>
            </td>
            <td align="left">
                <label id="nameError" class="error">&nbsp;</label>
            </td>
        </tr>
        <tr>
            <td>客户性别</td>
            <td>
                <input type="radio" name="gender" value="male" id="male" <c:if test="${requestScope.customer.gender eq 'male'}"> checked="checked"</c:if>/>
                <label for="male">男</label>

                <input type="radio" name="gender" value="female" id="female" <c:if test="${requestScope.customer.gender eq 'female'}"> checked="checked"</c:if>/>
                <label for="male">女</label>
            </td>
            <td>
                <label id="genderError"class="error">&nbsp;</label>
            </td>
        </tr>
        <tr>
            <td>客户生日</td>
            <td>
                <input type="text" name="birthday" id="birthday" readonly="readonly" value="${requestScope.customer.birthday}"/>
            </td>
            <td>
                <label id="birthdayError" class="error">&nbsp;</label>
            </td>
        </tr>
        <tr>
            <td>手机</td>
            <td>
                <input type="text" name="cellphone" id="phone" value="${requestScope.customer.cellphone}"/>
            </td>
            <td>
                <label id="phoneError"class="error">&nbsp;</label>
            </td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td>
                <input type="text" name="email" id="email" value="${requestScope.customer.email}"/>
            </td>
            <td>
                <label id="emailError"class="error">&nbsp;</label>
            </td>
        </tr>
        <tr>
            <td>描述</td>
            <td>
                <textarea rows="5" cols="30" name="description">${requestScope.customer.description}</textarea>
            </td>
            <td>
                <label id="discriptionError"class="error">&nbsp;</label>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" name="submit" value="编辑客户"/>
                <input type="reset" name="reset"/>
            </td>
        </tr>
    </table>
</form>


</body>
</html>
