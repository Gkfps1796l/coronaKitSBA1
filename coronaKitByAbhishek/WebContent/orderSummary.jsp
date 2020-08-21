<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Order Placed</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<hr/>
	<a href="http://localhost:6060/corona-kit-app/">Home</a>
	<span>|</span>
	<a href="newUser">New User</a>
	<hr/>
	<h3>Hurray ! Your Order have been placed successfully</h3>
	<h2>Order Summary</h2>
	<hr/>
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
				<tr>
					<td><label>Delivery Address</label></td>
					<td><label>${coronaKit.getDeliveryAddress()}</label></td>
				</tr>
				<tr>
					<td><label>Order Date</label></td>
					<td><label>${coronaKit.getOrderDate()}</label></td>
				</tr>
			</table>
			<hr/>
			<table border=1 cellpadding="5px" cellspacing="3px">
				<tr align="center">
					<td colspan="6"><b>Corona Kit Invoice</b></td>
				</tr>
				<tr align="center">
					<td>Product Id</td>
					<td>Product Name</td>
					<td>Product Description</td>
					<td>Product Cost</td>
					<td>Quantity</td>
					<td>Total Cost</td>
				</tr>
				
				<c:forEach items = "${productList}" var = "product">
					<tr>
						<td>${product.pId}</td>
						<td>${product.pName}</td>
						<td>${product.pDesc}</td>
						<td>${product.pCost}</td>
						<td>${pQtyMap.get(product.pId)}</td>
						<td>${totalCostMap.get(product.pId)}</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5" align="right"><b>Total Bill Amount</b><small><i> (Inclusive of taxes)</i></small></td>
					<td><b>${allItemsCost}</b></td>
				</tr>
		</table>
	<hr/>	
		<jsp:include page="footer.jsp"/>
</body>
</html>