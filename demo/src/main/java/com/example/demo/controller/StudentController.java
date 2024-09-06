package com.example.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/")
    public String home(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.isAuthenticated() + "=============");;
        System.out.println(authentication.getPrincipal().toString());

        return "Hello world ...!";
    }

    @GetMapping("/home")
    public String testHome(){
        return "Test =======";
    }
}
