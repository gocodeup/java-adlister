<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.codeup.adlister.dao.MySQLAdsDao"%>
<form action="/products/category" method="post">
<div class="dropdown" >
    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        Dropdown
    </button>
    <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
        <form action="/ads/categories" method="get">
            <input type="hidden" value = "1" name="category_id" id="1">
            <input class="dropdown-item" type="submit" value="Car">
        </form>

    </div>
</div>
</form>
