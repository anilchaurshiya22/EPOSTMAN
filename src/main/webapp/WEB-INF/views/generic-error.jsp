<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<body>

	<c:if test="${not empty errCode}">
		<h1>${errCode}: System Errors</h1>
	</c:if>

	<c:if test="${empty errCode}">
		<h1>System Errors</h1>
	</c:if>

	<c:if test="${not empty errMsg}">	
		<h4>${errMsg}</h4>
	</c:if>
 <p><button type=button onclick=window.location.href="<spring:url value="/dashboard" />">Home</button></p>
</body>
</html>