<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>E-PostMan</title>
<link rel="stylesheet" href="resource/css/foundation.css"></link>
<link rel="stylesheet" href="resource/css/main.css"></link>
</head>
<body>
	<div class="row">
		<div class="small-8 small-centered columns">
			<form:form modelAttribute="user" method="post" action="register">
				<fieldset>
					<legend>E-PostMan: Register</legend>
					<div class="row">
						<div class="large-3 columns">
							<label class="right"><spring:message code="user.firstname.label" /></label>
						</div>
						<div class="large-6 columns">
							<form:input type="text" path="firstName" />
						</div>
						<div class="large-3 columns">
							<form:errors class="label alert" path="firstName" />
						</div>
					</div>
					<div class="row">
						<div class="large-3 columns">
							<label class="right"><spring:message code="user.lastname.label" /></label>
						</div>
						<div class="large-6 columns">
							<form:input type="text" path="lastName" />
						</div>
						<div class="large-3 columns">
							<form:errors class="label alert" path="lastName" />
						</div>
					</div>
					<div class="row">
						<div class="large-3 columns">
							<label class="right"><spring:message code="user.gender.label" /></label>
						</div>
						<div class="large-6 columns">
							<form:radiobutton path="gender" value="M" /> Male
							<form:radiobutton path="gender" value="F" /> Female
						</div>
						<div class="large-3 columns">
							<form:errors class="label alert" path="gender" />
						</div>
					</div>
					<div class="row">
						<div class="large-3 columns">
							<label class="right"><spring:message code="user.email.label" /></label>
						</div>
						<div class="large-6 columns">
							<form:input type="text" path="email" />
						</div>
						<div class="large-3 columns">
							<form:errors class="label alert" path="email" />
						</div>
					</div>
					<div class="row">
						<div class="large-3 columns">
							<label class="right"><spring:message code="user.contact.label" /></label>
						</div>
						<div class="large-6 columns">
							<form:input type="text" path="contactNumber" />
						</div>
						<div class="large-3 columns">
							<form:errors class="label alert" path="contactNumber" />
						</div>
					</div>
					<div class="row">
						<div class="large-3 columns">
							<label class="right"><spring:message code="user.username.label" /></label>
						</div>
						<div class="large-6 columns">
							<form:input type="text" path="userName" />
						</div>
						<div class="large-3 columns">
							<form:errors class="label alert" path="userName" />
						</div>
					</div>
					<div class="row">
						<div class="large-3 columns">
							<label class="right"><spring:message code="user.password.label" /></label>
						</div>
						<div class="large-6 columns">
							<form:input type="password" path="loginPassword" />
						</div>
						<div class="large-3 columns">
							<form:errors class="label alert" path="loginPassword" />
						</div>
					</div>
					<div class="row">
						<div class="large-3 columns">
							<label class="right"><spring:message code="user.cpassword.label" /></label>
						</div>
						<div class="large-6 columns">
							<form:input type="password" path="confirmLoginPassword" />
						</div>
						<div class="large-3 columns">
							<form:errors class="label alert" path="confirmLoginPassword" />
						</div>
					</div>
					<div class="row">
						<div class="large-3 columns">
							<label class="right"><spring:message code="user.desc.label" /></label>
						</div>
						<div class="large-6 columns">
							<form:textarea path="description"></form:textarea>
						</div>
						<div class="large-3 columns">
							<form:errors class="label alert" path="description" />
						</div>
					</div>
					<div class="row">
						<div class="large-12 columns">
							<label>
								<input type="submit" value="REGISTER" class="button tiny" />
							</label>
						</div>
					</div>
				</fieldset>
			</form:form>
		</div>
	</div>
</body>
</html>