<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<c:if test="${sessionScope.user != null}">
    <a class="back-button" href="/WEB-INF/profile.jsp"><i class="fa fa-chevron-left" aria-hidden="true"> Back to Profile</i></a>
</c:if>

<div class="cat-container" id="cat-header">
    <h1 class="display-4">Here Are all the ads!</h1>
    <div class="category">
        <span class="align-baseline w3-tag w3-grey w3-margin-bottom w3-margin-left">
            <a href="${pageContext.request.contextPath}/ads/category?category=forsale">For Sale</a></span>

        <span class="align-top w3-tag w3-grey w3-margin-bottom">
                <a href="${pageContext.request.contextPath}/ads/category?=automotive">Automotive</a></span>

        <span class="align-bottom w3-tag w3-grey w3-margin-bottom">
                <a href="${pageContext.request.contextPath}/ads/category?category=jobs">Jobs</a></span>

    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">
            <h2><c:out value="${ad.title}"/></h2>
            <p><c:out value="${ad.description}"/></p>
            <c:if  test="${ad.userId == sessionScope.user.id}" >
                <form action="/ads/update" method="get">
                    <input type="hidden" name="ad_id" value="${ad.id}">
                    <input class="btn btn-secondary btn-sm" name="update" type="submit" value="Edit">
                </form>
                <form action="/ads/delete" method="post">
                    <input type="hidden" name="ad_id" value="${ad.id}">
                    <input class="btn btn-danger btn-sm" type="submit" value="Delete">
                </form>
            </c:if>
        </div>
    </c:forEach>
</div>
        <span class="align-baseline w3-tag w3-grey w3-margin-bottom w3-margin-left">
                <a href="${pageContext.request.contextPath}/ads/category?category=forsale">Community</a></span>
    </div>
</div>
<p><hr></p>
    <div class="container">
        <div class="display-cards w3-third w3-container margin-auto" style="width: 100%;">
            <c:forEach var="ad" items="${ads}">
                <div class="card" style="width: 18rem; margin: auto">
                    <div class="card-body">
                        <h4 class="card-title">
                            <a href="${pageContext.request.contextPath}/WEB-INF/ads/showAd?id=${ad.id}">${ad.title}</a>
                        </h4>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>
