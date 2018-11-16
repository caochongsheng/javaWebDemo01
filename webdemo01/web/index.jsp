<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:forward page="/admin">
    <jsp:param  value="index" name="method"/>
</jsp:forward>

<%--<a href="/admin?method=index">跳转</a>--%>

<%--<%

    request.getRequestDispatcher("/admin?method=index").forward(request,response);

    response.sendRedirect("/admin?method=index");
%>--%>
