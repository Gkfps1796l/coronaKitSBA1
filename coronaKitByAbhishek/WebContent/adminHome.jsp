<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit: Admin Homepage</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<hr/>
	<a href="http://localhost:6060/corona-kit-app/"><b>Home</b></a>
	<hr/>
	<h4>Welcome Admin</h4>
	<button><a href = "addProduct" >Add New Product</a></button>
	<span>|</span>
	<button><a href = "showProduct" >Show Product List</a></button>
	<br/>
		<c:if test="${successMsg != null }">
		<hr/>
			<p>${successMsg}</p>
		</c:if>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>