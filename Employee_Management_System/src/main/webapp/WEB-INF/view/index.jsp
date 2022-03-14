<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert </title>
<link rel="stylesheet" href="styleSheet.css">
</head>
<body>
<div style="width:300px; margin:auto; margin-top:150px; border:1px solid red; padding:25px; padding-left:100px">
	<form action="allemployee" method="post">
		<button type="submit">Get all Employee</button>
	</form>
	<br><br>
		<a href="newEmployee"><button>Add a Employee</button></a>
</div>
<div style="width:300px; margin:auto; margin-top:10px; border:1px solid red; padding:25px;">
	<h1>Search Emp By Id</h1>
	<form action ="Search">
		<label style="color:red;">Enter the id to show details</label>
		<input type="number" placeholder="Employee-id" name ="empId"><br><br>
		<button type="submit">Show details</button>
	</form>
</div>
</body>
</html>