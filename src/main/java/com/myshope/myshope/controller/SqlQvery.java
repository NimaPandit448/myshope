package com.myshope.myshope.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SqlQvery {

	public static void main(String[] args) throws SQLException {

		//SqlQvery sq= new SqlQvery();
		//sq.addUser();
		//SqlQvery sq1=new SqlQvery();
		//sq1.uapdatbike();
		SqlQvery sql2 = new SqlQvery();
		sql2.deletebike();
		
	}
	
	public void addUser () throws SQLException {
		System.out.println("pless enter bike name :-");
		Scanner sc = new Scanner(System.in);
		String Bikename = sc.nextLine();
		
		System.out.println("pless enter bike color :-");
		Scanner scs = new Scanner(System.in);
		String Bikecolor = scs.nextLine();
		
		System.out.println("pless enter bike model :-");
		Scanner srss = new Scanner(System.in);
		String bikemodel = srss.nextLine();
		
		System.out.println("pless enter bike prics:-");
		Scanner st = new Scanner(System.in);
		String bikeprics = st.nextLine();
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage_db","root","root");
		PreparedStatement pst = con.prepareStatement("insert into bike (name,color,model,price)values(?,?,?,?)");
		pst.setString(1, Bikename);
		pst.setString(2,Bikecolor);
		pst.setString(3,bikemodel);
		pst.setString(4, bikeprics);
		int i = pst.executeUpdate();
		if(i>0) {
			System.out.println("data is add database is sucssfully");
		}else {
			System.out.println("data is not sucssfully");
		}
		
		
	}
	public void uapdatbike() throws SQLException {
		System.out.println("pless enter bike id:-");
		Scanner sn = new Scanner(System.in);
		int bikeid= sn.nextInt();
		
		System.out.println("pless enter bike name :");
		Scanner se= new Scanner(System.in);
		String bikename= se.nextLine();
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage_db","root","root");
		PreparedStatement prs = con.prepareStatement("update bike set name= ? where id = " +bikeid );
		prs.setString(1, bikename);
		int i = prs.executeUpdate();
		
		if(i>0) {
			System.out.println("bike name is uapdat database is sucssfully");
		}else {
			System.out.println("  Uapdet database is not sucssfully");
		}
		
	}
	public void deletebike() throws SQLException {
		System.out.println("pless enter bike id:-");
		Scanner scd = new Scanner(System.in);
		int bikeid = scd.nextInt();
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage_db","root","root");
		PreparedStatement pst = con.prepareStatement("delete from bike where id = " + bikeid);
		int i = pst.executeUpdate();
		if(i>0) {
			System.out.println("bike id is delete database sucssfully");
		}else {
			System.out.println("bike id is not delete ");
		}
		
	}

}
