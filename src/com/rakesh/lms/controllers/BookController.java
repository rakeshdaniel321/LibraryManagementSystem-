package com.rakesh.lms.controllers;
import com.rakesh.lms.modules.BookEntity;
import com.rakesh.lms.modules.IssuedBooksEntity;
import com.rakesh.lms.modules.StudentEntity;
import com.rakesh.lms.services.BookServices;
import java.util.Scanner;

public class BookController{
public static void start() {

BookServices service = new BookServices();
Scanner sc =new Scanner(System.in);
boolean running = true;

while(running){
	System.out.println("*******************************");
	System.out.println("Libary Management Sysytem");
	System.out.println("*******************************");	
	System.out.println("1. Add Book");
  System.out.println("2. View Book");
  System.out.println("3. Issue Book");
  System.out.println("4. Return Book");
  System.out.println("5. Delete Book");
  System.out.println("6. Exit");
  System.out.println("7. Search Book");
  System.out.println("8. Search Issued Book (by Book Name)");
  System.out.println("9. View All Issued Books");
  System.out.print("Enter Your Choice (1-9): ");
			
int choice =sc.nextInt();
    sc.nextLine();
      
switch(choice){
	   case 1 -> {
                    System.out.print("Book Name: ");
                    String name = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("Category: ");
                    String category = sc.nextLine();
                    System.out.print("Quantity: ");
                    int qty = sc.nextInt();
                    sc.nextLine();
                    service.addBook(name, author, category, qty);
                }
    //case 2 -> service.viewAvailableBooks();   
    case 6 -> {
                  System.out.println("Tankyou !");
                  running = false;
              }
    default -> System.out.println("Invalid choice!");
    
	    }}
	     sc.close();
}
	    
	    
}
