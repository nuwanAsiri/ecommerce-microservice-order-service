package com.ecommerce.microservice.order.controller;

import com.ecommerce.microservice.order.entity.ProductOrder;
import com.ecommerce.microservice.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<ProductOrder> getOrders(){
        return orderService.getOrders();
    }

    @PostMapping
    public ProductOrder createOrder(@RequestBody ProductOrder productOrder){
        return orderService.createOrder(productOrder);
    }

    @PutMapping("/{id}")
    public ProductOrder updateOrder(@PathVariable Long id, @RequestBody ProductOrder productOrderDetails){
        return orderService.updateOrder(id, productOrderDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
    }
}
