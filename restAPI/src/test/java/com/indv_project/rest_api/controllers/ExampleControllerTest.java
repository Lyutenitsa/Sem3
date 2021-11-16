package com.indv_project.rest_api.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith(SpringExtension.class)
//@WebMvcTest
class ExampleControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void helloWorld()
    {
        ItemController controller = new ItemController();
        ResponseEntity<String> response = controller.HelloWorld();

        assertEquals("Hello World", response.getBody());
    }

    @Test
    void testData()
    {
    }

    @Test
    void createTutorial()
    {
    }

    @Test
    void getItemByID()
    {
    }
}