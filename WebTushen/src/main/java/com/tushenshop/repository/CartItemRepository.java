package com.tushenshop.repository;

import com.tushenshop.model.Cart;
import com.tushenshop.model.CartItem;
import com.tushenshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends CrudRepository<CartItem, Integer> {

    // Tìm tất cả các mục trong giỏ hàng theo đối tượng Cart
    List<CartItem> findByCart(Cart cart);

    // Tìm một mục trong giỏ hàng theo Cart và Product ID
    CartItem findByCartAndProductId(Cart cart, Integer productId);


}
