
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Color</title>
    <style>
        body {
            background-color: <%=request.getParameter("color")%>;
        }
    </style>
</head>
<body>
<h1>Here is your color!</h1>
</body>
</html>
