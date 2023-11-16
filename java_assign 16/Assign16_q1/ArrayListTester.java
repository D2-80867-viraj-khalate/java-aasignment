package com.sunbeam;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ArrayListTester {
	public static int menu() {
		int choice;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Select option from Below Menu");
		EnumMenu[] arr = EnumMenu.values();
		for(int i=0;i<arr.length-1;i++)
			System.out.println(arr[i].ordinal() + ". " + arr[i].name());

		System.out.print("Enter choice : ");
		choice = sc.nextInt();
		
		return choice;
	}
	
	
	public static void writeBooks(List<Book> library) {
	
	try(FileOutputStream fout = new FileOutputStream("/home/sunbeam/Desktop/Books.db")) {
		try(DataOutputStream dout = new DataOutputStream(fout)) {
			for (Book book : library) {
				
				dout.writeUTF(book.getIsbn());
				dout.writeDouble(book.getPrice());
				dout.writeUTF(book.getAuthorName());
				dout.writeInt(book.getQuantity());
			}
			System.out.println("Books saved: " + library.size());
		} 
	} 
	catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	
	public static void readBooks() {
		List<Book> list = new ArrayList<Book>();
		try(FileInputStream fin = new FileInputStream("/home/sunbeam/Desktop/Books.db")) {
			try(DataInputStream din = new DataInputStream(fin)) {
				while(true) {
					Book book = new Book();
					book.setIsbn(din.readUTF());
					book.setPrice(din.readDouble());
					book.setAuthorName(din.readUTF());
					book.setQuantity(din.readInt());
					list.add(book);
				}
			} 
		} 
		catch (EOFException e) {
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		list.forEach(e -> System.out.println(e));
	}
	
	public static void main(String[] args) {
		int choice;
		EnumMenu[] arr = EnumMenu.values();
		List<Book> library = new ArrayList<Book>();
		Scanner sc = new Scanner(System.in);
		do{	choice=menu();
		if(choice>=arr.length) {
			choice = 12;
		}
		
			EnumMenu input = arr[choice];	
			switch(input)
				{
				case EXIT:
					System.out.println("You have Exit from App..");
					break;
				case ADDNEWBOOK:
					if(library.isEmpty()) {
						library.add(new Book().acceptData(sc));
						System.out.println("You have "+library.size()+" Number of Books in Array");
						}	
					else {
					Book b = new Book();
					b.acceptData(sc);
					int idx = library.indexOf(b);
					
					if(idx == -1) {
						library.add(b);
						
						
						
					}else {
						int quantity = library.get(idx).getQuantity();
						library.get(idx).setQuantity(quantity + b.getQuantity());
					}
					}
					
					break;
					
					
				case DISPLAYALLBOOKSRANDOMACCESS:
					if(library.isEmpty()) {
						System.out.println("No Books are available to display...");
					}else {
					System.out.println("Displaying Books --->");


						for(int i=0;i<library.size();i++) {
							Book ele = library.get(i);
							System.out.println(ele);
						}

					}
					break;
					
				case SEARCHBOOKBYISBN:
					if(library.isEmpty()) {
						System.out.println("No Books added in Books Library.Please Add Book first.");	
					}
					else {
						System.out.println("Enter ISBN of Book:");
						String Isbn = sc.next();
						Book key = new Book();
						key.setIsbn(Isbn);
						
						int index=library.indexOf(key);
						if (index==-1) {
							System.out.println("No Book Present with this ISBN... ");
						}
						else {
							System.out.println("Your Book is available in Book Library at index : "+index );
						}
					}
						break;
						
				case DELETEBOOKBYINDEX:
					if(library.isEmpty()) {
						System.out.println("No Books added in Books array.Please Add Book first.");	
					}
					else {
						System.out.println("Enter Index:");
						int index = sc.nextInt();
						library.remove(index);
							System.out.println("Book deleted sucessfullyfrom index : "+index);
						}
						
						break;
					
						
					
				case DELETEBOOKBYISBN:
					if(library.isEmpty()) {
						System.out.println("No Books added in Books array.Please Add Book first.");	
					}
					else {
						System.out.println("Enter ISBN of Book:");
						String Isbn = sc.next();
						Book key = new Book();
						key.setIsbn(Isbn);
						if(library.contains(key)) {
							library.remove(key);
							System.out.println("Book deleted sucessfully...");
						}
						else {
							System.out.println("No Book Present with this ISBN... ");
						}
						
					
						}
					
					break;
					
				
						
				case DELETEBOOKBYNAME:
					if(library.isEmpty()) {
						System.out.println("Your Book array is already Empty..");
					}
					else {
						System.out.println("Enter Author Name of Book:");
						String name = sc.next();
						Book key = new Book();
						key.setAuthorName(name);
						boolean flag = false;
						for(int index=0;index<library.size();index++) {
							if(key.getAuthorName().equals(library.get(index).getAuthorName())){
								library.remove(index);
								flag=true;
						}
					
						}
						if(flag) {
							System.out.println("Book successfully deleted ");}
							else {System.out.println("Book not found with given Author name.");
						
						}
					}
					break;
					
					
					
				case SORTBYISBNASC:
					
					Collections.sort(library);
					System.out.println(library.toString());
					break;

				case SORTBYPRICEDESC:
					
					Collections.sort(library,new BookComparator<>());
					System.out.println(library.toString()); 
					break;
					
				case REVERSELIST:
					if(library.isEmpty()) {
						System.out.println("No Books added in Books array.Please Add Book first.");	
					}
					else{Collections.reverse(library);
					
					System.out.println(library.toString()); 
					}
					break;
				case SAVEINFILE:
					
					writeBooks(library);
					break;
					
				case LOADFROMFILE:
					readBooks();
					break;
				
				default:
					System.out.println("You Have Entered Wrong Input.");
				}
			
		}
		while(choice!=EnumMenu.EXIT.ordinal());


		
		
	}

}
