package org.example.exercice4.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Article {
    UUID id;
    String title;
    public static List<Article> articles = new ArrayList<>() ;

    public Article() {
    }

    public Article( String title ) {
        this.id = UUID.randomUUID();
        this.title = title;
        articles.add(this);
    }

    @Override
    public String toString() {
        return title +"\n" ;

    }
}
