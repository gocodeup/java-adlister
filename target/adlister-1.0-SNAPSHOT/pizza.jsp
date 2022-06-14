<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="partials/head.jsp"%>
</head>
<body>
<%@include file="partials/navbar.jsp"%>
<h1 class="text-center mb-2">Pizza Order Form</h1>
<form action="/pizza-order" method="POST">
    <div class="form-group">
        <label for="size">Select pizza size:</label>
        <select class="form-control" type="text" id="size" name="size">
            <option>Personal (8")</option>
            <option>Small (10")</option>
            <option>Medium (12")</option>
            <option>Large (16")</option>
            <option>Massive (20")</option>
        </select>
    </div>
    <div class="form-group">
        <label for="crust">Select crust type:</label>
        <select class="form-control" type="text" id="crust" name="crust">
            <option>Thin Crust</option>
            <option>Thick Crust</option>
            <option>Chicago-Style Deep Dish</option>
            <option>Pan Pizza Crust</option>
        </select>
    </div>
    <div class="form-group">
        <label for="sauce">Select pizza sauce:</label>
        <select class="form-control" type="text" id="sauce" name="sauce">
            <option>Marinara</option>
            <option>Spicy Red</option>
            <option>BBQ</option>
            <option>Alfredo</option>
            <option>Pesto</option>
            <option>Buffalo</option>
        </select>
    </div>
    <div class="form-check">
        <label class="form-check">Select meats:</label>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="checkbox" name="meat" value="pepperoni" id="pepperoni">
        <label>Pepperoni</label>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="checkbox" name="meat" value="sausage" id="sausage">
        <label>Sausage</label>
    </div>
    <div class="form-group">
        <label for="address">Address</label>
        <input type="text" class="form-control" id="address" name="address"
               placeholder="Enter your full address here.">
    </div>
    <button type="submit" class="btn btn-primary">Submit My Order</button>
</form>
<%--<%@include file="partials/footer.jsp"%>--%>
<%--<%@include file="partials/scripts.jsp"%>--%>
</body>
</html>