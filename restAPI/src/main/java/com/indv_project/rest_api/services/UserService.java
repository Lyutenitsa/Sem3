package com.indv_project.rest_api.services;

import com.indv_project.rest_api.models.User;
import com.indv_project.rest_api.payload.request.ChangePswdRequest;
import com.indv_project.rest_api.payload.request.ChangeUsernameRequest;
import com.indv_project.rest_api.payload.request.UserCreateRequest;
import com.indv_project.rest_api.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final IUserRepository userRepo;

    private final BCryptPasswordEncoder pswdEncoder;


    public User readByUsername(String username)
    {
        return userRepo.findByUsername(username).orElseThrow(EntityNotFoundException::new);
    }
    public Optional<User> findById(Long username)
    {
        return userRepo.findById(username);
    }
    public void saveUser(User user){
        userRepo.save(user);
    }


    // CREATING A USER ON SIGN UP
//    public void createUser(UserCreateRequest userCreateRequest)
//    {
//        User apiUser = new User();
//        Optional<User> byUsername = userRepo.findByUsername(userCreateRequest.getUsername());
//        if(byUsername.isPresent())
//        {
//            throw new RuntimeException("Username already in use. Please input a different username.");
//        }
//        apiUser.setUsername(userCreateRequest.getUsername());
//        apiUser.setPassword(pswdEncoder.encode(userCreateRequest.getPassword()));
//
//        //SETS DEFAULT ROLE OF USER
//        apiUser.setRole("USER");
//        userRepo.save(apiUser);
//    }



    //Changing password
    public ResponseEntity<String> changePassword(ChangePswdRequest request)
    {
        System.out.println("Tries to change password");
        Optional<User> _user = userRepo.findByUsername(request.getUsername());

        if(_user.isEmpty())
        {
            System.out.println("User not found");
            return new ResponseEntity<>("User with that username was not found", HttpStatus.NOT_FOUND);
        }
        User dbUser = _user.get();


        String reqPassword = request.getOldPassword();
        String realPassword = dbUser.getPassword();

        if(pswdEncoder.matches(reqPassword, realPassword))
        {
            String pswdToSave = pswdEncoder.encode(request.getNewPassword());
            dbUser.setPassword(pswdToSave);
            userRepo.save(dbUser);
            System.out.println("Password changed");
            return new ResponseEntity<>("PasswordChanged", HttpStatus.OK);
        }
        System.out.println(dbUser.getPassword());
        System.out.println(reqPassword);
        return new ResponseEntity<>("Incorrect password inputted", HttpStatus.NOT_FOUND);

    }



    //Changing username
    public ResponseEntity<String> changeUsername(ChangeUsernameRequest request)
    {
        System.out.println("Tries to change username");
        String oldUsername = request.getOldUsername();
        String newUsername = request.getNewUsername();
        String reqPassword = request.getPassword();

        Optional<User> _user = userRepo.findByUsername(oldUsername);
        if(_user.isEmpty())
        {
            System.out.println("User not found");
            return new ResponseEntity<>("User with that username was not found", HttpStatus.NOT_FOUND);
        }

        User dbUser = _user.get();
        String realPassword = dbUser.getPassword();

        if(pswdEncoder.matches(reqPassword, realPassword))
        {

            dbUser.setUsername(newUsername);
            userRepo.save(dbUser);
            System.out.println("Username changed");
            return new ResponseEntity<>("Username Changed", HttpStatus.OK);
        }

        System.out.println(dbUser.getPassword());
        System.out.println(reqPassword);
        return new ResponseEntity<>("Incorrect Password inputted", HttpStatus.UNAUTHORIZED);
    }

    public ResponseEntity<String> deleteUser(Long id)
    {
        Optional<User> dbUser = userRepo.findById(id);
        if(dbUser.isEmpty())
            return new ResponseEntity<>("User with that username was not found", HttpStatus.NOT_FOUND);

        userRepo.deleteById(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }
}
