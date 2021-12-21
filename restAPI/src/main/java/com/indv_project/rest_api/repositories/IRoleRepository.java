package com.indv_project.rest_api.repositories;

import com.indv_project.rest_api.models.ERole;
import com.indv_project.rest_api.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(ERole name);
}
