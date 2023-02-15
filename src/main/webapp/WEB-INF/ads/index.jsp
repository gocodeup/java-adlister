<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1 class="redirect">Here Are all the ads!</h1>

    <div class="container cmh overflow-scroll">
        <div class="row">
            <div class="col">
                <h1> Recent ad listings</h1>
            </div>
        </div>
        <div class="row row-cols-1">
            <c:forEach var="ad" items="${ads}">
                <div class="col redirect" id="${ad.id}">
                    <div class="row">
                        <h2>${ad.title}</h2>
                    </div>
                   <div class="row dmh overflow-hidden text-nowrap">
                       <p>${ad.description}</p>
                   </div>
                   <div class="row row-cols-4">
                       <c:forEach var="cat" items="${ad.categories}">
                           <div class="col col-3">
                               <span>${cat.name}</span>
                           </div>
                       </c:forEach>
                   </div>
                </div>
            </c:forEach>
        </div>
    </div>

</div>
<jsp:include page="../partials/footer.jsp"></jsp:include>
</body>
</html>
