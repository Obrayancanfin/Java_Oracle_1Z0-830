package org.example;


import java.io.Serializable;

public class Book implements Serializable {

    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Livre a pour  " +
                "titre : " + title  +
                " et auteur " + author ;
    }
}

