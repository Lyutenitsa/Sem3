package com.indv_project.rest_api.controllers;

import com.indv_project.rest_api.models.Item;
import com.indv_project.rest_api.models.User;
import com.indv_project.rest_api.payload.request.ItemCreator;
import com.indv_project.rest_api.services.ItemsService;
import com.indv_project.rest_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/api/item")
@CrossOrigin(origins = "*")
//http://localhost:8080")
public class ItemController {

    private String sample = "This is a test string";

    @Autowired
    private ItemsService itemsService;

    @Autowired
    private UserService userService;

    //Test methods
    //region
    @GetMapping(path = "/HelloWorld")
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
        Optional<Item> itemToReturn = itemsService.findById(id);
        if(itemToReturn.isEmpty())
        {
            System.out.println("not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else
            return new ResponseEntity<>(itemToReturn.get(), HttpStatus.OK);

    }

    @GetMapping(path = "/getAllItems/{id}")
    @ResponseBody
    public ResponseEntity<List<Item>> getAllItems(@PathVariable Long id)
    {
        System.out.println("get all items method");
        List<Item> allItems = itemsService.getAllItems(id);

        return new ResponseEntity<>(allItems, HttpStatus.OK);

    }

    @PostMapping("/createItem")
    public ResponseEntity<?> createItem(@RequestBody ItemCreator reqItem)
    {
        System.out.println("Cant get ID? or just cant resolve the JSON");
        try
        {

            Optional<User> _user = userService.findById(reqItem.getUser_id());
            userService.saveUser(_user.get());

            System.out.println(reqItem.toString());

            Item itemToSave = new Item(reqItem.getBody(), _user.get(), reqItem.getSubject());

            Item _item = itemsService.saveItem(itemToSave);
            return new ResponseEntity<>(_item, HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            System.out.println(e);
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/updateItem")
    public ResponseEntity<Item> updateItem(@RequestBody Item reqItem)
    {
        Optional<Item> itemDB = itemsService.findById(reqItem.getId());
        if(itemDB.isEmpty())
        {
            System.out.println("not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else
        {
            System.out.println("item found" + itemDB.get().getId());

            Item itemToSave = itemDB.get();
            itemToSave.setSubject(reqItem.getSubject());
            itemToSave.setBody(reqItem.getBody());


            itemsService.saveItem(itemToSave);
            return new ResponseEntity<>(itemToSave, HttpStatus.OK);
        }

    }


    @DeleteMapping(path = "/deleteItem/{id}")
    public ResponseEntity<Item> deleteItem(@PathVariable("id") Long itemID)
    {
        Optional<Item> itemDB = itemsService.findById(itemID);
        if(itemDB.isEmpty())
        {
            System.out.println("not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        System.out.println("Item deleted");
        itemsService.deleteItemById(itemID);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @DeleteMapping(path = "/deleteItems")
//    public ResponseEntity<?> deleteMultipleItems(@RequestBody Long[] ids)
//    {
//        System.out.println("Deleting items endpoint");
//        System.out.println(Arrays.toString(ids));
//
////        if(ids.isEmpty())
////        {
////            System.out.println("Must be not empty");
////            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
////        }
//        System.out.println("Multiple items deleted");
//        itemsService.deleteMultipleById(ids);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @DeleteMapping(path = "/deleteItems/{ids}")
    public ResponseEntity<?> deleteMultipleItems(@PathVariable("ids") ArrayList<String> ids)
    {
        System.out.println("Deleting items endpoint");
        System.out.println(ids);

        if(ids.isEmpty())
        {
            System.out.println("Must be not empty");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        for(String id : ids)
        {
            System.out.println(id);
            itemsService.deleteItemById(Long.parseLong(id));
        }

        System.out.println("Multiple items deleted");
//        itemsService.deleteMultipleById(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
