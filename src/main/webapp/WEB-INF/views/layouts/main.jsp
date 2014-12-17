<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>E-PostMan</title>
<c:set var="base" value="${pageContext.servletContext.contextPath}" />
<link rel="stylesheet" href="${base}/resource/css/foundation.css"></link>
<link rel="stylesheet" href="${base}resource/css/main.css"></link>
</head>
<body>
	<div class="row">
		<div class="small-12 small-centered columns">
			<div class="icon-bar six-up"  style="background-color: rgb(67, 172, 106);">
				<a href="<c:url value="/dashboard" />" class="item">
					<img src="${base}/resource/images/home.png">
					<label>Dashboard</label>
				</a> 
				<a href="<c:url value="/users" />" class="item"> 
					<img src="${base}/resource/images/user.png">
					<label>Users</label>
				</a> 
				<a  href="<c:url value="/mailBox" />" class="item">
					<img src="${base}/resource/images/mailbox.png">
					<label>Mail Box</label>
				</a> 
				<a  href="<c:url value="/mail" />" class="item">
					<img src="${base}/resource/images/email.png">
					<label>Mail</label>
				</a> 
				<a  href="<c:url value="settings" />" class="item">
					<img src="${base}/resource/images/setting.png">
					<label>Settings</label>
				</a> 
				<a href="<c:url value="/j_spring_security_logout" />" class="item"> 
					<img src="${base}/resource/images/logout.png">
					<label>Logout</label>
				</a>
			</div>
			<div style="padding: 30px;">
				<jsp:include page="../partials/${partials}.jsp" />
			</div>
			<div class="small-3 small-centered columns">copyright 2014</div>
		</div>
	</div>
</body>
</html>