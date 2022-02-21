<%--
  Created by IntelliJ IDEA.
  User: aidajimenez
  Date: 2/14/22
  Time: 3:07 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Search Ads" />
    </jsp:include>
    <link rel="stylesheet" href="/stylesheets/styles.css">
    <title>Search</title>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>


<div class="container">

    <h1>You Search Results:</h1>

<%--//added some style to show add in a card*** Agutierrez
NOTE: when click to indv ad gives error--%>

    <div class="container-fluid my-5 justify-content-around">

    <div class="display-cards row row-cols-4">


<c:if test="${ads != null}">
    <c:forEach var="ad" items="${ads}">
        <div class="card mx-1 my-1" style="width: 18rem;">
            <div class="card-body">
                <form action="/ads/individualAd" method="GET">
                    <input type="hidden" name="ad" value="${ad.id}">
                    <h3 style="color:#398AB9;">${ad.title}</h3>
                    <p>${ad.description}</p>
                    <button class="btn-light">Show Ad</button>
                </form>
            </div>
        </div>



</c:forEach>
    </div>
</c:if>

    <c:if test="${ads.isEmpty()}">
        <h3>No Search Results Found</h3>
    </c:if>


</div>

    <a class="back-button mx-auto" href="/profile"><i class="fa fa-chevron-left" aria-hidden="true"></i>Back to Profile</a>


    <a class="back-button mx-5"  href="${pageContext.request.contextPath}/ads" aria-hidden="true">See all ads<i class="fa fa-chevron-right" aria-hidden="true"></i></a>
</div>


<jsp:include page="/WEB-INF/partials/footer.jsp"></jsp:include>
</body>
</html>
