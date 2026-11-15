package services;
import java.util.ArrayList;
import modules.BookEntity;
public class BookServices{

private ArrayList <BookEntity> list = new ArrayList<>();

public boolean addBooks(BookEntity book){
 return list.add(book);
}

 public void viewAll()
 {

        if (list.isEmpty())
 {
            System.out.println("No Books found");
            return;
        }

        for (BookEntity book : list) {
            System.out.println(book);
        }
    }

}