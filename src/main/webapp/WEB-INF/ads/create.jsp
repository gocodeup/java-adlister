<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your New Ad" />
    </jsp:include>
    <jsp:include page="/WEB-INF/partials/navbar.jsp"></jsp:include>
</head>
<body>
    <div class="container ">
        <h1>Create a new Ad</h1>
        <form action="/ads/create" method="post">
            <div class="form-group">
                <label for="title">Title</label>
                <input id="title" name="title" class="form-control" type="text" value="<c:out value="${ad.title}"/>">
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <textarea id="description" name="description" class="form-control" type="text"><c:out value="${ad.description}"/></textarea>
            </div>
            <input type="submit" class="btn btn-block btn-primary">
            <div class="row text-nowrap">

                        <c:forEach var="cat" items="${categories}">
                            <c:set var="id" value="${cat.id}" />
                            <div class="col-3">
                                <input class="form-check-input me-1" name="category" type="checkbox" value="${cat.id}"
                                <c:forEach var="catTrue" items="${checked}">
                                    <c:set var="id1" value="${catTrue.id}" />
                                <c:if test="${fn:contains(id1,id)}">
                                checked</c:if>
                                </c:forEach>
                                       id="${cat.category}">
                                <label class="form-check-label" for="${cat.category}">${cat.category}</label>
                            </div>
                        </c:forEach>
            </div>
        </form>
    </div>
    <div>
        <h1><c:out value="${error.name}"/></h1>
    </div>


    <jsp:include page="../partials/footer.jsp"></jsp:include>
</body>
</html>

