package com.Transylvania.Hotel_Transylvania.controller;


import com.Transylvania.Hotel_Transylvania.entity.User;
import com.Transylvania.Hotel_Transylvania.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public User createUser(@RequestParam String name,
                           @RequestParam String email) {
        return service.createUser(name, email);
    }

    @GetMapping
    public List<User> getUsers() {
        return service.getAllUsers();
    }

}
