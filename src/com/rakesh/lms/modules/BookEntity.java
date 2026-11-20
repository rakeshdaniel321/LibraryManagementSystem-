package com.rakesh.lms.modules;

public class BookEntity{
private int bookId;
private String bookName;
private String authorName;
private String category;
private int availability;


public BookEntity(int bookId,String bookName,String authorName, String category, int availability){
  this.bookId=bookId;
  this.bookName=bookName;
  this.authorName=authorName;
  this.category=category;
  this.availability=availability;
}
public int getBookId()         {return bookId; }
public String getBookName()    {return bookName; }
public String getAuthorName()  {return authorName; }
public String getCategory()    {return category; }
public int getAvailability()   {return availability;}


public void setBookName(String bookName)      {this.bookName = bookName; }
public void setAuthorName(String authorName)  {this.authorName = authorName; }
public void setCategory(String category)      {this.category = category; }
public void setAvailability(int availability) {this.availability=availability;} 

 @Override
  public String toString() {
        return "{" + bookId + " - " + bookName + " - " + authorName + " - " + category + "-"+availability+"}";
    }


}
