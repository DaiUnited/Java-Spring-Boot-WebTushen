package com.tushenshop.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Order_id", unique = true, nullable = false)
    private Integer id;

    @Id
    @Column(name = "User_id", unique = true, nullable = false)
    private Integer userId;

    @Column(name = "Order_date")
    private String orderDate;

    @Column(name = "Total")
    private Integer total;

    @Column(name = "Shipping_address")
    private String shippingAddress;
}
