<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mail Boxes</title>
</head>
<body>
	<section>
	<div class="jumbotron">
		<div class="container">
			<h1>mailBox</h1>
			<p>${responseMsg}</p>
		</div>
	</div>
	</section>

	<section class="container">
	<div class="row">
		<table style="width: 50%;" border="1">
			<tr>
				<td>Mail Box Number</td>
				<td>Mail Box Code</td>
				<td>Status</td>
			</tr>
			<c:forEach items="${mailBoxesList}" var="mailBox">
				<tr>
					<td><c:out value="${mailBox.mNumber}"></c:out></td>
					<td><c:out value="${mailBox.code}"></c:out></td>
					<td><c:out value="${mailBox.status}"></c:out></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	</section>
</body>
</html>