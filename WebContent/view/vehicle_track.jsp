<html>
  <head>
  <!-- Required meta tags -->
    <meta charset="utf-8">
    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no"/>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <title>Vehicle Live Movement on Maps</title>
    <link rel="stylesheet" type="text/css" href="view/style.css">
    <script type="text/javascript"
    src="http://maps.google.com/maps/api/js?key=AIzaSyB-cDdpv_CCY8Yk1dS2FpL_-MaUTfk0Jes&sensor=false"></script>
    <script type ="text/javascript" src="http://www.geocodezip.com/scripts/v3_epoly.js"></script>
    <script type="text/javascript" src="view/script.js"></script>
  </head>
  <body onload="initialize()">
  <body>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
  		<a class="navbar-brand" href="#">TRACKING SYSTEM</a>
  		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    		<span class="navbar-toggler-icon"></span>
  		</button>
  
  		<div class="collapse navbar-collapse" id="navbarNav">
    		<ul class="navbar-nav">
      			<li class="nav-item active">
        			<a class="nav-link" href="#">Welcome<span class="sr-only">(current)</span></a>
      			</li>
      
      			<li class="nav-item">
        			<a class="nav-link" href="tracking.do">Track Vehicle</a>
      			</li>
      
      			<li class="nav-item">
        			<a class="nav-link" href="profile.do">Profile</a>
      			</li>
      			
      			<li class="nav-item">
      				<a class="nav-link" href="#">Hi, ${name}</a>
      			</li>
      			
				<li class="nav-item">
        			<a class="nav-link" href="logout.do">Logout</a>
      			</li>
      		</ul>
  		</div>
	</nav>
	
    <div id="tools" style="padding-left: 20px; padding-top:30px">                	
      <p>Source: <input id="start" value="${ frominput }" /></p>
      <p>Destination: <input id="end" value="${ toinput }" /></p>
      <div id="error-msg"></div>
      <button id="start-btn" onclick="setRoutes();">Start</button>
    </div>
    <div id="map_canvas" style="width:100%;height:100%;"></div>
  </body>
</html>
