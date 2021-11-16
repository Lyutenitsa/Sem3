//package com.indv_project.rest_api.controllers;
//
//import com.indv_project.rest_api.payload.response.request.LoginRequest;
//import com.indv_project.rest_api.payload.response.request.UserCreateRequest;
//import com.indv_project.rest_api.services.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
//@RequiredArgsConstructor
//@RestController
//@RequestMapping(path = "/auth")
//@CrossOrigin(origins = "http://localhost:8081") //http://localhost:8080/testing")
//public class AuthController {
//    @Autowired
//    private UserService userService;
//    private final BCryptPasswordEncoder pswdEncoder;
//
//    private final AuthenticationManager authenticationManager;
//
//
//    @PostMapping(path = "/signup")
//    public ResponseEntity createUser(@RequestBody UserCreateRequest userCreateRequest)
//    {
//        System.out.println("Tries to create user");
//        userService.createUser(userCreateRequest);
//        return ResponseEntity.ok().build();
//    }
//
//    @PostMapping("/signin")
//    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest)
//    {
//
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String jwt = jwtUtils.generateJwtToken(authentication);
//
//        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//        List<String> roles = userDetails.getAuthorities().stream()
//                .map(item -> item.getAuthority())
//                .collect(Collectors.toList());
//
//        return ResponseEntity.ok(new JwtResponse(jwt,
//                userDetails.getId(),
//                userDetails.getUsername(),
//                userDetails.getEmail(),
//                roles));
//    }
//
//}
