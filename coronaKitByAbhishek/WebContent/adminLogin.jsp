<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Admin Login</title>
</head>
<body>
<div>
<jsp:include page="header.jsp"/>
<a href="http://localhost:6060/corona-kit-app/">Home</a>
<hr/>
	<h2>Admin Login</h2>
	<form action="adminHome" method="post">
		<table cellpadding="5px" cellpacing="5px">
			<tr>
				<td><label>User Name</label></td>
				<td><input type="text" id="loginId" name="loginId" required placeholder="Enter User Name"/></td>
			</tr>
			<tr>
				<td><label>Password</label></td>
				<td><input type="password" id="password" name="password" required placeholder="Enter Password"/></td>
			</tr>
			<tr>
				<td></td>
				<td><button type="submit">Login</button></td>
			</tr>
		</table>
	</form>
	
</div>
<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>