package com.indv_project.rest_api.models.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class UserCreateRequest {

    private String username;
    private String password;
    private String role;

//    //region
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
//    //endregion



}
