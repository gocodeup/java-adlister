<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12/15/22
  Time: 5:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>

    <title>Pizza</title>
  </head>
  <body>
  <form action="PizzaOrder" method="post">

  <label for="crust">Choose a Crust:</label>

  <select name="crust" id="crust">
    <option value="thin">Thin</option>
    <option value="hand-tossed">Hand Tossed</option>
    <option value="deep-dish">Deep Dish</option>
  </select>

  <label for="sauce">Choose a Sauce:</label>

  <select name="sauce" id="sauce">
    <option value="pizza">Pizza</option>
    <option value="alfredo">Alfredo</option>
  </select>

  <label for="size">Choose a Size:</label>

  <select name="size" id="size">
    <option value="10">10</option>
    <option value="12">12</option>
    <option value="14">14</option>
    <option value="16">16</option>
  </select>

<fieldset>
  <legend>Choose your toppings</legend>
    <div name="toppings">
    <input type="checkbox" id="pepperoni" name="check" value="pepperoni" />
    <label for="pepperoni">Pepperoni</label>

    <input type="checkbox" id="mushroom" name="check" value="mushroom" />
    <label for="mushroom">Mushroom</label>

      <input type="checkbox" id="ham" name="check" value="ham" />
      <label for="ham">Ham</label>

        <input type="checkbox" id="sausage" name="check" value="sausage" />
        <label for="sausage">Sausage</label>
</div>
</fieldset>
        <label for="address">Delivery Address</label>
        <input type="text" name="address"/>
  <button type="submit">Submit</button>


  </form>
  </body>
</html>
