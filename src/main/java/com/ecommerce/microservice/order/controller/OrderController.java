package com.ecommerce.microservice.order.controller;

import com.ecommerce.microservice.order.entity.ProductOrder;
import com.ecommerce.microservice.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public List<ProductOrder> getOrders(){
        return orderRepository.findAll();
    }

    @PostMapping
    public ProductOrder createOrder(@RequestBody ProductOrder productOrder){
        return orderRepository.save(productOrder);
    }

    @PutMapping("/{id}")
    public ProductOrder updateOrder(@PathVariable Long id, @RequestBody ProductOrder productOrderDetails){
        ProductOrder productOrder = orderRepository.findById(id).orElseThrow();
        productOrder.setProductName(productOrderDetails.getProductName());
        productOrder.setQuantity(productOrderDetails.getQuantity());
        return orderRepository.save(productOrder);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderRepository.deleteById(id);
    }
}
