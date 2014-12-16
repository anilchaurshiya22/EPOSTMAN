<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<p>${responseMsg}</p>

<p><a href="<c:url value="/mailBox/addMailBox"/> ">Add Mail Box</a></p>
<table style="width: 100%;">
	<thead>
		<tr>
			<th>Mail Box Number</th>
			<th>Mail Box Code</th>
			<th>Status</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${mailBoxesList}" var="mailBox">
			<tr>
				<td>${mailBox.mNumber}</td>
				<td>${mailBox.code}</td>

				<td><c:if test="${mailBox.status eq Y}">Active</c:if> <c:if
						test="${mailBox.status eq N}">Inactive</c:if></td>
				<td><c:if test="${mailBox.status eq N}">
						<a href='<c:url value="/enable-mailBox?id=${mailBox.id}" />'
							class="button tiny success">Enable</a>
					</c:if> <c:if test="${mailBox.status eq 1}">
						<a href='<c:url value="/disable-mailBox?id=${mailBox.id}" />'
							class="button tiny alert">Disable</a>
					</c:if> <a href='<c:url value="/mailBox/edit?id=${mailBox.id}" />'
					class="button tiny">Edit</a> <a
					href='<c:url value="/user/delete?id=${mailBox.id}" />'
					class="button tiny alert">Delete</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>