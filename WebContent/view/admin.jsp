<%@include file="/common/admin_header.jspf" %>
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
	<h4 style="padding-bottom: 20px">Welcome Admin!</h4>
    <form action="regUser.do" method="get" class="form-signin" style="padding-bottom: 5px">
    	<div class="form-group">
     		 <button type="submit" class="btn btn-dark">Registered Users</button>
      	</div>
    </form>
    
    <form action="regVehicle.do" method="post" class="form-signin" style="padding-bottom: 5px">
      	<div class="form-group">
	      <button type="button" class="btn btn-dark">Registered Vehicles</button>
    	</div>
    </form>
    
    <form action="issues.do" method="post" class="form-signin" style="padding-bottom: 5px">
    	<div class="form-group">
      		<button type="button" class="btn btn-dark">List Issues</button>
     	</div>
    </form>
</div>

 
<!-- <%@include file="/common/footer.jspf" %> -->


