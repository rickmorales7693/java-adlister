
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Guess Page</title>
</head>
<body>
<form action="guess" method="POST">
    <label>Enter a number between 1 and 3: </label>
    <input type="text" name="guessedNumber" min="1" max="3" required>
    <input type="submit" value="Submit">
</form>

</body>
</html>
