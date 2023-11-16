package com.sunbeam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Tester {

	public static void main(String[] args) {
		//Collection<String> c = new ArrayList<>(); // multiple nulls are allowed
		Collection<String> c = new HashSet<>(); // duplicate null is not allowed
		//Collection<String> c = new LinkedHashSet<>(); // duplicate null is not allowed
		//Collection<String> c = new TreeSet<>(); // null is not allowed -> NullPointerException
		c.add("B"); 
		c.add("D"); 
		c.add("A"); 
		c.add("C"); 
		c.add(null); 
		c.add(null); 
		c.add(null); 
		System.out.println(c.toString());
	}

}
