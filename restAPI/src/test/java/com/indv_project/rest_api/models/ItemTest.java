package com.indv_project.rest_api.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    @Test
    void testBodyGetterSetter()
    {
        Item i = new Item();

        i.setBody("this is the body");
        String body = i.getBody();

        assertEquals(body, "this is the body");
    }

    @Test
    void testSubjectGetterSetter()
    {
        Item i = new Item();
        i.setSubject("this is the subject");
        String subject = i.getSubject();
        assertEquals(subject, "this is the subject");
    }

    @Test
    void testConstructorBodySubject()
    {
        Item i = new Item("TestBody", "TestSubject");

        String body = i.getBody();
        String subject = i.getSubject();

        assertEquals(body, "TestBody");
        assertEquals(subject, "TestSubject");
    }

}