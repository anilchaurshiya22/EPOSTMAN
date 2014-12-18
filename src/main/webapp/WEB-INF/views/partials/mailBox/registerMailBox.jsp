<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="base" value="${pageContext.servletContext.contextPath}" />
<div class="small-12 small-centered columns">
	<h2>
		<img src="${base}/resource/images/mailbox.png" style="width: 137px;">
		Add Mail Box
	</h2>

	<form:form modelAttribute="newMailBox" method="post"
		action="registerMailBox">
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
			<div class="large-3 columns"></div>
			<div class="large-9 columns">
				<label> <input type="submit" value="ADD"
					class="button tiny" />
				</label>
			</div>
		</div>
	</form:form>
</div>