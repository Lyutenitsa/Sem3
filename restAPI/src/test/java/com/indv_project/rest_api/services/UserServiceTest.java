package com.indv_project.rest_api.services;

import com.indv_project.rest_api.models.User;
import com.indv_project.rest_api.payload.request.ChangePswdRequest;
import com.indv_project.rest_api.payload.request.ChangeUsernameRequest;
import com.indv_project.rest_api.repositories.IUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
//
//    @Mock
//    private IUserRepository userRepoTest;
//
//    @Mock
//    private PasswordEncoder pswdEncoder;
//
//    @InjectMocks
//    private UserService userService;
//
//
//    private User user;
//
//    @BeforeEach
//    void setUp()
//    {
//        this.user = new User();
//        this.user.setUsername("Lyutenitsa");
//        this.user.setEmail("email@email.bg");
//    }
//
//    @Test
//    void findById()
//    {
//        final Long id = 1L;
//
//        when(userRepoTest.findById(id)).thenReturn(Optional.of(this.user));
//        final Optional<User> expected = userService.findById(id);
//        assertNotNull(expected);
//    }
//
//    @Test
//    void saveUser()
//    {
//    }
//
//    @Test
//    void getAllUsers()
//    {
//        when(userRepoTest.findAll()).thenReturn(new ArrayList<>());
//
//        List<User> dbUsers = userService.getAllUsers();
//
//        assertNotNull(dbUsers);
//    }
//
//    @Test
//    void existsByUsername()
//    {
//        when(userRepoTest.existsByUsername(this.user.getUsername())).thenReturn(Boolean.TRUE);
//
//        assertTrue(userService.existsByUsername(this.user.getUsername()));
//    }
//
//    @Test
//    void existsByEmail()
//    {
//        when(userRepoTest.existsByEmail(this.user.getEmail())).thenReturn(Boolean.TRUE);
//
//        assertTrue(userService.existsByEmail(this.user.getEmail()));
//    }
//
//    @Test
//    void changePasswordNoUsername()
//    {
//        ChangePswdRequest request = new ChangePswdRequest("Lyutenitsa", "123123", "321321");
//
//        when(userRepoTest.findByUsername(request.getUsername())).thenReturn(Optional.empty());
//
//        ResponseEntity<String> response = userService.changePassword(request);
//
//        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
//        assertEquals("User with that username was not found",response.getBody());
//    }
//
//    @Test
//    void changePasswordWrongPassword()
//    {
//        ChangePswdRequest request = new ChangePswdRequest("Lyutenitsa", "123123", "321321");
//
//        when(userRepoTest.findByUsername(request.getUsername())).thenReturn(Optional.of(user));
//
//        Optional<User> dbUser = userService.findById(1L);
//        when(pswdEncoder.matches(request.getOldPassword(), user.getPassword())).thenReturn(Boolean.FALSE);
//
//        ResponseEntity<String> response = userService.changePassword(request);
//
//        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
//        assertEquals("Incorrect password inputted",response.getBody());
//    }
//
//    @Test
//    void changePasswordAllCorrect()
//    {
//        ChangePswdRequest request = new ChangePswdRequest("Lyutenitsa", "123123", "321321");
//
//        when(userRepoTest.findByUsername(request.getUsername())).thenReturn(Optional.of(user));
//
//        Optional<User> dbUser = userService.findById(1L);
//        when(pswdEncoder.matches(request.getOldPassword(), user.getPassword())).thenReturn(Boolean.TRUE);
//
//        ResponseEntity<String> response = userService.changePassword(request);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals("PasswordChanged",response.getBody());
//    }
//
//    @Test
//    void changeUsernameNoUsername()
//    {
//        ChangeUsernameRequest request = new ChangeUsernameRequest("Lyutenitsa", "Lyut", "321321");
//
//        when(userRepoTest.findByUsername(request.getOldUsername())).thenReturn(Optional.empty());
//
//        ResponseEntity<String> response = userService.changeUsername(request);
//
//        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
//        assertEquals("User with that username was not found",response.getBody());
//    }
//
//    @Test
//    void changeUsernameWrongPassword()
//    {
//        ChangeUsernameRequest request = new ChangeUsernameRequest("Lyutenitsa", "Lyut", "321321");
//
//        when(userRepoTest.findByUsername(request.getOldUsername())).thenReturn(Optional.of(user));
//
//        Optional<User> dbUser = userService.findById(1L);
//        when(pswdEncoder.matches(request.getPassword(), user.getPassword())).thenReturn(Boolean.FALSE);
//
//        ResponseEntity<String> response = userService.changeUsername(request);
//
//        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
//        assertEquals("Incorrect password inputted",response.getBody());
//    }
//
//    @Test
//    void changeUsernameAllCorrect()
//    {
//        ChangeUsernameRequest request = new ChangeUsernameRequest("Lyutenitsa", "Lyut", "321321");
//
//        when(userRepoTest.findByUsername(request.getOldUsername())).thenReturn(Optional.of(user));
//
//        Optional<User> dbUser = userService.findById(1L);
//        when(pswdEncoder.matches(request.getPassword(), user.getPassword())).thenReturn(Boolean.TRUE);
//
//        ResponseEntity<String> response = userService.changeUsername(request);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals("Username Changed",response.getBody());
//    }
//
//
//    @Test
//    void deleteUser()
//    {
//        final Long id = 1L;- docker run -it -p 8000:8000 --rm --name back-end spring-api .
//
//        when(userRepoTest.findById(id)).thenReturn(Optional.empty());
//
//        ResponseEntity<String> response = userService.deleteUser(id);
//
//        assertEquals("User with that username was not found", response.getBody());
//        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
//    }
}