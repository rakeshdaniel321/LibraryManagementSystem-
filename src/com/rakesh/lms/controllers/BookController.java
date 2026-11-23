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
	System.out.println("Library Management System");  
	System.out.println("*******************************");	
	System.out.println("1. Add Book");
  System.out.println("2. View Book");
  System.out.println("3. Issue Book");
  System.out.println("4. Return Book");
  System.out.println("5. Delete Book");
  System.out.println("6. Exit");
  System.out.println("7. Search Book By ID");
  System.out.println("8. Search Issued Book (by Book Name)");
  System.out.println("9. Update Book (by Book ID)");
  System.out.println("10. View All Issued Books");
  System.out.print("Enter Your Choice (1-10): ");
			
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
                    BookEntity book = new BookEntity(name, author, category, qty);
                    service.addBook(book);
                }
    case 2 -> service.viewAvailableBooks();   
    case 3 -> {
                    System.out.print("Book Name: ");
                    String bName = sc.nextLine();
                    System.out.print("Student Name: ");
                    String sName = sc.nextLine();
                    System.out.print("Mobile Number: ");
                    String mobile = sc.nextLine();

                    IssuedBooksEntity issued = new IssuedBooksEntity(bName, sName, mobile);
                    service.issueBook(issued);
              }
    case 4 -> {
                      System.out.print("Book Name: ");
                      String bName = sc.nextLine();
                      System.out.print("Student Name: ");
                      String sName = sc.nextLine();
                      System.out.print("Mobile Number: ");
                      String mobile = sc.nextLine();

                      IssuedBooksEntity issued = new IssuedBooksEntity(bName, sName, mobile);
                      service.returnBook(issued);
              }
    case 5 -> {
                      System.out.print("Book ID: ");
                      int id = sc.nextInt();
                      sc.nextLine();
                      service.deleteBook(id);
              }
              
    case 6 -> {
                  System.out.println("Thank you !");
                  running = false;
              }
    case 7 -> {
                  System.out.print("Book ID: ");
                  int id = sc.nextInt();
                  sc.nextLine();
                  service.findByBookId(id);
              }
    case 8 -> {
                  System.out.print("Book Name: ");
                  String bookName = sc.nextLine();
                  service.findIssuedByBookName(bookName);
              }
    case 9 -> {
                  System.out.print("Book ID: ");
                  int id = sc.nextInt();
                  sc.nextLine();
                  BookEntity book = service.getBookById(id);
                  
                  if (book == null) {
                  System.out.println("Book not found!");
                  }
                  else {
                  System.out.println("Current Details: " + book);
                  System.out.println("Enter new value (Press Enter to keep unchanged)");
                  System.out.print("Book Name [" + book.getBookName() + "]: ");
                  String name = sc.nextLine();
                  
                      if (!name.isBlank()) {
                      book.setBookName(name);
                      }
                  
                      System.out.print("Author [" + book.getAuthorName() + "]: ");
                      String author = sc.nextLine();
                  
                      if (!author.isBlank()) {
                      book.setAuthorName(author);
                      }
                  
                      System.out.print("Category [" + book.getCategory() + "]: ");
                      String category = sc.nextLine();
                  
                      if (!category.isBlank()) {
                      book.setCategory(category);
                      } 
                  
                      System.out.print("Availability [" + book.getAvailability() + "]: ");
                      String avail = sc.nextLine();
                  
                      if (!avail.isBlank()) {
                  
                          try {
                          book.setAvailability(Integer.parseInt(avail));
                          } 
                          catch (NumberFormatException e) {
                          System.out.println("Please enter only the availability number; otherwise, the old value will remain");
                          }}
                      service.updateBook(book);
                      }}             
                  default -> System.out.println("Invalid choice!");
                  
                  case 10 -> service.viewAllIssuedBooks();
                  }}
                  sc.close();
                  }   
      

}
