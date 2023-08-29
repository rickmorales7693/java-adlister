<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>PizzaOrderForm</title>
</head>
<body>
<h1>Pizza Order Form</h1>
<form action="pizza-order" method="POST">
    <label>Crust Type: </label>
    <select name="crust">
        <option value="thin">Thin</option>
        <option value="pan">Pan</option>
        <option value="stuffed-crust">Stuffed Crust</option>
    </select><br><br>

    <label>Size Type: </label>
    <select name="size">
        <option value="small">Small</option>
        <option value="medium">Medium</option>
        <option value="large">Large</option>
    </select><br><br>

    <label>Toppings: </label><br>
    <input type="checkbox" name="toppings" value="pepperoni">Pepperoni<br>
    <input type="checkbox" name="toppings" value="bacon">Bacon<br>
    <input type="checkbox" name="toppings" value="ham">Ham<br>
    <input type="checkbox" name="toppings" value="sausage">Sausage<br><br>

    <label>Delivery Address:</label>
    <input type="text" name="address"><br><br>
    <input type="submit" value="Submit">

</form>
</body>
</html>
