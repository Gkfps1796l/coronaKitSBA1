<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-New User</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<hr/>
	<a href="http://localhost:6060/corona-kit-app/"><b>Home</b></a>
	<hr/>
	<h3>Enter Mandatory Details For Corona Kit Order</h3>
	<hr/>
		<form action="verifyUserDetails" method="post">
			<table cellpadding="5px" cellpacing="5px">
				<tr>
					<td><label>Name</label></td>
					<td><input type="text" name="uName" required placeholder="Enter Full Name"/></td>
				</tr>
				<tr>
					<td><label for="email">Email</label></td>
					<td><input type="email" name="eMail" required placeholder="Ex. abc@xyz.com"/></td>
				</tr>
				<tr>
					<td><label>Contact #  +91</label></td>
					<td><input type="number" name="contact" required placeholder="10 Digit Mobile Number"/></td>
				</tr>
				<tr>
					<td></td>
					<td><button>Submit</button></td>
				</tr>
			</table>
		</form>
	
	<hr/>	
		<jsp:include page="footer.jsp"/>
</body>
</html>