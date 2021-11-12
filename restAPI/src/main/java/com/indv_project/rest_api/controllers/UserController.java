package com.indv_project.rest_api.controllers;

import com.indv_project.rest_api.models.ApiUser;
import com.indv_project.rest_api.models.request.ChangePswdRequest;
import com.indv_project.rest_api.models.request.ChangeUsernameRequest;
import com.indv_project.rest_api.models.request.UserCreateRequest;
import com.indv_project.rest_api.models.response.UserResponse;
import com.indv_project.rest_api.services.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;
    private final BCryptPasswordEncoder pswdEncoder;


    @PostMapping(path = "/signup")
    public ResponseEntity createUser(@RequestBody UserCreateRequest userCreateRequest)
    {
        System.out.println("Tries to create user");
        userService.createUser(userCreateRequest);
        return ResponseEntity.ok().build();
    }
    @GetMapping(path = "/getUser/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id)
    {
        Optional<ApiUser> dbUser = userService.findById(id);
        if(dbUser.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dbUser.get().get(), HttpStatus.OK);
    }

    @PutMapping(path = "/changePswd")
    public ResponseEntity<String> changePswd(@RequestBody ChangePswdRequest request)
    {
       return userService.changePassword(request);

    }
    @PutMapping(path = "/changeUsername")
    public ResponseEntity<String> changeUsername(@RequestBody ChangeUsernameRequest request)
    {
        return userService.changeUsername(request);
    }
    @DeleteMapping(path = "/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id)
    {
        return userService.deleteUser(id);
    }
}
