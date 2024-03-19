package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CP {
	static Connection con;
	
	public static Connection createC() {
		
		try {
		DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
		System.out.println("HSQL Driver is registerd...");
		
		
		con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb","SA","");
		System.out.println("Connected to the HSQL : "+con);
		
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("select * from depnew");	
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}
