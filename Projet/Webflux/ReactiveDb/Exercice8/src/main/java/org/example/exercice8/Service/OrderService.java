package org.example.exercice8.Service;

import org.example.exercice8.Entity.Order;
import org.example.exercice8.Repository.OrderRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Flux<Order> gelAllOrders(){return orderRepository.findAll();}

    public Mono<Order> getOrderById(Long id){return orderRepository.findById(id);}

    //public Mono<Order> getAllOrderForId(Long id){return orderRepository.findOrderById(id). }


    public Mono<Order> addOrder(Order order){return orderRepository.save(order);}

    public Mono<Order> updateOrder(Long id, Order order){
        return orderRepository.findById(id)
                .flatMap(existingOrder -> {
                    existingOrder.setCustomerName(order.getCustomerName());
                    existingOrder.setStatus(order.getStatus());
                    existingOrder.setTotalAmount(order.getTotalAmount());
                    return orderRepository.save(existingOrder);
                });
    }

    public Mono<Void> deleteOrder(Long id){return orderRepository.deleteById(id);}

    public Mono<Order> findByStatus(String status){
        return orderRepository.findOrderByStatus(status);
    }

}
