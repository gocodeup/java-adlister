<%--
  Created by IntelliJ IDEA.
  User: jose
  Date: 2/14/22
  Time: 2:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Individual Ad" />
    </jsp:include>
    <link rel="stylesheet" href="/stylesheets/styles.css">
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Your Ad</h1>
<c:if test="${sessionScope.user == null}">
<div>
    <div class="card" style="width: 35rem;">
        <h2 style="color:#398AB9;"> Title: ${ad.title} </h2>
        <h3> Description: ${ad.description}</h3>
        <h3>User: ${userAd}</h3>
    </div>
</div>

        <br>
        <br>
        <a class="back-button" href="/ads"><i class="fa fa-chevron-left" aria-hidden="true"></i>Back to Ads</a>
    </div>
    </c:if>
<%--after user logged in/ on user profile--%>
    <c:if test="${sessionScope.user != null}">
        <div>
            <div class="card" style="width: 35rem;">
                <h2 style="color:#398AB9;"> Title: ${ad.title} </h2>
                <h3> Description: ${ad.description}</h3>
                <h3>User: ${userAd}</h3>
            </div>
        </div>

        <br>
        <br>
        <a class="back-button mx-auto" href="/profile"><i class="fa fa-chevron-left" aria-hidden="true"></i>Back to Profile</a>
        <a class="back-button mx-5" href="/ads">Back to Ads<i class="fa fa-chevron-right" aria-hidden="true"></i></a>
        </div>


    </c:if>




    <jsp:include page="/WEB-INF/partials/footer.jsp"></jsp:include>
</body>
</html>
