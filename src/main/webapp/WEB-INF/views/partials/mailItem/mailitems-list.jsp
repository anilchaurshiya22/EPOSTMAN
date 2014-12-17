<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<c:set var="base" value="${pageContext.servletContext.contextPath}" />
<h2>
	<img src="${base}/resource/images/email.png"> Mail Items
</h2>
<p><a href="<c:url value="/a/mails/register"/> ">Add Mail Items</a></p>
<c:if test="${successMessage != null}">
	<div class="panel" style="background-color: green; color: white;">${successMessage}</div>
</c:if>
<table style="width: 100%;">
	<thead>
		<tr>
			<th>Name</th>
			<th>Description</th>
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
				<td>${mailitem.description}</td>
				<td>${mailitem.itemType.name}</td>
				<td>${mailitem.user}</td>
				<td>${mailitem.arrivalDate}</td>
				<td>${mailitem.departureDate}</td>
				<td>${mailitem.barCode}</td>				
				<td>
					 <a href='<c:url value="/a/mailitem/edit/${mailitem.id}" />'
					class="button tiny">Edit</a> 
						<a href='<c:url value="/a/mailitem/delete/${mailitem.id}" />'
							class="button tiny alert">Delete</a>					
			</tr>
		</c:forEach>
	</tbody>
</table>