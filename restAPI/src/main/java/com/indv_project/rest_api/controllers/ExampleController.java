package com.indv_project.rest_api.controllers;

import com.indv_project.rest_api.models.Item;
import com.indv_project.rest_api.repositories.IitemsRepo;
import com.indv_project.rest_api.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/testing")
//@CrossOrigin(origins = "*") //http://localhost:8080/testing")
public class ExampleController {

    private static final String sample = "This is a test string";


    @Autowired
    public IitemsRepo itemsRepo;


    @GetMapping(path = "/HelloWorld")
    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseBody
    public ResponseEntity<String> HelloWorld()
    {
        System.out.println("Hello from front end");

        return new ResponseEntity<>("Hello World", HttpStatus.OK);

    }

    @GetMapping(path = "/data")
    @ResponseBody
    public ResponseEntity<String> This()
    {
//        return new ResponseEntity<>(sample, HttpStatus.OK);
        return ResponseEntity.ok(sample);

    }

    @PostMapping("/createItem")
    public ResponseEntity<Item> createTutorial(@RequestBody Item reqItem) {
        try {
            Item _item = itemsRepo.save(new Item(reqItem.getBody(), reqItem.getSubject() ));
            return new ResponseEntity<>(_item, HttpStatus.CREATED);
        }
        catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


//    @GetMapping(path = "/getItem/{id}")
//    @ResponseBody
//    public ResponseEntity<String> getItemByID(@PathVariable("id") String id) {
//        Item item = new Item();
//        if (!Items.contains(item)) {
//            System.out.println("create ?");
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        else
//            return new ResponseEntity<>("this just ran", HttpStatus.OK);
//
//    }


//    @PostMapping(path = "/createItem/{id}")
//    @ResponseBody
//    public ResponseEntity<String> CreateItem(@PathVariable("id") String id){
//        Item item = new Item(id);
//        Items.add(item);
//        System.out.println("This");
//        return new ResponseEntity<>(item.toString(), HttpStatus.CREATED);
//    }
}
