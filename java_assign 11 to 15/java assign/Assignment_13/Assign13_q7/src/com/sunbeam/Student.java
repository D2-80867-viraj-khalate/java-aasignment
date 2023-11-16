package com.sunbeam;

import java.util.Scanner;

public class Student {
	int roll;
	String name;
	
	public Student() {
	}
	
	public Student(int roll, String name) {
		this.roll = roll;
		this.name = name;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void acceptStudent() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter roll no.: ");
		roll = sc.nextInt();
		System.out.print("Enter name: ");
		name = sc.next();
	}

	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + "]";
	}
	
}
