<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="small-12 small-centered columns">
	<h2>Enable User</h2>
	<h3>Select Mail Box to be assigned to this user.</h3>
	<form:form modelAttribute="user" method="post" action="">
			<c:if test="${message != null}">
			<div class="label alert register-error">${message}</div>
			</c:if>
			<div class="row">
				<div class="large-3 columns">
					<label class="right"><spring:message code="mailBox.number.label" /></label>
				</div>
				<div class="large-6 columns">
					<form:select path="mailBox.id">
						<form:option value="">Select One</form:option>
						<c:forEach items="${mailboxes}" var="mailbox">
							<form:option value="${mailbox.id}">${mailbox.mNumber}</form:option>
						</c:forEach>
					</form:select>
				</div>
				<div class="large-3 columns">
					<form:errors class="label alert" path="*" />
				</div>
			</div>
			<div class="row">
				<div class="large-3 columns">
				</div>
				<div class="large-9 columns">
					<input type="submit" value="ENABLE" class="button tiny" />
				</div>
			</div>
	</form:form>
</div>