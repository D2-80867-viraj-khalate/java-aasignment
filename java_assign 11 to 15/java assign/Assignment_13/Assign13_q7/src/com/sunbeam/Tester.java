package com.sunbeam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Tester {

	public static void main(String[] args) {
		Map<Integer, Student> map = new LinkedHashMap<>();
		
		int choice;
		
		while((choice = menu()) != 0) {
			switch (choice) {
			case 1:
				Student s1 = new Student();
				s1.acceptStudent();
				map.put(s1.getRoll(), s1);
				break;
			case 2:
				Set<Entry<Integer, Student>> entries = map.entrySet();
				for(Entry<Integer, Student> entry : entries) {
					System.out.println("Key - " + entry.getKey());
					System.out.println("Student - " + entry.getValue());
				}
				break;
			case 3:
				Scanner sc = new Scanner(System.in);
				System.out.print("Enter roll no. to be searched: ");
				int roll = sc.nextInt();
				
				Student s2 = map.get(roll);
				if(s2 == null)
					System.out.println("No Student found...");
				else
					System.out.println(s2);
				break;

			default:
				System.out.println("Invalid choice...");
				break;
			}
		}
		
		// No, we don't need to write equals() and hashCode() in Student class.
	}
	
	public static int menu() {
		System.out.println("----------MENU------------");
		System.out.println("0. Exit");
		System.out.println("1. Add Student");
		System.out.println("2. Display Students");
		System.out.println("3. Get Student by roll number");
		System.out.println("--------------------------");
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter choice: ");
		int choice = sc.nextInt();
		return choice;
	}
}
