package Exo2;
public class Book extends LibraryItem {
    private String author;
    private String genre;

    public Book(String title, int publicationYear , String genre, String author) {
        super(title, publicationYear);
        this.genre = genre;
        this.author = author;

    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }



}
