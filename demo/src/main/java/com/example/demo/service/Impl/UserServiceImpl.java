package com.example.demo.service.Impl;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserEntity create(UserEntity userEntity) {
        return userRepo.save(userEntity);
    }

    @Override
    public List<UserEntity> getAll() {
        return userRepo.findAll();
    }
}
