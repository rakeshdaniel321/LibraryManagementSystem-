package com.rakesh.lms.modules;

public class IssuedBooksEntity{
private int  bookId;
private String bookName;
private int  studentId;
private String studentName;

public IssuedBooksEntity(int bookId, String bookName ,int studentId,String studentName){
  this.bookId=bookId;
  this.bookName = bookName;
	this.studentId=studentId;
  this.studentName = studentName;
}

public int getBookId()        { return bookId;}
public String getBookName()   { return bookName;}
public int getStudentId()     { return studentId;}
public String getStudentName(){ return studentName;}


public void setBookId(int bookId)       {this.bookId = bookId;}
public void setStudentId(int studentId) {this.studentId = studentId;}
public void setBookName(String bookName){this.bookName=bookName;}
public void setStudentName(String studentName){this.studentName=studentName;}

 @Override
    public String toString() {
    return "Book ID: " + bookId + " | Book: " + bookName +
               " | Student ID: " + studentId + " | Student: " + studentName;
    }
}
