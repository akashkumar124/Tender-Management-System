package com.masai.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {
	
	
	public static Connection provideConnection() {
		Connection conn=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String url ="jdbc:mysql://localhost:3306/tendermanagesystem";
		
		
		try {
			conn= DriverManager.getConnection(url,"root","monu");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		if(conn!=null)
//			System.out.println("Connected.....");
		
		
		
		return conn;
	}

}
