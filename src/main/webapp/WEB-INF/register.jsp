<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Register"/>
    </jsp:include>
</head>
<body>
<jsp:include page="partials/navbar.jsp"/>
<h1>Please fill in your information</h1>
<c:if test="${invalid == true}">
    <h2>Invalid Inputs, please try again.</h2>
</c:if>
<form action="/register" method="post">
    <table>
        <tr>
            <td>Username:</td>
            <td><input type="text" name="username" value="${username}"/></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="text" name="email" value="${email}"/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password" value="${password}"/></td>
        </tr>
        <tr>
            <td>Confirm Password:</td>
            <td><input type="password" name="confirmPassword" value="${confirmPassword}"/>
            </td>
        </tr>
            <input type="submit" value="Register"/>

    </table>
</form>
</body>
</html>
