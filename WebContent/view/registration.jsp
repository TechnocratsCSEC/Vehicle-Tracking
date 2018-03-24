<%@include file="/common/header.jspf" %>
<script type="text/javascript">
$('submit').click(function () {
	  if ($('#password').val() == $('#confirm_password').val()) {
	    $('#message').html('Matching').css('color', 'green');
	  } else 
	    $('#message').html('Not Matching').css('color', 'red');
	});
</script>

	<h4 style="text-align:center; padding-top:20px">Welcome! Please enter your details for Registration.</h4>

    <div class="box">
    <form action="register" method="post">
      <div class="form-group">
        <label>Username</label>
        <input type="text" class="form-control" name="uname" placeholder="Userame" required="" autofocus="" />
      </div>
      
      <div class="form-group">
        <label>Full Name</label>
        <input type="text" class="form-control" name="fname" placeholder="Full Name" required="" autofocus="" />
      </div>

      <div class="form-group">
        <label>Email address</label>
        <input type="email" class="form-control" name="InputEmail"  placeholder="Enter email">
      </div>
      
      <div class="form-group">
        <label>Phone Number</label>
        <input type="text" class="form-control" name="InputPhone"  placeholder="Enter phone">
      </div>
  
      <div class="form-group">
        <label>Password</label>
        <input type="password" class="form-control" id="password"  name="password" placeholder="Password" required=""/>
      </div>

      <div class="form-group">
        <label>Confirm Password</label>
        <input type="password" class="form-control" name="confirm_password"  id="confirm_password" placeholder="Confirm Password" required=""/>
      </div>

      <div class="input-group mb-3">
        <div class="input-group-prepend">
          <label class="input-group-text">Select a category :</label>
        </div>
        <select class="custom-select" id="one" name="category">
         	<option selected>Choose...</option>
          	<option value="Government">Government</option>
          	<option value="Logistics">Logistics</option>
          	<option value="Personal">Personal</option>
        </select>
      </div>

      <div id="two" style="display: none" class="input-group mb-3">
        <div class="input-group-prepend">
          <label class="input-group-text">Select a Department : </label>
          
          <select class="custom-select" name="subcat1">
            <option selected>Choose...</option>
            <option value="fire">Fire</option>
            <option value="ambu">Ambulance</option>
            <option value="police">Police</option>
            <option value="postal">Postal Service</option>
          </select>
        </div>
      </div>

      <div id="three" style="display: none" class="input-group mb-3">
        <div class="input-group-prepend">
          <label class="input-group-text">Select a Company : </label>
          
          <select class="custom-select" name="subcat2">
            <option selected>Choose...</option>
            <option value="fedex">FedEx</option>
            <option value="bluedart">Blue Dart</option>
            <option value="dhl">DHL</option>
            <option value="aegis">Aegis Logistics</option>
          </select>

          <script>
          document.getElementById('one').onchange = function() {
            var display = this.selectedIndex == 1 ? "inline" : "none";
            document.getElementById('two').style.display = display;

            var display2 = this.selectedIndex == 2 ? "inline" : "none";
            document.getElementById('three').style.display = display2;
          }
          </script>
        </div>
      </div>

      <div style="padding-top: 15px">      
        <button type="submit" class="btn btn-primary">Register</button>
      </div>
    </form> 
    </div>
    
<%@include file="/common/footer.jspf" %>
