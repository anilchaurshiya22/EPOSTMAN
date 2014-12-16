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
			<form:form modelAttibute="user" method="post" action="/process-register">
				<fieldset>
					<legend>E-PostMan: Register</legend>
					<div class="row">
						<div class="large-3 columns">
							<label class="right">First Name</label>
						</div>
						<div class="large-9 columns">
							<form:input type="text" path="firstName" id="firstName" />
						</div>
					</div>
					<div class="row">
						<div class="large-3 columns">
							<label class="right">Last Name</label>
						</div>
						<div class="large-9 columns">
							<form:input type="text" path="lastName" />
						</div>
					</div>
					<div class="row">
						<div class="large-3 columns">
							<label class="right">Email</label>
						</div>
						<div class="large-9 columns">
							<form:input type="text" path="email" />
						</div>
					</div>
					<div class="row">
						<div class="large-3 columns">
							<label class="right">Password</label>
						</div>
						<div class="large-9 columns">
							<form:input type="password" path="password" />
						</div>
					</div>
					<div class="row">
						<div class="large-3 columns">
							<label class="right">Confirm Password</label>
						</div>
						<div class="large-9 columns">
							<form:input type="password" path="confirm_password" />
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