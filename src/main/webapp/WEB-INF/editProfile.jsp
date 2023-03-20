<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="/WEB-INF/partials/head.jsp">
    <jsp:param name="title" value="Your Profile" />
  </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/userNavbar.jsp" />

<div class="container">
  <h1>Edit your profile below ${sessionScope.user.username}!</h1>
</div>

</body>
</html>
