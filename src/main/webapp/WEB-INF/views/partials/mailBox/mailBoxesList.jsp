<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${successMsg != null}">
	<div class="panel" style="background-color: green; color: white;">${successMsg}</div>
</c:if>

<p>
	<a href="<c:url value="/mailBox/addMailBox"/> ">Add New Mail Box</a>
</p>

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
				
				<td><c:if test="${mailBox.status eq 'Y'}">Active</c:if> <c:if
						test="${mailBox.status eq 'N'}">Inactive</c:if></td>
				<td>
					<a href="<c:url value="/a/mailBox/edit/${mailBox.id}" />"
					class="button tiny">Edit</a> <a
					href="<c:url value="/a/mailBox/delete/${mailBox.id}" />"
					class="button tiny alert">Delete</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>