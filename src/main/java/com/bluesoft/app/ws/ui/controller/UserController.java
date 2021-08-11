package com.bluesoft.app.ws.ui.controller;

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

    @GetMapping("/{userId}")
    public String getUserById(@PathVariable String userId){
        return "get user by id: " + userId + " was called";
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
