package com.myshope.myshope.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.xdevapi.PreparableStatement;

public class Register {

	public static void main(String[] args) throws SQLException {
      //Register re = new Register();
      //re.addUser();
      //Register re1 = new Register();
      //re1.UpdatRegister();
      //Register re2 = new Register();
      //re2.getAllRegister();
      Register r=new Register();
      r.deletregister();
	}

	public void addUser() throws SQLException {
		System.out.println("pless enter name :-");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();

		System.out.println("pless enter city name :-");
		Scanner sc1 = new Scanner(System.in);
		String city = sc1.nextLine();

		System.out.println("pless enter password :-");
		Scanner sc2 = new Scanner(System.in);
		String password = sc2.nextLine();

		System.out.println("pless enter mobileno :-");
		Scanner sc3 = new Scanner(System.in);
		String mobilno = sc3.nextLine();

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage_db", "root", "root");
		PreparedStatement pts = con.prepareStatement("insert into register(name,city,password,mobileno)values(?,?,?,?)");
		pts.setString(1, name);
		pts.setString(2, city);
		pts.setString(3, password);
		pts.setString(4, mobilno);

		int i = pts.executeUpdate();
		
		if(i>0) {
			System.out.println("Register is database sucssfully");
		}else {
			System.out.println("Register is not database sucssfully");
		}

	}

	public void UpdatRegister() throws SQLException {
		System.out.println("pless enter register id : ");
		Scanner ss = new Scanner(System.in);
		int regiterid = ss.nextInt();
		
		System.out.println("pless enter register name :-");
		Scanner scn =new Scanner(System.in);
		String regitername = scn.nextLine();
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage_db","root","root");
		PreparedStatement pstm = con.prepareStatement("Update register set name = ? where id= " + regiterid);
		pstm.setString(1, regitername);
		int i = pstm.executeUpdate();
		
		if(i>0) {
			System.out.println("register is upadet name database Sucssfully");
		}else {
			System.out.println("register is not set database sucssfully");
		}
		
	}
	 
	public void getAllRegister() {
		try {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage_db","root","root");
		Statement stm = con.createStatement();
		ResultSet rs= stm.executeQuery("select *from register");
		while(rs.next()) 
		System.out.println(rs.getInt(1)+ " " + rs.getString(2));
		con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void deletregister() throws SQLException {
		System.out.println("pless enter register id :- ");
		Scanner sss = new Scanner(System.in);
		int id=sss.nextInt();
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage_db","root","root");
		PreparedStatement pst = con.prepareStatement("delete from register where id = " + id);
		int i = pst.executeUpdate();
		if (i>0) {
			System.out.println("register id is delet database is sucssfully");
			
		}else {
			System.out.println("register id is not sucssfully");
		}
		
	}
}
