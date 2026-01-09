package com.eventplanner.user_service.controller;

import com.eventplanner.user_service.model.User;
import com.eventplanner.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    // 1. Yeni Kullanıcı Kaydet (Register)
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public User registerUser(@RequestBody User user) {
        // İleride buraya şifreleme (Hashing) eklenecek
        user.setRole("USER"); // Varsayılan rol
        return repository.save(user);
    }

    // 2. Tüm Kullanıcıları Gör (Test amaçlı)
    @GetMapping
    public List<User> getAllUsers() {
        return repository.findAll();
    }
}