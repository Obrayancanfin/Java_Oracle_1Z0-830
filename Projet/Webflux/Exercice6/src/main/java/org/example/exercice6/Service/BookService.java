package org.example.exercice6.Service;


import org.example.exercice6.Entity.Book;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class BookService {

    private final Map<UUID,Book > books = new ConcurrentHashMap<>();

    public BookService(){
        // books test
        Book book1 = new Book("Moby-Dick","Herman Melville");
        Book book2 = new Book("Frankenstein","Mary Shelley");
        books.put(book1.getId(),book1);
        books.put(book2.getId(),book2);
    }


    public Flux<Book> getAllBooks(){
        return Flux.fromIterable(books.values());
    }

    public Mono<Book> getBookById(UUID id){
        return Mono.justOrEmpty(books.get(id));
    }

    public Mono<Book> getBookByTitle(String title){
        return Mono.just(Objects.requireNonNull(books.values().stream().filter(book -> Objects.equals(book.gettitle(), title)).findFirst().orElse(null)));
    }

    public Mono<Book> createBook(Book book){
        UUID id = UUID.randomUUID();
        book.setId(id);
        book.settitle(book.gettitle());
        book.setAuthor(book.getAuthor() );
        books.put(id,book);
        return Mono.just(book);
    }

}
