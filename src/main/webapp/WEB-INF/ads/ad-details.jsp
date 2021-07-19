<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Ad Details"/>
    </jsp:include>

</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<h1 style="text-align: center">Ad Details</h1>
<div>
    <div>
        <div style="text-align: center">

            <div class="card ">
                <h4>${viewAdInfo.title}</h4>
                <p>${viewAdInfo.description}</p>
                <c:forEach var="cat" items="${categories}">
                <span>
                        ${cat}
                </span>
                </c:forEach>
                <br>
                <div class="button-container">
                    <form action="/ads/delete?id=${viewAdInfo.id}" method="post">
                        <button class="btn btn-primary delete" type="submit">Delete</button>
                    </form>
                    <form action="/ads/edit?id=${viewAdInfo.id}" method="post">
                        <a href="/ads/edit?id=${viewAdInfo.id}" class="btn btn-primary" type="submit">Edit</a>
                    </form>
                </div>

                <div>
                    <h4>Created by: ${viewUserInfo.username}</h4>

                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>