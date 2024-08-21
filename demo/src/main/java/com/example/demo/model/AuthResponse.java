package com.example.demo.model;

import lombok.Data;

@Data
public class AuthResponse {
    private String email;
    private String password;
    private String token;
}
