package com.bluesoft.app.ws.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public String getUser(){
        return "get user was called";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable Long id){
        return "get user by id: " + id + " was called";
    }

    @PostMapping
    public String createUser(){
        return "create user was called";
    }

    @PutMapping
    public String updateUser(){
        return "update user was called";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        return "delete user with id: " + id + " was called";
    }

}
