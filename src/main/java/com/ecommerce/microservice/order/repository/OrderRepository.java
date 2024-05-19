package com.ecommerce.microservice.order.repository;

import com.ecommerce.microservice.order.entity.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<ProductOrder, Long> {
}
