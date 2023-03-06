package com.expensetracker.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.expensetracker.dao.ExpenseDao;
import com.expensetracker.db.HibernateUtils;

@WebServlet("/deleteExpense")
public class DeleteExpenseServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));

		ExpenseDao expenseDao = new ExpenseDao(HibernateUtils.geSessionFactory());
		boolean f = expenseDao.deleteExpense(id);

		HttpSession httpSession = req.getSession();
		if (f) {
			httpSession.setAttribute("msg", "Expense Deleted Successfully...");
			resp.sendRedirect("user/view_expense.jsp");
		} else {
			httpSession.setAttribute("msg", "Something Went Wrong on Server...");
			resp.sendRedirect("user/view_expense.jsp");
		}

	}

}
