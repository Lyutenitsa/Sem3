package com.indv_project.rest_api.repositories;

import com.indv_project.rest_api.models.ERole;
import com.indv_project.rest_api.models.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class IRoleRepositoryTest {

    @Autowired
    private IRoleRepository roleRepoTest;

    @BeforeEach
    void setUp()
    {
    }

    @Test
    void findByName()
    {
        Role role = new Role();
        role.setName(ERole.ROLE_USER);
        roleRepoTest.save(role);

        Optional<Role> result = roleRepoTest.findByName(ERole.ROLE_USER);

        assertEquals(result.get(), role);
    }
}