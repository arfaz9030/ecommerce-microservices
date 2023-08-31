package com.tcs.ecommerce.ecommerceorderproduct.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "orders")
//@Table()
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @ManyToOne
//    private Product product;

    private int quantity;


}
