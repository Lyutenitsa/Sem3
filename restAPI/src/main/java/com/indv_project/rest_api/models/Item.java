package com.indv_project.rest_api.models;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "items")
@Getter
@Setter
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "body")
    private String body;


    @Column(name = "subject")
    @NonNull
    private String subject;

    @Column(name = "completed")
    private Boolean complete;

    @Override
    public String toString()
    {
        return "Item{" + "id=" + this.getId() + ", body='" + this.getSubject() + '\'' + ", subject='" + this.getBody() + '\'' + '}';
    }

    public Item(String body, String subject)
    {

        this.setBody(body);

        this.setSubject(subject);

    }

}

