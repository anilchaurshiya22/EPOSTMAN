<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table style="width: 100%;">
	<thead>
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Contact Number</th>
			<th>Gender</th>
			<th>Status</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user}</td>
				<td>${user.email}</td>
				<td>${user}</td>
				<td>${user.gender}</td>
				<td><c:if test="${user.status eq 1}">Active</c:if><c:if test="${user.status eq 0}">Inactive</c:if></td>
				<td>
					<c:if test="${user.status eq 0}">
						<a href='<c:url value="/enable-user?id=${user.id}" />' class="button tiny success">Enable</a>
					</c:if>
					<c:if test="${user.status eq 1}">
						<a href='<c:url value="/disable-user?id=${user.id}" />' class="button tiny alert">Disable</a>
					</c:if>
					<a href='<c:url value="/user/edit?id=${user.id}" />' class="button tiny">Edit</a>
					<a href='<c:url value="/user/delete?id=${user.id}" />' class="button tiny alert">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>