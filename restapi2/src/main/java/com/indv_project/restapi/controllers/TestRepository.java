package com.indv_project.restapi.controllers;

import com.indv_project.restapi.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TestRepository extends JpaRepository<Item, Integer> {
    Boolean findItemByBody(String body);
}
