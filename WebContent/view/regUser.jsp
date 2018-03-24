<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/common/admin_header.jspf"%>

<div class="container">
	<H3 align="center" style="padding-top: 30px">Registered User List</H3>
	
	<table class="table table-striped" style="padding-top: 40px">
		<thead>
			<th>User ID</th>
			<th>Username</th>
			<th>Full name</th>
			<th>Remove User</th>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="u">
				<tr>
					<td>${u.user_id}</td>
					<td>${u.uname}</td>
					<td>${u.fname}</td>
					<td>&nbsp;&nbsp;<a class="btn btn-danger"
						href="regUser.do?todo_id=${u.user_id}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<p>
		<font color="red">${errorMessage}</font>
	</p>

</div>

<%@include file="/common/footer.jspf"%>