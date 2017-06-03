<%--
  Created by IntelliJ IDEA.
  User: Reborn。
  Date: 2017/5/6
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<!-- 它是jsp指令，也是一种特殊的标签！-->
<%@ page contentType="text/html;charset=UTF-8" language="java" import="javax.servlet.*" %>

<!-- java代码片段-->
<%
    String path = request.getContextPath();//获取项目名
    String base = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/"+path+"/";
%>

<html>
  <head>
    <title>Super Start</title>
  </head>
  <body>
    This is my JSP page.<br/>

  <%
      int a = 10;
  %>

  <%=a%>
  <br/>

  <%
      out.print("a="+a);
  %>
    <br/>

  <%!
      int a = 100;
      public void fun1(){System.out.println(a);}
  %>

  <%
      out.print(this.a);
      this.a++;
      fun1();
  %>

  </body>
</html>
