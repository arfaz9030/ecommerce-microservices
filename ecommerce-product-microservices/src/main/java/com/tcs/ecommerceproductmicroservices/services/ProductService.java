package com.tcs.ecommerceproductmicroservices.services;

import com.tcs.ecommerceproductmicroservices.entities.Product;

import java.util.List;

public interface ProductService {

    // creating Product need Product(contains post related data), userId which is used to assign post to user, categoryId which is to assign

    Product createProduct(Product product);

    List<Product> getAllProducts();
    // update
    Product updateProduct( Product product, Long productId);

    // delete
    void deleteProduct(Long productId);

    // get
    Product getProductById(Long productId);




}
