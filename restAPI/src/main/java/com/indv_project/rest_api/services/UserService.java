package com.indv_project.rest_api.services;

import com.indv_project.rest_api.models.ApiUser;
import com.indv_project.rest_api.models.request.UserCreateRequest;
import com.indv_project.rest_api.repositories.IUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {


    private final IUserRepo userRepo;

    private final BCryptPasswordEncoder pswdEncoder;



    public ApiUser readByUsername(String username)
    {
        return userRepo.findByUsername(username).orElseThrow(EntityNotFoundException::new);
    }

    public void createUser(UserCreateRequest userCreateRequest)
    {
        ApiUser apiUser = new ApiUser();
        Optional<ApiUser> byUsername = userRepo.findByUsername(userCreateRequest.getUsername());
        if(byUsername.isPresent())
        {
            throw new RuntimeException("Username already in use. Please input a different username.");
        }
        apiUser.setUsername(userCreateRequest.getUsername());
        apiUser.setPassword(pswdEncoder.encode(userCreateRequest.getPassword()));
        apiUser.setRole(userCreateRequest.getRole());
        userRepo.save(apiUser);
    }

}
