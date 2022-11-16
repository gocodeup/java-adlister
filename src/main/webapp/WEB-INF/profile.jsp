<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads"/>
    </jsp:include>
</head>
<body>
<<<<<<< HEAD
    <jsp:include page="/WEB-INF/partials/navbarProf.jsp" />

    <div class="container">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
    </div>
=======
<jsp:include page="/WEB-INF/partials/navbarLoggedIn.jsp"/>

<div class="container">
    <h1>Welcome ${sessionScope.user.username}</h1>


    <h3 class="text-center">Here Are all the ads!</h3>

    <c:forEach var="ad" items="${ads}">

        <div class="card text-center" style="width: 18rem;border:5px solid cornflowerblue">
            <div class="card-body">
                <h5 class="card-title">${ad.title}</h5>
                <p class="card-text">${ad.description}</p>

                <div class="row">
                    <div class="col-6">
                        <form method="get" action="updateAd"  >

                        <label for="edit"></label>
                        <input id="edit" class="invisible" type="text" name="title" value="${ad.title}">
                            <button class="btn btn-primary" type="submit" >Update Ad</button>
                        </form>
                    </div>


                    <div class="col-6">
                        <form method="post" action="deleteAd" >
                        <label for="delete"></label>
                        <input id="delete" class="invisible" type="text" name="title" value="${ad.title}">

                            <button class="btn btn-primary" type="submit" >Delete Ad</button>
                        </form>
                    </div>
                </div>

            </div>
        </div>


    </c:forEach>
</div>
>>>>>>> refs/remotes/origin/master
</body>
</html>
