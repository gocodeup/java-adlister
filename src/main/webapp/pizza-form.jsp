<%--
  Created by IntelliJ IDEA.
  User: Hunter
  Date: 6/1/21
  Time: 12:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>
    body {
        background-color: #5F8AD3;
        color: burlywood;
    }
</style>
<html>
<head>
    <title>Pizza Form</title>
</head>
<body>

<h1>Welcome To Reds Pizzeria!</h1>
<h2> Please choose your pizza</h2>

<form action="/pizza-order.jsp" method="POST">
    Crust :
    <select name="typeOfCrust" id="crusts">
        <option value="crusts">Crust #1</option>
        <option value="crusts">Crust #2</option>
        <option value="crusts">Crust #3</option>
    </select><br><hr>

    Sauce :
    <select name="typeOfSauce" id="sauce">
        <option value="sauce">Sauce #1</option>
        <option value="sauce">Sauce #2</option>
        <option value="sauce">Sauce #3</option>
    </select><br><hr>

    Sizing :
    <select name="typeOfSizes" id="size">
        <option value="size">Size Option #1</option>
        <option value="size">Size Option #2</option>
        <option value="size">Size Option #3</option>
    </select><br><hr>

    Toppings :
    <input type="checkbox" id="one" name="1">
    <label for="one">1</label>

    <input type="checkbox" id="two" name="2">
    <label for="two">2</label>

    <input type="checkbox" id="three" name="3">
    <label for="three">3</label>

    <input type="checkbox" id="four" name="4">
    <label for="four">4</label><br><hr>

    <p></p>
    Delivery? No problem! Please input an address
    <br>
    <label for="address"></label>
    <input type="text" id="address">
</form>
</body>
</html>
