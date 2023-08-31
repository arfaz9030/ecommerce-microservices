package com.tcs.ecommerceproductmicroservices.services.impl;


import com.tcs.ecommerceproductmicroservices.entities.Product;
import com.tcs.ecommerceproductmicroservices.exceptions.ResourceNotFoundException;
import com.tcs.ecommerceproductmicroservices.repositories.ProductRepo;
import com.tcs.ecommerceproductmicroservices.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

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
