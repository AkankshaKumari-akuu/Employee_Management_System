<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<style type="text/css">
body {
    background-image: url("https://www.hrfuture.net/wp-content/uploads/elementor/thumbs/Depositphotos_208343728_xl-2015-ok529kg00xom63s5nzsk7x7t8nhap29ds8y4np6v7s.jpg");
}
</style>
</head>
<body>
<nav class="navbar navbar-dark bg-primary">
  <!-- Navbar content -->
   <a class="navbar-brand" href="home" style="color:black;">Employee Management System Portal</a>
</nav>
<div class="container">
<form action="newUser" method="get">
   <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">First Name</label>
      <input type="text" class="form-control" name="firstName" id="inputEmail4" placeholder="First">
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">Last Name</label>
      <input type="text" class="form-control" name="lastName" id="inputPassword4" placeholder="Last">
    </div>
  </div>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Emp ID</label>
      <input type="number" class="form-control" name="empId" id="inputEmail4" placeholder="Emp ID">
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">User ID</label>
      <input type="text" class="form-control" name="userId" id="inputPassword4" placeholder="User ID">
    </div>
  </div>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Email</label>
      <input type="email" class="form-control" name="email" id="inputEmail4" placeholder="Email">
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">Password</label>
      <input type="password" class="form-control" name="password" id="inputPassword4" placeholder="Password">
    </div>
  </div>
  <div class="form-group">
    <label for="inputAddress">Address</label>
    <input type="text" class="form-control" name="address" id="inputAddress" placeholder="1234 Main St">
  </div>
  <button type="submit" class="btn btn-primary">Sign in</button>
</form>
</div>
</body>
</html>