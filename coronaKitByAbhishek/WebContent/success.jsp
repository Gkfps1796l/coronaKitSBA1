<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Success</title>
</head>
<body>
<div>
<jsp:include page="header.jsp"/>
<hr/>
	<a href="http://localhost:6060/corona-kit-app/">Home</a>
	<span>|</span>
	<a href="adminLoginLink">Admin Login</a>
	<span>|</span>
	<a href="newUser">New User</a>
</div>
<hr/>
<h3>${msg}</h3>
</div>
<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>