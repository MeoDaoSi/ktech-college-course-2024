package vn.edu.likelion.book_store_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.edu.likelion.book_store_manager.config.Configuration;
import vn.edu.likelion.book_store_manager.entity.UserEntity;
import vn.edu.likelion.book_store_manager.model.UserDTO;
import vn.edu.likelion.book_store_manager.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    Configuration configuration;

    @PostMapping("/create")
    private UserEntity signup(@RequestBody UserDTO userDTO){
        UserEntity userEntity = UserEntity
                .builder()
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .build();
        return userService.create(userEntity);
    }

    @PostMapping("/login")
    private UserEntity login(@RequestBody UserDTO userDTO){
        UserEntity userEntity = userService.login(userDTO.getUsername(), userDTO.getPassword());
        configuration.setUserEntity(userEntity);
        return userEntity;
    }

}
