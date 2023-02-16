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

<div class="container">
  <div class="row">
    <div class="col">
      <p> Results</p>
    </div>
    <div class="row">
      <form method="post" action="/ads/search">
      <div class="col">
        <div class="row text-nowrap">
          <c:forEach var="cat" items="${categories}">
            <c:set var="id" value="${cat.id}" />
            <div class="col-3">
              <input class="form-check-input me-1" name="category" type="checkbox" value="${cat.id}"
              <c:forEach var="catTrue" items="${checked}">
                <c:set var="id1" value="${catTrue.id}" />
              <c:if test="${id1 == id}">
                     checked</c:if>
              </c:forEach>
                     id="${cat.category}">
              <label class="form-check-label" for="${cat.category}">${cat.category}</label>
            </div>
          </c:forEach>
        </div>
      </div>
        <div class="row row-cols-1">
          <div class="col">
            <label for="name">Search Input</label>
            <input type="text" id="name" name="words" placeholder="search" value="${words}">
          </div>
          <div class="col">
            <button class="btn" type="submit">Submit</button>
          </div>
        </div>
      </form>
    </div>
  </div>
  <div class="container cmh cmw overflow-scroll">
    <div class="row row-cols-1">
      <c:forEach var="ad" items="${ads}">
        <a class="unstyle" href="ads/ad?${ad.id}">
          <div class="row">
            <h2>${ad.title}</h2>
          </div>
          <div class="row dmh overflow-hidden">
            <p>${ad.description}</p>
          </div>
          <div class="row row-cols-4">
            <c:forEach var="cat" items="${ad.categories}">
              <div class="col col-3">
                <span>${cat.name}</span>
              </div>
            </c:forEach>
          </div>
        </a>

      </c:forEach>
    </div>
  </div>

</div>
<jsp:include page="../partials/footer.jsp"></jsp:include>
</body>
</html>
