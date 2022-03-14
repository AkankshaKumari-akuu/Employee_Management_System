<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Register</title>
<link rel="stylesheet" href="styleSheet.css">
<script defer src="validate.js"></script>
</head>
<body>
	<div style="width:300px; margin:auto; margin-top:70px; border:1px solid red; padding:25px;">
		<h1>Add an Employee</h1>
		<form onsubmit="return validateForm()" action="save" method="get">
		<input type="hidden" placeholder="Name" name="id" id="id" value="${employee.getId()}">
			<label>Enter Emp Name</label>
				<input type="text" placeholder="Name" name="empName" id="empName" required>
				<span id="Message" style="color:red"></span>
				<br><br>
			<label>Enter date of joining</label>
				<input type="date" placeholder="DOJ" name="doj" id="doj">
				<br><br>
			<label>Enter basic Pay</label>
				<input type="text" placeholder="Basic Pay" name="basicPay" id="bp">
				<span id="Message2" style="color:red"></span>
				<br><br>
			<button type="submit">Add employee</button>
		</form>
	</div>
</body>
</html>