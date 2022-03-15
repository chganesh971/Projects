<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Portfolio management</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
<style>
.body {
	width: 100%;
	height: 100%;
}
img {
	height: 750px;
}
.container {
	width:80%;
	margin-top: 21vh;
}
.heading {
	color: blue;
	text-align: center;
	padding-bottom: 50px;
	font-family: Cursive,Fantasy;
}
.form-control {
	border: 1px solid blue;
	font-family: Cursive,Fantasy;
	height: 40px;
}
.form-label {
	font-size: 20px;
	color: maroon;
	font-family: Cursive,Fantasy;
}
.btn {
	margin-top: 30px;
	border: 1px solid blue;
	font-style: italic;
}
.btn:hover {
	border: none;
	background-color: green;
	color: white;
	border: 1px solid blue;
}

.errorMessage {
	color: red;
	margin-top: 50px;
	font-size: 20px;
	margin-bottom: 50px;
}


</style>
</head>
<body>

<div class="container-fluid">
<div class="row">
<div class="col-lg-6 col-md-6 col-sm-6">
	<div class="container">
	<h1 class="heading">Portfolio Management</h1>
	
	<form action="login" method="post"  model="userData">
	<div class="mb-3">
	  <label for="formGroupExampleInput" class="form-label">Username </label>
	  <input type="text" class="form-control" id="formGroupExampleInput" name="userid" required placeholder="Username">
	</div><br>
	<div class="mb-3">
	  <label for="formGroupExampleInput2" class="form-label">Password </label>
	  <input type="password" class="form-control" id="formGroupExampleInput2" name="upassword" required placeholder="Password">
	</div>
	<div class="text-center">
		<button class="btn btn-warning">Sign in</button>
	</div>
	</form>
	
	<div class="text-center errorMessage">${errormsg}</div>
	
	</div>
</div>
<div class="col-lg-6 col-md-6 col-sm-6">
	<img src="https://www.liquidplanner.com/wp-content/uploads/2018/10/iStock-1175302204-2.jpg" class="image-responsive" width="100%" alt="Couldn't load image">
</div>
</div>
</div>

</body>
</html>