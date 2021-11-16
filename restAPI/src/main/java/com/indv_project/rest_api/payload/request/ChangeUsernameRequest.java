package com.indv_project.rest_api.payload.request;

import lombok.Data;

@Data
public class ChangeUsernameRequest {
    private String oldUsername;
    private String newUsername;
    private String password;
}
