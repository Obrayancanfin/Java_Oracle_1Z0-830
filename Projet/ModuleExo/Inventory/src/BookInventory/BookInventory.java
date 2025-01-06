package BookInventory;

import java.util.ArrayList;
import java.util.List;
import Book.Book;

public class BookInventory {
    static List<Book> books = new ArrayList<>();

    public static void AddBook(Book book){
        books.add(book);
    };

    public static void RemoveBook(Book book){
        books.remove(book);
    }

    public static void ShowBooks(){
        System.out.println(books);
    }

}
