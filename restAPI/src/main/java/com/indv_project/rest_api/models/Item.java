package com.indv_project.rest_api.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "items")
@Getter
@Setter
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "body")
    private String body;


    @Column(name = "subject")
    private String subject;

    public Item()
    {

    }

    public Item(String body, String subject)
    {

        this.setBody(body);

        this.setSubject(subject);

    }

    public Item(String body)
    {
        this.setBody(body);
    }

    @Override
    public String toString()
    {
        return "Item{ " + "id = '" + this.getId() + '\'' + '}';
    }
}

