package com.sunbeam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class BookTester {

	public static void main(String[] args) {
		MenuEnums choice;
		Scanner sc = new Scanner(System.in);
		//choice=menu(sc);
		Collection<Book> books = new ArrayList<>();
		Iterator<Book> itr ;
		do{
			choice = menu(sc);
			
			switch(choice) {
				case EXIT:
					break;
				case ADDBOOK:
					Book book = new Book();
					book.accept(sc);
					books.add(book);
					break;
				case DISPLAYBOOKINFORWARDORDER:
					itr = books.iterator();
					System.out.println("***Books details***");
					while(itr.hasNext()) {
						Book book1 = itr.next();
						System.out.println(book1.toString());
					}
					break;
				case DELETEBOOKFORGIVENID:{
					String isbn;
					System.out.println("Enter the id to delete");
					isbn = sc.next();
					Book requestedBook = new Book();
					requestedBook.setIsbn(isbn);
					itr = books.iterator();
					itr = books.iterator();
					if(books.contains(requestedBook)) {
						while(itr.hasNext()) {
							Book book1 = itr.next();
							if(book1.getIsbn().equals(requestedBook.getIsbn())) {
								books.remove(book1);
							}
						}
					}else {
						System.out.println("Book to delete not present");
					}
					break;
				}
				case BOOKWITHISBNPRESENTORNOT:
					String isbn;
					System.out.println("Enter the id to search: ");
					isbn = sc.next();
					Book requestedBook = new Book();
					requestedBook.setIsbn(isbn);
					itr = books.iterator();
					if(books.contains(requestedBook)) {
						System.out.println("Book with given ISBN is present");
					}else {
						System.out.println("Book with given ISBN not present");
					}
					break;
				case DELETEALLBOOK:
					books.removeAll(books);
					break;
				case DISPLAYNUMBEROFBOOKINLIST:
					System.out.println("No of books: "+books.size());
					break;
				default:
					System.out.println("Wrong choice...");
					//choice = MenuEnums.EXIT;
			}
			
		}while(choice != MenuEnums.EXIT);
		
	}
	
	static MenuEnums menu(Scanner sc) {
		MenuEnums[] arrEnum = MenuEnums.values();
		int choice;
		System.out.println("***Menu***");
		System.out.println("0.Exit");
		System.out.println("1. Add new book in list.");
		System.out.println("2. Display all books in forward order.");
		System.out.println("3. Delete book of given id");
		System.out.println("4. Check if book with given isbn is in list or not");
		System.out.println("5. Delete all books in list");
		System.out.println("6. Display number of books in list");
		System.out.println("Enter your choice");
		choice = sc.nextInt();
		if(choice>=arrEnum.length) {
			choice = 7;
		}
		return arrEnum[choice];
	}

}
