package com.tushenshop.service;

import com.tushenshop.exception.CategoryException;
import com.tushenshop.model.Category;
import com.tushenshop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // Lấy tất cả các loại sản phẩm
    public List<Category> listAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    // Lưu loại sản phẩm mới
    public void save(Category category) {
        categoryRepository.save(category);
    }

    // Cập nhật loại sản phẩm
    public Category updateCategory(Category category) throws CategoryException {
        Optional<Category> existingCategory = categoryRepository.findById(category.getCategoryId());
        if (existingCategory.isPresent()) {
            return categoryRepository.save(category);
        } else {
            throw new CategoryException("Could not find Category with id " + category.getCategoryId());
        }
    }

    // Lấy loại sản phẩm theo id
    public Category get(int id) throws CategoryException {
        Optional<Category> result = categoryRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new CategoryException("Could not find Category with id " + id);
    }

    // Xóa loại sản phẩm theo id
    public void delete(int id) throws CategoryException {
        Optional<Category> existingCategory = categoryRepository.findById(id);
        if (existingCategory.isPresent()) {
            categoryRepository.deleteById(id);
        } else {
            throw new CategoryException("Could not find Category with id " + id);
        }
    }

    // Tìm loại sản phẩm theo tên
    public Optional<Category> findByCategoryName(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);
    }
}
