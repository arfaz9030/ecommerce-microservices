package com.tcs.ecommerceproductmicroservices.repositories;

import com.tcs.ecommerceproductmicroservices.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
