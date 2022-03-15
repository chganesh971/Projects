<%@ page language="java" contentType="text/html;  charset=UTF-8"
	import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<link rel="stylesheet" href="style/sellAssets-style.css">
<title>Sell Assets</title>
<style>
.card-block {
	padding-top: 20px;
}

.card {
	border: 3px solid gold;
}

table {
	margin-top: -30px;
}

th {
	color: blue;
}
</style>

</head>
<body>
	<nav class="navbar navbar-dark bg-dark">
		<a class="navbar-brand" href="#" style="margin-left: 20px;"> <img
			src="https://cdn1.iconfinder.com/data/icons/investing-wildberry-vol-2/256/Portfolio_Management-512.png"
			width="30" height="30" class="d-inline-block align-top" alt="">
			&nbsp; Portfolio Manager
		</a>
		<form action="/Home">
			<button type="button float-right" style="margin-right: 20px;"
				class="btn btn-outline-light">Home</button>
		</form>
	</nav>
	<br>
	<div class="container">
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6 ">
				<div class="card text-center shadow-lg">
					<img class="card-img-top img-fluid"
						src="https://www.indiafilings.com/learn/wp-content/uploads/2014/12/How-to-sell-on-Flipkart.jpg"
						style="width: 600x; height: 300px;" alt="Card image cap">
					<div class="card-block">
						<h4 class="card-title">Assets Sale</h4>
						<p class="card-text">Select the assets which you want to sell.</p>
						<br>
						<br>

						<form method="post" onSubmit=" return checker();"
							action="/viewNetworth">
							<table border="1" class=table
								style="margin-left: auto; margin-right: auto;">
								<tr>
									<th scope=col>Asset Name</th>
									<th scope=col>Type of Asset</th>
									<th scope=col>Units to be sold</th>
									<th scope=col>you own (units)</th>
								<tr>
									<c:forEach items="${asset}" var="temp">
										<tr>
											<td scope=row><input type="checkbox" value="${temp.assetid}" name="selected">${temp.assetid }</td>
											<td scope=row> ${temp.type} </td>
											<td scope=row><input type="number" id="quantity" name="quantity" value="0" min="0" max="${temp.units}"> </td>
											<td scope=row> <p>${temp.units}</p> </td>
										</tr>
									</c:forEach>
								</tr>
							</table>
							<button type="submit" name="submit"
								class="btn btn-black btn-primary">Sell Assets</button>
						</form>


					</div>
				</div>
			</div>
			<script type="text/javascript">
            	var a=document.getElementById("quantity");
            	function checker(){
                	var count=0;
					var l = document.getElementsByName("selected");
					for(var i=0;i<l.length;i++){
						if(l[i].checked)count++;
					}
					if(count==0){
						alert("Please select assets you want to sell!");
						return false;
					}
					else {
						 var m = document.getElementsByName("quantity");
						 var c = 0;
						 for(var j=0;j<m.length;j++){
						 	if(m[j].value != 0) c++;
						 }
						if(c==0){
							alert("Please select the units!");
							return false;
						}
						else {
							return true;
						}
					} 	
                }
            </script>
</body>
</html>