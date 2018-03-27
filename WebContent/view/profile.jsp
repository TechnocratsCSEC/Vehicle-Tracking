<%@include file="/common/header.jspf" %>

<h4 style="text-align:center; padding-top:20px">User Profile</h4>

 <div class="box">
    <form class="form-signin" action="#">
      <div class="form-group">
        <label>Userame</label>
        <input type="text" class="form-control" name="uname" value="${ uname }" />
      </div>
      <button type="button" class="btn btn-dark" data-toggle="modal" data-target="#myModal">Change Username</button>
      
     <!--  
      <div class="modal fade" id="myModal" role="dialog">
    	<div class="modal-dialog" role="document">
    		<div class="modal-content">
      			<div class="modal-header">
        			<h5 class="modal-title">Enter your new Username</h5>
        			<button type="button" class="close" data-dismiss="modal" aria-label="Close">
          			<span aria-hidden="true">&times;</span>
        			</button>
      			</div>
      			<div class="modal-body">
        			<input type="text" class="form-control" name="newname" placeholder="New Username" required="" autofocus=""/>
      			</div>
      			<div class="modal-footer">
        			<button type="submit" class="btn btn-dark">Save changes</button>
      			</div>
    		</div>
 		 </div>
  	  </div> -->
    </form>
    
    <form>
      <div class="form-group">
        <label>Full Name</label>
        <input type="text" class="form-control" name="fname" value="${ fname }" disabled />
      </div>
      
      <div class="form-group">
        <label>Email Address</label>
        <input type="text" class="form-control" name="email" value="${ email }" disabled />
      </div>
      
      <div class="form-group">
        <label>Phone Number</label>
        <input type="text" class="form-control" name="fname" value="${ phone }" disabled />
      </div>
	</form>
 </div>
 
<%@include file="/common/footer.jspf" %>


