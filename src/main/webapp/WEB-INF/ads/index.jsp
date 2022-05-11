<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="d-flex " >
    <c:forEach var="ad" items="${ads}">

        <div class="card col-md-6 m-5 p-3" style="width: 20rem;">
            <div class="card-body">
                <div class="text-center">
                                <c:choose>
                                    <c:when test="${ad.catId == 1}">
                                        <i class="fa-solid fa-burger fa-2xl m-4"></i>
                                    </c:when>
                                    <c:when test="${ad.catId == 2}">
                                        <i class="fa-solid fa-landmark fa-2xl m-4"></i>
                                    </c:when>
                                    <c:when test="${ad.catId == 3}">
                                        <i class="fa-solid fa-solid fa-person-hiking fa-2xl m-4"></i>
                                    </c:when>
                                    <c:when test="${ad.catId == 4}">
                                        <i class="fa-solid fa-people-line fa-2xl m-4"></i>
                                    </c:when>
                                    <c:otherwise>
                                        <p>Etc</p>
                                    </c:otherwise>
                                </c:choose>

                <h3 class="card-title">${ad.title}</h3>
            </div>
                <hr>
                <p class="card-text">${ad.description}</p>
                <hr>
                <h6 class="card-subtitle mb-2 text-muted">${ad.location}</h6>


                <a class="fa-solid fa-thumbs-up" href="/like?${ad.id}"></a>



                <p>${ad.reputation} Users like this</p>
            </div>
        </div>
    </c:forEach>
</div>













<%--        <div class="col-md-6 p-3 container">--%>
<%--            <h2>${ad.title}--%>

<%--            </h2>--%>

<%--            <p>${ad.description}</p>--%>
<%--            <p>${ad.location}</p>--%>
<%--            <c:choose>--%>
<%--                <c:when test="${ad.catId == 1}">--%>
<%--                    <i class="fa-solid fa-burger fa-2xl mx-4"></i>--%>
<%--                </c:when>--%>
<%--                <c:when test="${ad.catId == 2}">--%>
<%--                    <i class="fa-solid fa-landmark fa-2xl mx-4"></i>--%>
<%--                </c:when>--%>
<%--                <c:when test="${ad.catId == 3}">--%>
<%--                    <i class="fa-solid fa-solid fa-person-hiking fa-2xl mx-4"></i>--%>
<%--                </c:when>--%>
<%--                <c:when test="${ad.catId == 4}">--%>
<%--                    <i class="fa-solid fa-people-line fa-2xl mx-4"></i>--%>
<%--                </c:when>--%>
<%--                <c:otherwise>--%>
<%--                    <p>Etc</p>--%>
<%--                </c:otherwise>--%>
<%--            </c:choose>--%>
<%--        </div>--%>



</body>
</html>
