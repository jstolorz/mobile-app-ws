package com.bluesoft.app.ws.ui.controller;

import com.bluesoft.app.ws.exception.UserServiceException;
import com.bluesoft.app.ws.ui.model.request.UpdateUserDetailsRequestModel;
import com.bluesoft.app.ws.ui.model.request.UserDetailsRequestModel;
import com.bluesoft.app.ws.ui.model.response.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/users")
public class UserController {

    Map<String, UserRest> users;

    @GetMapping
    public ResponseEntity<List<UserRest>> getUsers(
            @RequestParam(value="page", defaultValue="1") int page,
            @RequestParam(value="limit", defaultValue="50") int limit,
            @RequestParam(value="sort",defaultValue="desc", required=false) String sort)
    {

        if(users != null){
           return new ResponseEntity<>(
                   users.entrySet().stream().map(key -> key.getValue()).collect(toList()),
                   HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @GetMapping(value = "/{userId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRest> getUserById(@PathVariable String userId){
        UserRest user = users.get(userId);

        if(user != null){
            return new ResponseEntity<>(user,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                 produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails){

        UserRest user = new UserRest();
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());

        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);

        if(users == null) users = new HashMap<>();

        users.put(userId,user);

        return new ResponseEntity<>(user,HttpStatus.CREATED);

    }

    @PutMapping("{userId}")
    public ResponseEntity<UserRest> updateUser(@Valid @RequestBody UpdateUserDetailsRequestModel userDetails, @PathVariable String userId){
        UserRest user = users.get(userId);

        if(user != null){
            user.setFirstName(userDetails.getFirstName());
            user.setLastName(userDetails.getLastName());
            users.put(userId,user);
            return new ResponseEntity<>(user,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<UserRest> deleteUser(@PathVariable String userId){
        UserRest user = users.get(userId);

        if(user != null){
            users.remove(userId);
            return new ResponseEntity<>(user,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
