package com.indv_project.rest_api.models;

import lombok.*;
import net.bytebuddy.implementation.bind.annotation.Empty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "subject")
    @NonNull
    @NotBlank
    private String subject;

    @Column(name = "body")
    private String body;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "completed")
    private Boolean completed;

    public Item(String body, User user, @NonNull @NotBlank String subject, Boolean completed)
    {
        this.body = body;
        this.user = user;
        this.subject = subject;
        this.completed = completed;
    }

    @Override
    public String toString()
    {
        return "Item{" + "id= " + this.getId() +
                ", body= '" + this.getBody() + '\'' +
                ", user_id= " + this.user.getId() +
                ", subject= '" + this.getSubject() + '\'' +
                ", complete= " + this.getCompleted() + '}';
    }

    public Item(String body, String subject)
    {
        this.setBody(body);
        this.setSubject(subject);
    }

}

