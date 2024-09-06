package com.example.demo.controller;

import com.example.demo.model.UserEntity;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserEntity register(@RequestBody UserEntity user) {
        return userService.register(user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }
}
