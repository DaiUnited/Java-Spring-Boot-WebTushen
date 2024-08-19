package com.tushenshop.repository;

import com.tushenshop.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    // Optional method to find a Product by its ID
    Optional<Product> findById(long id);

}
