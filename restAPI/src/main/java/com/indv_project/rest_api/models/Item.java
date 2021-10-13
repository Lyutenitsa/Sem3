package com.indv_project.rest_api.models;

import javax.persistence.*;


@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "body")
    private String body;


    @Column(name = "subject")
    private String subject;

    public Item() {

    }
    public Item(String body, String subject){

        this.setBody(body);

        this.setSubject(subject);

    }

    public Item(String body) {
        this.setBody(body);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
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

