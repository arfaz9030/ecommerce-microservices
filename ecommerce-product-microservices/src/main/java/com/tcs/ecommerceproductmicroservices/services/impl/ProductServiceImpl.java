package com.tcs.ecommerceproductmicroservices.services.impl;


import com.tcs.ecommerceproductmicroservices.entities.Product;
import com.tcs.ecommerceproductmicroservices.exceptions.ResourceNotFoundException;
import com.tcs.ecommerceproductmicroservices.repositories.ProductRepo;
import com.tcs.ecommerceproductmicroservices.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class ProductServiceImpl implements ProductService {

    Logger log = Logger.getLogger(String.valueOf(ProductServiceImpl.class));
    private RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private ProductRepo productRepo;
    @Override
    public Product createProduct(Product product) {
        Product savedProduct= productRepo.save(product);
        return savedProduct;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products  = this.productRepo.findAll();
        String productUrl = "http://localhost:8080/api/v1/orders/get-orders";
             return products;
    }

    @Override
    public Product updateProduct(Product product, Long productId) {
         product = this.productRepo.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", " Id ", productId));
        product.setName(product.getName());
        product.setPrice(product.getPrice());
        return product;
    }

    @Override
    public void deleteProduct(Long productId) {
        Product product = this.productRepo.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "Id", productId));
        this.productRepo.delete(product);

    }

    @Override
    public Product getProductById(Long productId) {
        Product product  = this.productRepo.findById(productId)
            .orElseThrow(() -> new ResourceNotFoundException("Product", " Id ", productId));
        return(product);
    }



}
