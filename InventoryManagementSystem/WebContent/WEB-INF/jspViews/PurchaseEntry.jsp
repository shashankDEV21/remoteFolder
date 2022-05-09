<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
$("#categoryIdform").change(function() {
var getUserID = $(this).val();
if(getUserID!="")
{
$.ajax({
type:"GET",
url:"http://localhost:8088/unit/controller/getUnitsByCategoryId/"+getUserID,
success:function(data){
var s="";
for(var i=0;i<data.length;i++)
{
s+='<option value="' + data[i].unitId + '">' + data[i].unitName + '</option>'
}
$("#unitIdform").html(s);
}
});
$.ajax({
type:"GET",
url:"http://localhost:8088/type/controller/getTypeDetailsByCategoryId/"+getUserID,
success:function(data){
var s="";
for(var i=0;i<data.length;i++)
{
s+='<option value="' + data[i].typeId + '">' + data[i].typeName + '</option>'
}
$("#typeIdform").html(s);
}
});
}
});
});



</script>
<style type="text/css">

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
.form
{
    display: inline-block;
    margin-left: auto;
    margin-right: auto;
    text-align: left;
    width: 40%;
    border:3px solid;
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

.error {
	color: red;
	font-style: italic;
}

.selects {
	width: 200px
}
</style>
<meta charset="ISO-8859-1">
<title>PurchaseEntry</title>
</head>
<body>
<c:choose>
		<c:when test="${user!=null}">
			<div align="center">
				<h3 align="right">Welcome:${user.userName}</h3>
				<h1 style="font-size:60px">Inventory Management System</h1>
			</div>
		</c:when>
	</c:choose>
<c:choose>
	<c:when test="${user!=null}">
		<div align="center">
			<h1>Enter Your Purchase Details</h1>
			<br>
			<table class="form">
					<tr></tr>
				<form:form action="processPurchase.htm" method="POST"
					modelAttribute="purchaseEntryBean" class="form">
					<tr>
						<td>Vendor Names :</td>
						<td><form:select path="vendorId" cssClass="selects">
						<form:option value="">--Select--</form:option>
								<form:options items="${vendorNames}" />
							</form:select></td>
							<td><form:errors path="vendorId" cssClass="error" /></td>
						
						
					</tr>
					<tr>
						<td>Material Category :</td>
						<td><form:select path="materialCategoryId" cssClass="selects" id="categoryIdform">
						<form:option value="">--Select--</form:option>
						<form:options items="${MaterialCategories}" />
							</form:select></td>
							<td><form:errors path="materialCategoryId" cssClass="error" /></td>
					
					</tr>
					<tr>
						<td>Material Type :</td>
						<td><form:select path="materialTypeId" cssClass="selects" id="typeIdform">
						
							</form:select></td>
							<td><form:errors path="materialTypeId" cssClass="error" /></td>
					</tr>
					<tr>
						<td>Unit :</td>
						<td><form:select path="unitId" cssClass="selects" id="unitIdform">
							</form:select></td>
							<td><form:errors path="unitId" cssClass="error" /></td>
					</tr>
					<tr>
						<td>Brand Name :</td>
						<td><form:select path="brandId" cssClass="selects">
						<form:option value="">--Select--</form:option>
								<form:options items="${brandNames}" />
							</form:select></td>
							<td><form:errors path="brandId" cssClass="error" /></td>
					</tr>
					<tr>
						<td>Quantity :</td>
						<td><form:input path="quantity" cssClass="selects" id="quantInput" /></td>
						<td><form:errors path="quantity" cssClass="error" /></td>
					</tr>
					<tr>
						<td>Purchase Amount :</td>
						<td><form:input path="purchaseAmount" cssClass="selects" id="purchaseAmtInput"/></td>
						<td><form:errors path="purchaseAmount" cssClass="error" /></td>
					</tr>
					<tr>
					<tr>
						<td>Purchase Date [dd-MMM-yyyy] :</td>
						<td><form:input path="purchaseDate" cssClass="selects" /></td>
						<td><form:errors path="purchaseDate" cssClass="error" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="order" class="signupbtn"></td>
						<td></td>
					</tr>
				</form:form>
			</table>
			<br><br>
			<form:form name="homeForm" modelAttribute="user"
				action="validateLogin.htm">
				<a href="javascript:document.homeForm.submit()" class="signupbtn">Home</a>
			</form:form>
		</div>
	</c:when>
	<c:otherwise>
		<div align="center">
			<h1 align="center">Session Expired</h1>
			<a href="index.jsp" class="signupbtn">Home</a>
		</div>
	</c:otherwise>
</c:choose>
</body>
</html>