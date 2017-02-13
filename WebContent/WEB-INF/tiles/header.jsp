<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!-- Static navbar -->
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/">Offers App</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="/">Home</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><sec:authorize var="loggedIn" access="isAuthenticated()" />
					<sec:authentication var="user" property="principal" /> <c:choose>
						<c:when test="${loggedIn}">
							<a href="<c:url value="/logout" />">Logout</a>
						</c:when>
						<c:otherwise>
							<a href="<c:url value="/login" />">Login</a>
						</c:otherwise>
					</c:choose></li>
				<c:if test="${loggedIn}">
					<li><a href="<c:url value="/offers/list" />">My Offers</a></li>
				</c:if>
				<li><a href="<c:url value="/offers/add" />">Create Offer</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
	<!--/.container-fluid -->
</nav>