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
	
	public void acceptData() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter isbn : ");
		isbn = sc.next();
		System.out.print("Enter price : ");
		price = sc.nextDouble();
		System.out.print("Enter author name : ");
		authorName = sc.next();
		System.out.print("Enter quantity : ");
		quantity = sc.nextInt();
	}
	
	

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", price=" + price + ", authorName=" + authorName + ", quantity=" + quantity
				+ "]";
	}

	@Override
	public int compareTo(Book o) {
		return this.isbn.compareTo(o.isbn);
	}
}
