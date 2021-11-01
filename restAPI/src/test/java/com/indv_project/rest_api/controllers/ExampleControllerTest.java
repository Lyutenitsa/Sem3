package com.indv_project.rest_api.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
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
        ExampleController controller = new ExampleController();
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