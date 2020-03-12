<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>

</head>
<body>
    <jsp:include page="partials/navbar.jsp" />

    <div class="container">
        <h1 class="text-center mt-5">Welcome, ${sessionScope.user.username}!</h1>
        <h3 class="text-center mt-5 text-muted">${sessionScope.user.email}!</h3>
    </div>
    <div class="container-fluid d-flex flex-wrap overflow-auto">

    <c:forEach var="ad" items="${ads}">
        <div class="col-12 col-md-4 mb-1">


            <div class="card mt-5 text-center">
                <div class="card-img">
                    <img class="card-img-top"
                         src="https://picsum.photos/300/200"
                         alt="Card image">
                </div>
                <div class="card-body">
                    <div class="card-body-primary">
                        <h4 class="card-title">${ad.title}</h4>
                        <em class="card-text"><fmt:formatNumber value="${ad.price}" type="currency"/></em>
                    </div>
                    <div class="card-body-secondary">
                        <p class="card-text">${ad.description}</p>
                    </div>
                </div>
                <div class="card-footer text-center">
                    <form action = "/adDetails" method="POST">
                        <button name="button" class="edit button btn-info" type=submit value="${ad.id}">adDetails</button>
                    </form>
                </div>
            </div>

        </div>
    </c:forEach>
    </div>
</body>
</html>
