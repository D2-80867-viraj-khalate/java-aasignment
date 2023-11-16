package com.sunbeam;

import java.util.Comparator;

public class SelectionSortTester {

	
	static <T> void selectionSort(T[] arr, Comparator<T> c) {
	    for(int i=0; i<arr.length-1; i++) {
	        for(int j=i+1; j<arr.length; j++) {
	            if(c.compare(arr[i], arr[j]) > 0) {
	               T temp = arr[i];
	               arr[i] = arr[j];
	               arr[j] = temp;
	            }
	        }
	     }
	}
	public static void main(String[] args) {
		Double[] arr = new Double[]{2.22,2.2,3.12,21.2,1.2,0.9,1.21,9.0};
		
		System.out.println("Array before sort");
		for(Double d: arr) {
			System.out.println(d);
		}
		
		selectionSort(arr, new DoubleComparator());
		
		System.out.println();
		System.out.println("Array after sort");
		for(Double d: arr) {
			System.out.println(d);
		}
		
	}

}
