package com.indv_project.rest_api.services;

import com.indv_project.rest_api.models.Item;

import com.indv_project.rest_api.repositories.IItemsRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemsServiceTest {

    @Mock
    private IItemsRepository itemRepoTest;

    @InjectMocks
    private ItemsService itemsService;


    @Test
    void findById()
    {
        final Long id = 1L;
        final Item item = new Item();
        given(itemRepoTest.findById(id)).willReturn(Optional.of(item));
        final Optional<Item> expected = itemsService.findById(id);
        assertThat(expected).isNotNull();
    }

    @Test
    void saveItem()
    {
        final Item item = new Item();
        item.setBody("Lyutfi");

        when(itemRepoTest.save(any(Item.class))).thenReturn(item);
        Item dbItem = itemsService.saveItem(item);

        assertEquals(item, dbItem);
    }

    @Test
    void getAllItems()
    {
        final Item item = new Item();
        item.setSubject("Task");

        when(itemRepoTest.findAllByUserId(3L)).thenReturn(new ArrayList<Item>());

        List<Item> dbItems = itemsService.getAllItems(3L);
        assertNotEquals(null, dbItems);

    }

    @Test
    void deleteItemById()
    {

    }
}
