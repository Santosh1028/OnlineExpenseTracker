<%@page import="org.hibernate.SessionFactory"%>
<%@page import="com.expensetracker.db.HibernateUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Expense Tracker..</title>
<%@include file="components/all_css.jsp"%>


</head>
<body>
	<%@include file="components/navbar.jsp"%>

	<div id="carouselExampleSlidesOnly" class="carousel slide"
		data-bs-ride="carousel">
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="img/pic1.jpg" class="d-block w-100" alt="..."
					height="650px">
			</div>
			<div class="carousel-item">
				<img src="img/pic2.jpg" class="d-block w-100" alt="..."
					height="650px">
			</div>
			<div class="carousel-item">
				<img src="img/pic3.jpg" class="d-block w-100" alt="..."
					height="650px">
			</div>
		</div>
	</div>

</body>
</html>