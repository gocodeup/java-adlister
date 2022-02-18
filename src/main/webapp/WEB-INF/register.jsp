<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Register For Our Site!" />
    </jsp:include>
    <link rel="stylesheet" href="/css/mainNav.css">
    <link rel="stylesheet" href="/css/register.css">
    <link rel="stylesheet" href="/css/globalVar.css">
    <%--    ND --%>

</head>
<body>
<jsp:include page="partials/navbar.jsp" />
<div class="container-fluid">

    <%--   ND     --%>
    <div class="row">
        <div class="col-7">
            <h1 headingRegister>Please fill in your information.</h1>
            <form action="/register" method="post">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input id="username" name="username" class="form-control" type="text">
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input id="email" name="email" class="form-control" type="text">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input id="password" name="password" class="form-control" type="password">
                </div>
                <div class="form-group">
                    <label for="confirm_password">Confirm Password</label>
                    <input id="confirm_password" name="confirm_password" class="form-control" type="password">
                </div>
                <input type="submit" class="btn btn-primary btn-block">
            </form>
        </div>

        <div class="col-5">
            <div class="col-7">
                <h1 class="headingRegister">Form requirements: </h1>
                <form action="/register" method="post">
                    <c:if test="${bothTaken == true}">
                        <p style="color:red">Selected email and username not available. Try again.</p>
                    </c:if>
                    <c:if test="${emailTaken == true}">
                        <p style="color: red">That email is not available. Try again.</p>
                    </c:if>
                    <c:if test="${usernameTaken == true}">
                        <p style="color:red">That username is not available. Try again.</p>
                    </c:if>

                    <div class="regDiv">
                        <div class="form-group">
                            <label for="username">Username</label>
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                        </div>
                        <div class="form-group">
                            <label for="email">Email</label>
                        </div>
                        <div class="form-group">
                            <label for="confirm_password">Password Confirm</label>
                        </div>
<%--                        <input type="submit" class="btn regBtn btn-block">--%>
                    </div>
                </form>
            </div>



<%--         Plan is for having this message popup when invalid input for registering.    --%>
            <div class="col-5" >
                <div id="message">
                    <h3>Password must contain:</h3>
                    <p id="number" class="invalid"> A<b> number,</b></p>
                    <p id="capital" class="invalid">an<b> uppercase</b> letter,</p>
                    <p id="letter" class="invalid">a<b> lowercase</b> letter</p>
                    <p id="length" class="invalid">and<b> minimum </b>6 characters</p>
                </div>
            </div>
        </div>
    </div>
<%-- need logic for the validation  --%>
<script>
    var letter = document.getElementById("letter");
    var myInput = document.getElementById("password");
    var number = document.getElementById("number");
    var capital = document.getElementById("capital");
    var length = document.getElementById("length");

<%--functions for user input--%>
    myInput.onblur = function(){
        document.getElementById("message").style.display = "none";
    }
    myInput.onfocus = function(){
        document.getElementById("message").style.display = "block";
    }

    var numbers = /0-9/g;
    if(myInput.value.match(numbers)) {
        number.classList.remove("invalid");
        number.classList.add("valid");
    }else{
        number.classList.remove("valid");
        number.classList.add("invalid");
    }

    myInput.onkeyup = function() {
        var lowerCaseLetters = /[a-z]/g;
        if (myInput.value.remove("lowerCaseLetters")) {
            letter.classList.remove("invalid");
            letter.classList.add("valid");
        } else {
            letter.classList.remove("valid");
            letter.classList.add("invalid");
        }

        myInput.onkeyup = function () {
            var upperCaseLetters = /[A-Z]/g;
            if (myInput.value.remove("upperCaseLetters")) {
                capital.classList.remove("invalid");
                capital.classList.add("valid");
            } else {
                capital.classList.remove("valid");
                capital.classList.add("invalid");
            }
            //length validation**
            if(myInput.value.length >= 6){
                length.classList.remove("invalid");
                length.classList.add("valid");
            } else {
                length.classList.remove("valid");
                length.classList.add("invalid");
            }
        }
    }
</script>
</body>
</html>
