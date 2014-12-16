<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="base" value="${pageContext.servletContext.contextPath}" />
<h2><img src="${base}/resource/images/user.png"> Users</h2>
<c:if test="${successMessage != null}">
	<div class="panel" style="background-color: green; color: white;">${successMessage}</div>
</c:if>
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
				<td>${user.status.name}</td>
				<td>
					<c:if test="${user.status.value eq 0}">
						<a href='<c:url value="/enable-user/${user.id}" />' class="button tiny success">Enable</a>
					</c:if>
					<c:if test="${user.status.value eq 1}">
						<a href='<c:url value="/disable-user/${user.id}" />' class="button tiny alert">Disable</a>
					</c:if>
					<a href='<c:url value="/user/edit/${user.id}" />' class="button tiny">Edit</a>
					<a href='<c:url value="/user/delete/${user.id}" />' class="button tiny alert">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>