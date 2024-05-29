<!DOCTYPE html>
<html>
<head>
    <title>Employee Management System</title>
    <link rel="stylesheet" href="css/genericStyle.css">
</head>
<body>
<%@include file="header.jsp"%>

<p>Hello <%=session.getAttribute("uname")%> </p>

<%
     String name= (String)session.getAttribute("uname");
 if(name==null){
    response.setContentType("text/html");

              request.setAttribute("message","Please login");
              RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
              requestDispatcher.forward(request,response);
 }
%>
<div id="myForm">
    <form action="new" method="post">
        <label for="fname">First Name:</label>
        <input type="text" id="fname" name="fname" required><br><br>
        <label for="lname">Last Name:</label>
        <input type="text" id="lname" name="lname" required><br><br>
        <label for="age">Age:</label>
        <input type="text" id="age" name="age" required><br><br>
        <label for="position">Position:</label>
        <select id="position" name="position">
          <option value="software_engineer">software engineer</option>
          <option value="tester">tester</option>
          <option value="manager">manager</option>
          <option value="ba">business analyst</option>
        </select><br><br>
        <label for="salary">Salary:</label>
        <input type="text" id="salary" name="salary" required><br><br>
        <button type="submit">Submit</button>
        <button type="reset">Reset</button>
    </form>
</div>
</body>
</html>