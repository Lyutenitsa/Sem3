//package com.indv_project.rest_api.services;
//
//import com.indv_project.rest_api.models.User;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//
//@Service
//@RequiredArgsConstructor
//public class AuthenticationUserService implements UserDetailsService {
//    @Autowired
//    private UserService userService;
//
//    @Override public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
//    {
//        User apiUser = userService.readByUsername(username);
//        if (apiUser == null) {
//            throw new UsernameNotFoundException(username);
//        }
//        return new org.springframework.security.core.userdetails.User(apiUser.getUsername(), apiUser.getPassword(), Collections.emptyList());
//    }
//}
