package CheckoutSystem;
import NotificationService.NotificationService;
import Book.Book;

public class CheckoutSystem {
    public static void BorrowBook(Book book ){
        if (!book.isAvalaible()){
            System.out.println("le livre est déja empreinté");
        }else {
            System.out.println("Le livre suivant est désormais emprunté :");
            NotificationService.SendEmail("Borrow",book);
            book.setAvailable(false);
            System.out.println(book);
        }

    }

    public static void ReturnBook(Book book){
        if (book.isAvalaible()){
            System.out.println("Le livre est deja rendu");
        }else {
            System.out.println("Le livre suivant a étais rendu");
            NotificationService.SendEmail("return",book);
            book.setAvailable(true);
            System.out.println(book);
        }
    }
}