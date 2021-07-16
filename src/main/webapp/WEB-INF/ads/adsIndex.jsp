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
<div class="container mt-5 pt-5">
    <div class="row">
        <div class="col-3">
            <div class="card position-fixed">
                <div class="card-header text-center">
                    <p class="h5 mb-0">
                        Options
                    </p>
                </div>
                <div class="card-body">
                    <form class="mb-0" method="POST" action="/ads">
                        <div class="form-group">
                            <input name="search" type="text" class="form-control" id="inlineFormInputName2" value="${search}" placeholder="Search">
                        </div>
                        <div class="form-group">
                            <p class="h5">View</p>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="view" id="inlineRadio1" value="card" <c:if test="${view == 'card'}">checked</c:if>>
                                <label class="form-check-label" for="inlineRadio1">Cards</label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="view" id="inlineRadio2" value="list" <c:if test="${view == 'list'}">checked</c:if>>
                                <label class="form-check-label" for="inlineRadio2">List</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <p class="h5">Filter</p>
                            <c:forEach var="category" items="${categories}">
                                <div class="form-check">
                                    <input name="categories" class="form-check-input" type="checkbox" value="${category}" id="${category}" <c:if test="${filter.contains(category)}">checked</c:if>>
                                    <label class="form-check-label" for="${category}">${category}</label>
                                </div>
                            </c:forEach>
                        </div>
                        <div class="text-center">
                            <button type="submit" class="btn btn-primary">Apply</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-9">
            <c:choose>
                <c:when test="${view =='list'}">
                    <jsp:include page="/WEB-INF/ads/index.jsp"/>
                </c:when>
                <c:when test="${view == 'card'}">
                    <jsp:include page="/WEB-INF/ads/index.jsp"/>
                </c:when>
            </c:choose>
        </div>
    </div>
</div>
</body>
</html>