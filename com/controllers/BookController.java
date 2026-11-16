package  controllers;
import modules.BookEntity;
import modules.IssuedBooksEntity;
import modules.StudentEntity;
import services.BookServices;
import java.util.Scanner;
public class BookController{
public static void start() {
  BookServices service = new BookServices();
	Scanner scan =new Scanner(System.in);
      //boolean isAdded = service.addBooks(new BookEntity(1, "To Kill a Mockingbird", "Harper Lee", "Fiction",6));
   //  System.out.print(isAdded ? "Book ADD successfully" : " book add failed ");
	
	 System.out.println("\n--- All Records ---");
        service.viewAll();


		while(true){
			
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
			

	int choice =scan.nextInt();
       scan.nextLine();

	switch(choice){
	  case 1:
                    System.out.print("Book Name: ");
                    String name = scan.nextLine();
                    System.out.print("Author Name: ");
                    String author = scan.nextLine();
                    System.out.print("Category: ");
                    String category = scan.nextLine();
                    System.out.print("Quantity: ");
                    int qty = scan.nextInt();
                    scan.nextLine();
                    BookEntity added = service.addBook(name, author, category, qty);
                    System.out.println("Book added successfully! Book ID: " + added.getBookId());
                    break;

	    case 2:
                    service.viewAvailable();
                    break;

case 3:
    System.out.print("Book ID: ");
    int bid = scan.nextInt();
    System.out.print("Student ID: ");
    int sid = scan.nextInt();
    scan.nextLine();
    System.out.print("Student Name: ");
    String sname = scan.nextLine();
    service.issuedBooksAdded(bid, sid, sname);
    break;

case 4:
    System.out.print("Book ID: ");
    int rbid = scan.nextInt();
    System.out.print("Student ID: ");
    int rsid = scan.nextInt();
    scan.nextLine();
    service.issuedBooksReturn(rbid, rsid);
    break;

case 5:
    System.out.print("Book ID to delete: ");
    int dbid = scan.nextInt();
    scan.nextLine();
    service.deleteBook(dbid);
    break;

case 6:
    System.out.println("Thank you!");
    scan.close();
    return;

case 7:
    System.out.print("1. Search by ID   2. Search by Name : ");
    int opt = scan.nextInt();
    scan.nextLine();
    BookEntity result = null;
    if (opt == 1){
        System.out.print("Enter Book ID: ");
        result = service.FindByBookId(scan.nextInt());
        scan.nextLine();
    } else if (opt == 2){
        System.out.print("Enter Book Name: ");
        result = service.FindByBookName(scan.nextLine());
    } else {
        System.out.println("Invalid option");
        break;
    }
    System.out.println(result != null ? result : "Book not found");
    break;

case 8:
    System.out.print("Book Name: ");
    service.searchIssuedByBookName(scan.nextLine());
    break;

case 9:
    service.viewIssued();
    break;
	

                default:
                    System.out.println("Invalid choice");
	}

}}
}