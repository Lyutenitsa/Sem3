package com.indv_project.rest_api.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChangeUsernameRequest {
    private String oldUsername;
    private String newUsername;
    private String password;
}
