package com.example.springapi.api.controller;

import com.example.springapi.api.model.User;
import com.example.springapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
        } else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found");

    }

    // get all the users
    @GetMapping("/users")
    public List<User> getAllUsers() {
        Optional usersList = userService.getAllUsers();

        // if the optional is not empty
        if (usersList.isPresent()) {
            return (List<User>) usersList.get();
        } else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found");

    }

    // edit a specific user, given the new user
    @PutMapping("/user")
    public User editUser(@RequestBody User user) {

        Optional editedUser = userService.editUser(user);

        // if the optional is not empty
        if (editedUser.isPresent()) {
            return (User) editedUser.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found");
        }
    }

    // delete the specific user based on id
    @DeleteMapping("/user")
    public String deleteUser(@RequestParam Integer id) {

        return userService.deleteUser(id);
    }
}
