<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Add Products To Cart</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<hr/>
		<a href="http://localhost:6060/corona-kit-app/">Home</a>
		<span>|</span>
		<a href="newUser">New User</a>
	<hr/>
	
	<form action="addProductsToKit" method="post">
			<div>
				<label><h3>Welcome ${coronaKit.getPersonName()}</h3></label>
			</div>
			
			<hr/>
			<b align="center">Available Products To Add</b>
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
						<td><input type="text" min="0" max="10" name="pQuantity${product.pId}" value="0"/></td>
					</tr>
				</c:forEach>
		</table>
		<hr/>
					<button>Add Products To Kit</button>
				
			</tr>
		</table>
	
	<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>