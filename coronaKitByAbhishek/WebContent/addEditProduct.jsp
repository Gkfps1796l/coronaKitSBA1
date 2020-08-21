<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product List</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
		<hr/>
		<a href="http://localhost:6060/corona-kit-app/">Home</a>
		<hr/>
		<h2>Hello Admin</h2>
			<button><a href = "addProduct" >Add New Product</a></button>
			<span>|</span>
			<button><a href = "showProduct" >Show Product List</a></button>
			<hr/>
		<h2>${isNew?'Add Product':'Edit Product' }</h2>
		
		<form action="${isNew?'newProduct':'saveProduct'}" method="post" >
			<table cellpadding="5px" cellpacing="5px">
				<tr>
					<td><label><b>Product Id</b></label></td>
					<td><input type = "number" name="pId" value="${product.pId}" required ${isNew?'':'readonly' } /></td>
				</tr>
				<tr>
					<td><label><b>Product Name</b></label></td>
					<td><input type = "text" name="pName" value="${product.pName}" required /></td>
				</tr>
				<tr>
					<td><b><label>Product Description</b></label></td>
					<td><input type = "text" name="pDesc" value="${product.pDesc}" required /></td>
				</tr>
					<td><b><label>Product Cost</label></b></td>
					<td><input type = "number" name="pCost" value="${product.pCost}" required /></td>
				<tr>
					<td><button><b>${isNew?'Save Product Details':'Update Product Details'}</b></button></td>
				</tr>
			</table>
			
		</form>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>