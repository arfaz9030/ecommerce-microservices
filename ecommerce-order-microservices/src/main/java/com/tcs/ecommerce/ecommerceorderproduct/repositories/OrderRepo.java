package com.tcs.ecommerce.ecommerceorderproduct.repositories;

import com.tcs.ecommerce.ecommerceorderproduct.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Long> {
}
