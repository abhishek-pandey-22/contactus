package com.abhi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.abhi.model.User;

public class UserDao {
	
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
	
	

	public boolean isValidAdmin(User user) {
		loadDriver(driver);
		Connection connection=getConnection();
		try {
			String query="select uname from login where uname='"+user.getUsername()+"' and pass='"+user.getPassword()+"'";
			Statement stmt=connection.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			
			if(rs.next())
			{
				return true;
			}
			
		}
		catch(SQLException e)
		{
	     e.printStackTrace();		
  		}

		return false;	
	}

}
