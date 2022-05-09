<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	background-color: #C0C0C0;
}

* {
	box-sizing: border-box
}

div.main {
	text-align: center;
	margin: 50px;
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
	opacity: 2;
}

/* Float cancel and signup buttons and add an equal width */
.signupbtn {
	opacity: 2;
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
	align: middle;
}
</style>
<meta charset="ISO-8859-1">
<title>Success Page</title>
</head>
<body>
	<c:choose>
		<c:when test="${user!=null}">
			<div align="center">
				<h1>Material Purchase success entry</h1>
				<hr>
				<br>
				<table>
					<tr>
						<td>Purchase Entry ID :</td>
						<td>${purchase_id}</td>
					</tr>
					<tr>
						<td>Vendor Name :</td>
						<td>${vendorName}</td>
					</tr>
					<tr>
						<td>Material Category :</td>
						<td>${materialCategory}</td>
					</tr>
					<tr>
						<td>Material Type :</td>
						<td>${materialType}</td>
					</tr>
					<tr>
						<td>Unit Name :</td>
						<td>${unitName}</td>
					</tr>
					<tr>
					<tr>
						<td>Brand Name :</td>
						<td>${brandName}</td>
					</tr>
					<tr>
						<td>Purchase Quantity :</td>
						<td>${entryBean.quantity}</td>
					</tr>
					<tr>
						<td>Purchase Amount :</td>
						<td>${entryBean.purchaseAmount}</td>
					</tr>
					<tr>
						<td>Date of Purchase :</td>
						<td>${entryBean.purchaseDate}</td>
					</tr>
					<tr>
						<td>Transaction Id :</td>
						<td>${entry_id}</td>
					</tr>
				</table>
				<br>
				<hr>
				<form:form name="homeForm" modelAttribute="user"
					action="validateLogin.htm">
					<a href="javascript:document.homeForm.submit()">Home</a>
				</form:form>

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