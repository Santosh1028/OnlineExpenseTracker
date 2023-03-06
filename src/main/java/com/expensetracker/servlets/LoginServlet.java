package com.expensetracker.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.expensetracker.dao.UserDao;
import com.expensetracker.db.HibernateUtils;
import com.expensetracker.entities.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		UserDao userDao=new UserDao(HibernateUtils.geSessionFactory());
		User user = userDao.login(email, password);
		
		//System.out.println(user);
		
		
		HttpSession httpSession=request.getSession();
		if(user==null) {
			httpSession.setAttribute("msg", "Invalid Email and Passwod");
			response.sendRedirect("login.jsp");
		}
		else {
			httpSession.setAttribute("loginuser", user);
			response.sendRedirect("user/home.jsp");
		}
		
		
	}
	
	

}
