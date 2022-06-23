<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
</head>
<body>
<div class="container">
    <div class="row">
        <form action="/pizza-order" method="POST">
            <div class="form-group">
                <h1>This is your pizza order:</h1>
            </div>
            <div>
                <lebel for="crust-type">Crust type:</lebel>
                <select name="crust-type" id="crust-type">
                    <option value="original">Original</option>
                    <option value="pan">Pan</option>
                    <option value="cheesy-bites">Cheesy Bites</option>
                    <option value="hand-tossed">Original</option>
                </select>
            </div>
            <div>
                <lebel for="sauce-type">Sauce type:</lebel>
                <select name="sauce-type" id="sauce-type">
                    <option value="marinara">Marinara</option>
                    <option value="ranch">Ranch</option>
                    <option value="barbeque">Barbeque</option>
                    <option value="honey-sriracha">Honey Sriracha</option>
                </select>
            </div>
            <fieldset>
                <legend>Toppings:</legend>
                <lebel for="pepperoni">
                    <input id="pepperoni" type="checkbox" value="pepperoni" name="toppings">
                    Pepperoni
                </lebel>
                <lebel for="veggies">
                    <input id="veggies" type="checkbox" value="veggies" name="toppings">
                    Veggies
                </lebel>
                <lebel for="mushroom">
                    <input id="mushroom" type="checkbox" value="mushroom" name="toppings">
                    Mushroom
                </lebel>
            </fieldset>
            <div>
                <lebel for="address">Address</lebel>
                <input id="address" type="text" name="address" placeholder="Enter address">
            </div>
            <button>Submit your order</button>
        </form>
    </div>
</div>
</body>
</html>

