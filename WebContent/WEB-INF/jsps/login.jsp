
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<body onload='document.f.username.focus();'>
	<div class="container ">
		<div class="col-md-6">
			<h2>Please sign in</h2>
			<c:if test="${param.error ne null}">
				<div class="alert alert-danger">Invalid username or password.
					Pleases try again!</div>
			</c:if>
			<c:if test="${param.logout ne null}">
				<div class="alert alert-success">You have successfully logged
					out!</div>
			</c:if>
			<form name="f" class="form-horizontal"
				"<c:url value="/login" />" method="POST">
				<div class="form-group">
					<label for="username">Username</label> <input type="text"
						class="form-control" name="username" placeholder="Username">
				</div>
				<div class="form-group">
					<label for="password">Password</label> <input type="password"
						class="form-control" name="password" placeholder="Password">
				</div>
				<div class="form-group">
					<label><input type="checkbox" name="remember-me" checked="checked">
						Remember me </label>
				</div>
				<div class="form-group">
					<button type="submit" name="submit" class="btn btn-primary">Login</button>
				</div>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>
			<div>
				Don't have an account? <a href='<c:url value="/newaccount"></c:url>'>Register</a>
			</div>
		</div>
	</div>