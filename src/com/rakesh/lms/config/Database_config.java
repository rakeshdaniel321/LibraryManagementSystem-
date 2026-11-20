package com.rakesh.lms.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database_config{ 
private  static final String URL = "jdbc:postgresql://localhost:5432/lms_db";
private  static final String USER = "postgres";
private  static final String PASSWORD = "Rakesh@2006";

public static Connection getConnection() {
  Connection con = null;
  
   try{
       con= DriverManager.getConnection(URL,USER,PASSWORD);
       if (con != null) {
                System.out.println("DB Connected successfully!");
            }
    }
    
  catch(SQLException e){
     System.out.println("DB Connection error: " + e.getMessage());
    }
  return con;
 }
 }

