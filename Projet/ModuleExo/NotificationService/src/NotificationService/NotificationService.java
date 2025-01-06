package NotificationService;

import EmailNotification.EmailNotification;
import Book.Book;
import java.util.Objects;

public class NotificationService {
    public static void SendEmail(String barrowOrReturn, Book book){
        if (Objects.equals(barrowOrReturn, "barrow")){
            EmailNotification. BarrowNotification(book);
        } else if (Objects.equals(barrowOrReturn,"return")) {
            EmailNotification.ReturnNotification(book);
        }
    }
}
