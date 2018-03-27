<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/common/admin_header.jspf"%>

<div class="container">
	<H3 align="center" style="padding-top: 30px">Registered Vehicle List</H3>
	
	<table class="table table-striped" style="padding-top: 40px">
		<thead>
			<th>Vehicle Number</th>
			<th>Description</th>
		</thead> 
		<tbody>
			<c:forEach items="${vehicles}" var="u">
				<tr>
					<td>${u.vehicleNo}</td>
					<td>${u.vehicleDesc}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<p>
		<font color="red">${errorMessage}</font>
	</p>

</div>

<%@include file="/common/footer.jspf"%>