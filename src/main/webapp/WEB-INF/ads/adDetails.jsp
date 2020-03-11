<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <div class="card shadow p-3 mt-5 bg-white rounded text-center" style="width: 100%; height: 40em">
                <div class="card-body">
<%--        <div class="col">--%>
            <h3>posted by ${user.username}</h3>
            <h2>${ad.title}</h2>
            <p>${ad.description}</p>
            <div><h4>Contact Seller:    <a href="mailto:${user.email}" target="_blank" class="notBlue item"><i class="fas fa-envelope fa-2x"></i></a></h4>
<%--            </div>--%>
        </div>
                </div>
            </div>
        </div>

    </c:forEach>
</div>
</div>
<%--</div>--%>
</body>
</html>