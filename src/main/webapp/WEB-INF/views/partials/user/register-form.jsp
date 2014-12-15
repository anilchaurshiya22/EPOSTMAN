<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
			<form method="post" action="<c:url value='j_spring_security_check'/>">
				<fieldset>
					<legend>E-PostMan: Register</legend>
					<div class="row">
						<div class="large-3 columns">
							<label class="right">First Name</label>
						</div>
						<div class="large-9 columns">
							<input type="text" />
						</div>
					</div>
					<div class="row">
						<div class="large-3 columns">
							<label class="right">Last Name</label>
						</div>
						<div class="large-9 columns">
							<input type="text" />
						</div>
					</div>
					<div class="row">
						<div class="large-3 columns">
							<label class="right">Email</label>
						</div>
						<div class="large-9 columns">
							<input type="text" />
						</div>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>