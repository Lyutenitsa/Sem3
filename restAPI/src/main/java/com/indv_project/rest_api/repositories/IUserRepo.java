package com.indv_project.rest_api.repositories;

import com.indv_project.rest_api.models.ApiUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepo extends JpaRepository<ApiUser, Long> {
    Optional<ApiUser> findByUsername(String username);
}
