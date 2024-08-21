//package com.example.demo.service.Impl;
//
//import com.example.demo.entity.UserEntity;
//import com.example.demo.repository.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    UserRepo userRepo;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        UserEntity userEntity = userRepo.findByEmail(email).orElseThrow(
//                () -> new UsernameNotFoundException("User not exists ...!")
//        );
//
//        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
//        SimpleGrantedAuthority sga = new SimpleGrantedAuthority(userEntity.getRole());
//        authorities.add(sga);
//
//        return new User(
//                email,
//                userEntity.getPassword(),
//                authorities
//        );
//
//    }
//}
