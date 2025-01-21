package org.example.exercice6.Handler;

import org.example.exercice6.Entity.Book;
import org.example.exercice6.Service.BookService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.web.reactive.function.server.ServerResponse.*;

@Component
public class BookHandler {

    private final BookService bookService;

    private final List<Book> books = new ArrayList<Book>();

    public BookHandler(BookService bookService){
        this.bookService = bookService;
    }

    public Mono<ServerResponse> getBookByTitle(ServerRequest serverRequest) {
        String title = serverRequest.queryParam("title").orElse("");
        return ok().body(bookService.getBookByTitle(title),Book.class);
    };

    public Mono<ServerResponse> getAllBooks(ServerRequest serverRequest) {
        return ok().body(bookService.getAllBooks(), Book.class);
    };

    public Mono<ServerResponse> saveBook(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Book.class)
                .flatMap(bookService::createBook)
                .flatMap(book -> created(serverRequest.uri()).bodyValue(book));
    };

    public Mono<ServerResponse> deleteBook(ServerRequest serverRequest) {
            UUID id = UUID.fromString(serverRequest.pathVariable("id"));
            return serverRequest.bodyToMono(Book.class)
                    .flatMap(updatedBook-> {
                        Optional<Book> existedBook = books.stream()
                                .filter(book -> book.getId().equals(id))
                                .findFirst();
                        if (existedBook.isPresent()){
                            existedBook.get().setAuthor(updatedBook.getAuthor());
                            existedBook.get().settitle(updatedBook.gettitle());
                            return ok().bodyValue(existedBook.get());
                        }else {
                            return notFound().build();
                        }
                    });

    };
}
