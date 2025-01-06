package EmailNotification;

import Book.Book;

public class EmailNotification {
    public static void BarrowNotification(Book book){
        System.out.println("Email: livre "+book+" est emprinté ");
    }

    public static void ReturnNotification(Book book){
        System.out.println("Email: livre "+book+" est rendu ");
    }
}
