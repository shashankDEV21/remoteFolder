<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
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
	<c:choose>
		<c:when test="${user!=null}">
			<div align="center">
				<h3 align="right">Welcome:${user.userName}</h3>
				<h1 style="font-size:60px">Inventory Management System</h1>
				<h3><${message}</h3>
				<a href="loadPurchaseEntry.htm" class="signupbtn">Enter Purchase Entry</a>

			</div>
		</c:when>
		<c:otherwise>
			<div align="center">
				<h1 align="center">Session Expired</h1>
				<a href="index.jsp">Home</a>
			</div>
		</c:otherwise>
	</c:choose>
</body>
</html>