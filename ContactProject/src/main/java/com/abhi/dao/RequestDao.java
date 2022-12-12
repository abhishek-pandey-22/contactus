package com.abhi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.abhi.model.Request;

public class RequestDao {

	private String url = "jdbc:mysql://localhost:3306/contactinfo";
	private String name = "root";
	private String password = "Abhishek";
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	public void loadDriver(String driver)
	{
		try {
			Class.forName(driver);
			
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	public Connection getConnection()
	{
		Connection con=null;
		try {
			 return DriverManager.getConnection(url,name,password);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}

	public void insert(Request requestData) {
		loadDriver(driver);
		Connection connection=getConnection();
		
		String query="insert into contacts(name,email,messege,Activity) values(?,?,?,?)";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setString(1, requestData.getUname());
			ps.setString(2,requestData.getEmail());
			ps.setString(3, requestData.getMessege());
			ps.setString(4, requestData.getActivity());
			ps.executeUpdate();
			System.out.println("Data inserted");
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	}

	public List<Request> getRequests(String active) throws SQLException {
		
		List<Request> requests=new ArrayList<>();
		
		String query="select * from contacts where Activity='"+active+"'";
		loadDriver(driver);
		Connection connection =getConnection();
	
		Statement stmt=connection.createStatement();
		ResultSet rs=stmt.executeQuery(query);
		try {
			
			while(rs.next())
			{
			Request request=new Request();
			request.setId(rs.getInt(1));
			request.setUname(rs.getString(2));
			request.setEmail(rs.getString(3));
			request.setMessege(rs.getString(4));
			request.setActivity(rs.getString(5));
			request.setTime(rs.getString(6));
	
			requests.add(request);
		
			}
			return requests;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public void updateRequest(String requestId) throws SQLException {
		
		loadDriver(driver);

		Connection connection=getConnection();
		String query="select Activity from contacts where id="+requestId;
		Statement stm=connection.createStatement();
		ResultSet rs= stm.executeQuery(query);
		String queryUpdate="";
		
		try {
				while (rs.next()) {

					if (rs.getString(1).equals("archive")) {
						queryUpdate = "update contacts set  activity='active' where id=" +requestId;

					} else {
						queryUpdate = "update contacts set  activity='archive' where id=" +requestId;
					}
				}
				Statement statements = connection.createStatement();
				statements.executeUpdate(queryUpdate);
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	
}
