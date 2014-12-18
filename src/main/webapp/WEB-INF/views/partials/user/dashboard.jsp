<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h3>
	<spring:message code="welcome.label" />
	${authenitcatedUser}
</h3>
<br>
<c:if test="${authenitcatedUser.role.value eq 1}">
	<h5 style="float: right;">Mail Box Number:${mailBoxNumber}</h5>
	<h5>Mail Box Shared With</h5>
	<table style="width: 100%;">
		<thead>
			<tr>
				<th>Name</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${mailSharedUsers}" var="users">
				<tr>
					<td>${users}</td>
			</c:forEach>
		</tbody>
	</table>

	<h5>
		<spring:message code="mailItem.label" />
	</h5>
	<table style="width: 100%;">
		<thead>
			<tr>

				<th><spring:message code="mailItem.name.label" /></th>
				<th><spring:message code="mailItem.description.label" /></th>
				<th><spring:message code="mailItem.arrivalDate.label" /></th>
				<th><spring:message code="mailItem.barCode.label" /></th>
				<th><spring:message code="mailItem.type" /></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${mailItems}" var="mailItem">
				<tr>
					<td>${mailItem.name}</td>
					<td>${mailItem.description}</td>
					<td>${mailItem.arrivalDate}</td>
					<td>${mailItem.barCode}</td>
					<td>${mailItem.itemType}</td>
			</c:forEach>
		</tbody>
	</table>
</c:if>