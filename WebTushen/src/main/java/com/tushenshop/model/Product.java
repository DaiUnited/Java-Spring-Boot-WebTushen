package com.tushenshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Product_id", unique = true, nullable = false)
    private Integer id;

    @NotEmpty(message = "Product name must not be empty")
    @Column(name = "Product_name", nullable = false)
    private String productName;

    @Column(name = "Description")
    private String description;

    @NotNull
    @PositiveOrZero
    @Column(name = "Price", nullable = false)
    private Integer price;

    @NotNull
    @PositiveOrZero
    @Column(name = "Stock_quantity", nullable = false)
    private Integer stockQuantity;

    @Column(name = "Size")
    private String size;

    @Column(name = "Quality")
    private String quality;

    @Column(name = "Material")
    private String material;

    @Column(name = "Color")
    private String color;

    @Column(name = "Image")
    private String image;

    @ManyToOne
    @JoinColumn(name = "Category_id")
    private Category category;

    // Getters and Setters

    public long getProductId() {
        return id;
    }

    public void setProductId(int Id) {
        this.id = Id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product [productId=" + id + ", productName=" + productName + ", description=" + description
                + ", price=" + price + ", stockQuantity=" + stockQuantity + ", size=" + size + ", quality=" + quality
                + ", material=" + material + ", color=" + color + ", image=" + image + ", category=" + category + "]";
    }
}
