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
                    <div class="d-flex flex-row text-center">
                        <a class="fa-solid fa-thumbs-up pt-1" href="/like?${ad.id}"></a>
                        <p class="ps-3">${ad.reputation} Users like this</p>
                    </div>
                    <hr>
                    <h6 class="card-subtitle mb-2 text-muted">${ad.location}</h6>
                </div>
            </div>
        </c:forEach>
    </div>

<jsp:include page="/WEB-INF/partials/footer.jsp" />
</body>
</html>
