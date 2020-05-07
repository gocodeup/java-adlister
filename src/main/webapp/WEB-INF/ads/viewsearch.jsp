<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: smurfkat
  Date: 5/6/20
  Time: 3:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
   <jsp:include page="/WEB-INF/partials/head.jsp">
      <jsp:param name="title" value="Search" />
   </jsp:include>
</head>
<body>
   <jsp:include page="/WEB-INF/partials/navbar.jsp" />

   <div class="container">
      <h1>Here are the results for your search</h1>
<%--loop through the ads and display the ones searched for--%>
      <c:forEach var="ad" items="${ads}">
         <div class="col-md-6">
            <a href="/ad?id=${ad.id}"><h2>${ad.name}</h2></a>
            <p>${ad.description}</p>
         </div>
      </c:forEach>
   </div>
</body>
</html>
