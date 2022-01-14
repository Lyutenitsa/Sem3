package com.indv_project.rest_api.payload.request;

import lombok.Data;

@Data
public class ItemCreator {

    private Long user_id;
    private String subject;
    private String body;
    private Boolean completed;

}
