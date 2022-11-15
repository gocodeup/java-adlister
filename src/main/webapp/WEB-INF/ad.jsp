<%--
  Created by IntelliJ IDEA.
  User: casanovageary
  Date: 11/14/22
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ad</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar-create-ad.jsp" />
<div class="col-md-6">
<p>${singleAd.title}</p>
<p>${singleAd.description}</p>
</div>
</body>
</html>
