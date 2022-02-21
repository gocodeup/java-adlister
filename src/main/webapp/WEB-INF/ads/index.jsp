<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
    <link rel="stylesheet" href="/stylesheets/styles.css">
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container-fluid " style=" margin-left: 50px; margin-right: 50px;">
    <h1>Here Are all the ads!</h1>

<c:if test="${sessionScope.user == null}">
    <div class="display-cards row row-cols-5 " >
        <c:forEach var="ad" items="${ads}">
            <div class="card mx-2 my-2" style="width: 18rem">
                <form action="/ads/individualAd" method="GET">
                        <%--            <h2><a href="/ads/individualAd">${ad.id}</a></h2>--%>
                    <input type="hidden" name="ad" value="${ad.id}">
                        <%--            <h2><a href="<c:url value='/ads/individualAd?id=${ad.id}'/>"${ad.title}/></h2>--%>
                    <h3 style="color:#398AB9;">${ad.title}</h3>
                    <p>${ad.description}</p>
                    <button class="btn-light d-flex align-self-end">Show Ad</button>
                </form>

                    <%--            <p>${ad.description}</p>--%>

            </div>

        </c:forEach>
    </div>

    <a class="back-button" href="/index.jsp"><i class="fa fa-chevron-left" aria-hidden="true"></i>Return Home</a>
</div>

</c:if>

<%--after user logged in--%>
<c:if test="${sessionScope.user != null}">
    <div class="display-cards row row-cols-5 " >
    <c:forEach var="ad" items="${ads}">
        <div class="card mx-2 my-2" style="width: 18rem">
            <form action="/ads/individualAd" method="GET">
<%--            <h2><a href="/ads/individualAd">${ad.id}</a></h2>--%>
            <input type="hidden" name="ad" value="${ad.id}">
<%--            <h2><a href="<c:url value='/ads/individualAd?id=${ad.id}'/>"${ad.title}/></h2>--%>
            <h3 style="color:#398AB9;">${ad.title}</h3>
            <p>${ad.description}</p>
            <button class="btn-light d-flex align-self-end">Show Ad</button>
            </form>

<%--            <p>${ad.description}</p>--%>

        </div>

    </c:forEach>
    </div>

    <a class="back-button" href="/profile"><i class="fa fa-chevron-left" aria-hidden="true"></i>Back to Profile</a>
</div>

</c:if>
<jsp:include page="/WEB-INF/partials/footer.jsp"></jsp:include>
</body>
</html>
