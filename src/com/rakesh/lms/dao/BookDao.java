package com.rakesh.lms.dao;
import com.rakesh.lms.modules.BookEntity;
import com.rakesh.lms.modules.IssuedBooksEntity;
import com.rakesh.lms.modules.StudentEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.rakesh.lms.config.Database_config;
import java.sql.ResultSet;
import java.time.LocalDate;

public class BookDao {

public static void addBook(BookEntity book){
String query= "insert into books(book_name, author_name, category, availability) values (?, ?, ?, ?)";
try(Connection con = Database_config.getConnection(); 
    PreparedStatement ps = con.prepareStatement(query)){
     
      ps.setString(1,book.getBookName());
      ps.setString(2,book.getAuthorName());
      ps.setString(3,book.getCategory());
      ps.setInt(4,book.getAvailability());
      int rows = ps.executeUpdate();
      if(rows >0) {System.out.println("Book added successfully!");}
}
catch(SQLException e){
  System.out.println("Error adding book: " + e.getMessage());
  }}


public static void viewAvailableBooks(){
String query = "select * from books where availability > 0 order by book_id";
try(Connection con = Database_config.getConnection(); 
    PreparedStatement ps = con.prepareStatement(query);
    ResultSet rs = ps.executeQuery()){
      
     boolean found =false;
     while(rs.next()){
          BookEntity book =new BookEntity (
          rs.getInt("book_id"),
          rs.getString("book_name"),
          rs.getString("author_name"),
          rs.getString("category"),
          rs.getInt("availability")   
          );
          System.out.println(book);
          found = true;
         }
      if(!found){System.out.println("No available books.");}
}
catch(SQLException e){
  System.out.println("Error Viewing books: " + e.getMessage());
  }
}

public static void findByBookId(int book_id){
String query = "select * from books where book_id = ?";
try(Connection con = Database_config.getConnection(); 
    PreparedStatement ps = con.prepareStatement(query)){
      ps.setInt(1,book_id);
      try(ResultSet rs = ps.executeQuery()){
        boolean found =false;
        while(rs.next()){
          BookEntity book =new BookEntity (
          rs.getInt("book_id"),
          rs.getString("book_name"),
          rs.getString("author_name"),
          rs.getString("category"),
          rs.getInt("availability")   
          );
          System.out.println(book);
          found = true;
         }
      if(!found){System.out.println("No available books.");
      }
     }
}
catch(SQLException e){
  System.out.println("Error Viewing books: " + e.getMessage());
  }
}

public static void viewAllIssuedBooks() {
    String query = "select b.book_id, b.book_name, s.student_id, s.student_name, " +
                   "s.mobile_number, i.issue_date " +
                   "from issued_books i " +
                   "join books b on i.book_id = b.book_id " +
                   "join students s on i.student_id = s.student_id " +
                   "where i.return_date is null " +
                   "order by i.issue_id";
    try (Connection con = Database_config.getConnection();
         PreparedStatement ps = con.prepareStatement(query);
         ResultSet rs = ps.executeQuery()) {

        boolean found = false;
        while (rs.next()) {
            IssuedBooksEntity issued = new IssuedBooksEntity(
                rs.getInt("book_id"),
                rs.getString("book_name"),
                rs.getInt("student_id"),
                rs.getString("student_name"),
                rs.getString("mobile_number"),
                rs.getDate("issue_date").toLocalDate()
            );
            System.out.println(issued);
            found = true;
        }
        if (!found) {
            System.out.println("No issued books.");
        }
    } catch (SQLException e) {
        System.out.println("Error viewing issued books: " + e.getMessage());
    }
}

public static void findByBookName(String book_name){
String query = "select * from books where book_name = ?";
try(Connection con = Database_config.getConnection(); 
    PreparedStatement ps = con.prepareStatement(query)){
      ps.setString(1,book_name);
      try(ResultSet rs = ps.executeQuery()){
        boolean found =false;
        while(rs.next()){
          BookEntity book =new BookEntity (
          rs.getInt("book_id"),
          rs.getString("book_name"),
          rs.getString("author_name"),
          rs.getString("category"),
          rs.getInt("availability")   
          );
          System.out.println(book);
          found = true;
         }
      if(!found){System.out.println("Book not found..");
      }
     }
}
catch(SQLException e){
  System.out.println("Error Viewing books: " + e.getMessage());
  }}

public static void findIssuedByBookName(String bookName) {
    String query = "select b.book_id, b.book_name, s.student_id, s.student_name, " +
                   "s.mobile_number, i.issue_date " +
                   "from issued_books i " +
                   "join books b on i.book_id = b.book_id " +
                   "join students s on i.student_id = s.student_id " +
                   "where b.book_name = ? and i.return_date is null";
    try (Connection con = Database_config.getConnection();
         PreparedStatement ps = con.prepareStatement(query)) {

        ps.setString(1, bookName);
        try (ResultSet rs = ps.executeQuery()) {
            boolean found = false;
            while (rs.next()) {
                IssuedBooksEntity issued = new IssuedBooksEntity(
                    rs.getInt("book_id"),
                    rs.getString("book_name"),
                    rs.getInt("student_id"),
                    rs.getString("student_name"),
                    rs.getString("mobile_number"),
                    rs.getDate("issue_date").toLocalDate()
                );
                System.out.println(issued);
                found = true;
            }
            if (!found) {
                System.out.println("This book has not been issued to anyone..");
            }
        }
    } catch (SQLException e) {
        System.out.println("Error searching issued book: " + e.getMessage());
    }
}

public static BookEntity getBookById(int bookId) {
    String query = "select * from books where book_id = ?";
    try (Connection con = Database_config.getConnection();
         PreparedStatement ps = con.prepareStatement(query)) {

        ps.setInt(1, bookId);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return new BookEntity(
                    rs.getInt("book_id"),
                    rs.getString("book_name"),
                    rs.getString("author_name"),
                    rs.getString("category"),
                    rs.getInt("availability")
                );
            }
        }
    } catch (SQLException e) {
        System.out.println("Error fetching book: " + e.getMessage());
    }
    return null;
}

