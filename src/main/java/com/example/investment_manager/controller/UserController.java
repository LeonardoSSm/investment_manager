package com.example.investment_manager.controller;


import com.example.investment_manager.model.UserModel;
import com.example.investment_manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserModel> getAllUsers(){
        return userService.findAllUsers();
    }

    @PostMapping
    public UserModel createUser(@RequestBody UserModel userModel){
        return userService.saveUser(userModel);
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserModel> getUserByEmail(@PathVariable String email) {
        return userService.findByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
