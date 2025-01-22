package org.example.exercice8.Repository;

import org.example.exercice8.Entity.Order;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface OrderRepository extends ReactiveCrudRepository<Order,Long> {
    Mono<Order> findOrderByStatus(String status);
}
