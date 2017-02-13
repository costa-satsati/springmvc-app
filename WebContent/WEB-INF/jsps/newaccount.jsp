<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>    
       
<div class="container">
 
        <sf:form action="${pageContext.request.contextPath}/createaccount" commandName="user">      
                    <h3 style="margin-bottom: 25px; text-align: center;">Create Account</h3>             
    				<div class="form-group">
						<sf:input type="text" class="form-control" path="username" name="username" placeholder="Username"  />
					</div>
					<sf:errors path="username" cssClass="alert alert-danger" element="div"></sf:errors>
					<div class="form-group">
						<sf:input type="text" class="form-control" path="name" name="name" placeholder="Name"  />
					</div>
					<sf:errors path="name" cssClass="alert alert-danger" element="div"></sf:errors>
					<div class="form-group">
						<sf:input type="text" class="form-control" path="email" name="email" placeholder="Email"  />
					</div>	
					<sf:errors path="email" cssClass="alert alert-danger" element="div"></sf:errors>
					<div class="form-group">
						<sf:input type="password" class="form-control" path="password" name="password" id="password" placeholder="Password"  />
					</div>
					<sf:errors path="password" cssClass="alert alert-danger" element="div"></sf:errors>					
                    <div class="form-group">
                    <input type="password" class="form-control" name="confirmpass" id="confirmpass" placeholder="Confirm Password"  />                                           
                    </div>
                    <div id="passmatch" class="alert alert-danger"></div>           
        <button type="submit" id="submit" name="submit" class="btn btn-primary pull-right">Create Account</button>
        </sf:form>
   
</div>
<script type="text/javascript">

	$(document).ready(function() {
		$('#passmatch').hide();
		$('form').on('submit', function() {
			if ($('#password').val() != $('#confirmpass').val()) {
				$('#passmatch').text('Passwords do not match!').show();
				return false;
			}
			return true;
		});
	});
</script>