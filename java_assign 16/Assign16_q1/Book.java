package com.sunbeam;

import java.util.Scanner;

public class Book implements Comparable<Book> {
	private String isbn;
	private double price;
	private String authorName;
	private int quantity;
	
	public Book() {
		
	}
	
	public Book(String isbn, double price, String authorName, int quantity) {
		super();
		this.isbn = isbn;
		this.price = price;
		this.authorName = authorName;
		this.quantity = quantity;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Book acceptData(Scanner sc) {
		
		System.out.print("Enter ISBN: ");
		isbn=sc.next();
		System.out.print("Enter Price: ");
		price=sc.nextDouble();
		System.out.print("Enter Author Name: ");
		authorName=sc.next();
		System.out.print("Enter Quantity: ");
		quantity=sc.nextInt();

		return this;


	}
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(this == obj)
			return true;
		if(obj instanceof Book) {
			Book other = (Book) obj;
			if(this.isbn.equals(other.isbn))
				return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return String.format("Book [isbn=%s, price=%s, authorName=%s, quantity=%s]", isbn, price, authorName, quantity);
	}
	
	public int compareTo(Book other) {
		int diff = this.isbn.compareTo(other.isbn);	
		return diff;
	}
	
}
