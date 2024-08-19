package com.tushenshop.repository;

import com.tushenshop.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

    Optional<Category> findById(long categoryId);

    Optional<Category> findByCategoryName(String categoryName);

    long countByCategoryName(String categoryName);
}
