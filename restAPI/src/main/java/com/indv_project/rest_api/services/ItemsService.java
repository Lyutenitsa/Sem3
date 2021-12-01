package com.indv_project.rest_api.services;

import com.indv_project.rest_api.models.Item;
import com.indv_project.rest_api.repositories.IItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ItemsService {

    @Autowired
    private IItemsRepository itemsRepository;

    public Optional<Item> findById(Long id){
        return itemsRepository.findById(id);
    }

    public Item saveItem(Item item){
        return itemsRepository.save(item);
    }

    public List<Item> getAllItems(Long id){
//        return itemsRepository.findItemByUserId(id);
        return itemsRepository.findAllByUserId(id);
    }

    public void deleteItemById(Long id){
        itemsRepository.deleteById(id);
    }

    public void deleteMultipleById(Long[] ids){
        itemsRepository.deleteAllById(Arrays.asList(ids));
    }
}
