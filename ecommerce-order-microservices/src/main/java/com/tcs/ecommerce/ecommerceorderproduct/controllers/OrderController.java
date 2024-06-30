package com.tcs.ecommerce.ecommerceorderproduct.controllers;

import com.tcs.ecommerce.ecommerceorderproduct.entities.Order;
import com.tcs.ecommerce.ecommerceorderproduct.payloads.ApiResponse;
import com.tcs.ecommerce.ecommerceorderproduct.services.OrderService;
import com.tcs.ecommerceproductmicroservices.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    @Autowired
    public OrderService userService;

    //Get all orders
        @GetMapping("/get-orders")
    public ResponseEntity<List<Order>> getOrders() {
        List<Order> getOrder = userService.getAllOrders();
        return ResponseEntity.ok(getOrder);
    }
    @GetMapping("/orders/{productId}")
    public ResponseEntity<Product> getProductDetails(@PathVariable Long productId) {
        String productServiceUrl  = "http://localhost:8081/api/v1/products/get-products/";
        String productApiUrl = productServiceUrl + productId;
        RestTemplate restTemplate = new RestTemplate();
        Product product = restTemplate.getForObject(productApiUrl, Product.class);
        System.out.printf(""+ product);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // GET - user get
    @GetMapping("get-orders/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
        return ResponseEntity.ok(this.userService.getOrderById(orderId));
    }
    // POST-create user
    @PostMapping("/add-order")
    public ResponseEntity<Order> createOrder(@Validated @RequestBody Order userDto) {
        Order createOrder= this.userService.createOrder(userDto);
        return new ResponseEntity<>(createOrder, HttpStatus.CREATED);
    }
    @PutMapping("/update-user/{orderId}")
    public ResponseEntity<Order> updateOrder(@Validated @RequestBody Order userDto, @PathVariable("orderId") Long uid) {
        Order updatedOrder = this.userService.updateOrder(userDto, uid);
        return ResponseEntity.ok(updatedOrder);
    }
    //Delete map
    @DeleteMapping("delete/{orderId}")
    public ResponseEntity<ApiResponse> deleteOrder(@PathVariable("orderId") Long uid) {
//     ResponseEntity<?> can be used this line for return type
        this.userService.deleteOrder(uid);
        return new ResponseEntity<>( new ApiResponse("Order deleted Successfully",true), HttpStatus.OK);
    }
}
