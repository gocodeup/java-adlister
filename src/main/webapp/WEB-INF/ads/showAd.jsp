<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tripp
  Date: 2/10/23
  Time: 5:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Listing" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<c:set var="userId" value="${sessionScope.user.id}"/>
<c:set var="ownerId" value="${requestScope.owner.id}"/>



<div class="col-md-12" style="text-align: center">

    <h1><c:out value="${ad.title}"/></h1>
<%--    <c:if test="${userId == ownerId}">--%>
<%--        <a href="/ads/delete?${ad.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Delete Ad</a>--%>
<%--        <a href="/ads/edit?${ad.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Edit Ad</a>--%>
<%--    </c:if>--%>
    <div>
        <p><c:out value = "${ad.description}"/></p>
    </div>
    <div>
        <h1><c:out value="${owner.email}" /></h1>
    </div>
    <div>
        <c:forEach var="cat" items="${ad.categories}">
            <span>${cat.name}</span>
        </c:forEach>
    </div>
    <br>
    <c:if test="${userId == ownerId}">
        <a href="/ads/delete?${ad.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true" style="width: 50%">Delete Ad</a>
        <br>
        <br>
        <a href="/ads/edit?${ad.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true" style="width: 50%">Edit Ad</a>
    </c:if>
</div>

<jsp:include page="../partials/footer.jsp"></jsp:include>
</body>
</html>
