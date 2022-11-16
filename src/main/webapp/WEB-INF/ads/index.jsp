<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar-ads.jsp" />

<div class="container">
    <h1>Here Are all the ads!</h1>
<%--   <form action="/products/quantity" method="post">
                        <input type="hidden" name="product_id" value="${product.id}">
                        <input type="hidden" name="product_name" value="${product.name}">
                        <input type="hidden" name="product_quantity" value="${product.quantity + 1}">
                        <input class="btn btn-increment btn-success btn-sm" type="submit" value="+1">
                    </form>--%>
    <c:forEach var="ad" items="${ads}">

        <div class="col-md-6" >
            <form action="/ads/singles" method="post">
                <input type="hidden" name="ad_id" value="${ad.id}">
            <button type="submit"><h2>${ad.title}</h2></button>
            </form>
            <p>${ad.description}</p>
        </div>

    </c:forEach>

    <c:forEach var="ad2" items="${ads2}">
        <div class="col-md-6">
            <a href="/ads/singles"><h2>${ad2.title}</h2></a>
            <p>${ad2.description}</p>
        </div>
    </c:forEach>

<%--    <div>--%>
<%--        <h2>${ads2.title}</h2>--%>
<%--        <p>${ads2.description}</p>--%>
<%--    </div>--%>
</div>

</body>
</html>
