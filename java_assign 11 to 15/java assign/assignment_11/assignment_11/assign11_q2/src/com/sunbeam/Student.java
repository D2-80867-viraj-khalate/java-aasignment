package com.sunbeam;

public class Student {
    private int roll;
    private String name;
    private String city;
    private double marks;
    
	@Override
	public String toString() {
		return String.format("Student [roll=%s, name=%s, city=%s, marks=%s]", roll, name, city, marks);
	}

	public Student(int roll, String name, String city, double marks) {
		super();
		this.roll = roll;
		this.name = name;
		this.city = city;
		this.marks = marks;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}
	
	
	
    
    
}
