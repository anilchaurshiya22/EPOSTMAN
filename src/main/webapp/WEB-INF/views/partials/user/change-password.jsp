<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>E-PostMan | Change Password</title>
<link rel="stylesheet" href="resource/css/foundation.css"></link>
<link rel="stylesheet" href="resource/css/main.css"></link>
</head>
<body>
	<div class="row">
		<div class="small-8 small-centered columns">
			<form:form modelAttribute="user" method="post" action="changePassword">
				<fieldset>
					<legend>E-PostMan:Change Password</legend>
					
						<div class="label alert register-error">${message}</div>
					<div class="row">
						<div class="large-3 columns">
							<label class="right"><spring:message code="user.oldpassword.label" /></label>
						</div>
						<div class="large-6 columns">
							<form:input type="password" path="oldLoginPassword" />
						</div>
						<div class="large-3 columns">
							<form:errors class="label alert" path="oldLoginPassword" />
						</div>
					</div>
				
					<div class="row">
						<div class="large-3 columns">
							<label class="right"><spring:message code="user.newpassword.label" /></label>
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
							<label class="right"><spring:message code="user.cnewpassword.label" /></label>
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
						</div>
						<div class="large-9 columns">
							<label>
								<input type="submit" value="CHANGE PASSWORD" class="button tiny" />
							</label>
						</div>
					</div>
				</fieldset>
			</form:form>
		</div>
	</div>
</body>
</html>