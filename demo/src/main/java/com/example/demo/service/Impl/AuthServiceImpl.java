package com.example.demo.service.Impl;

import com.example.demo.config.JwtConstant;
import com.example.demo.entity.UserEntity;
import com.example.demo.model.UserDTO;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.AuthService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    UserRepo userRepo;

    @Override
    public String login(UserDTO userDTO) {

        UserEntity userEntity = userRepo.findByEmail(userDTO.getEmail());

        System.out.println(" Authentication =============== ");

        System.out.println(userEntity);

        SecretKey key = Keys.hmacShaKeyFor(JwtConstant.JWT_KEY.getBytes());

        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        SimpleGrantedAuthority sga = new SimpleGrantedAuthority(userEntity.getRole());
        System.out.println(userEntity.getRole());
        authorities.add(sga);
        System.out.println(sga);

        return Jwts.builder()
                .setSubject(userEntity.getEmail())
                .setIssuedAt(new Date())
                .claim("authorities", userEntity.getRole())
                .signWith(key)
                .compact();

    }
}
