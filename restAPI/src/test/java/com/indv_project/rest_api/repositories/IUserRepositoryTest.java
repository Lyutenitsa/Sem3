package com.indv_project.rest_api.repositories;

import com.indv_project.rest_api.models.ERole;
import com.indv_project.rest_api.models.Role;
import com.indv_project.rest_api.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class IUserRepositoryTest {

    @Autowired
    private IUserRepository userRepoTest;

    private User user;
    private final String username = "username";
    private final String email = "email@email.com";
    private final String password = "password";
    private Set<Role> roles;

    @BeforeEach
    void setUp()
    {
        this.user = new User();
        roles = new HashSet<>();
        roles.add(new Role(ERole.ROLE_USER));

        this.user.setUsername(this.username);
        this.user.setEmail(this.email);
        this.user.setPassword(this.password);
        this.user.setRoles(this.roles);
    }

    @Test
    void save()
    {
        User userTest = userRepoTest.save(this.user);

        assertEquals(userTest, this.user);
    }

    @Test
    void findByUsername()
    {
        userRepoTest.save(user);
        Optional<User> dbUser = userRepoTest.findByUsername(username);

        assertFalse(dbUser.isEmpty());
        assertEquals(user, dbUser.get());
    }

    @Test
    void existsByUsername()
    {
        userRepoTest.save(user);
        Boolean dbUser = userRepoTest.existsByUsername(username);

        assertTrue(dbUser);

    }

    @Test
    void existsByEmail()
    {
        userRepoTest.save(user);
        Boolean dbUser = userRepoTest.existsByEmail(email);

        assertTrue(dbUser);
    }


}