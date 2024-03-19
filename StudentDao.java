package com.student.manage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDao {

	public static boolean insertStudentToDB(Student st) {
		
		boolean f = false;
		
		try {
			
		Connection con = CP.createC();
		String q = "INSERT INTO STUDENTS(sid,sname, sphone, scity) VALUES(?,?,?,?)";
		
		PreparedStatement pst = con.prepareStatement(q);
		pst.setInt(1, st.getStudentId());
		pst.setString(2, st.getStudentName());
		pst.setString(3, st.getStudentPhone());
		pst.setString(4, st.getStudentCity());
		
		pst.executeUpdate();
		f = true;
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;

	}

	public static boolean deleteStudent(int userId) {
            boolean f = false;
		
		try {
			
		Connection con = CP.createC();
		String q = "DELETE FROM STUDENTS WHERE sid=?";
		
		PreparedStatement pst = con.prepareStatement(q);
		// Set value of parameter
		pst.setInt(1, userId);
		
		pst.executeUpdate();
		f = true;
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
 	
	}

	public static void showAllStudent() {
		try {	
		Connection con = CP.createC();
		String q = "SELECT * FROM STUDENTS;";
		
	    Statement st = con.createStatement();
	    ResultSet set = st.executeQuery(q); // Execute query when we need to fetch data from data base.
	    
	    while(set.next()) {
	    	int id = set.getInt(1);
	    	String name = set.getString(2);
	    	String phone = set.getString(3);
	    	String city = set.getString("scity");
	    	
	    	System.out.println("ID :" +id);
	    	System.out.println("Name :" +name);
	    	System.out.println("Phone :" +phone);
	    	System.out.println("City :" +city);
	    	System.out.println("------------------------------");
	        }
		
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	  }

	 public static boolean updateStudentInDB(int sid) {
	        boolean f = false;
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	        try {Connection con = CP.createC();
	             PreparedStatement pst = con.prepareStatement("UPDATE STUDENTS SET sname=?, sphone=?, scity=? WHERE sid=?");

	            System.out.println("Enter new name:");
	            String newName = br.readLine();
	            System.out.println("Enter new phone:");
	            String newPhone = br.readLine();
	            System.out.println("Enter new city:");
	            String newCity = br.readLine();

	            pst.setString(1, newName);
	            pst.setString(2, newPhone);
	            pst.setString(3, newCity);
	            pst.setInt(4, sid);

	            int rowsAffected = pst.executeUpdate();
	            if (rowsAffected > 0) {
	                f = true;
	            }

	        
	        }
	             catch(SQLException | IOException e) {
	            	 e.printStackTrace();
	             }

	        return f;
	    }
	}

