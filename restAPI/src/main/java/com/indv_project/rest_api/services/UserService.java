//package com.indv_project.rest_api.services;
//
//import com.indv_project.rest_api.models.User;
//import com.indv_project.rest_api.models.request.UserCreateRequest;
//import com.indv_project.rest_api.repositories.IUserRepo;
//import lombok.AllArgsConstructor;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import javax.persistence.EntityNotFoundException;
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class UserService {
//
//    @Autowired
//    private IUserRepo userRepo;
//
//    private BCryptPasswordEncoder pswdEncoder;
//
//
//    public User readByUsername(String username)
//    {
//        return userRepo.findByUsername(username).orElseThrow(EntityNotFoundException::new);
//    }
//
//    public void createUser(UserCreateRequest userCreateRequest)
//    {
//        User user = new User();
//        Optional<User> byUsername = userRepo.findByUsername(userCreateRequest.getUsername());
//        if(byUsername.isPresent())
//        {
//            throw new RuntimeException("Username already in use. Please input a different username.");
//        }
//        user.setUsername(userCreateRequest.getUsername());
//        user.setPassword(pswdEncoder.encode(userCreateRequest.getPassword()));
//        userRepo.save(user);
//    }
//
//}
