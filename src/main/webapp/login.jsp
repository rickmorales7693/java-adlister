<%@ page import="javax.swing.*" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    if (request.getMethod().equalsIgnoreCase("POST")) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("password"))
            response.sendRedirect("/profile.jsp");
    }
%>

<html>
<head>
    <title>Login</title>
    <%@include file="partials/head.jsp"%>
</head>
<body>
<%@include file="partials/navbar.jsp"%>
<h1>Login Form</h1>
<form action="login.jsp" method="POST">
    <label for="username">Username: </label>
    <input type="text" id="username" name="username" required><br>

    <label for="password">Password: </label>
    <input type="text" id="password" name="password" required><br>

    <input type="submit" value="Login">

    <c:choose>
        <c:when test="${param.username != null}">
            <c:if test="${param.username != null}">
                <p>Your Username is: ${param.username}</p>
            </c:if>
            <c:if test="${param.password != null}">
                <p>Your Password is: ${param.password}</p>
            </c:if>
        </c:when>

        <c:otherwise>
            <p>Please fill out the form.</p>
        </c:otherwise>
    </c:choose>

</form>


</body>
</html>
