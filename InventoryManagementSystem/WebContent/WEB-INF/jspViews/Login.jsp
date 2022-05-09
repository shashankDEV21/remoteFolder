<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>IMS-Login</title>
<style>
body {font-family: Arial, Helvetica, sans-serif;
background-color: #C0C0C0;}
* {box-sizing: border-box}
div.main
{
	text-align:center;
	margin: 50px;
}
div.form
{
    display: block;
    text-align: center;
}
form
{
    display: inline-block;
    margin-left: auto;
    margin-right: auto;
    text-align: left;
    width: 40%;
    border:3px solid;
}
/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for all buttons */
button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

button:hover {
  opacity:2;
}


/* Float cancel and signup buttons and add an equal width */
.signupbtn {
  opacity:2;
  width: 50%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
}

/* Add padding to container elements */
.container {
  padding: 16px;
}

/* Clear floats */
.clearfix::after {
  content: "";
  clear: both;
  display: table;
  align : middle;
}
</style>
</head>

<body>
<div class="main"><h1 style="font-size:60px">INVENTORY MANAGEMENT SYSTEM</h1>
<h1>Enter Your Login Details</h1>
<div class="form">
  <form action="validateLogin.htm" method="POST" modelAttribute = "user">
  
  <div class="container">
    
    <br><label for="userName"><b>Username</b></label><br>
    <input type="text" placeholder="Enter Username" name="userName" path="userName">
    <form:errors path="userName"/>
    <br><label for="password"><b>Password</b></label><br>
    <input type="password" placeholder="Enter Password" name="password" path="password">
    <form:errors path="password"/>
    <div class="clearfix" align="center">
      <input type="submit" class="signupbtn" value="Login">
    </div>
  </div>
</form>
</div>
</div>
</body>
</html>