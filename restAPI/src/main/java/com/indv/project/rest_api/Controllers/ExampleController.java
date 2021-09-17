package com.indv.project.rest_api.Controllers;

import com.indv.project.rest_api.models.Item;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/testing")
@CrossOrigin(origins = "*") //http://localhost:8080")
public class ExampleController {

    private static final String sample = "This is a test string";

    private List<Item> Items= new ArrayList<Item>();


    @GetMapping(path = "/HelloWorld")
    @ResponseBody
    public ResponseEntity<String> HelloWorld()
    {
        System.out.println("Hello");

        return new ResponseEntity<>("Hello World", HttpStatus.OK);

    }

    @GetMapping(path = "/data")
    @ResponseBody
    public ResponseEntity<String> This()
    {
//        return new ResponseEntity<>(sample, HttpStatus.OK);
        return ResponseEntity.ok(sample);

    }

    @GetMapping(path = "/getItem/{id}")
    @ResponseBody
    public ResponseEntity<String> getItemByID(@PathVariable("id") String id) {
        Item item = new Item(id);
        if (!Items.contains(item))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(item.toString(), HttpStatus.OK);

    }

    @PostMapping(path = "/createItem/{id}")
    @ResponseBody
    public ResponseEntity<String> CreateItem(@PathVariable("id") String id){
        Item item = new Item(id);
        Items.add(item);
        System.out.println("This");
        return new ResponseEntity<>(item.toString(), HttpStatus.CREATED);
    }
}
