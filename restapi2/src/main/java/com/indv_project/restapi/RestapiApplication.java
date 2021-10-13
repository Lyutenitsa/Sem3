package com.indv_project.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication //(scanBasePackages={"com.indv_project.restapi.controllers","com.indv_project.restapi.models","com.indv_project.restapi.repositories"})
public class RestapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestapiApplication.class, args);
    }

}
