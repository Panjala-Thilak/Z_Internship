package com.zemoso.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl="jdbc:mysql://localhost:3306/hb-03-one-to-many?useSSL=false";
		
		String user="hbstudent";
		String pass="Thilak@2414";
		
	
		
		try
		{
			System.out.println("Connecting to database: "+jdbcUrl);
			
			Connection connection=DriverManager.getConnection(jdbcUrl,user,pass);
			
			System.out.println("Connection successful!!!");
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		}
		
	}

}
