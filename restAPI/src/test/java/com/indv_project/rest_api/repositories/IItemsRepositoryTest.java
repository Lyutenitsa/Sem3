package com.indv_project.rest_api.repositories;

import com.indv_project.rest_api.models.Item;
import com.indv_project.rest_api.models.Role;
import com.indv_project.rest_api.models.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class IItemsRepositoryTest {

    @Autowired
    private IItemsRepository itemsRepoTest;
    @Autowired
    private IUserRepository userRepoTest;

    private Item item;
    private final Long item_id = 1L;
    private final String body = "body";
    private final String subject = "subject";
    private final Boolean completed = false;

    private final Long user_id = 1L;
    private User user;
    private final String username = "username";
    private final String email = "email@email.com";
    private final String password = "password";
    private Set<Role> roles;

    @BeforeEach
    void setUp()
    {
        this.user = new User();
        this.item = new Item();

//        this.item.setId(this.item_id);
        this.item.setBody(this.body);
        this.item.setSubject(this.subject);
        this.item.setCompleted(this.completed);
        this.item.setUser(this.user);

//        this.user.setId(this.user_id);
        this.user.setUsername(this.username);
        this.user.setEmail(this.email);
        this.user.setPassword(this.password);
        this.user.setRoles(this.roles);

        this.userRepoTest.save(this.user);

    }

//    @AfterEach
//    void tearDown()
//    {
//        userRepoTest.deleteAll();
//        itemsRepoTest.deleteAll();
//    }


//    @AfterAll
//    void afterAll()
//    {
//        userRepoTest.deleteAll();
//        itemsRepoTest.deleteAll();
//    }

    @Test
    void save()
    {
        Item testItem = itemsRepoTest.save(item);

        assertEquals(testItem, item);
    }

    @Test
    void findById()
    {
        Item item = itemsRepoTest.save(this.item);

        System.out.println("THIS IS THE ITEM THAT IS SAVEd\n" + this.itemsRepoTest.save(this.item));

        Optional<Item> dbItem = itemsRepoTest.findById(this.item_id);


        assertFalse(dbItem.isEmpty());
        assertEquals(this.item, dbItem.get());
    }

    @Test
    void findAllByUserId()
    {
        this.itemsRepoTest.save(this.item);

        List<Item> dbItems = itemsRepoTest.findAllByUserId(this.user_id);

        assertFalse(dbItems.isEmpty());
        assertEquals(this.item, dbItems.get(0));
    }

    @Test
    void findAllByUserIdMultiple()
    {
        Item newItem = new Item();

        newItem.setBody(body);
        newItem.setSubject(subject);
        newItem.setCompleted(completed);
        newItem.setUser(this.user);


        this.itemsRepoTest.save(this.item);
        this.itemsRepoTest.save(newItem);

        List<Item> dbItems = itemsRepoTest.findAllByUserId(this.user_id);
        System.out.println(dbItems);

        assertFalse(dbItems.isEmpty());
        assertEquals(2, dbItems.size());
        assertEquals(newItem, dbItems.get(1));
    }

    @Test
    void findAllByUserIdWrongId()
    {
        this.itemsRepoTest.save(this.item);

        List<Item> dbItems = itemsRepoTest.findAllByUserId(45678900L);

        assertTrue(dbItems.isEmpty());
    }

    @Test
    void deleteById()
    {
        this.itemsRepoTest.save(this.item);

        this.itemsRepoTest.deleteById(this.item_id);
        Optional<Item> dbItem = this.itemsRepoTest.findById(this.item_id);

        assertTrue(dbItem.isEmpty());
    }
}