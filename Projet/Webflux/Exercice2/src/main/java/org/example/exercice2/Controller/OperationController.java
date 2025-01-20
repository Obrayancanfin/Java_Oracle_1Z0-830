package org.example.exercice2.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class OperationController {

    @GetMapping("/api/processed-numbers")
    public Flux<String> operationNumber(){
        return Flux.range(1,10).filter(n-> n%2==0).map(n->"Processed: "+n*10+" ");
    }
}
