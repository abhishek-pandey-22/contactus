package com.abhi.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abhi.dao.UserDao;
import com.abhi.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name=request.getParameter("username");
		String password=request.getParameter("password");
		User user=new User(name,password);
		UserDao userDao=new UserDao();
		
		if(userDao.isValidAdmin(user))
		{
		
			response.sendRedirect("dashboard");
			
		}
		else {
		
		doGet(request, response);
		}
	}

}
