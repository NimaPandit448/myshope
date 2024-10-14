package com.myshope.myshope.controller;

import java.sql.*;
import java.util.Scanner;

public class InsertData {

	public static void main(String[] args) throws SQLException {
		InsertData data = new InsertData();
		data.adddocter();
		//data.getAllDocter();
		//data.updatedocter();
		//data.deletedocter();
		//data.rightjoin();
		//data.innerjoin();
		//data.leftJoin();
	}
    
	public void deletedocter() throws SQLException {
		System.out.println("pleass enter docter id:");
		Scanner sc3= new Scanner(System.in);
		int docterid=sc3.nextInt();
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage_db","root","root");
		PreparedStatement pstm = con.prepareStatement("delete from docter where Docter_Id =" +docterid );
		int i = pstm.executeUpdate();
		if(i > 0) {
			System.out.println("docter is delete in database successfully");
			InsertData id = new InsertData();
			id.getAllDocter();
		}else {
			System.out.println("docter is dose't in database successfully");
		}
		
		
	}
	
	public void adddocter() throws SQLException {
		System.out.println("pleass enter docter name :");
		Scanner sc = new Scanner(System.in);
		String d = sc.nextLine();
		
		System.out.println("pleass enter docter hospital :");
		Scanner sc1 = new Scanner(System.in);
		String h = sc1.nextLine();
		
		System.out.println("pleass enter docter city :");
		Scanner sc2 = new Scanner(System.in);
		String c = sc2.nextLine();

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage_db", "root", "root");
		PreparedStatement pstmt = con.prepareStatement("insert into docter(Dr_name,hospital,city)values(?,?,?)");
		pstmt.setString(1, d);
		pstmt.setString(2, h);
		pstmt.setString(3, c);

		int i = pstmt.executeUpdate();

		if (i > 0) {
			System.out.println("Docter Name add in databbase successsffully");
		} else {
			System.out.println("Docter Name dose't add in databbase successsffully");
		}
	}
		public void updatedocter() throws SQLException {
			System.out.println("pleass enter docter id");
			Scanner ss = new Scanner(System.in);
			int docterid = ss.nextInt();
			
			System.out.println("paless enter docter name");
			Scanner sc = new Scanner(System.in);
			String doctername = sc.nextLine();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage_db","root","root");
			PreparedStatement pstm = con.prepareStatement("update docter set Dr_name = ? where Docter_id =" + docterid);
			pstm.setString(1, doctername);
			int i = pstm.executeUpdate();
			if (i<0) {
				InsertData i1 = new InsertData();
				//i1.getAlldocter();
			}else {
				System.out.println("Docter Name dose't add in databbase successsffully");
			}
		}
		
		
		public void getAllDocter() {
			
			try {
	         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage_db","root","root");
	         Statement stmt = con.createStatement();
	         ResultSet rs = stmt.executeQuery("select * from docter");
	         while(rs.next())
	        	 System.out.println(rs.getInt(1) + " " + rs.getString(2));
	             con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
	}

		public void rightjoin() {
			
			try {
				System.out.println("in");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage_db","root","root");
			Statement stmt = con.createStatement();
			System.out.println("in 1");
			ResultSet rs = stmt.executeQuery("select * from docter as d right join pesent as p on d.Docter_Id=p.DR_id order by d.Docter_Id ");
			while (rs.next())
				System.out.println(rs.getInt(1)+ " " + rs.getString(2)+ " " + rs.getString(3)+ " " + rs.getString(4)+ " " + rs.getString(5)+ " " + rs.getString(6)+ " " + rs.getString(7));
			con.close();
			
			System.out.println("out");
		   }catch (Exception e) {
		     System.out.println(e);
		   }
		}
         public void innerjoin() {
         
        	 try {
        		 System.out.println("in");
        		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage_db","root","root");
        		 Statement stmt =con.createStatement();
        		 System.out.println("in 1");
        		 ResultSet rs = stmt.executeQuery("select * from docter as d inner join pesent as p on d.Docter_Id=p.DR_id order by d.Docter_Id");
        		 while (rs.next())
        				System.out.println("id :"+rs.getInt(1)+ " name : " + rs.getString(2)+ "hospital : " + rs.getString(3)+ "city : " + rs.getString(4)+ "pid : " + rs.getInt(5)+ "name : " + rs.getString(6)+ "city  " + rs.getString(7));
      			 con.close();
        		 System.out.println("out");
        		} catch (Exception e) {
        			System.out.println(e);
        		}
         }
         public void leftJoin() {
        	
        	 try {
        		 System.out.println("in");
        		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage_db","root","root");
        		 Statement stmt = con.createStatement();
        		 System.out.println("in 1");
        		 ResultSet rs = stmt.executeQuery("select * from docter as d left join pesent as p on d.Docter_Id=p.DR_id order by d.Docter_Id");
        		 while (rs.next())
        				System.out.println(rs.getInt(1)+ " " + rs.getString(2)+ " " + rs.getString(3)+ " " + rs.getString(4)+ " " + rs.getString(5)+ " " + rs.getString(6)+ " " + rs.getString(7));
     			 con.close();    	 
        	     System.out.println("out");
        	 }catch (Exception e) {
        		 e.printStackTrace();
        	  System.out.println(e);
        	 }
         }
		}

