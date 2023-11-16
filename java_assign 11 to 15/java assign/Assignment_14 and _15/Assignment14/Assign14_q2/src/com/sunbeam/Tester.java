package com.sunbeam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Tester {
	public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/akshatdb";
	public static final String DB_USER = "D6_80433_Akshat";
	public static final String DB_PASSWORD = "sunbeam";
	
	static {
		try {
			Class.forName(DB_DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		
		try(Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
			while((choice = menu()) != 0) {
				switch (choice) {
				case 1:
					String sql1 = "INSERT INTO users VALUES(default, ?, ?, ?, ?, ?, ?, ?)";
					try(PreparedStatement stmt = con.prepareStatement(sql1)){
						System.out.print("Enter first name: ");
						String fname = sc.next();
						System.out.print("Enter last name: ");
						String lname = sc.next();
						System.out.print("Enter email: ");
						String email = sc.next();
						System.out.print("Enter password: ");
						String pass = sc.next();
						System.out.print("Enter dob: ");
						String dob = sc.next();
						System.out.print("Enter status: ");
						int status = sc.nextInt();
						System.out.print("Enter role: ");
						String role = sc.next();
						
						SimpleDateFormat sdf;
						sdf = new SimpleDateFormat("dd-MM-yyyy");
						java.util.Date uDate = sdf.parse(dob);
						java.sql.Date sDate = new java.sql.Date(uDate.getTime());
						
						stmt.setString(1, fname);
						stmt.setString(2, lname);
						stmt.setString(3, email);
						stmt.setString(4, pass);
						stmt.setDate(5, sDate);
						stmt.setInt(6, status);
						stmt.setString(7, role);
						
						int count = stmt.executeUpdate();
						System.out.println("Rows Affected: " + count);
					}
					break;
				case 2:
					String sql2 = "Select * from users";
					try(PreparedStatement stmt = con.prepareStatement(sql2)){
						try(ResultSet rs = stmt.executeQuery(sql2)){
							while(rs.next()) {
								int id = rs.getInt("id");
								String fname = rs.getString("first_name");
								String lname = rs.getString("last_name");
								String email = rs.getString("email");
								String pass = rs.getString("password");
								
								java.sql.Date sDate = rs.getDate("dob");
								SimpleDateFormat sdf;
								sdf = new SimpleDateFormat("dd-MM-yyyy");
								String dateStr = sdf.format(sDate);
								
								int status = rs.getInt("status");
								String role = rs.getString("role");
								
								System.out.printf("%d %s %s %s %s %s %d %s\n", id, fname, lname, email, pass, dateStr, status, role);
							}
						}
					}
					break;
				case 3:
					String sql3 = "Delete from users where id = ? and role = 'voter'";
					try(PreparedStatement stmt = con.prepareStatement(sql3)){
						System.out.print("Enter id: ");
						int id = sc.nextInt();
						
						stmt.setInt(1, id);
						
						int count = stmt.executeUpdate();
						System.out.println("Rows Affected: " + count);
					}
					break;
				case 4:
					String sql4 = "update users set status = 1 where id = ? and role = 'voter'";
					try(PreparedStatement stmt = con.prepareStatement(sql4)){
						System.out.print("Enter id: ");
						int id = sc.nextInt();
						
						stmt.setInt(1, id);
						
						int count = stmt.executeUpdate();
						System.out.println("Rows Affected: " + count);
					}
					break;
				case 5:
					String sql5 = "update users set first_name = ?, last_name = ?, dob = ? where id = ? and role = 'voter'";
					try(PreparedStatement stmt = con.prepareStatement(sql5)){
						System.out.print("Enter id: ");
						int id = sc.nextInt();
						System.out.print("Enter first name: ");
						String fname = sc.next();
						System.out.print("Enter last name: ");
						String lname = sc.next();
						System.out.print("Enter dob: ");
						String dob = sc.next();
						
						SimpleDateFormat sdf;
						sdf = new SimpleDateFormat("dd-MM-yyyy");
						java.util.Date uDate = sdf.parse(dob);
						java.sql.Date sDate = new java.sql.Date(uDate.getTime());
						stmt.setDate(3, sDate);
						
						stmt.setString(1, fname);
						stmt.setString(2, lname);
						stmt.setInt(4, id);
						
						int count = stmt.executeUpdate();
						System.out.println("Rows Affected: " + count);
					}
					break;

				default:
					System.out.println("Invalid choice !!!");
					break;
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("---------------MENU-------------");
		System.out.println("0. Exit");
		System.out.println("1. Insert new user (Voter)");
		System.out.println("2. Display all users");
		System.out.println("3. Delete voter with given id");
		System.out.println("4. Change status of voter with given id to true");
		System.out.println("5. Change the name and birth date of voter");
		System.out.println("--------------------------------");
		System.out.print("Enter choice: ");
		int choice = sc.nextInt();
		return choice;
	}
}
