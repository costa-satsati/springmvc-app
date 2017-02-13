<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<div class="container">
	<h2>Display Offers</h2>
	<table class="table">
		<caption>My Offers</caption>
		<thead>
			<tr>
				<th>#</th>
				<th>Name</th>
				<th>Email</th>
				<th>Text</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="myoffer" items="${myoffers}">
				<tr>
					<th scope="row"><c:out value="${myoffer.id}"></c:out></th>
					<td><c:out value="${myoffer.user.name}"></c:out></td>
					<td><c:out value="${myoffer.user.email}"></c:out></td>
					<td><c:out value="${myoffer.text}"></c:out></td>
					<td><a href="<c:out value="/offers/${myoffer.id}/update" />">Update</a>
						<a  onclick="return confirm('are you sure?')" href="<c:out value="/offers/${myoffer.id}/delete" />" >Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</div>

