package com.rakesh.lms.services;
import com.rakesh.lms.modules.BookEntity;
import com.rakesh.lms.modules.IssuedBooksEntity;
import com.rakesh.lms.modules.StudentEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.rakesh.lms.config.Database_config;


public class BookServices{

public void addBook(String name,String author ,String category,int qty){
String query= "INSERT INTO books(book_name, author_name, category, availability) VALUES (?, ?, ?, ?)";
try(Connection con = Database_config.getConnection(); 
    PreparedStatement ps = con.prepareStatement(query)){
    
      ps.setString(1,name);
      ps.setString(2, author);
      ps.setString(3, category);
      ps.setInt(4, qty);
      int rows = ps.executeUpdate();
      if(rows >0) {System.out.println("Book added successfully!");}
}
catch(SQLException e){
  System.out.println("Error adding book: " + e.getMessage());
  }}
  
  
  }
  
  
  
