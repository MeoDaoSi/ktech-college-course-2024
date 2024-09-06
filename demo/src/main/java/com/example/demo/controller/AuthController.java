package com.example.demo.controller;

import com.example.demo.dto.response.JwtToken;
import com.example.demo.model.UserEntity;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/users/login")
    public ResponseEntity<JwtToken> login(@RequestBody UserEntity user) {
        return new ResponseEntity<>(authService.verify(user), HttpStatus.OK);
    }
}
