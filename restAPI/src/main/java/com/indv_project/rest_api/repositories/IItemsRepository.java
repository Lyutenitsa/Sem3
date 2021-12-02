package com.indv_project.rest_api.repositories;

import com.indv_project.rest_api.models.Item;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IItemsRepository extends JpaRepository<Item, Long> {
    Item save(Item item);
    Optional<Item> findById(Long aLong);
    List<Item> findAllByUserId(Long id);
    void deleteById(Long id);
//    void deleteAllById(List<Long> ids);

}
