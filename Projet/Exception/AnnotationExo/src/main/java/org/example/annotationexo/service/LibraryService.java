package org.example.annotationexo.service;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.example.annotationexo.annotation.Exceptionannotation;
import org.springframework.stereotype.Service;

import org.example.annotationexo.Entity.Book;

import java.time.LocalDate;

import static org.example.annotationexo.Entity.Book.books;


@Service
public class LibraryService {

    @Before("execution(* org.example.annotationexo.service.*.*(..))")
    public void beforeCreateBook() {
        System.out.println("Before Create Book");
    }

    public void RemoveBook(Book book) {
        if (books.contains(book)) {
            books.remove(book);
        }else {
            throw new IllegalArgumentException("this book does not exist or is not in library");
        }
    }


    public void afterCreateBook() {
        System.out.println("After Create Book");
    }

    public Book createBook(String titre, String auteur, String genre, LocalDate datePublication , int nombrePages,boolean disponible, int prix) {
        Book book = new Book(titre,auteur,genre,datePublication,nombrePages,disponible,prix);
        return book;

    }

    public void method() {
        System.out.println("Annotation Service");
    }

    public String methodWithResult() {
        return "result";
    }

    @Exceptionannotation
    public void methodThrow(int arg , String args2){
        throw new IllegalArgumentException("Annotation Service");
    }


}

