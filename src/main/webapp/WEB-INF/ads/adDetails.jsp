<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <div class="row">
    <c:forEach var="ad" items="${ads}">

        <div class="col-12">
            <div class="card text-center mx-auto mt-5" style="width: 50%">
                <div class="card-img">
                    <img class="card-img-top"
                         src="https://picsum.photos/300/200"
                         alt="Card image">
                </div>
                <div class="card-body">
                    <div class="card-body-primary">
                        <h3>Posted by: ${user.username}</h3>
                        <h4 class="card-title">${ad.title}</h4>
                        <em class="card-text"><fmt:formatNumber value="${ad.price}" type="currency"/></em>
                    </div>
                    <div class="card-body-secondary">
                        <p class="card-text">${ad.description}</p>
                    </div>
                </div>
                <div class="card-footer text-center">
                <p class="center-text">Contact Seller:</p>
                <a href="mailto:${user.email}" target="_blank" class=" item center-text"><i class="fas fa-envelope fa-2x"></i></a>
            </div>

            </div>

            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>