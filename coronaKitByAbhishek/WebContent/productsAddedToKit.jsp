<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Products Added In Kit</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<hr/>
		<a href="http://localhost:6060/corona-kit-app/">Home</a>
		<span>|</span>
		<a href="newUser">New User</a>
	<hr/>
	<form action="enterDeliveryAddress" method="post">
			<div>
				<label><h3>Hi ${coronaKit.getPersonName()}</h3></label>
			</div>
			<div>
				<label><h3>Here are the items added to kit</h3></label>
			</div>
			
			<hr/>
			
			<table border=1 cellpadding="5px" cellspacing="5px">
				<tr align="center">
					<td>Product Id</td>
					<td>Product Name</td>
					<td>Product Description</td>
					<td>Product Cost</td>
					<td>Quantity</td>
				</tr>
				
				<c:forEach items = "${productList}" var = "product">
					<tr>
						<td>${product.pId}</td>
						<td>${product.pName}</td>
						<td>${product.pDesc}</td>
						<td>${product.pCost}</td>
						<td>${pQtyMap.get(product.pId)}</td>
					</tr>
				</c:forEach>
		</table>
		<hr/>
		<table>
			<tr>
				<td colspan="3">
					<button>Procced For Delivery</button>
				</td>
			</tr>
		</table>
	
	<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>