<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Management Screen</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

</head>
<body>
<nav class="navbar navbar-dark bg-primary justify-content-between">
  <!-- Navbar content -->
   <a class="navbar-brand" href="home" style="color:black;">Employee Management</a>
    <a href="/portal/home"style="float:right; margin-right:30px" class="form-inline"><button class="btn btn-info" type="submit">Logout</button></a>
</nav>
	<div align="center">
		<h1>Employee List</h1>
		
		<table border="1">
			<th>Id</th>
			<th>Name</th>
			<th>DOJ</th>
			<th>Basic Pay</th>
			<th>DA</th>
			<th>HRA</th>
			<th>Gross</th>
			<th>Tax</th>
			<th>Net</th>

			<c:forEach var="employee" items="${listEmployee}">
				<tr>

					<td>${employee.getId()}</td>
					<td>${employee.getName()}</td>
					<td>${employee.getDateOfJoining()}</td>
					<td>${employee.getBasicpay()}</td>
					<td>${employee.getDa()}</td>
					<td>${employee.getHra()}</td>
					<td>${employee.getGross()}</td>
					<td>${employee.getTax()}</td>
					<td>${employee.getNet()}</td>
					<td><a href="editEmployee?id=${employee.getId()}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deleteEmployee?id=${employee.getId()}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<h4>
			New Employee Register <a href="newEmployee">here</a>
		</h4>
	</div>
</body>
</html>