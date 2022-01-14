package com.indv_project.rest_api.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class ChangeUsernameEmailRequest {
        private Long Id;
        private String username;
        private String email;

}
