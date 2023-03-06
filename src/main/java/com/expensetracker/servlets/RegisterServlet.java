package com.expensetracker.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.expensetracker.dao.UserDao;
import com.expensetracker.db.HibernateUtils;
import com.expensetracker.entities.User;

import net.bytebuddy.matcher.BooleanMatcher;

@WebServlet("/userRegister")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String about = request.getParameter("about");

		User user = new User(name, email, password, about);
//		PrintWriter out=response.getWriter();
//		out.println(user);
//		System.out.println(user);

		UserDao userDao = new UserDao(HibernateUtils.geSessionFactory());
		boolean f = userDao.saveUser(user);

		HttpSession httpSession = request.getSession();

		if (f) {
			//System.out.println("Register Successfull...");
			httpSession.setAttribute("msg", "Registered Successfully...");
			response.sendRedirect("register.jsp");

		} else {
			//System.out.println("Something Went Wrong...");
			httpSession.setAttribute("msg", "Something Went Wrong on Server...");
			response.sendRedirect("register.jsp");

		}
	}

}
