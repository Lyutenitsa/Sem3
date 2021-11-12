package com.indv_project.rest_api.models;

import com.indv_project.rest_api.models.response.UserResponse;
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

    public UserResponse get()
    {
        UserResponse user = new UserResponse();
        user.setId(this.id);
        user.setUsername(this.username);

        return user;
    }
}
