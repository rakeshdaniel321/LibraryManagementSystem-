package com.rakesh.lms.modules;
import java.time.LocalDate;

public class IssuedBooksEntity{
private int  bookId;
private String bookName;
private int  studentId;
private String studentName;
private String mobileNumber;
private LocalDate issueDate;

public IssuedBooksEntity(int bookId, String bookName, int studentId,String studentName, String mobileNumber, LocalDate issueDate) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.studentId = studentId;
        this.studentName = studentName;
        this.mobileNumber = mobileNumber;
        this.issueDate = issueDate;
}

public IssuedBooksEntity(String bookName, String studentName, String mobileNumber) {
    this.bookName = bookName;
    this.studentName = studentName;
    this.mobileNumber = mobileNumber;
}

public int getBookId()        { return bookId;}
public String getBookName()   { return bookName;}
public int getStudentId()     { return studentId;}
public String getStudentName(){ return studentName;}
public String getMobileNumber() { return mobileNumber; }
public LocalDate getIssueDate() { return issueDate; }

public void setBookId(int bookId)       {this.bookId = bookId;}
public void setStudentId(int studentId) {this.studentId = studentId;}
public void setBookName(String bookName){this.bookName=bookName;}
public void setStudentName(String studentName){this.studentName=studentName;}

 @Override
    public String toString() {
    return "Book ID: " + bookId + " | Book: " + bookName +" | Student: " + studentName + 
    " (+91" + mobileNumber + ")" +" | Issued: " + issueDate;
    }
}
