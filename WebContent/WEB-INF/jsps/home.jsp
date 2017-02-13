<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="container">
		<h1>Welcome to the Offers App</h1>
		
		<div class="container">		
		<table class="table">
			<caption>Available Offers</caption>
			<thead>
				<tr>
					<th>#</th>
					<th>Name</th>
					<th>Email</th>
					<th>Text</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="offer" items="${offers}">
					<tr>
						<th scope="row"><c:out value="${offer.id}"></c:out></th>
						<td><c:out value="${offer.user.name}"></c:out></td>
						<td><c:out value="${offer.user.email}"></c:out></td>
						<td><c:out value="${offer.text}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
	<img alt="image" src="<c:url value="/resources/img/home-image.png" />">
		
	</div>
