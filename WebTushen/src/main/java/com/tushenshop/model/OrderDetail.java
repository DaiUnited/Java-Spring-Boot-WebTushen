package com.tushenshop.model;

import jakarta.persistence.*;

@Entity
@Table(name = "OrderDetails")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Order_detail_id", unique = true, nullable = false)
    private Integer id;

    @Id
    @Column(name = "Order_id", unique = true, nullable = false)
    private Integer orderId;

    @Id
    @Column(name ="Product_id", unique = true, nullable = false)
    private Integer productId;

    @Column(name = "Quantity",nullable = false)
    private Integer quantity;

    @Column(name = "Unit_price")
    private Integer unitPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }


}
