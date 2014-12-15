<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>E-PostMan</title>
</head>
<body>
	<form method="post" action="<c:url value='j_spring_security_check'/>">
		<div>
			<h1>
				<span>E-PostMan</span>
			</h1>
			<div>
				<h2>
					<span>LOGIN</span>
				</h2>
				<p>
					<c:if test="${error}">
						<b class="error">Invalid login or password.</b>
					</c:if>
				</p>
				Username: <input type="text" name="j_username" id="j_username"
						size="30" maxlength="40"  /></br>

					Password: <input type="password" name="j_password" id="j_password"
						size="30" maxlength="32" /></br>
					<input type="submit" value="LOGIN"  />
			</div>
		</div>
	</form>

</body>
</html>