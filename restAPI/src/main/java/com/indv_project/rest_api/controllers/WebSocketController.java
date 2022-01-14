package com.indv_project.rest_api.controllers;

import com.indv_project.rest_api.models.Item;
import com.indv_project.rest_api.models.User;
import com.indv_project.rest_api.services.ItemsService;
import com.indv_project.rest_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.util.List;
import java.util.Optional;

@Controller
public class WebSocketController {

    @Autowired
    private ItemsService itemsService;
    @Autowired
    private UserService userService;

    @MessageMapping("/getGreeting")
    @SendTo("/login/greeting")
    public String greeting(String message) throws Exception {
        System.out.println(message);
        Long userID = Long.parseLong(message);
        List<Item> items = itemsService.getAllItems(userID);
        Optional<User> user = userService.findById(userID);

        int number = items.size();

        System.out.println("Received and sending");
        System.out.println(userID);
        System.out.println(number);
        System.out.println(user.get().getUsername());

        Thread.sleep(1000); // simulated delay
        return "Hello, "+ user.get().getUsername() + ". You have " + number + " item(s) left to do.";
    }

}
