package com.tushenshop.service;

import com.tushenshop.exception.ProductException;
import com.tushenshop.model.Product;
import com.tushenshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Lấy tất cả các sản phẩm
    public List<Product> listAll() {
        return (List<Product>) productRepository.findAll();
    }

    // Lưu sản phẩm mới
    public void save(Product product) {
        productRepository.save(product);
    }

    // Cập nhật sản phẩm
    public Product updateProduct(Product product) throws ProductException {
        Optional<Product> existingProduct = productRepository.findById(product.getProductId());
        if (existingProduct.isPresent()) {
            return productRepository.save(product);
        } else {
            throw new ProductException("Could not find Product with id " + product.getProductId());
        }
    }

    // Lấy sản phẩm theo id
    public Product get(int id) throws ProductException {
        Optional<Product> result = productRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new ProductException("Could not find Product with id " + id);
    }

    // Xóa sản phẩm theo id
    public void delete(int id) throws ProductException {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            productRepository.deleteById(id);
        } else {
            throw new ProductException("Could not find Product with id " + id);
        }
    }
}
