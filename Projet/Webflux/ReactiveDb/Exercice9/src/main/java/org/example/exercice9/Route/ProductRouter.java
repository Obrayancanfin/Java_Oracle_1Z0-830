package org.example.exercice9.Route;

import org.example.exercice9.Handler.ProductHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ProductRouter {

    @Bean
    public RouterFunction<ServerResponse> productRoute(ProductHandler productHandler){
        return route(GET("/api/product"), productHandler::getProducts)
                .andRoute(GET("/api/products/{id}") , productHandler::getProductByID)
                .andRoute(POST("/api/products") , productHandler::createProduct)
                .andRoute(PUT("/api/products/{id}") , productHandler::updateProduct)
                .andRoute(DELETE("/api/products/{id}") , productHandler::deleteProduct)
                .andRoute(GET("/api/products/search?name=phone") , productHandler::findpProductByName)
                .andRoute(PUT("/api/products/{id}/buy?quantity=5") , productHandler::ReduceProductQuantity);
    }
}
