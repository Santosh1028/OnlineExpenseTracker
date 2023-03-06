<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Homepage</title>
<%@include file="../components/all_css.jsp"%>
</head>
<body class="bg-light">

	<c:if test="${empty loginuser }">
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>

	<%@include file="../components/navbar.jsp"%>
	<div id="carouselExampleSlidesOnly" class="carousel slide"
		data-bs-ride="carousel">
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="../img/pic1.jpg" class="d-block w-100" alt="..."
					height="650px">
			</div>
			<div class="carousel-item">
				<img src="../img/pic2.jpg" class="d-block w-100" alt="..."
					height="650px">
			</div>
			<div class="carousel-item">
				<img src="../img/pic3.jpg" class="d-block w-100" alt="..."
					height="650px">
			</div>
		</div>
	</div>

</body>
</html>