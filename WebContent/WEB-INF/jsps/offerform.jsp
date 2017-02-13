<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="container">
	<div class="col-md-5">
		<div class="form-area">

			<c:choose>
				<c:when test="${offerForm['new']}">
					<h1>Add Offer</h1>
				</c:when>
				<c:otherwise>
					<h1>Update Offer</h1>
				</c:otherwise>
			</c:choose>
			<spring:url value="/offers" var="actionUrl" />
			<sf:form action="${actionUrl}"	modelAttribute="offerForm">
				<br style="clear: both">
					<sf:hidden path="id" />
				<div class="form-group">
					<sf:textarea class="form-control" type="textarea" path="text"
						name="text" placeholder="Message" maxlength="140" rows="7"></sf:textarea>
				</div>

				<sf:errors path="text" cssClass="alert alert-danger" element="div"></sf:errors>

				<c:choose>
					<c:when test="${offerForm['new']}">
						<button type="submit" name="create" class="btn-lg btn-primary pull-right">Add
							Offer</button>
					</c:when>
					<c:otherwise>
						<button type="submit" name="update" class="btn-lg btn-primary pull-right">Update
							Offer</button>
					</c:otherwise>
				</c:choose>
				
			</sf:form>
		</div>
	</div>
</div>
