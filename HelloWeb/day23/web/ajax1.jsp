<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Reborn。
  Date: 2017/5/22
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Ajax Hello World</title>

    <script type="text/javascript">
      //创建异步对象
      function createXmlHttpRequst() {
          try {
              return new XMLHttpRequest();//大多数浏览器
          } catch (e) {
              try {
                  return new ActiveXObject("Msxml2.XMLHTTP");//IE6.0
              } catch (e) {
                  try {
                      return new ActiveXObject("Microsoft.XMLHTTP");//IE5.5及更早版本
                  } catch (e) {
                      alert("无法识别您的浏览器");
                      throw e;
                  }
              }
          }

      }

      window.onload = function () {//文档加载完毕后执行
          var btn = document.getElementById("btn");
          btn.onclick = function () {//给按钮的点击事件注册监听
              /**
               * ajax四步操作，得到服务器的响应
               * 把响应结果显示到h1元素中
               */
              //1.得到异步对象
              var xmlHttpRequest = createXmlHttpRequst();

              //2. 打开与服务器的连接：参数：指定其请求方式，指定请求的URL，指定是否为异步请求
              //其中可以使用jstl标签是因为tocamt在服务器端就已经把jsp页面翻译成了html，翻译好了枯井字符串
              xmlHttpRequest.open("GET","<c:url value="/Aservlet" />",true);

              //3. 发送请求
              xmlHttpRequest.send(null);

              //4. 给异步对象的onreadystatechange注册监听器
              xmlHttpRequest.onreadystatechange = function () {//当xmlHttp的状态发生变化时执行，但我们只关心第五个状态
                  if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200)
                  {
                      var h1 = document.getElementById("h1");

                      //获取服务器的响应结束
                      var text = xmlHttpRequest.responseText;
                      h1.innerHTML = text;
                  }
              }
          };
      };
    </script>
  </head>
  <body>
  <button id = "btn">点击这里</button>
  <h1 id = "h1"></h1>
  </body>
</html>
