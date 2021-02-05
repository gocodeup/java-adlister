<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Update Ad" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Update</h1>
        <form action="/update" method="post">
            <div class="form-group">
                <label for="name">Name</label>
                <input id="name" name="name" class="form-control" type="text" value="${ad.name}">
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <textarea id="description" name="description" class="form-control" type="text">${ad.description}</textarea>
            </div>
            <div class="form-group">
                <label for="imageURL">Image URL</label>
                <input id="imageURL" name="imageURL" class="form-control" type="text" value="${ad.imageURL}">
            </div>
            <div class="form-group">
                <label for="price">Price</label>
                <input id="price" name="price" class="form-control" type="text" value="${ad.price}">
            </div>
            <div class="form-group">
                <strong>Shiny</strong><br>
                <label for="yes" class="radio-inline"><input type="radio" class="form-check-input" id="yes" name="shiny" value="Yes" <c:if test="${ad.shiny eq 'Yes'}">checked</c:if>> Yes</label>
                <label for="no" class="radio-inline"><input type="radio" class="form-check-input" id="no" name="shiny" value="No" <c:if test="${ad.shiny eq 'No'}">checked</c:if>> No</label>
            </div>
            <div class="form-group">
                <label for="type">Type</label>
                <select id="type" name="type" class="form-control">
                    <option></option>
                    <c:forEach var="type" items="${types}">
                        <option value="${type.type}" <c:if test="${type.type eq ad.type}">selected</c:if>>${type.type}</option>
                    </c:forEach>
                </select>
            </div>
            <input type="hidden" name="id" value="${ad.id}">
            <input type="submit" class="btn btn-block btn-primary">
        </form>
    </div>
</body>
</html>
