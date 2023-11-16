package com.sunbeam;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Tester {

	public static void main(String[] args) {
		Map<String, Book> map = new HashMap<>();
		
		Book b1 = new Book("20", 300, "akshat1", 10);
		Book b2 = new Book("10", 700, "akshat5", 5);
		Book b3 = new Book("15", 100, "akshat2", 15);
		Book b4 = new Book("22", 500, "akshat7", 20);
		Book b5 = new Book("18", 200, "akshat4", 8);
		Book b6 = new Book("10", 200, "akshat8", 8);
		Book b7 = new Book("20", 200, "akshat10", 8);
		
		map.put(b1.getIsbn(), b1);
		map.put(b2.getIsbn(), b2);
		map.put(b3.getIsbn(), b3);
		map.put(b4.getIsbn(), b4);
		map.put(b5.getIsbn(), b5);
		map.put(b6.getIsbn(), b6);
		map.put(b7.getIsbn(), b7);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter isbn to be searched: ");
		String isbn = sc.next();
		
		Book f = map.get(isbn);
		System.out.println(f);
		
		// No we don't need to write equals() and hashCode() in Book class
	}
}
