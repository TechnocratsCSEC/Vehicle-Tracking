<%@include file="/common/header.jspf" %>

<h4 style="text-align:center; padding-top:20px">User Login Page!</h4>

 <div class="box">
    <form action="login.do" method="post" class="form-signin">
      <div class="form-group">
        <label>Userame</label>
        <input type="text" class="form-control" name="name" placeholder="Username" required="" autofocus="" />
      </div>
      
      <div class="form-group">
        <label>Password</label>
        <input type="password" class="form-control" name="password" placeholder="Password" required="" autofocus="" />
      </div>
			    	      
      <button type="submit" class="btn btn-primary">Login</button>
	</form>
 </div>
 
<%@include file="/common/footer.jspf" %>


