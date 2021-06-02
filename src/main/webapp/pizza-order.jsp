<%--
  Created by IntelliJ IDEA.
  User: Kelvon
  Date: 6/1/21
  Time: 10:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pizza Order</title>
</head>
<body>
<form action="/pizza-order" method="post">
<label for="crust">Choose a crust type:</label>
<select id="crust" name="crust">
    <option value="thin">Thin</option>
    <option value="stuffed">Stuffed</option>
    <option value="original">Original</option>
</select>
<br>
    <label for="sauce">Choose a sauce :</label>
<select id="sauce" name="sauce">
    <option value="tomato">Tomato</option>
    <option value="alfredo">Alfredo</option>
    <option value="BBQ">BBQ</option>
</select>
<br>
<label for="crust-size">Crust Size</label>
<select id="crust-size" name="crust-size">
    <option value="12-inch">12-inch</option>
    <option value="14-inch">14-inch</option>
    <option value="16-inch">16-inch</option>
</select>
<br>
<input type="checkbox" id="pepperoni" name="pepperoni" value="pepperoni">
<label for="pepperoni"> Pepperoni</label><br>
<input type="checkbox" id="sausage" name="sausage" value="sausage">
<label for="sausage"> Sausage</label><br>
<input type="checkbox" id="bacon" name="bacon" value="bacon">
<label for="bacon"> Bacon</label><br>
<input type="checkbox" id="onion" name="onion" value="onion">
<label for="onion"> Onion</label><br>
<input type="checkbox" id="mushrooms" name="mushrooms" value="mushrooms">
<label for="mushrooms"> Mushrooms</label><br>
<input type="checkbox" id="pineapple" name="pineapple" value="pineapple">
<label for="pineapple"> Pineapple</label><br>

<label for="address">Delivery address :</label>
<input type="text" id="address" name="address" required >
    <br>
    <button type="submit" name="Submit">Submit Order</button>
</form>

</body>
</html>
