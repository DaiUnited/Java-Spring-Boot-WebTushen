package com.tushenshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Category_id", unique = true, nullable = false)
    private Integer id;

    @NotEmpty(message = "Category name must not be empty")
    @Size(max = 100)
    @Column(name = "Category_name", unique = true, nullable = false)
    private String categoryName;

    @Size(max = 65535) // TEXT in MySQL can store up to 65,535 bytes
    @Column(name = "Description")
    private String description;

    public Category() {
    }

    // Getters and Setters

    public long getCategoryId() {
        return id;
    }

    public void setCategoryId(int Id) {
        this.id = Id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category [categoryId=" + id + ", categoryName=" + categoryName + ", description=" + description + "]";
    }
}
