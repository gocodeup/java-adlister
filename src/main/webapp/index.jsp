<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style><%@include file="./CSS/style.css" %></style>
    <title>Adlister</title>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
    <script src="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"></script>
</head>
   <header>
       <jsp:include page="/WEB-INF/partials/navbar.jsp" />
        <h1>Welcome to the Adlister!</h1>
   </header>
   <script type="text/javascript"><%@include file="./JS/particles.js" %></script>
<div class="row">
    <hr>
</div>
<div class="row">
    <!-- posts -->
    <div class="col-md-8">
        <div class="panel blog-container">
            <div class="panel-body">
                <div class="image-wrapper">
                    <a class="image-wrapper image-zoom cboxElement" href="#">
                        <img src="https://www.bootdey.com/image/700x250/00CED1/000000" alt="Photo of Blog">
                        <div class="image-overlay"></div>
                    </a>
                </div>

                <h4>Fav Ads</h4>
                <p class="m-top-sm m-bottom-sm">
                    //Words Here//
                </p>
                <a href="single_post.html"><i class="fa fa-angle-double-right"></i> Continue reading</a>
                <span class="post-like text-muted tooltip-test" data-toggle="tooltip" data-original-title="I like this post!">
                  <i class="fa fa-heart"></i>
                </span>
            </div>
        </div>
        <div class="panel blog-container">
            <div class="panel-body">
                <div class="image-wrapper">
                    <a class="image-wrapper image-zoom cboxElement" href="#">
                        <img src="https://www.bootdey.com/image/700x250/FF69B4/000000" alt="Photo of Blog">
                        <div class="image-overlay"></div>
                    </a>
                </div>
                <h4>My Ads</h4>
                <p class="m-top-sm m-bottom-sm">
                    //Words Here//
                </p>
                <a href="single_post.html"><i class="fa fa-angle-double-right"></i> Continue reading</a>
                <span class="post-like text-muted tooltip-test" data-toggle="tooltip" data-original-title="I like this post!">
                  <i class="fa fa-heart"></i>
                </span>
            </div>
        </div>
    </div>

    <div class="col-md-4">
        <h4 class="headline text-muted">
            MORE GOES HERE
            <span class="line"></span>
        </h4>
        <div class="media popular-post">
            <a class="pull-left" href="#">
                <img src="https://www.bootdey.com/image/60x60/9400D3/000000" alt="Popular Post">
            </a>
            <div class="media-body">
                Under Construction
            </div>
        </div>
        <div class="media popular-post">
            <a class="pull-left" href="#">
                <img src="https://www.bootdey.com/image/60x60/4B0082/000000" alt="Popular Post">
            </a>
            <div class="media-body">
                Under Construction
            </div>
        </div>
        <div class="media popular-post">
            <a class="pull-left" href="#">
                <img src="https://www.bootdey.com/image/60x60/E6E6FA/000000" alt="Popular Post">
            </a>
            <div class="media-body">
                Under Construction
            </div>
        </div>
        <div class="media popular-post">
            <a class="pull-left" href="#">
                <img src="https://www.bootdey.com/image/60x60/FFFACD/000000" alt="Popular Post">
            </a>
            <div class="media-body">
                Under Construction
            </div>
        </div>
        <div class="media popular-post">
            <a class="pull-left" href="#">
                <img src="https://www.bootdey.com/image/60x60/E0FFFF/000000" alt="Popular Post">
            </a>
            <div class="media-body">
                Under Construction
            </div>
        </div>
    </div>
</div>
</div>

</body>
</html>
