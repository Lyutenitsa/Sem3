package com.indv_project.rest_api.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ChangePswdRequest {

    private String username;
    private String oldPassword;
    private String newPassword;


}
