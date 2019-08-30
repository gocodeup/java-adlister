<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container">
    <h1>Search for an Ad!</h1>
    <form action="/search" method="post">
        <div class="form-group">
            <label for="description">Search</label>
            <textarea id="description" name="description" class="form-control" type="text">
        </textarea>
            <button type="button" id="submitbtn">submit</button>
        </div>
    </form>

    <c:forEach var="ad" items="${ads}">
        <c:if test="${sessionScope.searched != null}">
            <c:if test="${ad.title || ad.description || ad.date || ad.category == sessionScope.searched}">
                <div class="col-md-6">
                    <h2>${ad.title}</h2>
                    <p>${ad.description}</p>
                    <p>${ad.category_id}</p>
                    <p>${ad.block_id}</p>
                    <p>${ad.date}</p>
                </div>
            </c:if>
        </c:if>
        <c:if test="${sessionScope.searched = null}">
            <div class="col-md-6">
                <h2>${ad.title}</h2>
                <p>${ad.description}</p>
            </div>
        </c:if>
    </c:forEach>
</div>

</body>
</html>
