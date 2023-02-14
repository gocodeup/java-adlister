<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
    </div>
    <c:forEach var="ad" items="${myAds}">
        <div class="col-md-6">
            <h2>${ad.title}</h2>
            <p>${ad.description}</p>
            <a href="${pageContext.request.contextPath}/ads/ad?${ad.id}">Click here to view ad</a>
        </div>
    </c:forEach>

    <c:forEach var="ads" items="${myFavs}">
        <div class="col-md-6">
            <h2>${ads.title}</h2>
            <p>${ads.description}</p>
            <a href="${pageContext.request.contextPath}/ads/ad?${ads.id}">Click here to view ad</a>
        </div>
    </c:forEach>

<%--    <div class="main-content">--%>
<%--        <!-- Top navbar -->--%>
<%--        <nav class="navbar navbar-top navbar-expand-md navbar-dark" id="navbar-main">--%>
<%--            <div class="container-fluid">--%>
<%--                <!-- Brand -->--%>
<%--                <a class="h4 mb-0 text-white text-uppercase d-none d-lg-inline-block" href="https://www.creative-tim.com/product/argon-dashboard" target="_blank">User profile</a>--%>
<%--                <!-- Form -->--%>
<%--                <form class="navbar-search navbar-search-dark form-inline mr-3 d-none d-md-flex ml-lg-auto">--%>
<%--                    <div class="form-group mb-0">--%>
<%--                        <div class="input-group input-group-alternative">--%>
<%--                            <div class="input-group-prepend">--%>
<%--                                <span class="input-group-text"><i class="fas fa-search"></i></span>--%>
<%--                            </div>--%>
<%--                            <input class="form-control" placeholder="Search" type="text">--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </form>--%>
<%--                <!-- User -->--%>
<%--                <ul class="navbar-nav align-items-center d-none d-md-flex">--%>
<%--                    <li class="nav-item dropdown">--%>
<%--                        <a class="nav-link pr-0" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
<%--                            <div class="media align-items-center">--%>
<%--                <span class="avatar avatar-sm rounded-circle">--%>
<%--                  <img alt="Image placeholder" src="https://demos.creative-tim.com/argon-dashboard/assets-old/img/theme/team-4.jpg">--%>
<%--                </span>--%>
<%--                                <div class="media-body ml-2 d-none d-lg-block">--%>
<%--                                    <span class="mb-0 text-sm  font-weight-bold">Jessica Jones</span>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </a>--%>
<%--                        <div class="dropdown-menu dropdown-menu-arrow dropdown-menu-right">--%>
<%--                            <div class=" dropdown-header noti-title">--%>
<%--                                <h6 class="text-overflow m-0">Welcome!</h6>--%>
<%--                            </div>--%>
<%--                            <a href="../examples/profile.html" class="dropdown-item">--%>
<%--                                <i class="ni ni-single-02"></i>--%>
<%--                                <span>My profile</span>--%>
<%--                            </a>--%>
<%--                            <a href="../examples/profile.html" class="dropdown-item">--%>
<%--                                <i class="ni ni-settings-gear-65"></i>--%>
<%--                                <span>Settings</span>--%>
<%--                            </a>--%>
<%--                            <a href="../examples/profile.html" class="dropdown-item">--%>
<%--                                <i class="ni ni-calendar-grid-58"></i>--%>
<%--                                <span>Activity</span>--%>
<%--                            </a>--%>
<%--                            <a href="../examples/profile.html" class="dropdown-item">--%>
<%--                                <i class="ni ni-support-16"></i>--%>
<%--                                <span>Support</span>--%>
<%--                            </a>--%>
<%--                            <div class="dropdown-divider"></div>--%>
<%--                            <a href="#!" class="dropdown-item">--%>
<%--                                <i class="ni ni-user-run"></i>--%>
<%--                                <span>Logout</span>--%>
<%--                            </a>--%>
<%--                        </div>--%>
<%--                    </li>--%>
<%--                </ul>--%>
<%--            </div>--%>
<%--        </nav>--%>
<%--        <!-- Header -->--%>
<%--        <div class="header pb-8 pt-5 pt-lg-8 d-flex align-items-center" style="min-height: 600px; background-image: url(https://raw.githubusercontent.com/creativetimofficial/argon-dashboard/gh-pages/assets-old/img/theme/profile-cover.jpg); background-size: cover; background-position: center top;">--%>
<%--            <!-- Mask -->--%>
<%--            <span class="mask bg-gradient-default opacity-8"></span>--%>
<%--            <!-- Header container -->--%>
<%--            <div class="container-fluid d-flex align-items-center">--%>
<%--                <div class="row">--%>
<%--                    <div class="col-lg-7 col-md-10">--%>
<%--                        <h1 class="display-2 text-white">Hello Jesse</h1>--%>
<%--                        <p class="text-white mt-0 mb-5">This is your profile page. You can see the progress you've made with your work and manage your projects or assigned tasks</p>--%>
<%--                        <a href="#!" class="btn btn-info">Edit profile</a>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>




