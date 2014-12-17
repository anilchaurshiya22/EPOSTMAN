<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Mail Box</title>
<link rel="stylesheet" href="resource/css/foundation.css"></link>
<link rel="stylesheet" href="resource/css/main.css"></link>
</head>
<body>
	<div class="row">
		<div class="small-8 small-centered columns">
		
			<form:form modelAttribute="mailBox" method="post" action="">
				<fieldset>
					<legend>Edit: Mail-Box</legend>

					<div class="label alert register-error">${responseMsg}</div>

					<div class="row">
						<div class="large-3 columns">
							<label class="right"><spring:message
									code="mailBox.number.label" /></label>
						</div>
						<div class="large-6 columns">
							<form:input type="text" path="mNumber" />
						</div>
						<div class="large-3 columns">
							<form:errors class="label alert" path="mNumber" />
						</div>
					</div>
					<div class="row">
						<div class="large-3 columns">
							<label class="right"><spring:message
									code="mailBox.code.label" /></label>
						</div>
						<div class="large-6 columns">
							<form:input type="text" path="code" />
						</div>
						<div class="large-3 columns">
							<form:errors class="label alert" path="code" />
						</div>
					</div>
					<div class="row">
						<div class="large-3 columns">
							<label class="right"><spring:message
									code="mailBox.status.label" /></label>
						</div>
						<div class="large-6 columns">
							<form:radiobutton path="status" value="Y" />
							Active
							<form:radiobutton path="status" value="N" />
							Inactive
						</div>
						<div class="large-3 columns">
							<form:errors class="label alert" path="status" />
						</div>
					</div>

					<div class="row">
						<div class="large-3 columns"></div>
						<div class="large-9 columns">
							<label> <input type="submit" value="EDIT"
								class="button tiny" />
							</label>
						</div>
					</div>
				</fieldset>
			</form:form>
		</div>
	</div>
</body>
</html>