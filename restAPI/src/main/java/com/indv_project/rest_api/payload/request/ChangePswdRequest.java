package com.indv_project.rest_api.payload.request;

import lombok.Data;

@Data
public class ChangePswdRequest {

    private String username;
    private String oldPassword;
    private String newPassword;
}
