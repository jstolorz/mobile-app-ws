package com.bluesoft.app.ws.ui.controller;

import com.bluesoft.app.ws.ui.model.response.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public String getUsers(
            @RequestParam(value="page", defaultValue="1") int page,
            @RequestParam(value="limit", defaultValue="50") int limit,
            @RequestParam(value="sort",defaultValue="desc", required=false) String sort)
    {
        return "get user was called, page = " + page + " limit = " + limit + " sort = " + sort;

    }

    @GetMapping(value = "/{userId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRest> getUserById(@PathVariable String userId){
        UserRest user = new UserRest();
        user.setFirstName("Janusz");
        user.setLastName("Stolorz");
        user.setEmail("janusz@op");
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PostMapping
    public String createUser(){
        return "create user was called";
    }

    @PutMapping("{userId}")
    public String updateUser(@PathVariable String userId){
        return "update user was called";
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId){
        return "delete user with id: " + userId + " was called";
    }

}
