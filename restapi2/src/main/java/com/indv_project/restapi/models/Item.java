package com.indv_project.restapi.models;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column
    private String body;


    @Column
    private String subject;

    public Item() {

    }

    public Item(String body, String subject) {

        this.setBody(body);

        this.setSubject(subject);

    }

    public Item(String body) {
        this.setBody(body);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Item{ " +
                "id = '" + this.getId() + '\'' +
                '}';
    }
}



