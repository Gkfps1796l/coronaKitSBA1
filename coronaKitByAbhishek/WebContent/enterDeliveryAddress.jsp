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
	<a href="http://localhost:6060/corona-kit-app/">Home</a>
	<span>|</span>
	<a href="newUser">New User</a>
	<hr/>
	<h2>Enter Delivery Address</h2>
	
		<form action="orderSummary" method="post">
			<table cellpadding="5px" cellpacing="5px">
				<tr>
					<td><label>Name</label></td>
					<td><label>${coronaKit.getPersonName()}</label></td>
				</tr>
				<tr>
					<td><label>Email</label></td>
					<td><label>${coronaKit.getEmail()}</label></td>
				</tr>
				<tr>
					<td><label>Contact # +91</label></td>
					<td><label>${coronaKit.getContactNumber()}</label></td>
				</tr>
				<br/>
				<hr/>
				<tr>
					<td><label>Delivery Address</label></td>
					<td><textarea id="w3review" name="dAddress" rows="4" cols="50" required placeholder="Enter Delivery Address"></textarea></td>
				</tr>
				<tr>
					<td></td>
					<td><button>Proceed For Checkout</button></td>
				</tr>
			</table>
		</form>
	
	<hr/>	
		<jsp:include page="footer.jsp"/>
</body>
</html>