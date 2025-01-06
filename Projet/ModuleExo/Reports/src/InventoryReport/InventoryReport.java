package InventoryReport;

import Book.Book;
import BookInventory.BookInventory;

public class InventoryReport {
    public static void AddBook(Book book){
        System.out.println("Le livre suivant est ajouté a l inventaire");
    }

    public static void RemoveBook(Book book){
        System.out.println("Le livre suivant est retiré a l inventaire");
    }

    public static void Inventory(){
        BookInventory.ShowBooks();
    }
}
