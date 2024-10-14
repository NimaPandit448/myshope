package com.myshope.myshope.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws SQLException {
		
		
		

		Test tobj=new Test();
		//tobj.deleteTeacher();
		//tobj.addTeacher();
		tobj.updateTeacher();
		//tobj.getAllTeacher();
		

	}

	
	public void deleteTeacher() throws SQLException {
		
		System.out.println("Please Enter Teacher ID");
		Scanner sc = new Scanner(System.in);
		int teacheid = sc.nextInt();
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage_db", "root", "root");
		PreparedStatement pstmt = con.prepareStatement("delete  from  teacher where id="+teacheid);
		int i = pstmt.executeUpdate();
		if (i > 0) {
		   System.out.println("Teacher is deleted in Database Successfully");
			Test t1 = new Test();
			t1.getAllTeacher();
		} else {
			System.out.println("Teacher Name dose't add in Database Successfully");

		}

	}
	
	public void updateTeacher() throws SQLException {
		
		System.out.println("Please Enter Teacher ID");
		Scanner sc = new Scanner(System.in);
		int teacheid = sc.nextInt();
		
		
		System.out.println("Please Enter Teacher Name:");
		Scanner s = new Scanner(System.in);
	    String teachename = s.nextLine();
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage_db", "root", "root");
		PreparedStatement pstmt = con.prepareStatement("update  teacher set name = ? where id="+teacheid);
		pstmt.setString(1, teachename);
		int i = pstmt.executeUpdate();
		if (i > 0) {
			// System.out.println("Teacher Name add in Database Successfully");
			Test t1 = new Test();
			t1.getAllTeacher();
		} else {
			System.out.println("Teacher Name dose't add in Database Successfully");

		}

	}

	public void addTeacher() throws SQLException {
		System.out.println("Please Enter Teacher Name:");
		Scanner s = new Scanner(System.in);
		String teachename = s.nextLine();
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage_db", "root", "root");
		PreparedStatement pstmt = con.prepareStatement("insert into teacher(name) values(?)");
		pstmt.setString(1, teachename);
		int i = pstmt.executeUpdate();
		if (i > 0) {
		 System.out.println("Teacher Name add in Database Successfully");
		
		} else {
			System.out.println("Teacher Name dose't add in Database Successfully");

		}

	}

	public void getAllTeacher() {

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage_db", "root", "root");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from teacher");
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2));
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
