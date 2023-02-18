<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="/WEB-INF/partials/head.jsp">
    <jsp:param name="title" value="Editing ad" />
  </jsp:include>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
</head>
<body>
<div class="container ">
  <h1>Edit your Ad "${ad.title}"</h1>
  <form action="/ads/edit" method="post">
    <input class="d-none" name="id" value="${ad.id}">
    <div class="form-group">
      <label for="title">Title</label>
      <input id="title" name="title" class="form-control" type="text" value="${ad.title}">
    </div>
    <div class="form-group">
      <label for="description">Description</label>
      <textarea id="description" name="description" class="form-control" type="text">${ad.description}</textarea>
    </div>
    <input type="submit" class="btn btn-block btn-primary">
    <div class="row text-nowrap">

      <c:forEach var="cat" items="${categories}">
        <c:set var="id" value="${cat.id}" />
        <div class="col-3">
          <input class="form-check-input me-1" name="category" type="checkbox" value="${cat.id}"
          <c:forEach var="catTrue" items="${checked}">
            <c:set var="id1" value="${catTrue.catId}" />
          <c:if test="${id1 == id}">
                 checked</c:if>
          </c:forEach>
                 id="${cat.category}">
          <label class="form-check-label" for="${cat.category}">${cat.category}</label>
        </div>
      </c:forEach>
    </div>
  </form>
</div>
<jsp:include page="../partials/footer.jsp"></jsp:include>
</body>
</html>

