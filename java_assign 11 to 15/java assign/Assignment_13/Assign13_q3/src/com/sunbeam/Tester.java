package com.sunbeam;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Tester {

	public static void main(String[] args) {
		Set<Book> s = new LinkedHashSet<>();
		
		s.add(new Book("20", 300, "akshat1", 10));
		s.add(new Book("10", 700, "akshat5", 5));
		s.add(new Book("15", 100, "akshat2", 15));
		s.add(new Book("22", 500, "akshat7", 20));
		s.add(new Book("18", 200, "akshat4", 8));
		s.add(new Book("10", 200, "akshat8", 8));
		s.add(new Book("20", 200, "akshat10", 8));
		
		Iterator<Book> itr = s.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		// Any book with duplicate isbn is not added.
		// Books are sorted in same order.
	}
}
