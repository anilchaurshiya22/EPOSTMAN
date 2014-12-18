<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="base" value="${pageContext.servletContext.contextPath}" />
<div class="small-12 small-centered columns">
	<h2>
		<img src="${base}/resource/images/epostman.jpg" style="width: 137px;">
		<c:choose>
			<c:when test="${isEdit}">
				<legend>Edit Mail Item</legend>
			</c:when>
			<c:otherwise>
				<legend>Add Mail Item</legend>
			</c:otherwise>
		</c:choose>
	</h2>

	<form:form modelAttribute="mailitem" method="post">
		<c:if test="${message != null}">
			<div class="label alert register-error">${message}</div>
		</c:if>
		<div class="row">
			<div class="large-3 columns">
				<label class="right"><spring:message
						code="mailItem.name.label" /></label>
			</div>
			<div class="large-6 columns">
				<form:input type="text" path="name" />
			</div>
			<div class="large-3 columns">
				<form:errors class="label alert" path="name" />
			</div>
		</div>
		<div class="row">
			<div class="large-3 columns">
				<label class="right"><spring:message
						code="mailItem.description.label" /></label>
			</div>
			<div class="large-6 columns">
				<form:textarea path="description"></form:textarea>
			</div>
			<div class="large-3 columns">
				<form:errors class="label alert" path="description" />
			</div>
		</div>
		<div class="row">
			<div class="large-3 columns">
				<label class="right"><spring:message
						code="mailItem.itemType.label" /></label>
			</div>

			<div class="large-6 columns">
				<form:select path="type">
				<form:option value="-1" label="--- Select ---" />					
					<form:options items="${mailTypes}" itemValue="value"
						itemLabel="name" />
				</form:select>
			</div>

			<div class="large-3 columns">
				<form:errors class="label alert" path="itemType" />
			</div>
		</div>
		<div class="row">
			<div class="large-3 columns">
				<label class="right"><spring:message
						code="mailItem.user.label" /></label>
			</div>
			<div class="large-6 columns">
				<form:select path="user.id">
					<form:option value="-1" label="--- Select ---" />
					<form:options items="${users}" itemValue="id" itemLabel="username" />
				</form:select>
			</div>
			<div class="large-3 columns">
				<form:errors class="label alert" path="" />
			</div>
		</div>

		<div class="row">
			<div class="large-3 columns">
				<label class="right"><spring:message
						code="mailItem.arrivalDate.label" /></label>
			</div>
			<div class="large-6 columns">
				<form:input type="text" path="arrivalDate" placeholder="MM/dd/yyyy" />
			</div>
			<div class="large-3 columns">
				<form:errors class="label alert" path="arrivalDate" />
			</div>
		</div>
		<div class="row">
			<div class="large-3 columns">
				<label class="right"><spring:message
						code="mailItem.departureDate.label" /></label>
			</div>
			<div class="large-6 columns">
				<form:input type="text" path="departureDate"
					placeholder="MM/dd/yyyy" />
			</div>
			<div class="large-3 columns">
				<form:errors class="label alert" path="departureDate" />
			</div>
		</div>
		<div class="row">
			<div class="large-3 columns">
				<label class="right"><spring:message
						code="mailItem.barCode.label" /></label>
			</div>
			<div class="large-6 columns">
				<form:input type="text" path="barCode" />
			</div>
			<div class="large-3 columns">
				<form:errors class="label alert" path="barCode" />
			</div>
		</div>
		<div class="row">
			<div class="large-3 columns"></div>
			<c:choose>
				<c:when test="${isEdit}">
					<div class="large-9 columns">
						<input type="submit" value="Edit Item" class="button tiny" />
					</div>
				</c:when>
				<c:otherwise>
					<div class="large-9 columns">
						<input type="submit" value="Add Item" class="button tiny" />
					</div>
				</c:otherwise>
			</c:choose>

		</div>
	</form:form>
</div>