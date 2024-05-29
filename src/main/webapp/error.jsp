<!DOCTYPE html>
<html>
<head>
    <title>Employee Management System</title>
    <link rel="stylesheet" href="css/genericStyle.css">
</head>
<body>
<%
   String user=request.getParameter("username");
%>

<%@include file="index.jsp"%>
<strong style="color:red">Invalid user</strong>
</body>
</html>