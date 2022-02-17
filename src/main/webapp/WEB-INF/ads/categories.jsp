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
  <link rel="stylesheet" href="/styles.css">
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
  <h1>All Categories</h1>

  <c:forEach var="category" items="${categories}">
    <div class="col-md-6">
      <ul>

      </ul>
    </div>
  </c:forEach>
</div>



<jsp:include page="/WEB-INF/partials/footer.jsp"></jsp:include>
</body>
</html>
