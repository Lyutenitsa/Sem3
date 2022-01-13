package com.indv_project.rest_api;

//import com.indv_project.rest_api.services.DataLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


@SpringBootApplication
public class RestApiApplication {

    public static void main(String[] args) throws IOException
    {
        SpringApplication.run(RestApiApplication.class, args);
//        File resource = new ClassPathResource("data.sql").getFile();
//        String text = new String(Files.readAllBytes(resource.toPath()));
//        System.out.println(text);
    }

}
