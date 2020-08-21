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
	<h4>Welcome Admin</h4>
		<button><a href = "addProduct" >Add New Product</a></button>
		<span>|</span>
		<button><a href = "showProduct" >Show Product List</a></button>
		<br>
		<hr/>
		<c:choose>
			<c:when test="${productList == null || productList.isEmpty()} ">
				<p>No Products Available !!</p>
			</c:when>
			<c:otherwise>
				<table border=1 cellpadding="5px" cellspacing="5px">
					<tr align="center">
						<td colspan="5"><b>Available Products</b></td>
					</tr>
					<tr align="center">
						<td>Product Id</td>
						<td>Product Name</td>
						<td>Product Description</td>
						<td>Product Cost</td>
						<td>Actions</td>
					</tr>
					
					<c:forEach items = "${productList}" var = "product">
						<tr>
							<td>${product.pId}</td>
							<td>${product.pName}</td>
							<td>${product.pDesc}</td>
							<td>${product.pCost}</td>
							<td>
								<a href = "editProduct?id=${product.pId}" >Edit</a>
								<span>|</span>
								<a href = "deleteProduct?id=${product.pId}" >Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>
		<c:if test="${successMsg != null }">
		<hr/>
			<p>${successMsg}</p>
		</c:if>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>