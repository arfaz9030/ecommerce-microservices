package com.tcs.ecommerce.ecommerceorderproduct.services.impl;

import com.tcs.ecommerce.ecommerceorderproduct.entities.Order;
import com.tcs.ecommerce.ecommerceorderproduct.exceptions.ResourceNotFoundException;
import com.tcs.ecommerce.ecommerceorderproduct.repositories.OrderRepo;
import com.tcs.ecommerce.ecommerceorderproduct.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;
    @Override
    public Order createOrder(Order order) {
        order= orderRepo.save(order);
        return order;
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> orders  = this.orderRepo.findAll();
        return orders;
    }

    @Override
    public Order updateOrder(Order order, Long orderId) {
         order = this.orderRepo.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order", " Id ", orderId));
//        order.setProduct(order.getProduct());
        order.setQuantity(order.getQuantity());
        return order;
    }

    @Override
    public void deleteOrder(Long orderId) {
        Order order = this.orderRepo.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "Id", orderId));
        this.orderRepo.delete(order);

    }

    @Override
    public Order getOrderById(Long orderId) {
        Order order  = this.orderRepo.findById(orderId)
            .orElseThrow(() -> new ResourceNotFoundException("Order", " Id ", orderId));
        return(order);
    }



}
