package com.indv_project.rest_api.services;

import com.indv_project.rest_api.models.ERole;
import com.indv_project.rest_api.models.Role;
import com.indv_project.rest_api.repositories.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private IRoleRepository roleRepo;

    public Optional<Role> findByName(ERole name)
    {
      return roleRepo.findByName(name);
    }

}
