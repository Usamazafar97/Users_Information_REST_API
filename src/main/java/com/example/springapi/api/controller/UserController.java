package com.example.springapi.api.controller;

import com.example.springapi.api.model.User;
import com.example.springapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // get the specific user based on id
    @GetMapping("/user")
    public User getUser(@RequestParam Integer id) {
        Optional user = userService.getUser(id);

        // if the optional is not empty
        if (user.isPresent()) {
            return (User) user.get();
        }

        return null;

    }

    // get all the users
    @GetMapping("/users")
    public List<User> getAllUsers() {
        Optional usersList = userService.getAllUsers();

        // if the optional is not empty
        if (usersList.isPresent()) {
            return (List<User>) usersList.get();
        }

        return null;

    }

    // delete the specific user based on id
    @DeleteMapping("/user")
    public String deleteUser(@RequestParam Integer id) {

        return userService.deleteUser(id);
    }
}
