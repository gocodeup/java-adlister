<%--
  Created by IntelliJ IDEA.
  User: aidajimenez
  Date: 2/16/22
  Time: 9:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Update your Ad" />
    </jsp:include>
    <link rel="stylesheet" href="/stylesheets/styles.css">
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container">
    <h1 class="display-4">Update your Ad</h1>



    <form action="/ads/updateAds" method="POST">
        <div class="form-group">
            <label for="updateTitle">Title</label>
            <input id="updateTitle" name="updateTitle" class="form-control" type="text" value="${title}">
            <input type="hidden" name="ad_id" value="${ad_id}">
        </div>
        <div class="form-group">
            <label for="updateDescription">Description</label>
            <textarea id="updateDescription" name="updateDescription" class="form-control" type="text">${description}</textarea>
        </div>
        <input type="submit" class="btn btn-block btn-dark">
    </form>

</div>
<div class="container-fluid my-5">
    <a class="back-button" href="/profile"><i class="fa fa-chevron-left" aria-hidden="true"></i>Back to Profile</a>
</div>
<jsp:include page="/WEB-INF/partials/footer.jsp"></jsp:include>
</body>
</html>
