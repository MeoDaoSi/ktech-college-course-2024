package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.model.AuthResponse;
import com.example.demo.model.UserDTO;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody UserDTO userDTO){

        String token = authService.login(userDTO);

        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(token);

        return new ResponseEntity<>(authResponse, HttpStatus.OK);
    }
}
