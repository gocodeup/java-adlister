<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pick Color</title>
</head>
<body>

<h1>Pick a Color:</h1>
<form action="/pick-color" method="POST">
    <input type="text" name="color" id="color" size="30" placeholder="Choose your background color">
    <button type="submit">Submit</button>
</form>

</body>
</html>
