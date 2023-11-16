package com.sunbeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxTester {

	public static void main(String[] args) {
		List<String> strings = new ArrayList<>();
		strings.add("Praneet");
		strings.add("ahsjd");
		strings.add("ajsdvs");
		strings.add("aaaaaa");
		strings.add("aaaaaaaaa");
		
		System.out.println("Highest value in String: "+ Collections.max(strings,new StringComparator()));
	}

}
