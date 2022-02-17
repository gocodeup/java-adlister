<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container-fluid">
        <h1>Welcome to the Adlister!</h1>
    </div>



<div class="container-fluid">
    <div class="search-bar">
        <form action="/ads/search" METHOD="POST">
            <input id="keyword" name="keyword" class="form-control" type="text" placeholder="What are you looking for?">
            <button type="submit" class="home-search-bar btn btn-dark btn-block" value="Search">Search</button>
        </form>
    </div>

</div>

    <div class="container-fluid">


    <div class="jumbotron jumbotron-fluid">
        <div class="categories-container" id="categories-header">
            <h3 class="categories-header"><i class="fa fa-hashtag" aria-hidden="true">CATEGORIES</i></h3>
            <div class="category">
                <span class="align-baseline w3-tag w3-grey w3-margin-bottom w3-margin-left"><a href="${pageContext.request.contextPath}/ads/categories?category=Electronics">Electronics & Media</a></span><span
                    class="align-top w3-tag w3-grey w3-margin-bottom"><a href="${pageContext.request.contextPath}/ads/categories?category=Clothing">Clothing</a></span>
                <span class="align-bottom w3-tag w3-grey w3-margin-bottom"><a href="${pageContext.request.contextPath}/ads/categories?category=Pets">Pets</a></span><span
                    class="align-top w3-tag w3-grey w3-margin-bottom"><a href="${pageContext.request.contextPath}/ads/categories?category=Sporting">Sporting Goods & Outdoors</a></span>
                <span class="align-baseline w3-tag w3-grey w3-margin-bottom"><a href="${pageContext.request.contextPath}/ads/categories?category=Vehicles">Vehicles</a></span>
            </div>
        </div>
    </div>
    </div>
    <footer class="w3-container w3-padding-32 w3-dark-grey">

        <h3>Something here, this is our footer, can be social media, our signature, etc</h3>
    </footer>
</body>
</html>
