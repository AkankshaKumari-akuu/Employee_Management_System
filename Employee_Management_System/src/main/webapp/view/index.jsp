<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert </title>
<link rel="stylesheet" href="styleSheet.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

</head>
<body>

<%

%>
<nav class="navbar navbar-dark bg-primary justify-content-between">
  <!-- Navbar content -->
   <a class="navbar-brand" href="home" style="color:black;">Employee Management</a>
    <a href="/portal/home"style="float:right; margin-right:30px" class="form-inline"><button class="btn btn-info" type="submit">Logout</button></a>
</nav>
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