<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile"/>
    </jsp:include>
    <link rel="stylesheet" href="/styles.css">
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container">
    <h1>Welcome, <c:out value="${sessionScope.user.username }"/>!</h1>
</div>

<div class="container">

<h3>Your Ads:</h3>
    <c:forEach var="ad" items="${userAd}">


        <div class="col-md-6">
            <h2>${ad.title}</h2>
            <p>${ad.description}</p>
            <br>
            <a href="${pageContext.request.contextPath}/ads/updateAds?ad_id=${ad.id}"
               class="btn btn-sm ">Update</a>
            <a href="${pageContext.request.contextPath}/ads/delete?ad_id=${ad.id}"
               onclick="return confirm('Are you sure you want to delete this item?')"
               class="btn btn-sm ">Delete</a>

        </div>


    </c:forEach>


</div>
<br>
<div>

    <a href="/editProfile" onclick="w3_close()"
       class="w3-bar-item w3-button w3-padding w3-text-teal"><i
            class="fa fa-th-large fa-fw w3-margin-right"></i>EDIT PROFILE</a>

</div>

</body>
</html>
