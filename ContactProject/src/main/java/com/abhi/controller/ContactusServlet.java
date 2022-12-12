package com.abhi.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abhi.dao.RequestDao;
import com.abhi.model.Request;


@WebServlet("/contactus")
public class ContactusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher("contactus.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Uname = request.getParameter("uname");

		String email = request.getParameter("email");
		String messege = request.getParameter("messege");
		Request requestData = new Request(Uname, email, messege,"active");
		RequestDao RequestDao = new RequestDao();
		RequestDao.insert(requestData);
		doGet(request, response);
		
		
	}

}
