<%@include file="/common/header2.jspf"%>
<style type="text/css">
      .leftbox{
        width: 500px;
        margin: 0 auto;
        padding-top: 50px;
        padding-left: 50px;
        float:left;
      }
      
      .rightbox{
        width: 1000px;
        margin: 0 auto;
        padding-top: 50px;
        padding-left: 50px;
        padding-right: 20px;
        float:right;
      }
</style>

<div class="leftbox">
	<h4 style="padding-bottom: 20px">Get Your Vehicle Details</h4>
    <form class="form-signin" style="padding-bottom: 5px">
      <div class="form-group">
        <label>Enter Vehicle Details: </label>
        <input type="text" class="form-control" name="vehicle" placeholder="Vehicle Details" required="" autofocus="" />
      </div>
      <button type="button" class="btn btn-primary" onclick="vehiDetails()">Fetch Details!</button>
      <script>
      function vehiDetails() {
    	    document.getElementById("detailcard").style.display = "inline";
    	}
      </script>
	</form>
		
	<div style="background-color: #bdbdbd; height: 1px"></div>
	
	<h4 style="padding-bottom: 20px; padding-top: 15px">Track Your Vehicle</h4>
    <form action="tracking.do" method="post" class="form-signin">
      <div class="form-group">
        <label>Enter GPS ID: </label>
        <input type="text" class="form-control" name="gpsid" placeholder="GPS ID" required="" autofocus="" />
      </div>
      
      <div class="form-group">
        <label>Enter Destination: </label>
        <input type="text" class="form-control" name="source" placeholder="Destination" required="" autofocus="" />
      </div>
      
      <div class="form-group">
        <label>Enter Destination: </label>
        <input type="text" class="form-control" name="dest" placeholder="Destination" required="" autofocus="" />
      </div>
      
      <button type="submit" class="btn btn-primary">Track It!</button>
	</form>	
 </div>
 
 <div class="rightbox" id="detailcard" style="display: none">
 	<div class="card" style="height: 500px">
  	<div class="card-body">
    	<h5 class="card-title">Card title</h5>
    	<h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
    	<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    	<a href="#" class="card-link">Card link</a>
    	<a href="#" class="card-link">Another link</a>
 	 </div>
	</div>
 </div>
 
 