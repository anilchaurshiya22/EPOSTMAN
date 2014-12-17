<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Profile</title>
</head>
<body>
	<a href="changePassword"> Change Password </a>
	${message }
	<div class="row">
		<div class="small-8 small-centered columns"></div>
		<fieldset>
			<legend>User Profile: ${user.username}</legend>
			<div id="profilePic">
				<img
					src="${pageContext.servletContext.contextPath}${user.picLocation}" />
			</div>
			<form:form modelAttribute="user" class="form-horizontal" action="uploadPhoto" method="post"
				enctype="multipart/form-data">
				<div class="row">
					<div class="large-4 columns">
						<label class="left">Change your profile picture</label> <form:input
							id="profilePic" path="profilePic" type="file" /> <input
							id="pic" type="submit" Value="Change Profile Picture"/>
					</div>
				</div>
				<form:hidden path="id"/>
			</form:form>
			</br> </br>
			<div class="row">
				<div class="large-2 columns">
					<label class="left"><spring:message
							code="user.firstname.label" /></label> <label class="right">${user.firstName}</label>
				</div>
			</div>
			<div class="row">

				<div class="large-2 columns">
					<label class="left"><spring:message
							code="user.lastname.label" /></label> <label class="right">${user.lastName}</label>
				</div>
			</div>
			<div class="row">
				<div class="large-2 columns">
					<label class="left"><spring:message
							code="user.gender.label" /></label> <label class="right">${user.gender}</label>
				</div>
			</div>
			<div class="row">
				<div class="large-3 columns">
					<label class="left"><spring:message
							code="user.contact.label" /></label> <label class="right">${user.contactNumber }</label>

				</div>
			</div>
			<div class="row">
				<div class="large-3 columns">
					<label class="left"><spring:message code="user.email.label" /></label>
					<label class="right">${user.email }</label>

				</div>
			</div>
			<div class="row">
				<div class="large-4 columns">
					<label class="left"><spring:message code="user.desc.label" /></label>
					<textarea readonly>${user.description }</textarea>
				</div>
			</div>
		</fieldset>
	</div>
</body>
</html>