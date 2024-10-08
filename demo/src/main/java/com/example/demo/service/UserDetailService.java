package com.example.demo.service;

import com.example.demo.model.UserEntity;
import com.example.demo.model.UserPricipal;
import com.example.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepo.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("User not found with email: " + email)
        );

        List<String> roles = new ArrayList<>();
        roles.add(user.getRole());
        System.out.println(new UserPricipal(user.getEmail(), user.getPassword(), roles) + "tesssssssss");
        return new UserPricipal(user.getEmail(), user.getPassword(), roles);
    }

}
