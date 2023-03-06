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
import com.expensetracker.entities.Expense;
import com.expensetracker.entities.User;

@WebServlet("/saveExpense")
public class SaveExpenseServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String title = req.getParameter("title");
		String date = req.getParameter("date");
		String time = req.getParameter("time");
		String description = req.getParameter("description");
		int price = Integer.parseInt(req.getParameter("price"));

		HttpSession httpSession = req.getSession();

		User user = (User) httpSession.getAttribute("loginuser");
		Expense expense = new Expense(title, date, time, description, price, user);

		ExpenseDao expenseDao = new ExpenseDao(HibernateUtils.geSessionFactory());
		boolean f = expenseDao.saveExpense(expense);

		if (f) {
			// System.out.println("Register Successfull...");
			httpSession.setAttribute("msg", "Expense Added Successfully...");
			resp.sendRedirect("user/add_expense.jsp");

		} else {
			// System.out.println("Something Went Wrong...");
			httpSession.setAttribute("msg", "Something Went Wrong on Server...");
			resp.sendRedirect("user/add_expense.jsp");

		}

	}

}
