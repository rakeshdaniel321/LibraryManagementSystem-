package services;
import java.util.ArrayList;
import modules.BookEntity;
public class BookServices{

private ArrayList <BookEntity> list = new ArrayList<>();

public boolean addBooks(BookEntity book){
 return list.add(book);
}

}