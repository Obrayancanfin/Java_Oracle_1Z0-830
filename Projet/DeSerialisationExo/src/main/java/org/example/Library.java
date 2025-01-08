package org.example;

import java.io.Serializable;
import java.util.List;

public class Library  {
    List<Book> books ;

    public Library(List<Book> books) {
        this.books = books;
    }
}
