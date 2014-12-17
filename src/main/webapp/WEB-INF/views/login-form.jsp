<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>E-PostMan</title>
<link rel="stylesheet" href="resource/css/foundation.css"></link>
<link rel="stylesheet" href="resource/css/main.css"></link>
</head>
<body>
	<div class="row">
		<div class="small-4 small-centered columns">
		Language : <a href="?language=en">English</a>|<a href="?language=ne">Nepali</a>
			<form method="post" action="<c:url value='j_spring_security_check'/>">
				<fieldset>
					<legend><spring:message code="epostman.login.label"/></legend>
					<c:if test="${error}">
						<div class="label alert login-error">Invalid login or
							password.</div>
					</c:if>
					<div class="row">
						<div class="large-12 columns">
							<label><spring:message code="user.username.label" /><input type="text" name="j_username"
								id="j_username" />
							</label>
						</div>
					</div>
					<div class="row">
						<div class="large-12 columns">
							<label><spring:message code="user.password.label" /> <input type="password"
								name="j_password" id="j_password" />
							</label>
						</div>
					</div>
					<div class="row">
						<div class="large-12 columns">
							<label>
<<<<<<< HEAD
								<input type="submit" value="LOGIN" class="button tiny" />
								<a href="<spring:url value="/u/register"></spring:url>" class="right">Register</a>
=======
								<input type="submit" value="<spring:message code="user.login.label" />" class="button tiny" />
								<a href="<spring:url value="/register"></spring:url>" class="right"><spring:message code="user.register.label" /></a>
>>>>>>> ee264cba7388c4c0fae307ea519345bbd3fabf9f
							</label>
						</div>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>