<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>第一个 页面</h1>

  <%-- 从1 开始遍历到10 ，得到的结果 ，赋值给 i ,并且会存储到page域中， step , 增幅为2，--%>
  <c:forEach var="movie" items="${movies}">
      <div>${movie.title}</div>
  </c:forEach>

  </body>
</html>


 
