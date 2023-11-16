package com.sunbeam;

import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		
		while((choice = menu()) != 0) {
			switch (choice) {
			case 1:
				try {
					System.out.print("Enter first value: ");
					double a = sc.nextDouble();
					System.out.print("Enter second value: ");
					double b = sc.nextDouble();
					calculate(a, b, (x, y) -> x + y);
				}catch(ArithmeticException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				try {
					System.out.print("Enter first value: ");
					double a = sc.nextDouble();
					System.out.print("Enter second value: ");
					double b = sc.nextDouble();
					calculate(a, b, (x, y) -> x - y);
				}catch(ArithmeticException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				try {
					System.out.print("Enter first value: ");
					double a = sc.nextDouble();
					System.out.print("Enter second value: ");
					double b = sc.nextDouble();
					calculate(a, b, (x, y) -> x * y);
				}catch(ArithmeticException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				try {
					System.out.print("Enter first value: ");
					double a = sc.nextDouble();
					System.out.print("Enter second value: ");
					double b = sc.nextDouble();
					calculate(a, b, (x, y) -> x / y);
				}catch(ArithmeticException e) {
					System.out.println(e.getMessage());
				}
				break;

			default:
				System.out.println("Invalid choice !!!");
				break;
			}
		}
	}

	static void calculate(double num1, double num2, Arithematic op) {
		double result = op.calc(num1, num2); 
	    System.out.println("Result: "+result);
	}
	
	public static int menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("---------MENU-----------");
		System.out.println("0. Exit");
		System.out.println("1. Addition");
		System.out.println("2. Subtraction");
		System.out.println("3. Multiplication");
		System.out.println("4. Division");
		System.out.println("------------------------");
		System.out.print("Enter choice: ");
		int choice = sc.nextInt();
		return choice;
	}
}
