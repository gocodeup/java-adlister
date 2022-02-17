<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="javascript" %>--%>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <div class="row pt-3">
            <h1>Welcome to the Adlister!</h1>
            <h4>Buy, Sell, Trade, and Job postings.</h4>
        </div>
        <div class="col-5">
            <div class="card">
                <div class="card-body reg">
                    <h5 class="card-title font-weight-bold">Please register.</h5>
                    <p class="card-text">Post your listings here.</p>
                    <form action="/register" method="GET">

                        <a href="/register" class="nav-link btn btn-primary text-light blk" style="background: #d4372b">Register</a>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <form class="row pt-4" action="/ads" method="GET">
        <a class="red-hover w-text" href="/category?value=0"> View recent ads. </a>
    </form>
    <div class="scrollBx ">
        <c:forEach var="ad" items="${all}">
            <a class="blk" href="/viewAd?adId=${ad.id}" class="dark">
                <div class="cards mr-2">
                    <h2>${ad.title}</h2>
                    <p>${ad.description}</p>
                    <p>Categories: ${ad.category}</p>
                <br>
                    <p>Created by: ${ad.username} on, ${ad.dateCreated}</p>
                </div>
            </a>
        </c:forEach>
    </div>

    <form class="row pt-4" action="/ads" method="GET">
        <a class="red-hover w-text" href="/category?value=1"> Automotive </a>
    </form>
    <div class="scrollBx ">
        <c:forEach var="ad" items="${all}">
            <a class="blk" href="/viewAd?adId=${ad.id}" >
                <div class="cards mr-2">
                    <h2>${ad.title}</h2>
                    <p>${ad.description}</p>
                    <p>Categories: ${ad.category}</p>
                    <br>
                    <p>Created by: ${ad.username} on, ${ad.dateCreated}</p>
                </div>
            </a>
        </c:forEach>
    </div>
    <form class="row pt-4" action="/ads" method="GET">
        <a class="red-hover w-text" href="/category?value=3">Jobs </a>
    </form>
    <div class="scrollBx ">
        <c:forEach var="ad" items="${all}">
            <a class="blk" href="/viewAd?adId=${ad.id}" >
                <div class="cards mr-2">
                    <h2>${ad.title}</h2>
                    <p>${ad.description}</p>
                    <p>Categories: ${ad.category}</p>
                    <br>
                    <p>Created by: ${ad.username} on, ${ad.dateCreated}</p>
                </div>
            </a>
        </c:forEach>
    </div>
    <form class="row pt-4" action="/ads" method="GET">
        <a class="red-hover w-text" href="/category?value="> Community</a>
    </form>
    <div class="scrollBx ">
        <c:forEach var="ad" items="${all}">
            <a class="blk" href="/viewAd?adId=${ad.id}">
                <div class="cards mr-2">
                    <h2>${ad.title}</h2>
                    <p>${ad.description}</p>
                    <p>Categories: ${ad.category}</p>
                    <br>
                    <p>Created by: ${ad.username} on, ${ad.dateCreated}</p>
                </div>
            </a>
        </c:forEach>
    </div>
    <form class="row pt-4" action="/category" method="get">
        <a class="red-hover w-text" href="category?value5">Furniture</a>
    </form>
        <div class="scrollBx ">
            <c:forEach var="ad" items="${all}">
                <a class="blk" href="/viewAd?adId=${ad.id}">
                    <div class="cards mr-2">
                        <h2>${ad.title}</h2>
                        <p>${ad.description}</p>
                        <p>Categories: ${ad.category}</p>
                        <br>
                    </div>
                </a>
            </c:forEach>

        </div>
</body>
</html>
