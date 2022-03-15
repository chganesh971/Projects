<!DOCTYPE html> 
<html lang="en"> 
  
<head> 
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"	rel="stylesheet">
	<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <title>Home</title>
    <style>
   	.row {
   		margin-top: 50px;
   	}
   	.btn-outline-light {
   		border: 3px solid red;
   	}
   	body {
   		background-color: aqua;
   	}
   	.card-block {
   		margin-top: 30px;  
   		margin-bottom: 30px;
   	}
   	.card {
   		border:2px solid black;	
   	}
   	.btn:hover {
   		background-color: white;
   		color: green;
   	}
   	.row>.cardboard {
   		padding-bottom: 50px;
   	}
     	 
    </style>
</head>
<body>
    <nav class="navbar navbar-dark bg-dark" style="margin-left: 20px;">
        <a class="navbar-brand" style="color: white; margin-left: 10px;">
          <img src="https://cdn1.iconfinder.com/data/icons/investing-wildberry-vol-2/256/Portfolio_Management-512.png" width="30" height="30" class="d-inline-block align-top" style="color: white" alt="">
          &nbsp;&nbsp;  Portfolio Manager</a>
        <form action="/logout" method="GET"><button type="button float-right" class="btn btn-outline-light">Logout</button></form>
      </nav>
    <br>
    <div class="container-fluid">
    	 <div class="row">
            <div class="col-lg-4 col-md-6 col-sm-12 cardboard">
                <div class="card text-center">
                    <img class="card-img-top img-fluid" src="https://img.flaticon.com/icons/png/512/1728/1728914.png?size=1200x630f&pad=10,10,10,10&ext=png&bg=FFFFFFFF" style="width:600x;height:300px;" alt="Card image cap">
                    <div class="card-block">
                        <h4 class="card-title">View My Assets</h4>
                        <p class="card-text">Click here to view all Assets</p>
                        <form action="/viewportfolio" method="GET"><button type="submit" value="submit" class="btn btn-warning">View my Portfolio</button></form>
                        <p></p>
                    </div>
                </div>
            </div>
    
            <div class="col-lg-4 col-md-6 col-sm-12 cardboard">
                <div class="card text-center">
                    <img class="card-img-top img-fluid" src="https://learnskills.org/images/LS_Touch_Typing_Course.jpg" style="width:600x;height:300px;" alt="Card image cap">
                    <div class="card-block">
                        <h4 class="card-title">Calculate Portfolio</h4>
                        <p class="card-text">Click here to view my portfolio</p>
                        <form action="/viewNetworth" method="GET"><button type="submit" value="submit" class="btn btn-primary">Calculate Portfolio</button></form>
                        <p></p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 col-sm-12 cardboard">
                <div class="card text-center">
                    <img class="card-img-top img-fluid" src="https://www.hostgator.com/blog/wp-content/uploads/2018/06/How-to-make-a-profit-buying-selling-websites@2x.jpg" style="width:600x;height:300px;" alt="Card image cap">
                    <div class="card-block">
                        <h4 class="card-title">Sell my Assets</h4>
                        <p class="card-text">Click here to sell a stock</p>
                        <form action="/sellAssets" method="GET"><button type="submit" name="submit" class="btn btn-success">Sell Stock</button></form>
                        <p></p>
                    </div>
                </div>
        </div>
    </div>

</body> 
</html> 

