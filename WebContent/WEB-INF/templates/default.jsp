<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- insert head content -->
<tiles:insertAttribute name="head" />
<body>
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="content" /> 
	<tiles:insertAttribute name="footer" />
	
</body>
</html>