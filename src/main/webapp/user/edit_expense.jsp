<%@page import="com.expensetracker.entities.Expense"%>
<%@page import="com.expensetracker.db.HibernateUtils"%>
<%@page import="com.expensetracker.dao.ExpenseDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Expense</title>
<%@include file="../components/all_css.jsp"%>
<style type="text/css">
.card-sh {
	box-shadow: 0 0 6px 0 rgba(0, 0, 0.3);
}
</style>

</head>
<body class="bg-light">

	<c:if test="${empty loginuser }">
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>

	<%
	int id = Integer.parseInt(request.getParameter("id"));

	ExpenseDao expenseDao = new ExpenseDao(HibernateUtils.geSessionFactory());
	Expense expense = expenseDao.getExpenseById(id);
	%>
	<%@include file="../components/navbar.jsp"%>

	<div class="container mt-2">
		<div class="row">
			<div class="col-md-5 offset-md-4">
				<div class="card card-sh">
					<div class="card-header text-center">
						<p class="fs-3">Edit Expense</p>
						<c:if test="${not empty msg} }">
							<p class="tex-center text-success fs-3">${msg}</p>
							<c:remove var="msg" />
						</c:if>

					</div>

					<div class="card-body">
						<form action="../updateExpense" method="post">
							<div class="mb-3">
								<label>Title</label> <input type="text" name="title"
									class="form-control" value="<%=expense.getTitle()%>">
							</div>

							<div class="mb-3">
								<label>Date</label> <input type="date" name="date"
									class="form-control" value="<%=expense.getDate()%>">
							</div>

							<div class="mb-3">
								<label>Time</label> <input type="time" name="time"
									class="form-control" value="<%=expense.getTime()%>">
							</div>

							<div class="mb-3">
								<label>Description</label> <input type="text" name="description"
									class="form-control" value="<%=expense.getDescription()%>">
							</div>

							<div class="mb-3">
								<label>Price</label> <input type="number" name="price"
									class="form-control" value="<%=expense.getPrice()%>">
							</div>

							<input type="hidden" name="id" value="<%=expense.getId()%>">
							<button class="btn btn-success col-md-12">Edit Expense</button>
							<button class="btn btn-warning col-md-12 mt-1">Reset</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>