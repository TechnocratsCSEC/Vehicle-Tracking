<%@include file="/common/header.jspf" %>

<h4 style="text-align:center; padding-top:20px">Enter Your OTP</h4>

 <div class="box">
    <form action="otp.do" method="post" class="form-signin">
      
      <div class="form-group">
        <label>Enter OTP</label>
        <input type="password" class="form-control" name="otp" placeholder="OTP" required="" autofocus="" />
      </div>
			    	      
      <button type="submit" class="btn btn-primary">Submit</button>
	</form>
 </div>
 
<%@include file="/common/footer.jspf" %>


