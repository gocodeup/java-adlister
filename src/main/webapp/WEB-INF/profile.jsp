<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="messages.jsp"%>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
<%--    <link href="https://api.magicthegathering.io/v1/cards">--%>
<%--    <script language="JavaScript" src="js/mtg-require.js"></script>--%>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
        <div class="col-lg-12">
            <h1>Here Are all the user ads!</h1>
            <c:forEach var="ad" items="${ads}">
                <div class="col-md-4" style="border: black 1px; padding: 5em">
                    <div class="individual-ad" style="border: black 1px">
                        <h1>${ad.title}</h1>
                        <p>${ad.description}</p>
                        <hr>
                        <script>
                            card
                        </script>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>


</body>
</html>
