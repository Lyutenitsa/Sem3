package com.indv_project.rest_api.controllers;

import com.indv_project.rest_api.models.User;
import com.indv_project.rest_api.payload.request.ChangePswdRequest;
import com.indv_project.rest_api.payload.request.ChangeUsernameRequest;
import com.indv_project.rest_api.payload.request.UserCreateRequest;
import com.indv_project.rest_api.payload.response.UserResponse;
import com.indv_project.rest_api.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/user")
@RequiredArgsConstructor
@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
//@CrossOrigin(origins = "http://localhost:8081") //http://localhost:8080/testing")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder pswdEncoder;

    @GetMapping(path = "/getUser/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id)
    {
        Optional<User> dbUser = userService.findById(id);
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
