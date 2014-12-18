<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<c:set var="base" value="${pageContext.servletContext.contextPath}" />
<h2 style="height:61px;">
	<img src="${base}/resource/images/epostman.jpg" style="width: 137px;"> Mail Items
</h2>
<p style="float:right;"><a href="<c:url value="/a/mails/register"/>" class="button tiny">Add Mail Items</a></p>
<c:if test="${successMessage != null}">
	<div class="panel" style="background-color: green; color: white;">${successMessage}</div>
</c:if>
<table style="width: 100%;">
	<thead>
		<tr>
			<th>Name</th>
			<!-- <th>Description</th> -->
			<th>Item Type</th>
			<th>User Assigned</th>
			<th>Date of Arrival</th>
			<th>Date of Departure</th>
			<th>BarCode</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${mailitems}" var="mailitem">
			<tr>
				<td>${mailitem.name}</td>
				<%-- <td>${mailitem.description}</td> --%>
				<td>${mailitem.itemType.name}</td>
				<td>${mailitem.user}</td>
				<td>${mailitem.arrivalDate}</td>
				<td>${mailitem.departureDate}</td>
				<td>${mailitem.barCode}</td>
				<td><a href='<c:url value="/a/mails/edit?id=${mailitem.id}" />'
					class="button tiny">Edit</a> <a
					href='<c:url value="/a/mails/delete/${mailitem.id}" />'
					class="button tiny alert">Delete</a> <c:choose>
						<c:when test="${mailitem.status.value==1}">
							<a href='<c:url value="" />' class="button tiny success">Deliver</a>
						</c:when>
						<c:otherwise>
							<a href='<c:url value="/a/mails/notification/${mailitem.id}" />'
								class="button tiny success">Notify User</a>
						</c:otherwise>
					</c:choose>
			</tr>
		</c:forEach>
	</tbody>
</table>