<!DOCTYPE html>
<html>
<head>
    <title>Employee Management System</title>
    <link rel="stylesheet" href="css/genericStyle.css">
</head>
<body>
<%@include file="header.jsp"%>
<%
    request.getAttribute("message");
    String message = (String)request.getAttribute("message");
    if(message!=null){
       out.println("<p>"+message+"</p>");
    }
%>
<div id="myForm">
    <form action="addEmployee" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br><br>
        <label for="username">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        <button type="submit">Submit</button>
        <button type="reset">Reset</button>
    </form>
    <p>if you are new user <a href="registerNewAdmin.jsp">Register</a></p>
</div>
</body>
</html>