<%--        <!-- Page content -->--%>
<%--        <div class="container-fluid mt--7">--%>
<%--            <div class="row">--%>
<%--                <div class="col-xl-4 order-xl-2 mb-5 mb-xl-0">--%>
<%--                    <div class="card card-profile shadow">--%>
<%--                        <div class="row justify-content-center">--%>
<%--                            <div class="col-lg-3 order-lg-2">--%>
<%--                                <div class="card-profile-image">--%>
<%--                                    <a href="#">--%>
<%--                                        <img src="https://demos.creative-tim.com/argon-dashboard/assets-old/img/theme/team-4.jpg" class="rounded-circle">--%>
<%--                                    </a>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>


<%--                        <div class="card-header text-center border-0 pt-8 pt-md-4 pb-0 pb-md-4">--%>
<%--                            <div class="d-flex justify-content-between">--%>
<%--                                <a href="#" class="btn btn-sm btn-info mr-4">Connect</a>--%>
<%--                                <a href="#" class="btn btn-sm btn-default float-right">Message</a>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <div class="card-body pt-0 pt-md-4">--%>
<%--                            <div class="row">--%>
<%--                                <div class="col">--%>
<%--                                    <div class="card-profile-stats d-flex justify-content-center mt-md-5">--%>
<%--                                        <div>--%>
<%--                                            <span class="heading">22</span>--%>
<%--                                            <span class="description">Friends</span>--%>
<%--                                        </div>--%>
<%--                                        <div>--%>
<%--                                            <span class="heading">10</span>--%>
<%--                                            <span class="description">Photos</span>--%>
<%--                                        </div>--%>
<%--                                        <div>--%>
<%--                                            <span class="heading">89</span>--%>
<%--                                            <span class="description">Comments</span>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="text-center">--%>
<%--                                <h3>--%>
<%--                                    Jessica Jones<span class="font-weight-light">, 27</span>--%>
<%--                                </h3>--%>
<%--                                <div class="h5 font-weight-300">--%>
<%--                                    <i class="ni location_pin mr-2"></i>Bucharest, Romania--%>
<%--                                </div>--%>
<%--                                <div class="h5 mt-4">--%>
<%--                                    <i class="ni business_briefcase-24 mr-2"></i>Solution Manager - Creative Tim Officer--%>
<%--                                </div>--%>
<%--                                <div>--%>
<%--                                    <i class="ni education_hat mr-2"></i>University of Computer Science--%>
<%--                                </div>--%>
<%--                                <hr class="my-4">--%>
<%--                                <p>Ryan — the name taken by Melbourne-raised, Brooklyn-based Nick Murphy — writes, performs and records all of his own music.</p>--%>
<%--                                <a href="#">Show more</a>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>




<%--                &lt;%&ndash; Users adds will go here&ndash;%&gt;--%>
<%--                <div class="col-xl-8 order-xl-1">--%>
<%--                    <div class="card bg-secondary shadow">--%>
<%--                        <div class="card-header bg-white border-0">--%>
<%--                            <div class="row align-items-center">--%>
<%--                                <div class="col-8">--%>
<%--                                    <h3 class="mb-0">My account</h3>--%>
<%--                                </div>--%>
<%--                                <div class="col-4 text-right">--%>
<%--                                    <a href="#!" class="btn btn-sm btn-primary">Settings</a>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <div class="card-body">--%>
<%--                            <form>--%>
<%--                                <h6 class="heading-small text-muted mb-4">User information</h6>--%>
<%--                            </form>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>

<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>

</body>
</html>



