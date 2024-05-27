<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="css/genericStyle.css">
</head>
<body>
<%@include file="header.jsp"%>
<div id="myRegisterForm">
    <h1>Please enter the below details</h1>
    <form action="register" method="post">
        <label for="firstName">First Name </label>
        <input type="text" id="firstName" name="firstName" placeholder="Enter First Name" required><br>
        <label for="lastName">Last Name </label>
        <input type="text" id="lastName" name="lastName" required placeholder="Enter Last Name"><br>
        <input type="submit">
    </form>
</div>

</body>
</html>
