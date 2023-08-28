<%@ page import="javax.swing.*" %><%--
  Created by IntelliJ IDEA.
  User: rickmorales
  Date: 8/28/23
  Time: 11:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%! boolean methodIsPost = false;%>
<%
    if (request.getMethod().equalsIgnoreCase("POST")) {
        methodIsPost = true;
    }
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
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

    <%
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(username) && "password".equals(password)) {
            response.sendRedirect("profile.jsp");
        } else if (username != null || password != null) {
            System.out.println("Invalid username or password");
        }
    %>
</form>


</body>
</html>
