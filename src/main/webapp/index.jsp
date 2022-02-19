<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
    <link rel="stylesheet" href="./styles.css">
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />



    <div class="container my-5 mx-auto main">
        <div class="jumbo-container mx-auto text-center">
            <h1 class="">Welcome to the Adlister!</h1>
        </div>




<div class="container-fluid my-5" >

    <div class="search-bar">
        <form class="mx-5 search-bar" action="/ads/search" METHOD="POST">
            <input id="keyword" name="keyword" class="form-control" type="text" placeholder="What are you looking for?">
            <button type="submit" class="home-search-bar btn btn-dark btn-block" value="Search">Search</button>
        </form>
    </div>

</div>
    </div>
    <div class="container-fluid my-5">


    <div class="container">
        <div class="categories-container" id="categories-header">
<%--            <h3 class="categories-header"><i class="fa fa-hashtag" aria-hidden="true">CATEGORIES</i></h3>--%>
            <div class="category text-center justify-content-around">
                <span class="align-baseline w3-tag w3-grey w3-margin-bottom w3-margin-left"><a href="${pageContext.request.contextPath}/ads/categories?category=Automobile">Automobile</a></span>
                <span class="align-top w3-tag w3-grey w3-margin-bottom"><a href="${pageContext.request.contextPath}/ads/categories?category=Clothing">Clothing</a></span>
                <span class="align-bottom w3-tag w3-grey w3-margin-bottom"><a href="${pageContext.request.contextPath}/ads/categories?category=Electronics">Electronics</a></span>
                <span class="align-top w3-tag w3-grey w3-margin-bottom"><a href="${pageContext.request.contextPath}/ads/categories?category=Furniture">Furniture</a></span>
                <span class="align-baseline w3-tag w3-grey w3-margin-bottom"><a href="${pageContext.request.contextPath}/ads/categories?category=Home">Home</a></span>
                <span class="align-baseline w3-tag w3-grey w3-margin-bottom"><a href="${pageContext.request.contextPath}/ads/categories?category=Miscellaneous">Miscellaneous</a></span>
                <span class="align-bottom w3-tag w3-grey w3-margin-bottom"><a href="${pageContext.request.contextPath}/ads/categories?category=Toys">Toys</a></span>
                <span class="align-top w3-tag w3-grey w3-margin-bottom"><a href="${pageContext.request.contextPath}/ads/categories?category=Tools">Tools</a></span>

            </div>
        </div>
    </div>
    </div>
    <div class="footer">

        <footer class="footer" style="margin-top: 300px">

            <h3 class="mx-auto text-center" style="width: 200px; color: darkred">Red Team</h3>


            <jsp:include page="/WEB-INF/partials/footer.jsp"></jsp:include>
        </footer>

    </div>


</body>
</html>
