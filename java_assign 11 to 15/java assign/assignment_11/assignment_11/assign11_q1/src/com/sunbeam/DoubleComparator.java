package com.sunbeam;

import java.util.Comparator;

public class DoubleComparator implements Comparator<Double> {

	@Override
	public int compare(Double o1, Double o2) {
		int diff = Double.compare(o1, o2);
		return diff;
	}
	
	
}
