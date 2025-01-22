package org.example.exercice9.Handler;

import org.example.exercice9.Entity.Product;
import org.example.exercice9.Service.ProductService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.*;

@Component
public class ProductHandler {

    private final ProductService productService;

    public ProductHandler(ProductService productService) {
        this.productService = productService;
    }

    public Mono<ServerResponse> getProducts(ServerRequest serverRequest) {
        return ok().body(productService.getAllProduit(),Product.class);
    }

    public Mono<ServerResponse> getProductByID(ServerRequest serverRequest) {
        Long id = Long.valueOf(serverRequest.pathVariable("id"));
        return ok().body(productService.getProduitByID(id),Product.class);
    }

    public Mono<ServerResponse> createProduct(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Product.class)
                .flatMap(productService::createProduit)
                .flatMap(product -> created(serverRequest.uri()).bodyValue(product));
    }

    public Mono<ServerResponse> updateProduct(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Product.class)
                .flatMap(productService.)
    }

    public Mono<ServerResponse> deleteProduct(ServerRequest serverRequest) {
    }

    public Mono<ServerResponse> findpProductByName(ServerRequest serverRequest) {
    }

    public Mono<ServerResponse> ReduceProductQuantity(ServerRequest serverRequest) {
    }
}
