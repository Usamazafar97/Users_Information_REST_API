package com.example.springapi.service;

import com.example.springapi.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> usersList;

    public UserService() {

        usersList = new ArrayList<>();

        usersList.add(new User(1, "Usama", 24, "osama@gmail.com"));
        usersList.add(new User(2, "Burhan", 25, "Burhan@gmail.com"));
        usersList.add(new User(3, "Ali K", 26, "alik@gmail.com"));
        usersList.add(new User(4, "Ali R", 27, "alir@gmail.com"));
        usersList.add(new User(5, "Salman", 28, "salman@gmail.com"));

    }

    // get the specific user with the given id
    public Optional getUser(Integer id) {

        Optional optional = Optional.empty();
        for (User user : usersList) {

            // if the item matches, place that item
            if (id == user.getId()) {
                return Optional.of(user);
            }
        }

        return optional;
    }


    // get all the users
    public Optional getAllUsers() {

        Optional optional = Optional.empty();

        // if there are still items left in the list
        if (!usersList.isEmpty()) {
            return Optional.of(usersList);
        }

        return optional;
    }

    // delete the specific user with the given id
    public String deleteUser(Integer id) {
        for (User user : usersList) {

            // if the user id matches with one of the items in the list
            if (id == user.getId()) {
                usersList.remove(user);
                return "Successfully removed";
            }
        }

        // otherwise
        return "User Not found";
    }

}
