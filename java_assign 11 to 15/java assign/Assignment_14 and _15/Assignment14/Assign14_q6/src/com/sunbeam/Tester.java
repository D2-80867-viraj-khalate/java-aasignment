package com.sunbeam;

public class Tester {

	public static void main(String[] args) {
		Double [] arr = {1.1, 3.3, 5.5, 3.3, 3.3, 2.2, 3.3}; 
		Double key = 3.3; 
		int cnt = countIf(arr, key, (x,y)-> x.equals(y)); 
		System.out.println("Count = " + cnt); // 4
	}
	
	static <T> int countIf(T[] arr, T key, Check<T> c) {
		int cnt = 0;
		for(T ele : arr) {
			if(c.compare(ele, key))
				cnt++;
		}
		return cnt;
	}
}
