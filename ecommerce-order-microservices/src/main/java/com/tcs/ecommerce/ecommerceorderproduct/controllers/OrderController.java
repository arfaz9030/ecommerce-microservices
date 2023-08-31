package com.tcs.ecommerce.ecommerceorderproduct.controllers;

import com.tcs.ecommerce.ecommerceorderproduct.entities.Order;
import com.tcs.ecommerce.ecommerceorderproduct.payloads.ApiResponse;
import com.tcs.ecommerce.ecommerceorderproduct.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    // GET - user get
    @GetMapping("get-orders/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
        return ResponseEntity.ok(this.userService.getOrderById(orderId));
    }
    // POST-create user
    @PostMapping("/add-user")
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
