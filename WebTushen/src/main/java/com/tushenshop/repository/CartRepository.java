package com.tushenshop.repository;

import com.tushenshop.model.Cart;
import com.tushenshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer> {

    // Tìm giỏ hàng theo User ID
    Cart findByUserId(Integer userId);
}
