package org.example.exercice3.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;



@RestController
public class ErrorHandlingController {

    @GetMapping("/api/error-resume")
    public Flux<String> errorresume() {

        return Flux.just("A","B","C","D","E")
                .map(value -> {
                    if("C".equals(value)){
                        throw new RuntimeException("Erreur simuler !!!");
                    }
                    return value;
                })
                .onErrorResume(e -> Flux.just("Default 1","Default 2"));
    }

    @GetMapping("/api/error-continue")
    public Flux<Integer> resume() {
        return Flux.range(1, 5)
                .map(n -> {
                    if (n == 2) {
                        throw new RuntimeException("Erreur simuler !!! pour : " + n);
                    }
                    return n;
                })
                .onErrorContinue((e, value) -> {
                    System.err.println("Erreur avec : " + value + " -> : " + e.getMessage());
                });

    }
}


