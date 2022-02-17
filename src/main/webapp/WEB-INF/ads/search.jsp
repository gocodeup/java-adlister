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

    <title>Search</title>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<div class="container">
    <h1>You Search Results:</h1>

<%--//added some style to show add in a card*** Agutierrez--%>
<c:if test="${ads != null}">
    <c:forEach var="ad" items="${ads}">
        <div class="card" style="width: 18rem;">
            <div class="card-body">
                <h2><a href="${pageContext.request.contextPath}/ads/individualAd?id=${ad.id}">${ad.title}</a></h2>
                 <p>${ad.description}</p>
            </div>
        </div>
</c:forEach>
</c:if>

    <c:if test="${ads.isEmpty()}">
        <h3>No Search Results Found</h3>
    </c:if>

    <a href="${pageContext.request.contextPath}/ads">Return to all ads</a>
</div>

</body>
</html>
