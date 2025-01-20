package org.example.exercice4.Controller;

import org.example.exercice4.Entity.Article;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ArticleController{
    public Article article1 = new Article("Introduction to Spring WebFlux");
    public Article article2 = new Article("Reactive Programming with Project Reactor");
    public Article article3 = new Article("Building APIs with Spring Boot");




    @GetMapping("/api/articles")
    public Flux<String> titleArticle(){
        return Flux.just(Article.articles.toString());
    }
}
