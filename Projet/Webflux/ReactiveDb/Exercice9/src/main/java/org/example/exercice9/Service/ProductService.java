package org.example.exercice9.Service;

import org.example.exercice9.Entity.Product;
import org.example.exercice9.Repository.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Flux<Product> getAllProduit(){return productRepository.findAll();}

    public Mono<Product> getProduitByID(Long id){return productRepository.findById(id);}

    public Mono<Product> createProduit(Product product){
        return productRepository.save(product);
    }

    public Mono<Void> deleteProduct(Long id){
        return productRepository.deleteById(id);
    }

}
