package com.sunbeam;

import java.util.Arrays;

public class StudentTester {

	public static void main(String[] args) {
		Student[] s1 = new Student[] { 
				new Student(7,"Sushil","Mumbai",78.0),
				new Student(2,"Praneet","Mumbai",98.1),
				new Student(4,"Vaibhav","Pune",99.0),
				new Student(5,"Akhilesh","goa",99.0),
				new Student(9,"Rahul","Indore",78.0),
				new Student(8,"Pradeep","goa",99.0),
		};
		
		System.out.println("Array before sort: " + Arrays.toString(s1));
		
		Arrays.sort(s1, new StudentComparator());
		
		System.out.println("Array before sort: " + Arrays.toString(s1));
		
	}

}