public static void updateBook(BookEntity book) {
    String query = "update books set book_name = ?, author_name = ?, category = ?, availability = ? where book_id = ?";
    try (Connection con = Database_config.getConnection();
         PreparedStatement ps = con.prepareStatement(query)) {

        ps.setString(1, book.getBookName());
        ps.setString(2, book.getAuthorName());
        ps.setString(3, book.getCategory());
        ps.setInt(4, book.getAvailability());
        ps.setInt(5, book.getBookId());

        int rows = ps.executeUpdate();
        if (rows > 0) {
            System.out.println("Book updated successfully!");
        }
    } catch (SQLException e) {
        System.out.println("Error updating book: " + e.getMessage());
    }
}
  
public static void issueBook(IssuedBooksEntity issued) {
    try (Connection con = Database_config.getConnection()) {
        con.setAutoCommit(false);

        int bookId = getAvailableBookId(con, issued.getBookName());
        if (bookId == -1) {
            System.out.println("Book not found or no stock available!");
            return;
        }

        int studentId = getStudentId(con, issued.getStudentName(), issued.getMobileNumber());
        if (studentId == -1) {
            studentId = addStudent(con, issued.getStudentName(), issued.getMobileNumber());
            if (studentId == -1) {
                con.rollback();
                return;
            }
            System.out.println("New student added! Student ID: " + studentId);
        }

        LocalDate issueDate = insertIssue(con, bookId, studentId);
        if (issueDate == null || !reduceAvailability(con, bookId)) {
            con.rollback();
            System.out.println("Issue failed, nothing saved!");
            return;
        }

        con.commit();
        System.out.println("Book issued successfully!");
        System.out.println("Issue Date: " + issueDate);

    } catch (SQLException e) {
        System.out.println("Error issuing book: " + e.getMessage());
    }
}


public static void returnBook(IssuedBooksEntity issued) {
    try (Connection con = Database_config.getConnection()) {
        con.setAutoCommit(false);

        int bookId = getBookId(con, issued.getBookName());
        if (bookId == -1) {
            System.out.println("Book not found!");
            return;
        }

        int studentId = getStudentId(con, issued.getStudentName(), issued.getMobileNumber());
        if (studentId == -1) {
            System.out.println("Student not found!");
            return;
        }

        int issueId = getIssueId(con, bookId, studentId);
        if (issueId == -1) {
            System.out.println("This student has not taken this book, or it is already returned!");
            return;
        }

        LocalDate[] dates = updateReturnDate(con, issueId);
        if (dates == null || !increaseAvailability(con, bookId)) {
            con.rollback();
            System.out.println("Return failed, nothing saved!");
            return;
        }

        con.commit();
        System.out.println("Book returned successfully!");
        System.out.println("Issue Date : " + dates[0]);
        System.out.println("Return Date: " + dates[1]);

    } catch (SQLException e) {
        System.out.println("Error returning book: " + e.getMessage());
    }
}

    
public static void deleteBook(int bookId) {
    try (Connection con = Database_config.getConnection()) {
        con.setAutoCommit(false);
        if (isBookIssued(con, bookId)) {
            System.out.println("This book is currently issued and cannot be deleted!");
            return;
        }

        if (!deleteHistory(con, bookId)) {
            con.rollback();
            return;
        }
        int rows = deleteBookById(con, bookId);
        if (rows > 0) {
            con.commit();
            System.out.println("Book deleted successfully!");
        } else {
            con.rollback();
            System.out.println("Book not found!");
        }
    } catch (SQLException e) {
        System.out.println("Error deleting book: " + e.getMessage());
    }
}

// Helper Methods 

private static int getAvailableBookId(Connection con, String bookName) {
    String query = "select book_id from books where book_name = ? and availability > 0";
    try (PreparedStatement ps = con.prepareStatement(query)) {
        ps.setString(1, bookName);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt("book_id");
        }
    } catch (SQLException e) {
        System.out.println("Error finding book: " + e.getMessage());
    }
    return -1;
}

