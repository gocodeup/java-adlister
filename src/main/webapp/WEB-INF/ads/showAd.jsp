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
    <title><c:out value="${ad.title}"/></title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">

</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<%--consider page being a card--%>
<main class="container">
    <div class="card w-100">
        <div class="card-body pb-0">
            <h3 class="card-title"><c:out value="${ad.title}"/></h3>
            <p class="card-text">${ad.description}</p>
            <ul class="list-group list-group-horizontal justify-content-end align-items-end">
                <li class="list-group-item border-0 p-1"><c:out value="${adUser.username}"/></li>
                <li class="list-group-item border-0 p-1"><a href="mailto: ${adUser.email}"><c:out value="${adUser.email}"/></a></li>
                <li class="list-group-item border-0 p-1">
                    <form action="/ads/update" method="get" class="mb-0">
                        <input type="hidden" name="ad_id" value="${ad.id}"/>
                        <input class="btn btn-secondary btn-sm" name="update" type="submit" value="Edit"/>
                    </form>
                </li>
                <li class="list-group-item border-0 p-1">
                    <form action="/ads/delete" method="post" class="mb-0">
                        <input type="hidden" name="ad_id" value="${ad.id}"/>
                        <input class="btn btn-danger btn-sm" name="delete" type="submit" value="Delete"/>
                    </form>
                </li>
            </ul>
        </div>
    </div>
    <%--FOR LOOP to display all categories an ad belongs to ad.category_id.getName()--%>
    <%--Still need to work on categories--%>
    <%--    <ul>--%>
    <%--        <li>Jobs</li>--%>
    <%--        <li>Housing</li>--%>
    <%--        <li>For Sale</li>--%>
    <%--        <li>Community</li>--%>
    <%--    </ul>--%>
</main>

<jsp:include page="/WEB-INF/partials/scripts.jsp"/>
</body>
</html>
