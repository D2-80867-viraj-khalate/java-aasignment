package com.sunbeam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Tester {
	public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc";
	public static final String DB_USER = "D6_80355_akhilesh";
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
		
		while((choice = menu()) != 0) {
			try(Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
				switch (choice) {
				case 1:
					String sql1 = "INSERT INTO candidates VALUES(default, ?, ?, ?)";
					try(PreparedStatement stmt = con.prepareStatement(sql1)){
						System.out.print("Enter Name: ");
						String name = sc.next();
						System.out.print("Enter Party: ");
						String party = sc.next();
						System.out.print("Enter Votes: ");
						int votes = sc.nextInt();
						
						stmt.setString(1, name);
						stmt.setString(2, party);
						stmt.setInt(3, votes);
						
						int count = stmt.executeUpdate();
						System.out.println("Rows Affected: " + count);
					}
					break;
				case 2:
					String sql2 = "Select * from candidates";
					try(PreparedStatement stmt = con.prepareStatement(sql2)){
						try(ResultSet rs = stmt.executeQuery(sql2)){
							while(rs.next()) {
								int id = rs.getInt("id");
								String name = rs.getString("name");
								String party = rs.getString("party");
								int votes = rs.getInt("votes");
								System.out.printf("%d %s %s %d\n", id, name, party, votes);
							}
						}
					}
					break;
				case 3:
					String sql3 = "Update candidates set votes = votes + ? where id = ?";
					try(PreparedStatement stmt = con.prepareStatement(sql3)){
						System.out.print("Enter id: ");
						int id = sc.nextInt();
						System.out.print("Enter votes to increment: ");
						int votes = sc.nextInt();
						
						stmt.setInt(1, votes);
						stmt.setInt(2, id);
						System.out.println("Rows Affected: " + stmt.executeUpdate());
					}
					break;
				case 4:
					String sql4 = "Delete from candidates where id = ?";
					try(PreparedStatement stmt = con.prepareStatement(sql4)){
						System.out.print("Enter id: ");
						int id = sc.nextInt();
						
						stmt.setInt(1, id);
						
						System.out.println("Rows Affected: " + stmt.executeUpdate());
					}
					break;
				case 5:
					String sql5 = "Select * from candidates where id = ?";
					try(PreparedStatement stmt = con.prepareStatement(sql5)){
						System.out.print("Enter id: ");
						int id = sc.nextInt();
						
						stmt.setInt(1, id);
						
						try(ResultSet rs = stmt.executeQuery()){
							boolean flag = false;
							while(rs.next()) {
								flag = true;
								int id1 = rs.getInt("id");
								String name1 = rs.getString("name");
								String party1 = rs.getString("party");
								int votes1 = rs.getInt("votes");
								
								System.out.printf("%d %s %s %d\n", id1, name1, party1, votes1);
							}
							
							if(!flag) {
								System.out.println("No candidate found...");
							}
						}
					}
					break;
				case 6:
					String sql6 = "Select * from candidates where party = ?";
					try(PreparedStatement stmt = con.prepareStatement(sql6)){
						System.out.print("Enter party: ");
						String party = sc.next();
						
						stmt.setString(1, party);
						
						try(ResultSet rs = stmt.executeQuery()){
							boolean flag = false;
							while(rs.next()) {
								flag = true;
								int id1 = rs.getInt("id");
								String name1 = rs.getString("name");
								String party1 = rs.getString("party");
								int votes1 = rs.getInt("votes");
								
								System.out.printf("%d %s %s %d\n", id1, name1, party1, votes1);
							}
							
							if(!flag) {
								System.out.println("No candidate found...");
							}
						}
					}
					break;
				case 7:
					String sql7 = "Select sum(votes) total_votes, party from candidates group by party";
					try(PreparedStatement stmt = con.prepareStatement(sql7)){
						try(ResultSet rs = stmt.executeQuery()){
							while(rs.next()) {
								int totalVotes = rs.getInt("total_votes");
								String party2 = rs.getString("party");
								
								System.out.printf("%d %s \n", totalVotes, party2);
							}
						}
					}
					break;

				default:
					System.out.println("Invalid choice !!!");
					break;
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static int menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("---------------MENU-------------");
		System.out.println("0. Exit");
		System.out.println("1. Insert new candidate");
		System.out.println("2. Display all candidates");
		System.out.println("3. Increment votes of candidate with given id");
		System.out.println("4. Delete candidate with given id");
		System.out.println("5. Find candidate of given id");
		System.out.println("6. Find candidates of given party");
		System.out.println("7. Display total votes for each party");
		System.out.println("--------------------------------");
		System.out.print("Enter choice: ");
		int choice = sc.nextInt();
		return choice;
	}
}
