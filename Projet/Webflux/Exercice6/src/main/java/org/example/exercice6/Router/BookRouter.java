package org.example.exercice6.Router;

import org.example.exercice6.Handler.BookHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class BookRouter {

    @Bean
    public RouterFunction<ServerResponse> bookRoutes(BookHandler bookHandler){
        return route(GET("/api/books"), bookHandler::getAllBooks)
                .andRoute(GET("/api/books/search"), bookHandler::getBookByTitle)
                .andRoute(POST("/api/books"),bookHandler::saveBook)
                .andRoute(DELETE("/api/books/{id}"),bookHandler::deleteBook)
                ;
    }
}
