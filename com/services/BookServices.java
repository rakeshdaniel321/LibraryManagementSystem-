package services;
import java.util.ArrayList;
import modules.BookEntity;
import modules.IssuedBooksEntity;
import modules.StudentEntity;
public class BookServices{

private ArrayList <BookEntity> list = new ArrayList<>();
private ArrayList <StudentEntity> stdRecord=new ArrayList<>();
private ArrayList <IssuedBooksEntity> issuedBooks =new ArrayList<>();
  private int nextBookId = 1;


public BookEntity addBook(String name, String author, String category, int qty) {
        BookEntity book = new BookEntity(nextBookId++, name, author, category, qty);
        list.add(book);
        return book;
    }


//public boolean addBooks(BookEntity book){return list.add(book);}

 public void viewAll(){ 
if (list.isEmpty()){
	System.out.println("No Books found");
           return;}
   for (BookEntity book : list) {System.out.println(book);  }
   }

 public void viewAvailable() {
        boolean found = false;
        for (BookEntity book : list) {
            if (book.getAvailability() > 0) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) System.out.println("No available books");
    }


public BookEntity FindByBookId(int bookId){
	for (BookEntity book:list){		
	if(book.getBookId() ==bookId)	{return book;}}
return null;
}


public BookEntity FindByBookName(String bookName){
for (BookEntity book:list){
		if(book.getBookName().equalsIgnoreCase(bookName))	{
		return book;}}
return null;
}

public boolean addStudent(StudentEntity student){return stdRecord.add(student);}

public void issuedBooksAdded(int bookId, int studentId, String studentName){
    if (list.isEmpty()){
        System.out.println("No Books found");
        return;
    }
    for (BookEntity book : list){
        if (book.getBookId() == bookId){
            if (book.getAvailability() > 0){
                book.setAvailability(book.getAvailability() - 1);
                issuedBooks.add(new IssuedBooksEntity(bookId, book.getBookName(), studentId, studentName));
                System.out.println("Book issued successfully! Book ID: " + bookId + " | Remaining: " + book.getAvailability());
            } else {
                System.out.println("Book is currently out of stock");
            }
            return;
        }
    }
    System.out.println("Not Found Book");
}

public void issuedBooksReturn(int bookId, int studentId){
    if (issuedBooks.isEmpty()){
        System.out.println("No issued books found");
        return;
    }
    for (IssuedBooksEntity ib : issuedBooks){
        if (ib.getBookId() == bookId && ib.getStudentId() == studentId){
            issuedBooks.remove(ib);
            BookEntity book = FindByBookId(bookId);
            if (book != null){
                book.setAvailability(book.getAvailability() + 1);
            }
            System.out.println("Book returned successfully!");
            return;
        }
    }
    System.out.println("This book was not issued to this student");
}

public void viewIssued(){
    if (issuedBooks.isEmpty()){
        System.out.println("No issued books");
        return;
    }
    for (IssuedBooksEntity ib : issuedBooks){
        System.out.println(ib);
    }
}

public void deleteBook(int bookId){
    BookEntity book = FindByBookId(bookId);
    if (book == null){
        System.out.println("Book not found");
        return;
    }
    for (IssuedBooksEntity ib : issuedBooks){
        if (ib.getBookId() == bookId){
            System.out.println("Cannot delete. Book is currently issued");
            return;
        }
    }
    list.remove(book);
    System.out.println("Book deleted successfully");
}

public void searchIssuedByBookName(String bookName) {
    boolean found = false;
    for (IssuedBooksEntity ib : issuedBooks) {
        if (ib.getBookName().equalsIgnoreCase(bookName)) {
            System.out.println(ib);
            found = true;
        }
    }
    if (!found) System.out.println("No issued record found for this book");
}


}

