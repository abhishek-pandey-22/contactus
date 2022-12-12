package com.abhi.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abhi.dao.RequestDao;
import com.abhi.model.Request;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDao requestDao=new RequestDao();
		List<Request> requestActive=new ArrayList<>();
		List<Request> requestArchive=new ArrayList<>();
		try {
			if(requestDao.getRequests("active")!=null)
			{
			 requestActive=requestDao.getRequests("active");
			 
			}
			if(requestDao.getRequests("archive")!=null)
			{
			 requestArchive= requestDao.getRequests("archive");
			}
			request.setAttribute("requests",requestActive);
			request.setAttribute("requestArchive",requestArchive);
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);

			
		}catch (SQLException e) {

			e.printStackTrace();
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestId = request.getParameter("requestId");
		
		RequestDao requestDao=new RequestDao();
		try {
			requestDao.updateRequest(requestId);
			
		} catch(SQLException e)
		{
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
