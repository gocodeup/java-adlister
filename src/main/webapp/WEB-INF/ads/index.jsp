<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
<%--          <jsp:include page="../partials/dropdown.jsp" /> %>--%>
</head>
<body>
<jsp:include page="../partials/navbar.jsp" />
<jsp:include page="../partials/dropdown.jsp" />
<div class="container">
    <h1 class="text-center mt-5">Here Are all the ads!</h1>
    <div class="row">
        <c:forEach var="ad" items="${ads}">
        <br>
            <div class="col-12 col-md-4 mb-1">


    <div class="card mt-5 text-center">
        <div class="card-img">
            <img class="card-img-top"
                 src="https://picsum.photos/300/200"
                 alt="Card image">
        </div>
        <div class="card-body">
            <div class="card-body-primary">
                <h4 class="card-title">${ad.title}</h4>
                <em class="card-text"><fmt:formatNumber value="${ad.price}" type="currency"/></em>
            </div>
            <div class="card-body-secondary">
                <p class="card-text">${ad.description}</p>
            </div>
        </div>
        <div class="card-footer text-center">
            <form action = "/adDetails" method="POST">
                <button name="button" class="edit button btn-info" type=submit value="${ad.id}">adDetails</button>
            </form>
        </div>
    </div>

        </div>
    </c:forEach>
    </div>
    </div>
    <br>
</body>
</html>
