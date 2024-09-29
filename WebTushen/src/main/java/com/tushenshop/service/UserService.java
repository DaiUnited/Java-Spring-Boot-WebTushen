package com.tushenshop.service;

import com.tushenshop.exception.UserException;
import com.tushenshop.model.User;
import com.tushenshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public User login(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public List<User> listAll()
    {
        return (List<User>) userRepository.findAll();
    }

    public void save(User user)
    {
        userRepository.save(user);
    }

    public User updateUser(User user) throws UserException {
        Optional<User> existingUser = userRepository.findById(user.getUserId());
        if (existingUser.isPresent()) {
            return userRepository.save(user);
        } else {
            throw new UserException("Could not find User with id " + user.getUserId());
        }

    }

    public User getUserByUsername(String username) throws UserException {
        Optional<User> user = Optional.ofNullable(userRepository.findByUsername(username));
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UserException("Could not find User with username " + username);
        }
    }

    public User get(int id) throws UserException
    {
        Optional<User> result = userRepository.findById(id);
        if (result.isPresent())
        {
            return result.get();
        }
        throw new UserException("Could not find User with id " + id);
    }

    public void delete(int id) throws UserException
    {
        userRepository.deleteById(id);
    }
}

