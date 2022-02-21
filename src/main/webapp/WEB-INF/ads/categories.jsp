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

  <div class="category text-center justify-content-around">
    <span class="align-baseline w3-tag w3-grey w3-margin-bottom w3-margin-left"><a href="${pageContext.request.contextPath}/ads/categories?category=Automotive">Automobile</a></span>
    <span class="align-top w3-tag w3-grey w3-margin-bottom"><a href="${pageContext.request.contextPath}/ads/categories?category=Clothing">Clothing</a></span>
    <span class="align-bottom w3-tag w3-grey w3-margin-bottom"><a href="${pageContext.request.contextPath}/ads/categories?category=Electronics">Electronics</a></span>
    <span class="align-top w3-tag w3-grey w3-margin-bottom"><a href="${pageContext.request.contextPath}/ads/categories?category=Furniture">Furniture</a></span>
    <span class="align-baseline w3-tag w3-grey w3-margin-bottom"><a href="${pageContext.request.contextPath}/ads/categories?category=Home">Home</a></span>
    <span class="align-baseline w3-tag w3-grey w3-margin-bottom"><a href="${pageContext.request.contextPath}/ads/categories?category=Miscellaneous">Miscellaneous</a></span>
    <span class="align-bottom w3-tag w3-grey w3-margin-bottom"><a href="${pageContext.request.contextPath}/ads/categories?category=Toys">Toys</a></span>
    <span class="align-top w3-tag w3-grey w3-margin-bottom"><a href="${pageContext.request.contextPath}/ads/categories?category=Tools">Tools</a></span>

  </div>

  <div class="container">
    <h3 class="title my-5">Category: ${category}</h3>
    <div class="display-cards  row row-cols-4" style="width: 100%">
      <c:if test="${ads.isEmpty()}">
        <h5>No ads found. <a href="${pageContext.request.contextPath}/ads"> Explore all ads</a></h5>
      </c:if>
      <c:forEach var="ad" items="${ads}">
        <div class="card my-1 mx-1" style="width: 18rem;">
          <form action="/ads/individualAd" method="GET">
            <input type="hidden" name="ad" value="${ad.id}">
            <h3 style="color:#398AB9;">${ad.title}</h3>
            <p>${ad.description}</p>
            <button class="btn-light">Show Ad</button>
          </form>
        </div>
      </c:forEach>
    </div>

<%--</div>--%>



  </div>

  <a class="back-button " href="/index.jsp"><i class="fa fa-chevron-left" aria-hidden="true"></i>Return Home</a>
  <a class="back-button mx-5" href="/ads" aria-hidden="true">See all Ads<i class="fa fa-chevron-right" aria-hidden="true"></i></a>
</div>


<jsp:include page="/WEB-INF/partials/footer.jsp"></jsp:include>
</body>
</html>
