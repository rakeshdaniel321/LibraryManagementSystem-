package  controllers;
import modules.BookEntity;
import services.BookServices;

public class BookController{
public static void start() {
  BookServices service = new BookServices();

      boolean isAdded = service.addBooks(new BookEntity(101, "To Kill a Mockingbird", "Harper Lee", "Fiction",6));
     System.out.print(isAdded ? "Book ADD successfully" : " book add failed ");
	
	 System.out.println("\n--- All Records ---");
        service.viewAll();
}
}