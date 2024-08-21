package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.model.UserDTO;
import com.example.demo.service.Impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping
    private UserEntity createUser(@RequestBody UserDTO userDTO){
        UserEntity userEntity = UserEntity.builder()
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .role("ROLE_USER")
                .build();
        return userService.create(userEntity);
    }

    @GetMapping
    private List<UserEntity> getAllUser(){
        Authentication contextHolder = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(contextHolder);
        return userService.getAll();
    }

    @GetMapping("/me")
    private String getProfile(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getAuthorities().toString();
    }

}
