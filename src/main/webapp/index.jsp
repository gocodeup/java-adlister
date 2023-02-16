<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adlister</title>
    <jsp:include page="/WEB-INF/partials/head.jsp"/>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div>
    <h1>Welcome to the Adlister!</h1>
</div>
<br>
<div class="typing animate"></div>
<div class="marton-animation-container"></div>
<div class="window"></div>
<div class="instrument-rack"></div>
<div class="body-table-section">
    <div class="marton-body"></div>
    <div class="marton-head">
        <div class="marton-beard-shadow"></div>
        <div class="marton-beard"></div>
        <div class="marton-ears">
            <div class="marton-ear-right"></div>
            <div class="marton-ear-shadow-right"></div>
            <div class="marton-ear-left"></div>
            <div class="marton-ear-shadow-left"></div>
            <div class="marton-earbud-right"></div>
            <div class="marton-earbud-left"></div>
            <div class="marton-earbud-right2"></div>
            <div class="marton-earbud-left2"></div>
        </div>
        <div class="marton-hair">
            <div class="marton-hair-parting-right"></div>
            <div class="marton-hair-parting-left"></div>
            <div class="marton-face">
                <div class="marton-face-traits">
                    <div class="marton-eyebrows">
                        <div class="marton-eyebrow-right"></div>
                        <div class="marton-eyebrow-left"></div>
                    </div>
                    <div class="marton-eyes">
                        <div class="marton-noserim-box">
                            <div class="marton-eye-noserim"></div>
                        </div>
                        <div class="marton-eye-right"></div>
                        <div class="marton-eye-left"></div>
                    </div>
                    <div class="marton-nostrils">
                        <div class="marton-nostril-right"></div>
                        <div class="marton-nostril-left"></div>
                    </div>
                    <div class="marton-mouth"></div>
                    <div class="marton-moustache">
                        <div class="marton-moustache-right"></div>
                        <div class="marton-moustache-left"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="computer-table"></div>
    <div class="computer-stand-layer4"></div>
    <div class="computer-stand-layer3"></div>
    <div class="computer-screen">
        <div class="computer-screen-layer1"></div>
        <div class="computer-screen-layer2"></div>
        <div class="computer-stand">
            <div class="computer-stand-layer1"></div>
            <div class="computer-stand-layer2"></div>
        </div>
    </div>
<jsp:include page="WEB-INF/partials/footer.jsp"></jsp:include>
</body>
</html>
