package com.indv_project.rest_api.controllers;

import com.indv_project.rest_api.models.Item;
import com.indv_project.rest_api.repositories.IItemsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/api")
@CrossOrigin(origins = "*") //http://localhost:8080/testing")
public class ItemController {

    private static final String sample = "This is a test string";


    @Autowired
    private IItemsRepo itemsRepo;

    //Test methods
    //region
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
    public ResponseEntity<String> testData()
    {
        //return new ResponseEntity<>(sample, HttpStatus.OK);
        return ResponseEntity.ok(sample);

    }

    //endregion

    @GetMapping(path = "/getItem/{id}")
    @ResponseBody
    public ResponseEntity<Item> getItemByID(@PathVariable("id") Long id)
    {
        System.out.println("get item method");
        Optional<Item> itemToReturn = itemsRepo.findById(id);
        if(itemToReturn.isEmpty())
        {
            System.out.println("not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else
            return new ResponseEntity<>(itemToReturn.get(), HttpStatus.OK);

    }

    @GetMapping(path = "/getAllItems")
    @ResponseBody
    public ResponseEntity<List<Item>> getAllItems()
    {
        System.out.println("get all items method");
        List<Item> allItems = itemsRepo.findAll();

        return new ResponseEntity<>(allItems, HttpStatus.OK);

    }

    @PostMapping("/createItem")
    public ResponseEntity<Item> createItem(@RequestBody Item reqItem)
    {
        try
        {
            Item _item = itemsRepo.save(new Item(reqItem.getBody(), reqItem.getSubject()));
            return new ResponseEntity<>(_item, HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/updateItem")
    public ResponseEntity<Item> updateItem(@RequestBody Item reqItem)
    {
        Optional<Item> itemDB = itemsRepo.findById(reqItem.getId());
        if(itemDB.isEmpty())
        {
            System.out.println("not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else
        {
            System.out.println("user found" + itemDB.get().getId());

            Item itemToSave = itemDB.get();
            itemToSave.setSubject(reqItem.getSubject());
            itemToSave.setBody(reqItem.getBody());


            itemsRepo.save(itemToSave);
            return new ResponseEntity<>(itemToSave, HttpStatus.OK);
        }

    }


    @DeleteMapping(path = "/deleteItem/{id}")
    public ResponseEntity<Item> deleteUser(@PathVariable("id") Long itemID)
    {
        Optional<Item> itemDB = itemsRepo.findById(itemID);
        if(itemDB.isEmpty())
        {
            System.out.println("not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        System.out.println("Item deleted");
        itemsRepo.deleteById(itemID);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
