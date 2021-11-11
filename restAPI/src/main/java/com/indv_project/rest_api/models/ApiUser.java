package com.indv_project.rest_api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "user")
@NoArgsConstructor
public class ApiUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String role;

    //region
//    public Long getId()
//    {
//        return id;
//    }
//
//    public String getUsername()
//    {
//        return username;
//    }
//
//    public void setUsername(String username)
//    {
//        this.username = username;
//    }
//
//    public String getPassword()
//    {
//        return password;
//    }
//
//    public void setPassword(String password)
//    {
//        this.password = password;
//    }
    //endregion
}
