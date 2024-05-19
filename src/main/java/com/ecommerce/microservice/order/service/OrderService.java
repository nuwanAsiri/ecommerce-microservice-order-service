package com.ecommerce.microservice.order.service;

import com.ecommerce.microservice.order.entity.ProductOrder;
import com.ecommerce.microservice.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<ProductOrder> getOrders(){
        return orderRepository.findAll();
    }

    public ProductOrder createOrder(ProductOrder productOrder){
        return orderRepository.save(productOrder);
    }

    public ProductOrder updateOrder(Long id, ProductOrder productOrderDetails){
        ProductOrder productOrder = orderRepository.findById(id).orElseThrow();
        productOrder.setProductName(productOrderDetails.getProductName());
        productOrder.setQuantity(productOrderDetails.getQuantity());
        return orderRepository.save(productOrder);
    }

    public void deleteOrder(Long id){
        orderRepository.deleteById(id);
    }
}
