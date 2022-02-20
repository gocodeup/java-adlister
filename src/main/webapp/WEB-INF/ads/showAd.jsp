<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: julianmartinez
  Date: 2/14/22
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%--    added by ND--%>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Ad Info"/>
    </jsp:include>
    <link rel="stylesheet" href="/mainNav.css">
    <title>Title</title>
    <title><c:out value="${ad.title}" /> </title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
</head>

<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<%--added back button--%>
<a class="back-button" href="/ads"><i class="fa fa-chevron-left" aria-hidden="true">Back to Ads</i></a


<%--consider page being a card--%>
<main class="container">
<%--    <h2>Your Ad Title: <c:out value="${ad.title}"/></h2>--%>
<%--    <p>${ad.description}</p>--%>
<%--    <h5>${ad.user_id.getName()}</h5>--%>
<%--    <h6>${ad.user_id.getEmail()}</h6>--%>
   <div class="display-cards">
       <div class="card" style="width: 18rem"><
           <h2>Ad Title</h2>
           <p>${ad.description}</p>

           <h5>Contact Info</h5>
           <h5>User: ${user.username}</h5>
           <h5>Email: ${user.email}</h5>

           <h5>ad.user_id.getName()</h5>
           <h6>ad.user_id.getEmail()</h6>
           <h3>Categories</h3>
           <%--FOR LOOP to display all categories an ad belongs to ad.category_id.getName()--%>
           <ul>
               <li>Jobs</li>
               <li>Housing</li>
               <li>For Sale</li>
               <li>Community</li>
           </ul>
       </div>
   </div>
</main>
</body>
</html>
