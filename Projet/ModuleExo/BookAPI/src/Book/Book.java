package Book;

import java.util.UUID;

public class Book {
    private String title ;
    private String author ;
    private UUID id ;
    private boolean isAvailable;

    public Book(String title, String author, UUID id, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.id = id;
        this.isAvailable = isAvailable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public UUID getId() {
        return id;
    }

    public void setId() {
        this.id = UUID.randomUUID();
    }

    public boolean isAvalaible() {
        return isAvailable;
    }

    public void setAvailable(boolean avalaible) {
        isAvailable = avalaible;
    }

}

