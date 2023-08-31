package com.tcs.ecommerce.ecommerceorderproduct.services;

import com.tcs.ecommerce.ecommerceorderproduct.entities.Order;

import java.util.List;

public interface OrderService {

    // creating Order need Order(contains post related data), userId which is used to assign post to user, categoryId which is to assign

    Order createOrder( Order order);

    List<Order> getAllOrders();
    // update
    Order updateOrder( Order order, Long ordertId);

    // delete
    void deleteOrder(Long orderId);

    // get
    Order getOrderById(Long orderId);




}
