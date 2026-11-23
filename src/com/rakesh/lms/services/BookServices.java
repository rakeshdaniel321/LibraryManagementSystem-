package com.rakesh.lms.services;
import com.rakesh.lms.modules.BookEntity;
import com.rakesh.lms.modules.IssuedBooksEntity;
import com.rakesh.lms.modules.StudentEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.rakesh.lms.config.Database_config;
import java.sql.ResultSet;
import com.rakesh.lms.dao.BookDao;
public class BookServices{

public void addBook(BookEntity book){
    BookDao.addBook(book);
}
  
public void viewAvailableBooks(){
    BookDao.viewAvailableBooks();
}

public void issueBook(IssuedBooksEntity issued) {
    BookDao.issueBook(issued);
}

public void returnBook(IssuedBooksEntity issued) {
    BookDao.returnBook(issued);
}

public void deleteBook(int bookId) {
    BookDao.deleteBook(bookId);
}
public void findByBookId(int bookId) {
    BookDao.findByBookId(bookId);
}
public void findIssuedByBookName(String bookName) {
    BookDao.findIssuedByBookName(bookName);
}
public BookEntity getBookById(int bookId) {
    return BookDao.getBookById(bookId);
}

public void updateBook(BookEntity book) {
    BookDao.updateBook(book);
}
public void viewAllIssuedBooks() {
    BookDao.viewAllIssuedBooks();
}

}
  
  
