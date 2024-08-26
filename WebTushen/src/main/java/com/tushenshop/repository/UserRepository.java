package com.tushenshop.repository;

import com.tushenshop.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    public long countById(int id);

    Optional<User> findById(long userId);

    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);

}
