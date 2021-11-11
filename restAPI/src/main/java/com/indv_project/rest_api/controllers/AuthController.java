package com.indv_project.rest_api.controllers;

import com.indv_project.rest_api.models.request.UserCreateRequest;
import com.indv_project.rest_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {

    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity createUser(@RequestBody UserCreateRequest userCreateRequest)
    {
        System.out.println("Tries to create user");
        userService.createUser(userCreateRequest);
        return ResponseEntity.ok().build();
    }


}
