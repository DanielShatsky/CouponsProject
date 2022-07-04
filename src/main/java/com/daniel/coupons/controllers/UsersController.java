package com.daniel.coupons.controllers;


import com.daniel.coupons.dto.User;
import com.daniel.coupons.logic.UsersLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersLogic usersLogic;

    @PostMapping
    public long createUser(@RequestBody User user){
        return usersLogic.createUser(user);
    }

    @PutMapping
    public void updateUser(@RequestBody User user){
        usersLogic.updateUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") int userId){
        return usersLogic.getUserById(userId);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") int userId){
        usersLogic.deleteUserById(userId);
    }
}