private static int getBookId(Connection con, String bookName) {
    String query = "select book_id from books where book_name = ?";
    try (PreparedStatement ps = con.prepareStatement(query)) {
        ps.setString(1, bookName);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt("book_id");
        }
    } catch (SQLException e) {
        System.out.println("Error finding book: " + e.getMessage());
    }
    return -1;
}

private static int getStudentId(Connection con, String studentName, String mobile) {
    String query = "select student_id from students where student_name = ? and mobile_number = ?";
    try (PreparedStatement ps = con.prepareStatement(query)) {
        ps.setString(1, studentName);
        ps.setString(2, mobile);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt("student_id");
        }
    } catch (SQLException e) {
        System.out.println("Error finding student: " + e.getMessage());
    }
    return -1;
}

private static int addStudent(Connection con, String studentName, String mobile) {
    String query = "insert into students(student_name, mobile_number) values (?, ?) returning student_id";
    try (PreparedStatement ps = con.prepareStatement(query)) {
        ps.setString(1, studentName);
        ps.setString(2, mobile);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt("student_id");
        }
    } catch (SQLException e) {
        System.out.println("Error adding student: " + e.getMessage());
    }
    return -1;
}

private static int getIssueId(Connection con, int bookId, int studentId) {
    String query = "select issue_id from issued_books " +
                   "where book_id = ? and student_id = ? and return_date is null " +
                   "order by issue_id limit 1";
    try (PreparedStatement ps = con.prepareStatement(query)) {
        ps.setInt(1, bookId);
        ps.setInt(2, studentId);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt("issue_id");
        }
    } catch (SQLException e) {
        System.out.println("Error finding issue record: " + e.getMessage());
    }
    return -1;
}



private static boolean reduceAvailability(Connection con, int bookId) {
    String query = "update books set availability = availability - 1 where book_id = ?";
    try (PreparedStatement ps = con.prepareStatement(query)) {
        ps.setInt(1, bookId);
        return ps.executeUpdate() > 0;
    } catch (SQLException e) {
        System.out.println("Error reducing availability: " + e.getMessage());
        return false;
    }
}

  
private static boolean isBookIssued(Connection con, int bookId) {
    String query = "select issue_id from issued_books where book_id = ? and return_date is null limit 1";
    try (PreparedStatement ps = con.prepareStatement(query)) {
        ps.setInt(1, bookId);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    } catch (SQLException e) {
        System.out.println("Error checking issued book: " + e.getMessage());
        return true;   
    }
}

private static int deleteBookById(Connection con, int bookId) {
    String query = "delete from books where book_id = ?";
    try (PreparedStatement ps = con.prepareStatement(query)) {
        ps.setInt(1, bookId);
        return ps.executeUpdate();
    } catch (SQLException e) {
        if ("23503".equals(e.getSQLState())) {
            System.out.println("This book has an issue history and cannot be deleted!");
        } else {
            System.out.println("Error deleting book: " + e.getMessage());
        }
        return -1;
    }
}


private static LocalDate insertIssue(Connection con, int bookId, int studentId) {
    String query = "insert into issued_books(book_id, student_id) values (?, ?) returning issue_date";
    try (PreparedStatement ps = con.prepareStatement(query)) {
        ps.setInt(1, bookId);
        ps.setInt(2, studentId);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getDate("issue_date").toLocalDate();
        }
    } catch (SQLException e) {
        System.out.println("Error inserting issue: " + e.getMessage());
    }
    return null;
}


private static LocalDate[] updateReturnDate(Connection con, int issueId) {
    String query = "update issued_books set return_date = CURRENT_DATE " +
                   "where issue_id = ? returning issue_date, return_date";
    try (PreparedStatement ps = con.prepareStatement(query)) {
        ps.setInt(1, issueId);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new LocalDate[] {
                rs.getDate("issue_date").toLocalDate(),
                rs.getDate("return_date").toLocalDate()
            };
        }
    } catch (SQLException e) {
        System.out.println("Error updating return date: " + e.getMessage());
    }
    return null;
}




private static boolean deleteHistory(Connection con, int bookId) {
    String query = "delete from issued_books where book_id = ?";
    try (PreparedStatement ps = con.prepareStatement(query)) {
        ps.setInt(1, bookId);
        ps.executeUpdate();
        return true;
    } catch (SQLException e) {
        System.out.println("Error deleting history: " + e.getMessage());
        return false;
    }
    
}

private static boolean increaseAvailability(Connection con, int bookId) {
    String query = "update books set availability = availability + 1 where book_id = ?";
    try (PreparedStatement ps = con.prepareStatement(query)) {
        ps.setInt(1, bookId);
        return ps.executeUpdate() > 0;
    } catch (SQLException e) {
        System.out.println("Error increasing availability: " + e.getMessage());
        return false;
    }
}

}
