<%@include file="/common/header2.jspf"%>

<div class="box">
	<h4 style="padding-bottom: 20px">Get Your Vehicle Details</h4>
    <form action="details.do" method="post" class="form-signin" style="padding-bottom: 5px">
      <div class="form-group">
        <label>Enter Vehicle Details: </label>
        <input type="text" class="form-control" name="vehicle" placeholder="Vehicle Details" required="" autofocus="" />
      </div>
      <button type="submit" class="btn btn-primary" data-toggle="popover" title="${ vehi }" data-content="${ desc }">Fetch Details!</button>
      <script>
      $(function () {
    	  $('[data-toggle="popover"]').popover()
    	})
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
        <label>Enter Source: </label>
        <input type="text" class="form-control" name="source" placeholder="Source" required="" autofocus="" />
      </div>
      
      <div class="form-group">
        <label>Enter Destination: </label>
        <input type="text" class="form-control" name="dest" placeholder="Destination" required="" autofocus="" />
      </div>
      
      <button type="submit" class="btn btn-primary">Track It!</button>
	</form>	
 </div>
 
 
 