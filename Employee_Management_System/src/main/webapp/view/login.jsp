<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


<style type="text/css">
body {
    background-image: url("https://miro.medium.com/max/1400/1*Bhy1_Q8Zo8Y9kTwslMP-9A.jpeg");
}
.loginForm{
	margin-top:250px;
	display: flex;
	justify-content: center;
	
}
</style>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

</head>

<body class="container card">
<nav class="navbar navbar-dark bg-primary">
  <!-- Navbar content -->
   <a class="navbar-brand" href="home" style="color:black;">Employee Management System Portal</a>
</nav>
<div class="loginForm">
<form action="login" method="get">
	<input type="text" placeholder="enter the user id" name="userId"/>
	<br/><br/>
	<input type="password" placeholder="enter your password" name="password"/> 
	<br/><br/>
	<button type="submit">Login..</button>
</form>
</div>
<div style="margin: auto;width: 50%; float:right">
<a href="registerUser"><button type="submit">Register</button></a>
</div>
</body>
</html>