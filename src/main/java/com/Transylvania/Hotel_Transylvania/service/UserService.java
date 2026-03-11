package com.Transylvania.Hotel_Transylvania.service;

import com.Transylvania.Hotel_Transylvania.entity.Order;
import com.Transylvania.Hotel_Transylvania.entity.User;
import com.Transylvania.Hotel_Transylvania.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User createUser(String name, String email) {
        User user = new User(name, email);
        return repository.save(user);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }
}

