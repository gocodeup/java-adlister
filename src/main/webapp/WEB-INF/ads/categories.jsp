<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jose
  Date: 2/16/22
  Time: 11:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="/WEB-INF/partials/head.jsp">
    <jsp:param name="title" value="Viewing All Categories"/>
  </jsp:include>
  <link rel="stylesheet" href="/stylesheets/styles.css">
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
  <h1>All Categories</h1>

<div class="category">
  <span class="align-baseline w3-tag w3-grey w3-margin-bottom w3-margin-left"><a href="${pageContext.request.contextPath}/ads/categories?categories=Automobile">Automobile</a></span>
  <span class="align-top w3-tag w3-grey w3-margin-bottom"><a href="${pageContext.request.contextPath}/ads/categories?categories=Clothing">Clothing</a></span>
  <span class="align-bottom w3-tag w3-grey w3-margin-bottom"><a href="${pageContext.request.contextPath}/ads/categories?categories=Electronics">Electronics</a></span>
  <span class="align-top w3-tag w3-grey w3-margin-bottom"><a href="${pageContext.request.contextPath}/ads/categories?categories=Furniture">Furniture</a></span>
  <span class="align-baseline w3-tag w3-grey w3-margin-bottom"><a href="${pageContext.request.contextPath}/ads/categories?categories=Home">Home</a></span>
  <span class="align-baseline w3-tag w3-grey w3-margin-bottom"><a href="${pageContext.request.contextPath}/ads/categories?categories=Miscellaneous">Miscellaneous</a></span>
  <span class="align-bottom w3-tag w3-grey w3-margin-bottom"><a href="${pageContext.request.contextPath}/ads/categories?categories=Toys">Toys</a></span>
  <span class="align-top w3-tag w3-grey w3-margin-bottom"><a href="${pageContext.request.contextPath}/ads/categories?categories=Tools">Tools</a></span>

</div>

  <div class="container">
    <h1 class="display-4">Category: ${category}</h1>
    <div class="display-cards" style="width: 100%">
      <c:if test="${ads.isEmpty()}">
        <h4>No ads found. <a href="${pageContext.request.contextPath}/ads">View all ads</a></h4>
      </c:if>
      <c:forEach var="ad" items="${ads}">
<%--        <div class="card" style="width: 18rem;">--%>
<%--          <div class="card-body">--%>
<%--            <a href="${pageContext.request.contextPath}/ads/categories?id=${ad.id}">${ad.title}${ad.category}</a>--%>
<%--            <h5 class="card-title">${ad.title}</h5></a>--%>
<%--            <p>${ad.description}</p>--%>
<%--          </div>--%>
<%--        </div>--%>
        <div>${ad.title}</div>
      </c:forEach>
    </div>

<%--</div>--%>




<a class="back-button" href="/ads"><i class="fa fa-chevron-left" aria-hidden="true">Back to Ads</i></a>

<jsp:include page="/WEB-INF/partials/footer.jsp"></jsp:include>
</body>
</html>
