<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>ad</title>
  <jsp:include page="/WEB-INF/partials/head.jsp" />
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar-create.jsp" />
<div class="col-md-6">
  <p>${singleAd.title}</p>
  <p>${singleAd.description}</p>
</div>
</body>
</html>