package com.indv_project.rest_api.services;

import com.indv_project.rest_api.models.ERole;
import com.indv_project.rest_api.models.Role;
import com.indv_project.rest_api.repositories.IItemsRepository;
import com.indv_project.rest_api.repositories.IRoleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RoleServiceTest {

    @Mock
    private IRoleRepository roleRepoTest;

    @InjectMocks
    private RoleService roleService;

    @Test
    void findByName()
    {
        Role role = new Role();
        role.setName(ERole.ROLE_USER);

        when(roleRepoTest.findByName(role.getName())).thenReturn(Optional.of(role));

        Optional<Role> dbRole = roleService.findByName(role.getName());

        assertNotNull(dbRole);
    }
}