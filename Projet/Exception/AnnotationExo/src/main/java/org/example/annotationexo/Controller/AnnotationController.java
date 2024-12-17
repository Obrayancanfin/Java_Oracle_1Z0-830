package org.example.annotationexo.Controller;


import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.example.annotationexo.annotation.*;
import org.example.annotationexo.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.example.annotationexo.Entity.Book;

import javax.swing.event.ListDataEvent;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("api/controller")
public class AnnotationController {

    @Autowired
    private LibraryService annotationService;
    private final LocalDate date = LocalDate.now();
    

    Book book1 = new Book("test","test","test",date, 666 , true , 42);
    Book book2 = new Book("test","test","test",date, 666 , true , 42);
    Book book3 = new Book("test","test","test",date, 666 , true , 42);
    Book book4 = new Book("test","test","test",date, 666 , true , 42);
    Book book5 = new Book("test","test","test",date, 666 , true , 42);
    Book book6 = new Book("test","test","test",date, 666 , true , 42);


    @AfterCreateAnnotation
    @BeforeCreateAnnotation

    @GetMapping
    public void getmethode() {
        try {
            annotationService.createBook("test","test","test",date, 666 , true , 42);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @PerformanceAnnotation
    @RequestMapping("/Performance")

    public void getTest(String test) {
        try {
            long start = System.currentTimeMillis();
            long end = start + 30 * 100;
            while (System.currentTimeMillis() < end) {
                String test2 = "ok";
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }


    @Exceptionannotation
    @RequestMapping("/Exception")
    public void getException() {
        List<Book> bookList = List.of();
        bookList.remove(book1);

    }

    @PostMapping
    @RequestMapping("book/{titre},{auteur},{genre},{datePublication},{nombrePages},{disponible},{prix}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@PathVariable String titre , @PathVariable String auteur , @PathVariable String genre , @PathVariable LocalDate datePublication, @PathVariable int nombrePages  , @PathVariable boolean disponible , @PathVariable double prix ) {
        Book book = new Book(titre, auteur, genre, datePublication, nombrePages, disponible, prix);

    }


}
