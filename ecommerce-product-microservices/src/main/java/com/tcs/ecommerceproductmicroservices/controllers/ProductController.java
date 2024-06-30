package com.tcs.ecommerceproductmicroservices.controllers;


import com.tcs.ecommerceproductmicroservices.entities.Product;
import com.tcs.ecommerceproductmicroservices.payloads.ApiResponse;
import com.tcs.ecommerceproductmicroservices.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    public ProductService productService;

    //Get all products
    @GetMapping("/get-products")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> getProduct = productService.getAllProducts();
        return ResponseEntity.ok(getProduct);
    }
    // GET - product get
    @GetMapping("/get-products/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
        return ResponseEntity.ok(this.productService.getProductById(productId));
    }
    // POST-create product
    @PostMapping("/add-product")
    public ResponseEntity<Product> createProduct( @RequestBody Product product) {
        Product createProduct= this.productService.createProduct(product);
        return new ResponseEntity<>(createProduct, HttpStatus.CREATED);
    }
    @PutMapping("/update-product/{productId}")
    public ResponseEntity<Product> updateProduct( @RequestBody Product product, @PathVariable("productId") Long uid) {
        Product updatedProduct = this.productService.updateProduct(product, uid);
        return ResponseEntity.ok(updatedProduct);
    }
    //Delete map
    @DeleteMapping("delete/{productId}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable("productId") Long uid) {
//     ResponseEntity<?> can be used this line for return type
        this.productService.deleteProduct(uid);
        return new ResponseEntity<>( new ApiResponse("Product deleted Successfully",true), HttpStatus.OK);
    }
}
