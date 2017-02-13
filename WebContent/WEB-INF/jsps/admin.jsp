<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<div class="container">
		<h3>Only authorised users allowed</h3>

		<table class="table">
			<caption>All users</caption>
			<thead>
				<tr>
					<th>Username</th>
					<th>Enabled</th>
					<th>Email</th>
					<th>Role</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${users}">
					<tr>
						<th scope="row"><c:out value="${user.username}"></c:out></th>
						<td><c:out value="${user.enabled}"></c:out></td>
						<td><c:out value="${user.email}"></c:out></td>
						<td><c:out value="${user.authority}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
