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

<h1><c:out value="${ad.title}"/></h1>
<c:if test="${userId == ownerId}">
    <form action="/ads/delete?${ad.id}" method="post">
        <button type="submit">Delete Ad</button>
    </form>
    <form action="/ads/edit?${ad.id}" method="post">
        <button type="submit">Edit Ad</button>
    </form>
</c:if>
    <div class="col-md-6">
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
<jsp:include page="../partials/footer.jsp"></jsp:include>
</body>
</html>
